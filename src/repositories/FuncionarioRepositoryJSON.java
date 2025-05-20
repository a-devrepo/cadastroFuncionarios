package repositories;

import java.io.PrintWriter;
import java.util.List;

import entities.Funcionario;
import exceptions.RepositoryException;

public class FuncionarioRepositoryJSON implements FuncionarioRepository {

	@Override
	public void exportar(List<Funcionario> funcionarios, String path) {
		try (var printWriter = new PrintWriter(path + "/funcionarios.json")) {
			printWriter.println("[");

			for (int i = 0; i < funcionarios.size(); i++) {
				var funcionario = funcionarios.get(i);
				printWriter.println("\t{");
				printWriter.println("\t\t\"id\": \"" + funcionario.getId() + "\",");
				printWriter.println("\t\t\"nome\": \"" + funcionario.getNome() + "\",");
				printWriter.println("\t\t\"setor\": \"" + funcionario.getSetor().getDescricao() + "\",");
				printWriter.println("\t\t\"funcao\": \"" + funcionario.getFuncao().getNome() + "\"");
				printWriter.println("\t}" + (i < funcionarios.size() - 1 ? "," : ""));
			}

			printWriter.println("]");
		} catch (Exception e) {
			throw new RepositoryException("Erro ao exportar funcionarios: " + e.getMessage());
		}
	}

	@Override
	public void exportar(List<Funcionario> funcionarios) {
		// TODO Auto-generated method stub
		
	}
}
