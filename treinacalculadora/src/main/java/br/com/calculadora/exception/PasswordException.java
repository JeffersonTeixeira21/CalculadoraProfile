package br.com.calculadora.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Senha inválida meu parceiro")
public class PasswordException extends RuntimeException{
}
