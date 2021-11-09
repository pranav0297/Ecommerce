package com.e.commerce.domain.e.commerce.domain.Service;

import com.e.commerce.domain.e.commerce.domain.repo.customerRepo;
import com.e.commerce.domain.e.commerce.domain.repo.sellerRepo;
import com.e.commerce.domain.e.commerce.domain.repo.userRepo;
import com.e.commerce.domain.e.commerce.domain.table.user.Customer;
import com.e.commerce.domain.e.commerce.domain.table.user.Seller;
import com.e.commerce.domain.e.commerce.domain.table.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class adminService {

    @Autowired
    userRepo user_repo;


    @Autowired
    customerRepo customer_repo;

    @Autowired
    sellerRepo seller_repo;



    public List<Customer> getCustomerr(){
        //List<Customer> customers = customer_repo.findAll();
        return this.customer_repo.findAll();
    }


    //Get
    public List<Seller> getSeller(){
        return this.seller_repo.findAll();
    }
}
