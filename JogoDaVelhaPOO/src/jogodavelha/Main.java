package jogodavelha;

import armazenamento.GerenciaJogadores;
import armazenamento.GerenciaJogadoresArquivo;
import armazenamento.GerenciaJogadoresArrayList;
import entradadados.Console;

/**
 * Classe principal que inicializa o jogo e gerencia a pontuação dos jogadores.
 * @author Joao Pedro e Iuri Pedroso
 */
public class Main {

    /**
     * Método principal para iniciar o jogo.
     */
    public static void main(String[] args) {
        Console console = new Console();

        System.out.println("Digite o nome do jogador 1 = ");
        String nome1 = console.ReceberEntrada();
        Jogador jogador1 = new Jogador(nome1, 'X', 0);

        System.out.println("Digite o nome do jogador 2 = ");
        String nome2 = console.ReceberEntrada();
        Jogador jogador2 = new Jogador(nome2, 'O', 0);

        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
        System.out.println("---- MODOS DE JOGO ----");
        System.out.println("1. Jogo da Velha 3x3");
        System.out.println("2. Jogo da Velha 5x5");
        System.out.println();
        int modoJogo = Integer.parseInt(console.ReceberEntrada());

        GerenciaJogadores gerenciaArquivo = new GerenciaJogadoresArquivo("pontuacao_jogadores.txt");
        GerenciaJogadores gerenciaLista = new GerenciaJogadoresArrayList();

        switch (modoJogo) {
            case 1:
                Jogo jogo = new Jogo(jogador1, jogador2);
                jogo.jogar();
                break;
            case 2:
                Jogo5x5 jogo5x5 = new Jogo5x5(jogador1, jogador2);
                jogo5x5.jogar();
                break;
        }

        gerenciaArquivo.adicionarJogador(jogador1.getNome(), jogador1.getPontuacao());
        gerenciaArquivo.adicionarJogador(jogador2.getNome(), jogador2.getPontuacao());

        gerenciaLista.adicionarJogador(jogador1.getNome(), jogador1.getPontuacao());
        gerenciaLista.adicionarJogador(jogador2.getNome(), jogador2.getPontuacao());

        for (int i = 0; i < 20; i++) {
            System.out.println();
        }

        System.out.println("Pontuação do " + jogador1.getNome() + " na lista: " + gerenciaLista.obterPontuacao(jogador1.getNome()));
        System.out.println("Pontuação do " + jogador2.getNome() + " na lista: " + gerenciaLista.obterPontuacao(jogador2.getNome()));
    }
}
