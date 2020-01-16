package com.example.demoias.configuration;

import com.example.demoias.domain.Account;
import com.example.demoias.domain.Ingreso;
import com.example.demoias.serialization.adapters.AccountAdapter;
import com.example.demoias.serialization.adapters.IngresoAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GsonConfiguration {

    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .registerTypeAdapter(Ingreso.class, new IngresoAdapter())
                .registerTypeAdapter(Account.class, new AccountAdapter())
                .create();
    }
}
