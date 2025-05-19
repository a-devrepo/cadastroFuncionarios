package principal;

import controllers.FuncionarioController;
import repositories.FuncionarioRepositoryJSON;
import views.ConsoleOutput;

public class Main {

	public static void main(String[] args) {
		var funcionarioRepository = new FuncionarioRepositoryJSON();
		var consoleOutput = new ConsoleOutput();
		var funcionarioController = new FuncionarioController(funcionarioRepository,consoleOutput);
		funcionarioController.exibirOpcoes();
	}
}