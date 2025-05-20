package views;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class PastaView {

	public File escolherDiretorio() {
		JFileChooser seletor = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		seletor.setDialogTitle("Selecione a pasta para salvar o arquivo");
		seletor.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		seletor.setAcceptAllFileFilterUsed(false);

		int retorno = seletor.showSaveDialog(null);
		if (retorno == JFileChooser.APPROVE_OPTION) {
			return seletor.getSelectedFile();
		}
		return null;
	}
}
