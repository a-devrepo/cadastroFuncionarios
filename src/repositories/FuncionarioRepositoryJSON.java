package repositories;

import java.io.PrintWriter;
import java.util.List;

import entities.Funcionario;

public class FuncionarioRepositoryJSON implements FuncionarioRepository {

	@Override
	public void exportar(List<Funcionario> funcionarios) {
		try (var printWriter = new PrintWriter("/tmp/funcionarios.json")) {
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
			System.out.println("Erro ao exportar os funcionarios: " + e.getMessage());
		}
	}
}
