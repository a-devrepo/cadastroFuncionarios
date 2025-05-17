package entities;

import java.util.UUID;

public class Setor {
	private UUID id;
	private String descricao;

	public Setor() {
	}

	public Setor(UUID id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Setor [id=" + id + ", descricao=" + descricao + "]";
	}
}
