import java.io.File;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) throws IOException {
		
		File arquivo; 
		char [][] labirintoTxt;
		boolean isTherePath = true;
		
		//inicio programa que le o labirinto do arquivo txt
		arquivo = Labirinto.caminhoArquivo();
		labirintoTxt = Labirinto.criaLabirinto(arquivo);
		isTherePath = Labirinto.percorreLabirinto(labirintoTxt);
		
		if(isTherePath) {
			System.out.println("Existe um caminho até a saída!");
		}
		
		else {
			System.out.println("Não há uma caminho até saida");
		}
	}
}
