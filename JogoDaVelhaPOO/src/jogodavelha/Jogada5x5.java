package jogodavelha;

import entradadados.Console;

/**
 * Gerencia as jogadas em um tabuleiro de Jogo da Velha 5x5.
 * Solicita e valida as jogadas dos jogadores.
 * @author Iuri Pedroso
 */
public class Jogada5x5 {
    private Console console;

    /**
     * Inicializa a instância de console.
     */
    public Jogada5x5() {
        console = new Console();
    }

    /**
     * Solicita uma jogada do jogador e atualiza o tabuleiro.
     *
     * Valida a entrada e garante que a posição escolhida esteja disponível.
     *
     * @param tabuleiro O tabuleiro do jogo.
     * @param jogador O jogador que faz a jogada.
     */
    public void solicitarJogada(char[][] tabuleiro, Jogador jogador) {
        boolean jogadaValida = false;

        while (!jogadaValida) {
            int linha = 0;
            int coluna = 0;
            System.out.println("Vez do jogador: " + jogador.getNome());
            System.out.print("Digite a casa = ");
            String casa = console.ReceberEntrada().toUpperCase();
            char simbolo = jogador.getTipo();

            switch (casa.charAt(0)) {
                case 'A':
                    linha = 0;
                    break;
                case 'B':
                    linha = 1;
                    break;
                case 'C':
                    linha = 2;
                    break;
                case 'D':
                    linha = 3;
                    break;
                case 'E':
                    linha = 4;
                    break;
                default:
                    System.out.println("Linha inválida, tente novamente.");
                    continue;
            }

            switch (casa.charAt(1)) {
                case '1':
                    coluna = 0;
                    break;
                case '2':
                    coluna = 1;
                    break;
                case '3':
                    coluna = 2;
                    break;
                case '4':
                    coluna = 3;
                    break;
                case '5':
                    coluna = 4;
                    break;
                default:
                    System.out.println("Coluna inválida, tente novamente.");
                    continue;
            }

            if (tabuleiro[linha][coluna] == '□') {
                tabuleiro[linha][coluna] = simbolo;
                jogadaValida = true;
            } else {
                System.out.println("Posição inválida ou já ocupada, tente novamente.");
            }
        }
    }
}
