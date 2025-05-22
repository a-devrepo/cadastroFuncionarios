package controllers;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Funcionario;
import exceptions.DadosEntradaException;
import exceptions.DirectoryException;
import exceptions.DomainException;
import exceptions.RepositoryException;
import repositories.FuncionarioRepository;
import views.ConsoleInput;
import views.ConsoleOutput;
import views.DirectoryView;

public class FuncionarioController {

	private final FuncionarioRepository funcionarioRepository;
	private final Scanner scanner = new Scanner(System.in);
	private final ConsoleOutput consoleOutput;
	private final DirectoryView pastaView;
	private final ConsoleInput consoleInput;

	public FuncionarioController(FuncionarioRepository funcionarioRepository, ConsoleOutput consoleOutput,
			ConsoleInput consoleInput, DirectoryView pastaView) {
		this.funcionarioRepository = funcionarioRepository;
		this.consoleOutput = consoleOutput;
		this.pastaView = pastaView;
		this.consoleInput = consoleInput;
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
			} catch (DirectoryException e) {
				consoleOutput.exibirTextoComQuebra(e.getMessage());
			} catch (DadosEntradaException e) {
				consoleOutput.exibirTextoComQuebra(e.getMessage());
			}
		}
	}

	private void cadastrarFuncionario() {
		var funcionario = consoleInput.montarFuncionario();

		var funcionarios = new ArrayList<Funcionario>();
		funcionarios.add(funcionario);
		var caminho = pastaView.escolherDiretorio();

		funcionarioRepository.exportar(funcionarios, caminho);
		consoleOutput.exibirTextoComQuebra("Funcionário cadastrado com sucesso!");
	}
}
