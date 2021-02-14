package com.shesha.projects.springbootcrud.services;

import com.shesha.projects.springbootcrud.entities.Customer;
import com.shesha.projects.springbootcrud.entities.CustomerOrder;
import com.shesha.projects.springbootcrud.entities.User;
import com.shesha.projects.springbootcrud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user)
    {
        return userRepository.save(user);
    }

    public User getUserByUsername(String userName)
    {
        return userRepository.findByUserName(userName);
    }

    public String deleteUser(int userId)
    {
        userRepository.deleteById(userId);
        return "User removed: " + userId;
    }

    public User updateUser(User user)
    {
        User existingUser = userRepository.findById(user.getUserId()).orElse(null);
        existingUser.setUserName(user.getUserName());
        existingUser.setCustomerOrders((ArrayList<CustomerOrder>) user.getCustomerOrders());
        existingUser.setCustomers((ArrayList<Customer>) user.getCustomers());
        existingUser.setDateCreated(user.getDateCreated());
        existingUser.setEmailId(user.getEmailId());
        existingUser.setIsAdmin(user.getIsAdmin());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setUserPassword(user.getUserPassword());
        existingUser.setUserGroup(user.getUserGroup());
        existingUser.setUserId(user.getUserId());
        return userRepository.save(existingUser);

    }
    public List<User> getUsers()
    {
        return userRepository.findAll();
    }
}
