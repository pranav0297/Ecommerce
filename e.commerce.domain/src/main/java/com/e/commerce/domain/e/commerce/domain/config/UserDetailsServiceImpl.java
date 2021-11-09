package com.e.commerce.domain.e.commerce.domain.config;

import com.e.commerce.domain.e.commerce.domain.repo.userRepo;
import com.e.commerce.domain.e.commerce.domain.table.user.Customer;
import com.e.commerce.domain.e.commerce.domain.table.user.Seller;
import com.e.commerce.domain.e.commerce.domain.table.user.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final String USER_NOT_FOUND_MSG ="user with %s not found";

    @Autowired
    private final userRepo repo;

    @Autowired
    private final BCryptPasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
      // User user= repo.getUserByUserName(username);


        //CustomUserDetails customUserDetails= new CustomUserDetails(user);
        return repo.findByEmail(email).orElseThrow(
                ()->new UsernameNotFoundException
                        (String.format(USER_NOT_FOUND_MSG,email)));
    }
//    public String signUp(User seller) throws IllegalAccessException {
//       boolean userExists= repo.findByEmail(seller.getEmail()).isPresent();
//       if(userExists){
//           throw new IllegalAccessException("User already exists");
//       }
//        seller.setPassword(passwordEncoder.encode(seller.getPassword()));
//
//        repo.save(seller);
//        return "done";
//
//    }

    public int enableUser(String email) {
        return repo.enableUser(email);
    }

}
