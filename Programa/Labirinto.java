import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Daniela Vescia Menna Barreto
 *
 */
public class Labirinto {
	
	//atributos
	private static final char LIVRE = ' ';
	private static final char PAREDE = 'X';
	private static final char TESTADO = '*';
	private static final char SAIDA = 'D';
	private static char[][] labirinto;
	
	//métodos de acesso
	public static char[][] getLabirinto() {
		return labirinto;
	}

	public static void setLabirinto(char[][] labirinto) {
		Labirinto.labirinto = labirinto;
	}

	public static char getLivre() {
		return LIVRE;
	}

	public static char getParede() {
		return PAREDE;
	}

	public static char getTestado() {
		return TESTADO;
	}

	//método que retorna um boolean para encontrar um caminho até a saida do labirinto
	public static boolean percorreLabirinto(char[][] labirinto) {
	    
		char[][] labirintoClonado = clonaLabirinto(labirinto);
	    int[] posicaoSaida = retornaIndicesSaida(labirintoClonado);
	    int posicaoLinha = posicaoSaida[0];
	    int posicaoColuna = posicaoSaida[1];
	    
	    
	    System.out.printf("LABIRINTO FORNECIDO: %n");
	    imprimeLabirinto(labirinto);
	    System.out.printf("%n  CHECANDO CAMINHO ATÉ ENTRADA... %n");
	    
	    return percorreLabirinto(labirintoClonado, posicaoLinha, posicaoColuna);
	}

	//método privado recursivo que procura por um caminho até a saida
	private static boolean percorreLabirinto(char[][] labirintoClonado, int posicaoLinha, int posicaoColuna) {
	    
		int qntColunas = labirintoClonado[0].length;
	    int qntLinhas = labirintoClonado.length;

	    if (posicaoLinha == 0 && posicaoColuna == 0) {
	        return true;
	    }
	    
	    if (!isPosicaovalida(posicaoLinha, posicaoColuna, qntLinhas, qntColunas) || labirintoClonado[posicaoLinha][posicaoColuna] == TESTADO || labirintoClonado[posicaoLinha][posicaoColuna] == PAREDE) {
	        return false;
	    }
	    
	    labirintoClonado[posicaoLinha][posicaoColuna] = TESTADO; // marca a posição como visitada

	    imprimeLabirinto(labirintoClonado); // Exibe o programa caminhando no labirinto
	    wait(200);

	    // Movimenta para a esquerda
	    if (percorreLabirinto(labirintoClonado, posicaoLinha, posicaoColuna - 1)) {
	        return true;
	    }
	    // Movimenta para cima
	    if (percorreLabirinto(labirintoClonado, posicaoLinha - 1, posicaoColuna)) {
	        return true;
	    }
	    // Movimenta para a direita
	    if (percorreLabirinto(labirintoClonado, posicaoLinha, posicaoColuna + 1)) {
	        return true;
	    }
	    // Movimenta para baixo
	    if (percorreLabirinto(labirintoClonado, posicaoLinha + 1, posicaoColuna)) {
	        return true;
	    }

	    labirintoClonado[posicaoLinha][posicaoColuna] = LIVRE; // Remove a marcação da posição
	    imprimeLabirinto(labirintoClonado); 
	    
	    return false;
	}
	
    private static char[][] clonaLabirinto(char[][] labirinto) { //clona o labirinto para poder alterar no método percorreLabirinto
        char[][] labirintoClonado = new char[labirinto.length][labirinto[0].length];
        
        for (int i = 0; i < labirinto.length; i++) {
            labirintoClonado[i] = labirinto[i].clone();
        }
        
        return labirintoClonado;
	    }
    
    private static void wait(int milissegundos) { //tempo entre cada impressão
        try {
        	
            Thread.sleep(milissegundos);
        
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
	//método recursivo publico que verifica se há saída(char = D) do labirinto. Se há saída retorna a sua posição e se não há retorna -1, -1	
	public static int[] retornaIndicesSaida(char [][] labirinto) {
	
			int coluna = labirinto[0].length - 1;
			int linha = labirinto.length - 1;

			if(labirinto[linha][coluna] == SAIDA) {
				return new int[] {linha, coluna};
				
			} else{
				return retornaIndicesSaida(labirinto, 0, 0, linha, coluna);
			}
		}
		
	//método que retorna a posicao da saida através de uma busca recursiva em toda a estrutura do array bidimensional
	private static int[] retornaIndicesSaida(char [][] labirinto, int posicaoLinha, int posicaoColuna, int qntLinhas, int qntColunas) {

		while (!(posicaoLinha >= qntLinhas && posicaoColuna>=qntColunas)) {

			if (labirinto[posicaoLinha][posicaoColuna] == SAIDA) {
				return new int[] {posicaoLinha, posicaoColuna};   

			} else if(posicaoColuna >= qntColunas) {
				return retornaIndicesSaida(labirinto, posicaoLinha+1, posicaoColuna = 0, qntLinhas, qntColunas);	
			}

			return retornaIndicesSaida(labirinto, posicaoLinha, posicaoColuna+1, qntLinhas, qntColunas);
		}
		return new int[] {-1,1};
	}
	
	
	//metodo que retorna se a posicao recebida está dentro dos limites da matriz
	public static boolean isPosicaovalida(int posicaoLinha, int posicaoColuna,  int qntLinhas, int qntColunas) {

		 return posicaoLinha >= 0 && posicaoLinha < qntLinhas && posicaoColuna >= 0 && posicaoColuna < qntColunas;
		
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
	
	public static char[][] criaLabirinto(File arquivo) throws IOException, IllegalArgumentException {  
		
		if(!arquivo.exists()){
			throw new IllegalArgumentException();
		}
		
		else {
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

		} finally {
			br.close();
		}
		
		return labirintoTxt;
		}	

	}
	
	//cria um matriz a partir de uma lista de char
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
	public static void imprimeLabirinto(char [][] labirintoTxt)throws  NullPointerException {
		
		try {
			
		for(int i = 0; i < labirintoTxt.length; i++) {
			for(int j = 0; j < labirintoTxt[i].length; j++) {

				if(j==0) {
					System.out.println();
				}
				System.out.print(labirintoTxt[i][j]+ " ");
			}	
		}
		System.out.println();
		
		
	} catch(Exception e){
		e.getMessage();
	}
		
	}
}
