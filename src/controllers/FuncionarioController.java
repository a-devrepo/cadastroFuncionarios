package controllers;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import entities.Funcao;
import entities.Funcionario;
import entities.Setor;
import exceptions.RepositoryException;
import repositories.FuncionarioRepository;

public class FuncionarioController {

	private final FuncionarioRepository funcionarioRepository;
	private final Scanner scanner = new Scanner(System.in);

	public FuncionarioController(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public void exibirOpcoes() {

		var excutando = true;

		while (excutando) {
			try {
				System.out.println("1. Cadastrar Funcionários");
				System.out.println("2. Sair");
				System.out.println("Escolha uma opção (1-2):");

				var opcao = scanner.nextLine();

				switch (opcao) {
				case "1":
					cadastrarFuncionario();
					break;
				case "2":
					System.out.println("Saindo do programa...");
					excutando = false;
					break;
				default:
					System.out.println("Opção inválida! Tente novamente.");
				}

			} catch (RepositoryException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private void cadastrarFuncionario() {
		System.out.print("Informe o nome do funcionário: ");
		var nome = scanner.nextLine();
		System.out.print("Informe o CPF do funcionário: ");
		var cpf = scanner.nextLine();
		System.out.print("Informe a matrícula do funcionário: ");
		var matricula = scanner.nextLine();
		System.out.print("Informe o setor do funcionário: ");
		var descricaoSetor = scanner.nextLine();
		System.out.print("Informe a função do funcionário: ");
		var descricaoFuncao = scanner.nextLine();

		var setor = new Setor();
		setor.setId(UUID.randomUUID());
		setor.setDescricao(descricaoSetor);
		var funcao = new Funcao();
		funcao.setId(UUID.randomUUID());
		funcao.setNome(descricaoFuncao);

		var funcionario = new Funcionario(UUID.randomUUID(), nome, cpf, matricula, 3000.0, setor, funcao);

		var funcionarios = new ArrayList<Funcionario>();
		funcionarios.add(funcionario);

		funcionarioRepository.exportar(funcionarios);
		System.out.println("\nFuncionário cadastrado com sucesso!");
	}
}
