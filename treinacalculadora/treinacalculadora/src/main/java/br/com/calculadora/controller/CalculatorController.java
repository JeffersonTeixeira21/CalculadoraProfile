package br.com.calculadora.controller;

import br.com.calculadora.service.SenhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/calculo")
public class CalculatorController {

    @Autowired
    private SenhaService senhaService;

    @GetMapping(value = "/add")
    public ResponseEntity<Double> adicao(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2, @RequestParam("senha") String senha) {

        if (senhaService.validarSenha(senha) == "valido") {
            Double soma = num1 + num2;
            return ResponseEntity.ok().body(soma);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping(value = "/sub")
    public ResponseEntity<Double> subtracao(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2, @RequestParam("senha") String senha) {

        if (senhaService.validarSenha(senha) == "valido") {
            Double subtracao = num1 - num2;
            return ResponseEntity.ok().body(subtracao);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping(value = "/div")
    public ResponseEntity<Double> divisao(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2, @RequestParam("senha") String senha) {

        if (senhaService.validarSenha(senha) == "valido") {
            Double divisao = num1 / num2;
            return ResponseEntity.ok().body(divisao);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping(value = "/mult")
    public ResponseEntity<Double> multiplicacao(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2, @RequestParam("senha") String senha) {

        if (senhaService.validarSenha(senha) == "valido") {
            Double multiplicacao = num1 * num2;
            return ResponseEntity.ok().body(multiplicacao);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping(value = "/add/numbers")
    public ResponseEntity<Integer> somaNumbers(@RequestParam("numbers") String numbers, @RequestParam("senha") String senha) {

        if (senhaService.validarSenha(senha) == "valido") {
            int soma = 0;
            String numeros[] = numbers.split(",");
            for (int i = 0; i < numeros.length; i++) {
                soma += Integer.parseInt(numeros[i]);
            }
            return ResponseEntity.ok().body(soma);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping(value = "/sub/numbers")
    public ResponseEntity<Double> subtracaoNumbers(@RequestParam("numbers") String numbers, @RequestParam("senha") String senha) {

        if (senhaService.validarSenha(senha) == "valido") {
            String numeros[] = numbers.split(",");
            double subtracao = Double.parseDouble(numeros[0]);
            for (int i = 1; i < numeros.length; i++) {

                subtracao -= Double.parseDouble(numeros[i]);
            }
            return ResponseEntity.ok().body(subtracao);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping(value = "/mult/numbers")
    public ResponseEntity<Integer> multiplicacaoNumbers(@RequestParam("numbers") String numbers, @RequestParam("senha") String senha) {

        if (senhaService.validarSenha(senha) == "valido") {
            int multiplicacao = 1;
            String numeros[] = numbers.split(",");
            for (int i = 0; i < numeros.length; i++) {
                multiplicacao *= Integer.parseInt(numeros[i]);
            }

            return ResponseEntity.ok().body(multiplicacao);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping(value = "/div/numbers")
    public ResponseEntity<Double> divisaoNumbers(@RequestParam("numbers") String numbers, @RequestParam("senha") String senha) {

        if (senhaService.validarSenha(senha) == "valido") {
            String numeros[] = numbers.split(",");
            double divisao = Double.parseDouble(numeros[0]);
            for (int i = 1; i < numeros.length; i++) {
                divisao /= Double.parseDouble(numeros[i]);
            }

            return ResponseEntity.ok().body(divisao);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}