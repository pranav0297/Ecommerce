//package com.e.commerce.domain.e.commerce.domain.config;
//
//import com.e.commerce.domain.e.commerce.domain.table.user.Role;
//import com.e.commerce.domain.e.commerce.domain.table.user.User;
//import lombok.*;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import javax.persistence.Entity;
//import java.util.*;
//@Getter
//@Setter
//@EqualsAndHashCode
//@NoArgsConstructor
//@AllArgsConstructor
//public class CustomUserDetails implements UserDetails {
//
//  private  User user;
//
//  private Role role;
//
////    public CustomUserDetails(User user) {
////        this.user = user;
////    }
////
////    public CustomUserDetails(Role role) {
////        this.role = role;
////    }
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//
//       // List<User>list=new ArrayList<>() ;
//
//        HashSet<SimpleGrantedAuthority> set =new HashSet<>();
//
//            set.add(new SimpleGrantedAuthority(String.valueOf(this.user.getRole())));
//
//            return set;
//    }
//
//    @Override
//    public String getPassword() {
//        return user.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return user.getEmail();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
//
