package armazenamento;

/**
 * Interface para gerenciamento de jogadores.
 * @author Iuri Pedroso
 */
public interface GerenciaJogadores {
    /**
     * Adiciona um jogador ou atualiza sua pontuação.
     *
     * @param nome Nome do jogador.
     * @param pontuacao Pontuação do jogador.
     */
    void adicionarJogador(String nome, int pontuacao);

    /**
     * Obtém a pontuação de um jogador pelo nome.
     *
     * @param nome Nome do jogador.
     * @return Pontuação do jogador.
     */
    int obterPontuacao(String nome);

    /**
     * Atualiza a pontuação de um jogador.
     *
     * @param nome Nome do jogador.
     * @param pontuacao Nova pontuação do jogador.
     */
    void atualizarPontuacao(String nome, int pontuacao);
}
