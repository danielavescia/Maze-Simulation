# *Labirinto*
Este programa implementa um algoritmo para percorrer um labirinto representado por uma matriz de caracteres. O objetivo é encontrar um caminho da saída (marcada como 'D') até entrada (posição [0][0]).

- # Requisitos
Java 8 ou superior
Executando o programa
Clone este repositório em sua máquina local.

Compile o código-fonte executando o seguinte comando no terminal:
javac Principal.java

Execute o programa com o seguinte comando:
java Principal

# *Descrição do código*
O código está organizado em três classes:

- *Labirinto:* Implementa os métodos para percorrer o labirinto e encontrar o caminho da saída até a entrada. Contém os seguintes métodos principais:

- percorreLabirinto: Método público que inicia a busca do caminho até a saída.
- percorreLabirinto (sobrecarregado): Método privado recursivo que realiza a busca do caminho até a saída.
- retornaIndicesSaida: Método público que encontra a posição da saída na matriz do labirinto.
- isPosicaoValida: Método público que verifica se uma posição está dentro dos limites do labirinto.
- Outros métodos auxiliares.

- *Principal:* Classe com o método main que é responsável por executar o programa. Neste exemplo, o labirinto é lido a partir de um arquivo de texto e o algoritmo é executado para encontrar um caminho até a saída. O resultado é exibido no console.

- *TesteUnidadeLabirinto:* Classe de teste JUnit que contém casos de teste para verificar o programa.

# Arquivos
 - Labirinto.java: Contém a implementação da classe Labirinto.
 - Principal.java: Contém a implementação da classe Principal.
 - TesteUnidadeLabirinto.java: Contém a implementação dos testes de unidade.

# Testes
A classe TesteUnidadeLabirinto contém casos de teste para verificar o programa. Os testes incluem:

- Verificar se o método retornaIndicesSaida encontra corretamente a posição da saída na matriz do labirinto.
- Verificar se o método percorreLabirinto retorna corretamente se há um caminho até a saída
