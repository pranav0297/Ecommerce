package com.e.commerce.domain.e.commerce.domain.controller;


import com.e.commerce.domain.e.commerce.domain.Service.RegistrationRequest;
import com.e.commerce.domain.e.commerce.domain.Service.RegistrationService;
import com.e.commerce.domain.e.commerce.domain.table.user.Seller;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    @Autowired
    private final RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody Seller seller) throws IllegalAccessException {
        return registrationService.register(seller);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
