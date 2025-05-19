package entities;

import java.util.Objects;
import java.util.UUID;

import exceptions.DomainException;

public class Setor {
	private UUID id;
	private String descricao;

	public Setor() {
	}

	public Setor(UUID id, String descricao) {
		this.setId(id);
		this.setDescricao(descricao);
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		if (descricao == null || descricao.isBlank()) {
			throw new DomainException("Descrição não pode ser nula ou vazia.");
		}
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Setor [id=" + id + ", descricao=" + descricao + "]";
	}
}
