package com.example.demoias.services;

import com.example.demoias.domain.Account;
import com.example.demoias.domain.Ingreso;
import com.google.common.base.Preconditions;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServices {

    public List<Ingreso> byTen(Account account) {
        Preconditions.checkNotNull(account);

        return  account
                .getValues()
                .stream()
                .map(ingreso -> {
                    BigDecimal value = ingreso.getValue();
                    return Ingreso.of(value.multiply(BigDecimal.TEN));
                })
                .collect(Collectors.toList());
    }
}
