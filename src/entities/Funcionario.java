package entities;

import java.util.UUID;

import exceptions.DomainException;

public class Funcionario extends Pessoa {

	private String cpf;
	private String matricula;
	private Double salario;
	private Setor setor;
	private Funcao funcao;

	public Funcionario() {
	}

	public Funcionario(UUID id, String nome, String cpf, String matricula, Double salario, Setor setor, Funcao funcao) {
		super(id, nome);
		this.setCpf(cpf);
		this.setMatricula(matricula);
		this.setSalario(salario);
		this.setSetor(setor);
		this.setFuncao(funcao);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if (cpf == null || cpf.isBlank()) {
			throw new DomainException("CPF não pode ser nulo ou vazio");
		}
		this.cpf = cpf;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		if (matricula == null || matricula.isBlank()) {
			throw new DomainException("Matrícula não pode ser nulo ou vazio");
		}
		this.matricula = matricula;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		if (salario == null || salario <= 0) {
			throw new DomainException("Salário deve ser maior que zero");
		}
		this.salario = salario;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		if (setor == null) {
			throw new DomainException("Setor não pode ser nulo");
		}
		this.setor = setor;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		if (funcao == null) {
			throw new DomainException("Função não pode ser nulo");
		}
		this.funcao = funcao;
	}

	@Override
	public String toString() {
		return "Funcionario [cpf=" + cpf + ", matricula=" + matricula + ", salario=" + salario + "]";
	}
}
