package controllers;

import java.util.Scanner;

import repositories.FuncionarioRepository;

public class FuncionarioController {

	private final FuncionarioRepository funcionarioRepository;
	private final Scanner scanner = new Scanner(System.in);

	public FuncionarioController(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public void exibirOpcoes() {
		System.out.println("1. Cadastrar Funcionários");
		System.out.println("2. Sair");
		System.out.println("Escolha uma opção (1-2):");

		var excutando = true;

		while (excutando) {
			try {
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

			} catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}
		
		
	}

	private void cadastrarFuncionario() {
		// TODO Auto-generated method stub
		
	}
}
