import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Daniela Vescia Menna Barreto
 *
 */
public class Labirinto {
	//atributo
	private char [][] estrutura;

	//construtor
	public Labirinto(char [][] estrutura){	
		this.estrutura = estrutura;	
	}

	//propriedade
	public char [][] getEstrutura() {
		return estrutura;
	}

	public void setEstrutura(char [][] estrutura) {
		this.estrutura = estrutura;
	}
	

	//método recursivo publico que verifica se há saída(char = D) do labirinto. Se há saída retorna a sua posição e se não há retorna -1, -1	
	public static int[] retornaIndicesSaida(char [][] labirinto) {
		char saida = 'D';
		int coluna = labirinto[0].length - 1;
		int linha = labirinto.length - 1;

		if(labirinto[linha][coluna] == saida) {
			return new int[] {linha, coluna};
			
		} else{
			return retornaIndicesSaida(labirinto, saida, 0, 0, linha, coluna);
		}
	}

	//método que retorna a posicao da saida através de uma busca recursiva em toda a estrutura do array bidimensional
	private static int[] retornaIndicesSaida(char [][] labirinto,  char saida, int posicaoLinha, int posicaoColuna, int qntLinhas, int qntColunas) {

		while (!(posicaoLinha >= qntLinhas && posicaoColuna>=qntColunas)) {

			if (labirinto[posicaoLinha][posicaoColuna] == saida) {
				return new int[] {posicaoLinha, posicaoColuna};   

			} else if(posicaoColuna >= qntColunas) {
				return retornaIndicesSaida(labirinto, saida, posicaoLinha+1, posicaoColuna = 0, qntLinhas, qntColunas);	
			}

			return retornaIndicesSaida(labirinto,saida, posicaoLinha, posicaoColuna+1, qntLinhas, qntColunas);
		}
		return new int[] {-1,1};
	}
	
	public static boolean isCaminho(int[] posicao, char [][] labirinto) {
		
		if((labirinto[posicao[0]][posicao[1]]  == ' ')) {
			return true;
		}
		
		return false;
			
	}
	
	
	

	//método que que cria um File para ser lido no método criaLabirinto
	public static File caminhoArquivo() throws FileNotFoundException {

	    String caminhoArquivo = "src/LabirintoTeste_tudoPar.txt";
	    File arquivo = new File(caminhoArquivo);

	    // Verifica se o caminho do arquivo existe. Se não existir, lança uma exceção FileNotFoundException
	    if (!arquivo.exists()) {
	        throw new FileNotFoundException("O caminho especificado não existe: " + caminhoArquivo);    
	    }
	    return arquivo;
	}
	

	public static char[][] criaLabirinto(File arquivo) throws IOException {  

		//inicialização de objetos para ler o arquivo txt e criar o labirinto
		BufferedReader br = new BufferedReader(new FileReader(arquivo));
		String [] conteudoArquivo;
		String linha = br.readLine();
		ArrayList<Character> listaChar = new ArrayList<>();
		char  [][]  labirintoTxt = null;
		int qntLinha = 0;


		try {
			//lê a linha do arquivo e realiza a separação dos caracteres e adiciona a uma lista e logo após adiciona a matriz de char.
			//a leitura é interrompida ao chegar no final do arquivo
			while(linha !=null) {

				qntLinha++;
				conteudoArquivo = linha.split("(?<=.)");

				for(String caracter: conteudoArquivo) {

					listaChar.add(caracter.charAt(0));

				}

				linha = br.readLine();
			}

			labirintoTxt = criarMatrizChar(qntLinha, listaChar);		

			br.close();

		} catch(IOException e) {

			e.getMessage();	
		}

		return labirintoTxt;	

	}

	public static char [][] criarMatrizChar(int qntLinhas, ArrayList<Character> listaChar) throws FileNotFoundException{

		if(listaChar == null) {
			System.out.println("A lista esta nula!Recarregue o arquivo do labirinto novamente!");
			caminhoArquivo();
		}
		
		int qntElementos = listaChar.size(); 
		int qntColunas = qntElementos/qntLinhas;

		char [][] labirintoTxt = new char[qntLinhas][qntColunas];
		int k =1;

		for(int i = 0; i < qntLinhas; i++) {
			for(int j = 0; j < qntColunas; j++) {

				labirintoTxt[i][j] = listaChar.get(k-1);
				k++;
			}
		}

		return labirintoTxt;
	}


	//imprime o array bidimensional de char
	public static void imprimeLabirinto(char [][] labirintoTxt) {

		for(int i = 0; i < labirintoTxt.length; i++) {
			for(int j = 0; j < labirintoTxt[i].length; j++) {

				if(j==0) {
					System.out.println();
				}
				System.out.print(labirintoTxt[i][j]);
			}	
		}
	}
}
