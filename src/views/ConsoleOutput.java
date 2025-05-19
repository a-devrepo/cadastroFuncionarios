package views;

public class ConsoleOutput {

	public void exibirTexto(String texto) {
		System.out.println(texto);
	}

	public void exibirTextoComQuebra(String texto) {
		System.out.println("\n" + texto);
	}
	
	public void exibirTextoEntradaDados(String texto) {
		System.out.print(texto);
	}
}
