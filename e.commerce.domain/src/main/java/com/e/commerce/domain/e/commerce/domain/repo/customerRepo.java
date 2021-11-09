package com.e.commerce.domain.e.commerce.domain.repo;

import com.e.commerce.domain.e.commerce.domain.table.user.Customer;
import com.e.commerce.domain.e.commerce.domain.table.user.Seller;
import com.e.commerce.domain.e.commerce.domain.table.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface customerRepo extends JpaRepository<Customer, Long> {

////@Query("select new Customer(firstName) from  Customer  ")
//     List<Customer> getCustomer();



}
