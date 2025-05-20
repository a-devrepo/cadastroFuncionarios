package controllers;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import entities.Funcao;
import entities.Funcionario;
import entities.Setor;
import exceptions.DirectoryException;
import exceptions.DomainException;
import exceptions.RepositoryException;
import repositories.FuncionarioRepository;
import views.ConsoleOutput;
import views.PastaView;

public class FuncionarioController {

	private final FuncionarioRepository funcionarioRepository;
	private final Scanner scanner = new Scanner(System.in);
	private final ConsoleOutput consoleOutput;
	private final PastaView pastaView;

	public FuncionarioController(FuncionarioRepository funcionarioRepository, ConsoleOutput consoleOutput,PastaView pastaView) {
		this.funcionarioRepository = funcionarioRepository;
		this.consoleOutput = consoleOutput;
		this.pastaView = pastaView;
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
			catch (DirectoryException e) {
				consoleOutput.exibirTextoComQuebra(e.getMessage());
			}
		}
	}

	private void cadastrarFuncionario() {
		var funcionario = montarFuncionario();

		var funcionarios = new ArrayList<Funcionario>();
		funcionarios.add(funcionario);
		var pasta = pastaView.escolherDiretorio();
		var caminho = pasta.getAbsolutePath();

		funcionarioRepository.exportar(funcionarios,caminho);
		consoleOutput.exibirTextoComQuebra("Funcionário cadastrado com sucesso!");
	}

	private Funcionario montarFuncionario() {
		var nome = lerCampo("Informe o nome do funcionário: ");
		var cpf = lerCampo("Informe o CPF do funcionário: ");
		var matricula = lerCampo("Informe a matrícula do funcionário: ");
		var descricaoSetor = lerCampo("Informe o setor do funcionário: ");
		var descricaoFuncao = lerCampo("Informe a função do funcionário: ");
		var salario = Double.parseDouble(lerCampo("Informe o salário do funcionário: "));
		var setor = new Setor(UUID.randomUUID(), descricaoSetor);
		var funcao = new Funcao(UUID.randomUUID(), descricaoFuncao);

		return new Funcionario(UUID.randomUUID(), nome, cpf, matricula, salario, setor, funcao);
	}

	private String lerCampo(String mensagem) {
		consoleOutput.exibirTextoEntradaDados(mensagem);
		return scanner.nextLine();
	}
}
