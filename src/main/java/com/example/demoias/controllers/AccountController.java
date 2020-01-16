package com.example.demoias.controllers;

import com.example.demoias.domain.Account;
import com.example.demoias.domain.Ingreso;
import com.example.demoias.services.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountServices accountServices;

    @Autowired
    public AccountController(AccountServices accountServices) {
        this.accountServices = accountServices;
    }


    @PostMapping(value = "/ingresos")
    public ResponseEntity<List<Ingreso>> getIngresos(@RequestBody Account account) {
        List<Ingreso> ingresos = accountServices.byTen(account);
        return ResponseEntity.ok(ingresos);
    }
}
