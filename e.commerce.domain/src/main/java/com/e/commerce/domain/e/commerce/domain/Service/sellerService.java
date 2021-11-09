package com.e.commerce.domain.e.commerce.domain.Service;

import com.e.commerce.domain.e.commerce.domain.Enum.Status;
import com.e.commerce.domain.e.commerce.domain.repo.sellerRepo;
import com.e.commerce.domain.e.commerce.domain.repo.userRepo;
import com.e.commerce.domain.e.commerce.domain.table.user.Seller;
import com.e.commerce.domain.e.commerce.domain.table.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class sellerService {

    @Autowired
    sellerRepo seller_repo;

   @Autowired
    userRepo user_repo;


@Autowired
        BCryptPasswordEncoder passwordEncoder;


User user;

//    public sellerService(userRepo user_repo, BCryptPasswordEncoder passwordEncoder) {
//        this.user_repo = user_repo;
//        this.passwordEncoder = passwordEncoder;
//    }
// Post method for User_Seller

    public Seller saveUserSeller(Seller seller){
        user_repo.save(seller);
        return seller;
    }


    // user--Seller  Register

    public Status registerUserSeller(Seller newSeller) throws IllegalAccessException {
        List<User> users = user_repo.findAll();

        for (User user : users) {
            if (user.getEmail().equals(newSeller.getEmail())) {

                throw new IllegalAccessException("Email already present");
            }
        }
        newSeller.setPassword(passwordEncoder.encode(newSeller.getPassword()));
        user_repo.save(newSeller);
        return Status.SUCCESS;
    }

    //Upadte user
    public User  updateSeller(Seller seller){
        Seller existingUser = seller_repo.findById(seller.getId()).orElse(null);
       existingUser.setInvalidAttemptCount(seller.getInvalidAttemptCount());
        return user_repo.save(existingUser);

    }



    //login Seller
//    public Seller  loginSeller(Seller userName){
//        List<User> users = user_repo.findAll();
//        for (User user : users) {
//            if (user.getEmail().equals(userName.getEmail())) {
//               // if(user.getPassword().equals(password.getPassword())){
//                    return getUserAfterLogin();
//                }
//            }
//
//        //user_repo.save(userName);
//        //user_repo.save(password);
//           return ;
//    }

//public Seller getUserAfterLogin(){
//
//}

}
