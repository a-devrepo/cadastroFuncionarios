package principal;

import controllers.FuncionarioController;
import repositories.FuncionarioRepositoryJSON;

public class Main {

	public static void main(String[] args) {
		var funcionarioRepository = new FuncionarioRepositoryJSON();
		var funcionarioController = new FuncionarioController(funcionarioRepository);
		funcionarioController.exibirOpcoes();
	}

}
