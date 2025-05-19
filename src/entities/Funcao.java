package entities;

import java.util.Objects;
import java.util.UUID;

import exceptions.DomainException;

public class Funcao {

	private UUID id;
	private String nome;

	public Funcao() {
	}

	public Funcao(UUID id, String nome) {
		this.setId(id);
		this.setNome(nome);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		if (Objects.isNull(id)) {
			throw new DomainException("ID não pode ser nulo.");
		}
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome == null || nome.isBlank()) {
			throw new DomainException("Nome não pode ser nulo ou vazio.");
		}
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Funcao [id=" + id + ", nome=" + nome + "]";
	}
}
