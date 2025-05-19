package entities;

import java.util.Objects;
import java.util.UUID;

import exceptions.DomainException;

public abstract class Pessoa {

	private UUID id;
	private String nome;

	public Pessoa() {
	}

	public Pessoa(UUID id, String nome) {
		this.setId(id);
		this.setNome(nome);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		if (!Objects.nonNull(id)) {
			throw new DomainException("ID não pode ser null.");
		}

		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (!Objects.nonNull(nome)) {
			throw new DomainException("Nome não pode ser null.");
		}

		if (nome.isBlank()) {
			throw new DomainException("Nome não pode estar em branco.");
		}

		if (nome.length() < 3) {
			throw new DomainException("Nome deve ter no míninmo 3 caracteres.");
		}
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + "]";
	}
}
