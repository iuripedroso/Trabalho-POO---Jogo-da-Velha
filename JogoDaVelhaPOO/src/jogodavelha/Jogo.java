package jogodavelha;

import java.util.Scanner;
import java.util.Random;

/**
 * Gerencia o jogo da velha 3x3, incluindo a lógica de vitória e empate.
 * @author Joao Pedro
 */
public class Jogo {
    private Scanner scanner = new Scanner(System.in);
    private Tabuleiro tabuleiro;
    private Jogada jogada;
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorAtual;
    private Random random;
    private boolean novojogo = true;

    /**
     * Construtor para iniciar um jogo da velha 3x3.
     *
     * @param jogador1 o jogador 1.
     * @param jogador2 o jogador 2.
     */
    public Jogo(Jogador jogador1, Jogador jogador2) {
        this.jogada = new Jogada();
        this.tabuleiro = new Tabuleiro();
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
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == tipo && tabuleiro[i][1] == tipo && tabuleiro[i][2] == tipo) {
                return true;
            }
        }
        // Verificar colunas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[0][i] == tipo && tabuleiro[1][i] == tipo && tabuleiro[2][i] == tipo) {
                return true;
            }
        }
        // Verificar diagonais
        if (tabuleiro[0][0] == tipo && tabuleiro[1][1] == tipo && tabuleiro[2][2] == tipo) {
            return true;
        }
        if (tabuleiro[0][2] == tipo && tabuleiro[1][1] == tipo && tabuleiro[2][0] == tipo) {
            return true;
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
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
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
     * Este método muda o jogador atual para o outro jogador na partida.
     */
    private void alternarJogador() {
        if (jogadorAtual == jogador1) {
            jogadorAtual = jogador2;
        } else {
            jogadorAtual = jogador1;
        }
    }
}
