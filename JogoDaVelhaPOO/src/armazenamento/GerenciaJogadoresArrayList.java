package armazenamento;

import jogodavelha.Jogador;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementa o gerenciamento de jogadores usando uma lista em memória.
 * @author Iuri Pedroso
 */
public class GerenciaJogadoresArrayList implements GerenciaJogadores {
    private final List<Jogador> jogadores = new ArrayList<>();

    /**
     * Adiciona um jogador ou atualiza sua pontuação se já existir.
     *
     * @param nome Nome do jogador.
     * @param pontuacao Pontuação do jogador.
     */
    @Override
    public void adicionarJogador(String nome, int pontuacao) {
        for (Jogador jogador : jogadores) {
            if (jogador.getNome().equals(nome)) {
                jogador.setPontuacao(pontuacao);
                return;
            }
        }
        jogadores.add(new Jogador(nome, ' ', pontuacao)); // Adiciona um tipo padrão
    }

    /**
     * Obtém a pontuação de um jogador pelo nome.
     *
     * @param nome Nome do jogador.
     * @return Pontuação do jogador, ou 0 se o jogador não existir.
     */
    @Override
    public int obterPontuacao(String nome) {
        for (Jogador jogador : jogadores) {
            if (jogador.getNome().equals(nome)) {
                return jogador.getPontuacao();
            }
        }
        return 0;
    }

    /**
     * Atualiza a pontuação de um jogador.
     *
     * @param nome Nome do jogador.
     * @param pontuacao Nova pontuação do jogador.
     */
    @Override
    public void atualizarPontuacao(String nome, int pontuacao) {
        adicionarJogador(nome, pontuacao);
    }
}
