package br.com.calculadora.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Você não informou a senha")
public class PasswordNotFoundException extends RuntimeException{
}
