package com.e.commerce.domain.e.commerce.domain.Service;

import com.e.commerce.domain.e.commerce.domain.Enum.Status;
import com.e.commerce.domain.e.commerce.domain.repo.customerRepo;
import com.e.commerce.domain.e.commerce.domain.repo.roleRepo;
import com.e.commerce.domain.e.commerce.domain.repo.sellerRepo;
import com.e.commerce.domain.e.commerce.domain.repo.userRepo;
import com.e.commerce.domain.e.commerce.domain.table.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Service
public class customerService {

    @Autowired
    userRepo user_repo;

    @Autowired
    customerRepo customer_repo;

    @Autowired
    roleRepo role_repo;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    User user;


    // Post method for User_customer

    public Customer saveUserCustomer(Customer customer){
        user_repo.save(customer);
        return customer;
    }





    public List<Role> getRole(){
        return this.role_repo.findAll();
    }


    // user--customer  Register

    public Status registerUserCustomer(Customer newCustomer) {
        List<User> users = user_repo.findAll();

        for (User user : users) {
            if (user.getEmail().equals(newCustomer.getEmail())) {
               return Status.USER_ALREADY_EXISTS;
            }
        }
        newCustomer.setPassword(passwordEncoder.encode(newCustomer.getPassword()));
        user_repo.save(newCustomer);
        return Status.SUCCESS;
    }

}
