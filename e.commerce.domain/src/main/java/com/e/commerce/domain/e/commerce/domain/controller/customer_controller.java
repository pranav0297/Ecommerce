package com.e.commerce.domain.e.commerce.domain.controller;

import com.e.commerce.domain.e.commerce.domain.Enum.Status;
import com.e.commerce.domain.e.commerce.domain.Service.customerService;
import com.e.commerce.domain.e.commerce.domain.table.user.Customer;
import com.e.commerce.domain.e.commerce.domain.table.user.Role;
import com.e.commerce.domain.e.commerce.domain.table.user.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class customer_controller {

    @Autowired
customerService service;

//API for create Customer
    @PostMapping ("/create-customer")
    public Customer addCustomer(@RequestBody Customer customer){
            return service.saveUserCustomer(customer);
    }






//    @GetMapping("/get/role")
//    public List<Role> findAllRole(){
//        return service.getRole();
//
//    }



// API for Customer register

    @PostMapping("/users/register/customer")
    public Status registerCustomer(@RequestBody  Customer customer){
        return service.registerUserCustomer(customer);
    }


}

