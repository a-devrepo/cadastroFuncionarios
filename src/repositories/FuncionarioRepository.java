package repositories;

import java.util.List;

import entities.Funcionario;

public interface FuncionarioRepository {

	void exportar(List<Funcionario> funcionarios, String path);
}
