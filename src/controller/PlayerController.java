package controller;

import javax.swing.JOptionPane;

import modelString.IListaString;

public class PlayerController {
	public void adicionaMusica(IListaString lista) {
		StringBuffer Buffer = new StringBuffer();
		Buffer.append(JOptionPane.showInputDialog("Digite o nome da musica")+";");
		Buffer.append(JOptionPane.showInputDialog("Digite o nome do artista")+";");
		Buffer.append(Integer.parseInt( JOptionPane.showInputDialog("Digite o tempo da musica *Coloque no formato: Minutos:Segundos")));
		if (lista.isEmpty()) {
			lista.addFirst(Buffer.toString());
		}else {
			try {
				lista.addLast(Buffer.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void removeMusica(IListaString lista) throws Exception {
		int tam = lista.size();
		System.out.println( "Posição" + espaço(7)
		+ "Nome da Musica" + espaço(14) + 
		"Nome do Artista" + espaço(15) +
		"Tempo");
		for (int J=0;J<tam;J++) {
			
			try {
				String[] vetLinha = lista.get(J).split(";");
				System.out.println( (J) + espaço(1)
						+ vetLinha[0] + espaço(vetLinha[0].length()) + 
						vetLinha[1] + espaço(vetLinha[1].length()) +
						vetLinha[2]);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		int Pos = Integer.parseInt(JOptionPane.showInputDialog("Qual posição da musica que deseja remover"));
		if (lista.isEmpty()) {
			throw new Exception("Lista esta vazia");
		} else {
			lista.remove(Pos);
		}
		
		
	}
	public void executaPlaylist(IListaString lista) throws Exception {
		int J = 0;
		while (!lista.isEmpty()) {
			String[] vetLinha = lista.get(J).split(";");
			System.out.println("Musica: "+ vetLinha[0] + espaço(vetLinha[0].length()) + 
					"Artista: "+vetLinha[1] + espaço(vetLinha[1].length()) +
					"Tempo: "+vetLinha[2]);
			String[] Temp = vetLinha[2].split(":");
			int T = Integer.parseInt(Temp[0])*60 + Integer.parseInt(Temp[1]);
			Thread.sleep(T);
			lista.removeFirst();
		}
	}
	
	
	
	public String espaço(int Cont) {
		
		StringBuffer Buffer = new StringBuffer();
		if(Cont == 30) {
			return Buffer.append(" ").toString();
		}else {
			Buffer.append(" ");
			Buffer.append(espaço(Cont+1));
			return Buffer.toString();
		}
		
	}
}
