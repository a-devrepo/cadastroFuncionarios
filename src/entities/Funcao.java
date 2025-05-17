package entities;

import java.util.UUID;

public class Funcao {

	private UUID id;
	private String nome;
	
	public Funcao() {}
	
	public Funcao(UUID id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Funcao [id=" + id + ", nome=" + nome + "]";
	}
}
