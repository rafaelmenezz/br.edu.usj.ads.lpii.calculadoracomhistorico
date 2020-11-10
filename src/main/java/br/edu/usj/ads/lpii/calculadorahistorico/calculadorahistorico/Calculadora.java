package br.edu.usj.ads.lpii.calculadorahistorico.calculadorahistorico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class Calculadora {

    List<String> operacoes = new ArrayList<>();
    String resultado = "";


    @PostMapping(value = "/calcular")
    public ModelAndView postSomar(@RequestParam String operacao) {

        Calculos calc = new Calculos(operacao);
             
        this.operacoes.add(operacao + " = "+ calc.retornaResultado());

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("resultado", calc.retornaResultado());
        modelAndView.addObject("operacoes", operacoes);
        return modelAndView;
    }
    @GetMapping(value = "/apagarTudo")
    public ModelAndView postSomar() {

        operacoes.clear();
       return new ModelAndView("index");
    }
}