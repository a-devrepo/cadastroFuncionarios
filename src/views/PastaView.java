package views;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import exceptions.DirectoryException;

public class PastaView {

	public String escolherDiretorio() {
		JFileChooser seletor = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		seletor.setDialogTitle("Selecione a pasta para salvar o arquivo");
		seletor.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		seletor.setAcceptAllFileFilterUsed(false);

		int retorno = seletor.showSaveDialog(null);
		if (retorno == JFileChooser.CANCEL_OPTION) {
			throw new DirectoryException("Seleção de diretório cancelada.");
		}

		var pasta = seletor.getSelectedFile();

		if (pasta == null || !pasta.isDirectory()) {
			throw new DirectoryException("Selecione um diretório válido.");
		}
		return seletor.getSelectedFile().getAbsolutePath();
	}
}
