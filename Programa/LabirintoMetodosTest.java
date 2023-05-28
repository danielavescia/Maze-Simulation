import static org.junit.Assert.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class LabirintoMetodosTest {
	
	//Teste para verificar caminhos existentes

	// Teste para encontrar um elemento existente na direita inferior da matriz 
    @Test
    public void testeUmRetornaIndiceSaida() {
    	char [][]labirinto = {{' ','X','X'}, {'X', 'X', 'X'}, {' ', ' ', 'D'}};
        int[] posicaoEsperada = {2, 2};
        int[] posicaoAtual = Labirinto.retornaIndicesSaida(labirinto);
        assertArrayEquals(posicaoEsperada, posicaoAtual);
    }

    // Teste para encontrar um elemento que esta localizado na parte inferior esquerda da matriz.
    @Test
    public void testeDoisRetornaIndiceArrayBidimensionalElementoNaoExistente() {
    	char [][]labirinto = {{' ','X','X'}, {'X', ' ', 'X'},{'X', ' ', 'X'},{'D', ' ', ' '}};
        int[] posicaoEsperada = {3, 0};
        int[] posicaoAtual = Labirinto.retornaIndicesSaida(labirinto);
        assertArrayEquals(posicaoEsperada, posicaoAtual);
    }

    // Teste para encontrar um elemento que esta localizado na parte central da matriz.
    @Test
    public void testeTresRetornaIndiceArrayBidimensionalElementoNaoExistente() {
    	char [][]labirinto = {{' ','X','X', 'X', ' ', 'X'}, {'X', ' ', 'X','X', ' ', 'X'},{'X', ' ', ' ','X', ' ', 'X'},{'X', ' ', 'X', ' ', 'D', 'X'},{' ', ' ', ' ', 'X', ' ', 'X'}};
        int[] posicaoEsperada = {3, 4};
        int[] posicaoAtual = Labirinto.retornaIndicesSaida(labirinto);
        assertArrayEquals(posicaoEsperada, posicaoAtual);
    }
}
