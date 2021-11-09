package com.e.commerce.domain.e.commerce.domain.controller;

import com.e.commerce.domain.e.commerce.domain.Enum.Status;
import com.e.commerce.domain.e.commerce.domain.Service.customerService;
import com.e.commerce.domain.e.commerce.domain.Service.sellerService;
import com.e.commerce.domain.e.commerce.domain.table.user.Seller;
import com.e.commerce.domain.e.commerce.domain.table.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class seller_controller {


    @Autowired
    sellerService service;

    //API for create Seller




    // API for Seller register

    @PostMapping("/users/register/seller")
    public Status registerSeller(@RequestBody Seller seller) throws IllegalAccessException {
        return service.registerUserSeller(seller);
    }


    @PutMapping("/update_user/")
    public User updateUser(@RequestBody Seller u){
        return service.updateSeller(u);

    }


//    @PostMapping("/user/login/seller")
//    public String sellerLogin(@RequestBody Seller seller){
//        return service.loginSeller(seller);
//    }
}
