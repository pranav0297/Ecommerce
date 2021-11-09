package com.e.commerce.domain.e.commerce.domain.config;


import lombok.AllArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.mail.internet.MimeMessage;
import java.io.InputStream;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

   @Autowired
   UserDetailsServiceImpl userDetailsServiceImpl;

   @Autowired
   private  final BCryptPasswordEncoder passwordEncoder;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/users/register/**","/user/login/seller","/api/v*/registration/**").permitAll()
                .antMatchers("/get/**").hasRole("ADMIN")

                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("pranav").password(this.passwordEncoder().encode("pranav")).roles("ADMIN");
////        auth.inMemoryAuthentication().withUser("mayank").password(this.passwordEncoder().encode("mayank")).roles("SELLER");
////
////        auth.inMemoryAuthentication().withUser("aman").password(this.passwordEncoder().encode("aman")).roles("CUSTOMER");
////
//       auth. authenticationProvider(authenticationProvider());
//       //.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
//    }
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(daoAuthenticationProvider());
}

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userDetailsServiceImpl);
        return provider;
    }

//    @Bean
//    public BCryptPasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

//    @Bean
//    UserDetailsService getUserDetailsService(){
//        return new UserDetailsServiceImpl();
//    }


//    @Bean
//    public DaoAuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider daoAuthenticationProvider= new DaoAuthenticationProvider();
//        daoAuthenticationProvider.setUserDetailsService(this.getUserDetailsService());
//      // daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//        return daoAuthenticationProvider;
//    }

//    @Bean
//    public JavaMailSender javaMailSender(){
//        return new JavaMailSender() {
//            @Override
//            public void send(SimpleMailMessage simpleMessage) throws MailException {
//
//            }
//
//            @Override
//            public void send(SimpleMailMessage... simpleMessages) throws MailException {
//
//            }
//
//            @Override
//            public MimeMessage createMimeMessage() {
//                return null;
//            }
//
//            @Override
//            public MimeMessage createMimeMessage(InputStream contentStream) throws MailException {
//                return null;
//            }
//
//            @Override
//            public void send(MimeMessage mimeMessage) throws MailException {
//
//            }
//
//            @Override
//            public void send(MimeMessage... mimeMessages) throws MailException {
//
//            }
//
//            @Override
//            public void send(MimeMessagePreparator mimeMessagePreparator) throws MailException {
//
//            }
//
//            @Override
//            public void send(MimeMessagePreparator... mimeMessagePreparators) throws MailException {
//
//            }
//        };
//    }
}
