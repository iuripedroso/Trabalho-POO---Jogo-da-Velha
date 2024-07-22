package jogodavelha;

/**
 * Representa um tabuleiro de Jogo da Velha de 5x5.
 * @author Iuri Pedroso
 */
public class Tabuleiro5x5 {
    /** Matriz que armazena o estado do tabuleiro. */
    public char[][] tabuleiro;

    /**
     * Inicializa o tabuleiro preenchendo todas as posições com o símbolo '□'.
     */
    public void IniciaTabuleiro() {
        tabuleiro = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
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
        char[] linhas = {'A','B','C','D','E'};
        System.out.println("   1  2  3  4  5");
        for (int i = 0; i < 5; i++) {
            System.out.print(linhas[i]);
            for (int j = 0; j < 5; j++) {
                System.out.print("  " + tabuleiro[i][j]);
            }
            System.out.println();
        }
    }
}
