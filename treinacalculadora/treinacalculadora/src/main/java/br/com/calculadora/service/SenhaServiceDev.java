package br.com.calculadora.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("dev")
@Service
public class SenhaServiceDev implements SenhaService {

    @Override
    public String validarSenha(String senha) {
        return "valido";
    }
}
