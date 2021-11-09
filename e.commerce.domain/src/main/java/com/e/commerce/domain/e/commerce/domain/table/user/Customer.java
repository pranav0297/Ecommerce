package com.e.commerce.domain.e.commerce.domain.table.user;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Component
@Table(name = "customer")
@PrimaryKeyJoinColumn(name = "user_id")
public class Customer extends User{



//    @Column(name = "user_id")
//    private long userId;
   private Long contact;

//
//    public long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(long userId) {
//        this.userId = userId;
//    }

//    public Customer() {
//
//    }
//
//    public Customer(String firstName) {
//
//       super(firstName);
//
//    }



    public Long  getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }


}
