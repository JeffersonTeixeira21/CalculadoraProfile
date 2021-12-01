package br.com.calculadora.service;

import br.com.calculadora.exception.PasswordNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("prod")
@Service
public class SenhaServiceProd implements SenhaService {

    @Value("${br.com.calculadora.prod.password}")
    private String senhaLocal;

    @Override
    public String validarSenha(String senha) {
        if(senha == null) {
            throw new PasswordNotFoundException();
        } if (senhaLocal.equals(senha)) {
            return "valido";
        } else {
            return "invalido";
        }
    }
}
