import java.io.File;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) throws IOException {
		
		File arquivo; 
		char [][] labirintoTxt;
		int[] posicaoSaida;
		
		/*
		//inicio programa que le o labirinto do arquivo txt
		arquivo = Labirinto.caminhoArquivo();
		labirintoTxt = Labirinto.criaLabirinto(arquivo);
		Labirinto.imprimeLabirinto(labirintoTxt);
		posicaoSaida = Labirinto.retornaIndicesSaida(labirintoTxt);
		System.out.println();
		System.out.println("Posição da saida no array = linha: "+ posicaoSaida[0]+ " e coluna:" + posicaoSaida[1]);
		System.out.println(Labirinto.percorreLabirinto(labirintoTxt));
		 */
		
		
		char[][] labirinto2 = {
			    {' ', 'X', 'X', 'X', 'X', 'X'},
			    {' ', ' ', ' ', ' ', ' ', 'X'},
			    {'X', 'X', 'X', 'X', ' ', 'X'},
			    {'X', ' ', ' ', 'X', ' ', 'X'},
			    {'X', 'X', ' ', 'D', ' ', 'X'},
			    {'X', 'X', 'X', 'X', 'X', 'X'}
			};
		posicaoSaida = Labirinto.retornaIndicesSaida(labirinto2);
		System.out.println();
		System.out.println("Posição da saida no array = linha: "+ posicaoSaida[0]+ " e coluna:" + posicaoSaida[1]);
		System.out.println(Labirinto.percorreLabirinto(labirinto2));
		
		char[][] labirinto3 = {
			    {'X', ' ', 'X', 'X', 'X'},
			    {'X', ' ', 'X', ' ', 'X'},
			    {'X', ' ', 'X', ' ', 'X'},
			    {'X', ' ', 'X', ' ', 'X'},
			    {'X', 'X', 'X', 'X', 'X'}
			};
		
		System.out.println(Labirinto.percorreLabirinto(labirinto3));
		
		char [][] labirinto4 = {		 
				{' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
			    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
			    {'X', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X', 'X', 'X', ' ', ' ', ' ', ' ', 'X', 'X', 'X'},
			    {'X', 'X', 'X', 'X', ' ', ' ', 'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X'},
			    {'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', ' ', ' ', 'X', 'X'},
			    {'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'X', ' ', 'X', 'X'},
			    {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', ' ', ' ', ' ', ' ', ' '},
			    {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', ' ', ' ', ' ', 'X', ' ', ' ', 'X', 'X', 'D'}
		};
		
		System.out.println(Labirinto.percorreLabirinto(labirinto4));
		
	}
}	 
	
		//System.out.println("linhas:" + labirintoTxt.length + " e " + "colunas"+ labirintoTxt[0].length);
		//temCaminho = Labirinto.percorreLabirinto(labirintoTxt);
		//System.out.println(temCaminho);
	

