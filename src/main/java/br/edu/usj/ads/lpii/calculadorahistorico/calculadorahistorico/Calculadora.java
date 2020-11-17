package br.edu.usj.ads.lpii.calculadorahistorico.calculadorahistorico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class Calculadora {

    //List<String> operacoes = new ArrayList<>();
    String resultado = "";

    @Autowired
    CalculosRepository repCalculos;

    @PostMapping(value = "/calcular")
    public ModelAndView postSomar(@RequestParam String operacao) {

        Calculos calc = new Calculos(operacao);

        repCalculos.save(calc);
             
        //this.operacoes.add(operacao + " = "+ calc.retornaResultado());

        List<Calculos> lista = repCalculos.findAll();

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("resultado", calc.retornaResultado());
        modelAndView.addObject("operacoes", lista);
        return modelAndView;
    }
    @GetMapping(value = "/apagarTudo")
    public ModelAndView postSomar() {

        //operacoes.clear();
       return new ModelAndView("index");
    }
}