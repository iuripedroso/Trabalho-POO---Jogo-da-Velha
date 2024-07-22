package jogodavelha;

/**
 * Representa um tabuleiro de Jogo da Velha de 3x3.
 * @author Joao Pedro
 */
public class Tabuleiro {
    /** Matriz que armazena o estado do tabuleiro. */
    public char[][] tabuleiro;

    /**
     * Inicializa o tabuleiro preenchendo todas as posições com o símbolo '□'.
     */
    public void IniciaTabuleiro() {
        tabuleiro = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = '□';
            }
        }
    }

    /**
     * Retorna o tabuleiro atual.
     *
     * @return a matriz do tabuleiro.
     */
    public char[][] getTabuleiro() {
        return tabuleiro;
    }

    /**
     * Imprime o tabuleiro no console.
     */
    public void ImprimirTabuleiro() {
        char[] linhas = {'A','B','C'};
        System.out.println("   1  2  3");
        for (int i = 0; i < 3; i++) {
            System.out.print(linhas[i]);
            for (int j = 0; j < 3; j++) {
                System.out.print("  " + tabuleiro[i][j]);
            }
            System.out.println();
        }
    }
}
