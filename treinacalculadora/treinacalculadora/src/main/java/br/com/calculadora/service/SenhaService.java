package br.com.calculadora.service;

import org.springframework.stereotype.Service;

@Service
public interface SenhaService {

    public String validarSenha(String senha);
}
