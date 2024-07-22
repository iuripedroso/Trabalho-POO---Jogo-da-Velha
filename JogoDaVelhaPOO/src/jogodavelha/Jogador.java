package jogodavelha;

/**
 * Representa um jogador no jogo da velha.
 * @author Joao Pedro e Iuri Pedroso
 */
public class Jogador {
    private String nome;
    private char tipo;
    private int pontuacao;

    /**
     * Construtor para criar um novo jogador.
     *
     * @param nome o nome do jogador.
     * @param tipo o símbolo do jogador 'X' ou 'O'.
     * @param pontuacao a pontuação inicial do jogador.
     */
    public Jogador(String nome, char tipo, int pontuacao) {
        this.nome = nome;
        this.tipo = tipo;
        this.pontuacao = pontuacao;
    }

    /**
     * Retorna o nome do jogador.
     *
     * @return o nome do jogador.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do jogador.
     *
     * @param nome o nome do jogador.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o símbolo do jogador.
     *
     * @return o símbolo do jogador.
     */
    public char getTipo() {
        return tipo;
    }

    /**
     * Define o símbolo do jogador.
     *
     * @param tipo o símbolo do jogador.
     */
    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna a pontuação do jogador.
     *
     * @return a pontuação do jogador.
     */
    public int getPontuacao() {
        return pontuacao;
    }

    /**
     * Define a pontuação do jogador.
     *
     * @param pontuacao a nova pontuação do jogador.
     */
    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    /**
     * Incrementa a pontuação do jogador.
     */
    public void incrementarPontuacao() {
        this.pontuacao++;
    }
}
