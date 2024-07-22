package armazenamento;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementa o gerenciamento de jogadores usando um arquivo para armazenamento persistente.
 * @author Iuri Pedroso
 */
public class GerenciaJogadoresArquivo implements GerenciaJogadores {
    private final String caminhoArquivo;

    /**
     * Inicializa com o caminho do arquivo para armazenamento dos dados dos jogadores.
     *
     * @param caminhoArquivo Caminho do arquivo.
     */
    public GerenciaJogadoresArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    /**
     * Adiciona ou atualiza um jogador no arquivo.
     *
     * @param nome Nome do jogador.
     * @param pontuacao Pontuação do jogador.
     */
    @Override
    public void adicionarJogador(String nome, int pontuacao) {
        Map<String, Integer> jogadores = lerArquivo();
        jogadores.put(nome, pontuacao);
        escreverArquivo(jogadores);
    }

    /**
     * Obtém a pontuação de um jogador pelo nome a partir do arquivo.
     *
     * @param nome Nome do jogador.
     * @return Pontuação do jogador, ou 0 se o jogador não existir.
     */
    @Override
    public int obterPontuacao(String nome) {
        Map<String, Integer> jogadores = lerArquivo();
        return jogadores.getOrDefault(nome, 0);
    }

    /**
     * Atualiza a pontuação de um jogador no arquivo.
     *
     * @param nome Nome do jogador.
     * @param pontuacao Nova pontuação do jogador.
     */
    @Override
    public void atualizarPontuacao(String nome, int pontuacao) {
        Map<String, Integer> jogadores = lerArquivo();
        jogadores.put(nome, pontuacao);
        escreverArquivo(jogadores);
    }

    private Map<String, Integer> lerArquivo() {
        Map<String, Integer> jogadores = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split("=");
                if (partes.length == 2) {
                    jogadores.put(partes[0], Integer.parseInt(partes[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jogadores;
    }

    private void escreverArquivo(Map<String, Integer> jogadores) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (Map.Entry<String, Integer> entrada : jogadores.entrySet()) {
                writer.write(entrada.getKey() + "=" + entrada.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
