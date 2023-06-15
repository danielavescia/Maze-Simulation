

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

public class TesteUnidadeLabirinto {
	
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
    public void testeDoisRetornaIndiceSaida() {
    	char [][]labirinto = {{' ','X','X'}, {'X', ' ', 'X'},{'X', ' ', 'X'},{'D', ' ', ' '}};
        int[] posicaoEsperada = {3, 0};
        int[] posicaoAtual = Labirinto.retornaIndicesSaida(labirinto);
        assertArrayEquals(posicaoEsperada, posicaoAtual);
    }

    // Teste para encontrar um elemento que esta localizado na parte central da matriz.
    @Test
    public void testeTresRetornaIndiceSaida() {
    	char [][]labirinto = {{' ','X','X', 'X', ' ', 'X'}, {'X', ' ', 'X','X', ' ', 'X'},{'X', ' ', ' ','X', ' ', 'X'},{'X', ' ', 'X', ' ', 'D', 'X'},{' ', ' ', ' ', 'X', ' ', 'X'}};
        int[] posicaoEsperada = {3, 4};
        int[] posicaoAtual = Labirinto.retornaIndicesSaida(labirinto);
        assertArrayEquals(posicaoEsperada, posicaoAtual);
    }
    
    @Test
    public void testeProgramaUm() {
    boolean expected = true;
    
    char[][] labirinto2 = {
		    {' ', 'X', 'X', 'X', 'X', 'X'},
		    {' ', ' ', ' ', ' ', ' ', 'X'},
		    {'X', 'X', 'X', 'X', ' ', 'X'},
		    {'X', ' ', ' ', 'X', ' ', 'X'},
		    {'X', 'X', ' ', 'D', ' ', 'X'},
		    {'X', 'X', 'X', 'X', 'X', 'X'}
		};
	
	System.out.println();
	boolean returned = Labirinto.percorreLabirinto(labirinto2);
	assertEquals(expected, returned);
    }
    
    @Test
    public void testeProgramaDois() {
    boolean expected = false;
	char[][] labirinto3 = {
		    {'X', ' ', 'X', 'X', 'X'},
		    {'X', ' ', 'X', ' ', 'X'},
		    {'X', ' ', 'X', ' ', 'X'},
		    {'X', ' ', 'X', ' ', 'X'},
		    {'X', 'X', 'X', 'X', 'X'}
		};
	
	boolean returned = Labirinto.percorreLabirinto(labirinto3);
	assertEquals(expected, returned);
    }
    
    @Test
    public void testeProgramaTres() {
    boolean expected = true;
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
	
	boolean returned = Labirinto.percorreLabirinto(labirinto4);
	assertEquals(expected, returned);
    
    }
}
