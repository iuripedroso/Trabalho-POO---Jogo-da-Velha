package jogodavelha;

import java.util.Scanner;
import java.util.Random;
/**
 * Gerencia o jogo da velha 5x5, incluindo a lógica de vitória e empate.
 * @author Iuri Pedroso
 */
public class Jogo5x5 {
    private Scanner scanner = new Scanner(System.in);
    private Tabuleiro5x5 tabuleiro;
    private Jogada5x5 jogada;
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorAtual;
    private Random random;
    private boolean novojogo = true;
    /**
     * Construtor para iniciar um jogo da velha 5x5.
     *
     * @param jogador1 o jogador 1.
     * @param jogador2 o jogador 2.
     */
    public Jogo5x5(Jogador jogador1, Jogador jogador2) {
        this.jogada = new Jogada5x5();
        this.tabuleiro = new Tabuleiro5x5();
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.random = new Random();
        int escolha = random.nextInt(2);
        if (escolha == 1) {
            this.jogadorAtual = jogador1;
        } else {
            this.jogadorAtual = jogador2;
        }
    }

    /**
     * Inicia o jogo e gerencia a alternância de turnos e condições de vitória.
     */
    public void jogar() {
        while (novojogo) {
            tabuleiro.IniciaTabuleiro();
            boolean jogoEmAndamento = true;

            while (jogoEmAndamento) {
                System.out.println();
                System.out.println();

                tabuleiro.ImprimirTabuleiro();
                jogada.solicitarJogada(tabuleiro.getTabuleiro(), jogadorAtual);

                if (verificarVitoria(tabuleiro.getTabuleiro())) {
                    tabuleiro.ImprimirTabuleiro();
                    System.out.println("Jogador " + jogadorAtual.getNome() + " venceu!");
                    jogadorAtual.incrementarPontuacao();
                    System.out.println("Pontuação do " + jogador1.getNome() + ": " + jogador1.getPontuacao());
                    System.out.println("Pontuação do " + jogador2.getNome() + ": " + jogador2.getPontuacao());
                    jogoEmAndamento = false;
                }

                if (verificarEmpate(tabuleiro.getTabuleiro())) {
                    tabuleiro.ImprimirTabuleiro();
                    System.out.println("Empate!");
                    System.out.println("Pontuação do " + jogador1.getNome() + ": " + jogador1.getPontuacao());
                    System.out.println("Pontuação do " + jogador2.getNome() + ": " + jogador2.getPontuacao());
                    jogoEmAndamento = false;
                }

                if (jogoEmAndamento) {
                    alternarJogador();
                }
            }

            try {
                System.out.print("Deseja continuar jogando? (s/n) ");
                String resposta = scanner.nextLine();
                if (resposta.equalsIgnoreCase("n")) {
                    novojogo = false;
                }
            } catch (Exception e) {
                System.err.println("Erro ao ler a resposta: " + e.getMessage());
                e.printStackTrace();
                novojogo = false;
            }

        }
    }
    /**
     * Verifica se houve vitória no tabuleiro.
     *
     * @param tabuleiro a matriz do tabuleiro.
     * @return true se houver vitória, caso contrário, false.
     */
    private boolean verificarVitoria(char[][] tabuleiro) {
        char tipo = jogadorAtual.getTipo();
        // Verificar linhas
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 1; j++) {
                if (tabuleiro[i][j] == tipo && tabuleiro[i][j+1] == tipo && tabuleiro[i][j+2] == tipo && tabuleiro[i][j+3] == tipo && tabuleiro[i][j+4] == tipo) {
                    return true;
                }
            }
        }
        // Verificar colunas
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 1; j++) {
                if (tabuleiro[j][i] == tipo && tabuleiro[j+1][i] == tipo && tabuleiro[j+2][i] == tipo && tabuleiro[j+3][i] == tipo && tabuleiro[j+4][i] == tipo) {
                    return true;
                }
            }
        }
        // Verificar diagonais
        for (int i = 0; i < 1; i++) {
            if (tabuleiro[i][i] == tipo && tabuleiro[i+1][i+1] == tipo && tabuleiro[i+2][i+2] == tipo && tabuleiro[i+3][i+3] == tipo && tabuleiro[i+4][i+4] == tipo) {
                return true;
            }
            if (tabuleiro[i][4-i] == tipo && tabuleiro[i+1][3-i] == tipo && tabuleiro[i+2][2-i] == tipo && tabuleiro[i+3][1-i] == tipo && tabuleiro[i+4][0-i] == tipo) {
                return true;
            }
        }
        return false;
    }
    /**
     * Verifica se há empate no tabuleiro.
     *
     * @param tabuleiro a matriz do tabuleiro.
     * @return true se houver empate, caso contrário, false.
     */
    private boolean verificarEmpate(char[][] tabuleiro) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (tabuleiro[i][j] == '□') {
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * Alterna o jogador atual.
     *
     * Este método muda o jogador atual para o outro jogador na partida
     */
    private void alternarJogador() {
        if (jogadorAtual == jogador1) {
            jogadorAtual = jogador2;
        } else {
            jogadorAtual = jogador1;
        }
    }
}
