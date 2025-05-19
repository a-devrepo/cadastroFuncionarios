package controllers;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import entities.Funcao;
import entities.Funcionario;
import entities.Setor;
import exceptions.DomainException;
import exceptions.RepositoryException;
import repositories.FuncionarioRepository;
import views.ConsoleOutput;

public class FuncionarioController {

	private final FuncionarioRepository funcionarioRepository;
	private final Scanner scanner = new Scanner(System.in);
	private final ConsoleOutput consoleOutput;

	public FuncionarioController(FuncionarioRepository funcionarioRepository, ConsoleOutput consoleOutput) {
		this.funcionarioRepository = funcionarioRepository;
		this.consoleOutput = consoleOutput;
	}

	public void exibirOpcoes() {

		var excutando = true;

		while (excutando) {
			try {
				consoleOutput.exibirTextoComQuebra("1. Cadastrar Funcionários");
				consoleOutput.exibirTexto("2. Sair");
				consoleOutput.exibirTextoEntradaDados("Escolha uma opção (1-2):");

				var opcao = scanner.nextLine();

				switch (opcao) {
				case "1":
					cadastrarFuncionario();
					break;
				case "2":
					consoleOutput.exibirTexto("Saindo...");
					excutando = false;
					break;
				default:
					consoleOutput.exibirTextoComQuebra("Opção inválida! Tente novamente.");
				}

			} catch (RepositoryException e) {
				consoleOutput.exibirTextoComQuebra(e.getMessage());
			} catch (DomainException e) {
				consoleOutput.exibirTextoComQuebra(e.getMessage());
			}
		}
	}

	private void cadastrarFuncionario() {
		consoleOutput.exibirTextoEntradaDados("Informe o nome do funcionário: ");
		var nome = scanner.nextLine();
		consoleOutput.exibirTextoEntradaDados("Informe o CPF do funcionário: ");
		var cpf = scanner.nextLine();
		consoleOutput.exibirTextoEntradaDados("Informe a matrícula do funcionário: ");
		var matricula = scanner.nextLine();
		consoleOutput.exibirTextoEntradaDados("Informe o setor do funcionário: ");
		var descricaoSetor = scanner.nextLine();
		consoleOutput.exibirTextoEntradaDados("Informe a função do funcionário: ");
		var descricaoFuncao = scanner.nextLine();
		consoleOutput.exibirTextoEntradaDados("Informe o salário do funcionário: ");
		var salario = scanner.nextDouble();
		
		var setor = new Setor();
		setor.setId(UUID.randomUUID());
		setor.setDescricao(descricaoSetor);
		var funcao = new Funcao();
		funcao.setId(UUID.randomUUID());
		funcao.setNome(descricaoFuncao);

		var funcionario = new Funcionario(UUID.randomUUID(), nome, cpf, matricula, salario, setor, funcao);

		var funcionarios = new ArrayList<Funcionario>();
		funcionarios.add(funcionario);

		funcionarioRepository.exportar(funcionarios);
		consoleOutput.exibirTextoComQuebra("Funcionário cadastrado com sucesso!");
	}
}
