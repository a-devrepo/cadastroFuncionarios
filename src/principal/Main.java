package principal;

import java.util.Scanner;

import controllers.FuncionarioController;
import controllers.InputValidator;
import repositories.FuncionarioRepositoryJSON;
import views.ConsoleInput;
import views.ConsoleOutput;

public class Main {

	public static void main(String[] args) {
		var funcionarioRepository = new FuncionarioRepositoryJSON();
		var consoleOutput = new ConsoleOutput();
		var pastaView = new views.DirectoryView();
		var inputValidator = new InputValidator();
		var consoleInput = new ConsoleInput(inputValidator, new Scanner(System.in), consoleOutput);

		var funcionarioController = new FuncionarioController(funcionarioRepository, consoleOutput, consoleInput,
				pastaView);
		funcionarioController.exibirOpcoes();
	}
}