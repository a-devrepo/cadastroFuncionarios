package entities;

import java.util.UUID;

public class Funcionario extends Pessoa {

	private String cpf;
	private String matricula;
	private Double salario;
	private Setor setor;
	private Funcao funcao;

	public Funcionario(UUID id, String nome, String cpf, String matricula, Double salario, Setor setor, Funcao funcao) {
		super(id, nome);
		this.cpf = cpf;
		this.matricula = matricula;
		this.salario = salario;
		this.setor = setor;
		this.funcao = funcao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	@Override
	public String toString() {
		return "Funcionario [cpf=" + cpf + ", matricula=" + matricula + ", salario=" + salario + "]";
	}
}
