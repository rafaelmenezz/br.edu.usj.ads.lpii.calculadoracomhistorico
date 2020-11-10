package br.edu.usj.ads.lpii.calculadorahistorico.calculadorahistorico;

import java.text.DecimalFormat;

public class Calculos {

	private String operacao;


    public Calculos(String op){
        this.operacao = op;
    }

	public String getOperacao() {
		return operacao;
	}
	// método setter para receber a operacao
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	//método que recebe toda a string e realiza o cáculo e retorna o resultado 
	public String retornaResultado() {
		
		char[] operadores = { '+', '-', '÷', 'x', '√', '%' }; // Arry com as operações realizada pela calculadora
		char operadorSelecionado = 0; //variavel que irá receber a operação ex: "+"

		
		for (int i = 0; i <= operadores.length; i++) {
			if (operacao.indexOf(operadores[i]) != -1) {
				operadorSelecionado = operadores[i];
				break;
			}
		}
		/*Criada duas String; uma receberá o conteudo da String operação até onde está o sinal da operação
		 * , na outra o conteudo será do sinal +1  da operação até o final */
		
		String parte1 = operacao.substring(0, operacao.indexOf(operadorSelecionado));
		String parte2 = operacao.substring(operacao.indexOf(operadorSelecionado) + 1);
				
		String resultado = "valor";
		switch (operadorSelecionado) {
		case '+':
			resultado = String.valueOf(Double.parseDouble(parte1) + Double.parseDouble(parte2));
			break;
		case '-':
			resultado = String.valueOf(Double.parseDouble(parte1) - Double.parseDouble(parte2));
			break;
		case '÷':
			resultado = String.valueOf(Double.parseDouble(parte1) / Double.parseDouble(parte2));
			break;
		case 'x':
			resultado = String.valueOf(Double.parseDouble(parte1) * Double.parseDouble(parte2));
			break;
		case '√':
			resultado = String.valueOf(Math.sqrt(Double.parseDouble(parte2)));
			break;
		case '%':
			resultado = String.valueOf(Double.parseDouble(parte1) * (Double.parseDouble(parte2)/ 100));
			break;
		default:
			System.out.println("Operador desconhecido");
			break;
		}
	
		// Classe que formata o numero(caso ele for inteiro) do tipo Double para que não tenha virgula
		DecimalFormat f = new DecimalFormat("0.#");
		
		// Condição para formatação. Verifica se resultado é um número inteiro.
		if ((Double.parseDouble(resultado) * 2) % 2 == 0) {
			return "" + f.format(Double.parseDouble(resultado.replaceAll(",", ".")));
		} else
			return resultado;
	}
	
	// método que verifica se uma string é uma operação matemática
	public boolean verificarOperação(String op) {
		char[] operadores = { '+', '-', '÷', 'x', '√', '%' };
		char operadorSelecionado = 0;
		for (int i = 0; i <= operadores.length; i++) {
			if (op.indexOf(operadores[i]) != -1) {
				operadorSelecionado = operadores[i];
				System.out.println(operadorSelecionado);
				return true;
			}
		}
		return false;
	}

}