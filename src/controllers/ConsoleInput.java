package controllers;

import java.util.Scanner;
import java.util.UUID;

import entities.Funcao;
import entities.Funcionario;
import entities.Setor;
import exceptions.DadosEntradaException;
import views.ConsoleOutput;

public class ConsoleInput {

	private final InputValidator inputValidator;
	private final Scanner scanner;
	private final ConsoleOutput consoleOutput;
	
	public ConsoleInput(InputValidator inputValidator,Scanner scanner,ConsoleOutput consoleOutput) {
		this.inputValidator = inputValidator;
		this.scanner = scanner;
		this.consoleOutput = consoleOutput;
	}
	
	private Funcionario montarFuncionario() {
		var nome = lerCampo("Informe o nome do funcionário: ");
		var cpf = lerCampo("Informe o CPF do funcionário: ");
		var matricula = lerCampo("Informe a matrícula do funcionário: ");
		var descricaoSetor = lerCampo("Informe o setor do funcionário: ");
		var descricaoFuncao = lerCampo("Informe a função do funcionário: ");
		var salario = lerCampo("Informe o salário do funcionário: ");
		inputValidator.validarSalario(salario);

		var setor = new Setor(UUID.randomUUID(), descricaoSetor);
		var funcao = new Funcao(UUID.randomUUID(), descricaoFuncao);

		return new Funcionario(UUID.randomUUID(), nome, cpf, matricula, Double.parseDouble(salario), setor, funcao);
	}

	private String lerCampo(String mensagem) {
		try {
			consoleOutput.exibirTextoEntradaDados(mensagem);
			return scanner.nextLine();
		} catch (Exception e) {
			throw new DadosEntradaException("Erro ao ler o campo: " + e.getMessage());
		}

	}
}
