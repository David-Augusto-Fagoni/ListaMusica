package view;

import java.io.IOException;

import javax.swing.JOptionPane;
import controller.PlayerController;
import modelString.IListaString;
import modelString.ListaString;

public class Principal {
	public static void main(String[] args) {
		PlayerController Play = new PlayerController();
		IListaString Lista = new ListaString();
		int J =0;
		while (J!=9) {
			J = Integer.parseInt(JOptionPane.showInputDialog("1- Adiciona Musica\n2- Remover Musica\n3- Executar Playlist\n9- Sair "));
			try {
				switch (J) {
				
				case(1) -> Play.adicionaMusica(Lista);
				case(2) -> Play.removeMusica(Lista);
				case(3) -> Play.executaPlaylist(Lista);
				case(9) -> JOptionPane.showMessageDialog(null, "Saindo");
				default -> JOptionPane.showMessageDialog(null, "Numero Invalido");
				}
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		
	}
}
