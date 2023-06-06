import java.io.File;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) throws IOException {
		
		File arquivo; // E:\\Dani\\Dani\\SI\\Unisinos\\ProgramaçãoLabII\\Módulo 3 e 4\\Labirinto3232.txt    // E:\\Dani\\Dani\\SI\\Unisinos\\ProgramaçãoLabII\\DesafioLab\\LabirintoTeste_saidaLadoEsquerdo.txt
		char [][] labirintoTxt;
		int[] posicaoSaida;
		//boolean temCaminho;

		//inicio programa que le o labirinto do arquivo txt
		
		//arquivo = Labirinto.caminhoArquivo();
		arquivo = Labirinto.caminhoArquivo();
		labirintoTxt = Labirinto.criaLabirinto(arquivo);
		Labirinto.imprimeLabirinto(labirintoTxt);
		posicaoSaida = Labirinto.retornaIndicesSaida(labirintoTxt);
		System.out.println();
		System.out.println("Posição da saida no array = linha: "+ posicaoSaida[0]+ " e coluna:" + posicaoSaida[1]);
		System.out.println(Labirinto.percorreLabirinto(labirintoTxt));
	
		//System.out.println("linhas:" + labirintoTxt.length + " e " + "colunas"+ labirintoTxt[0].length);
		//temCaminho = Labirinto.percorreLabirinto(labirintoTxt);
		//System.out.println(temCaminho);
	}

}
