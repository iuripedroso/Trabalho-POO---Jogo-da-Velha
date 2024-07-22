package entradadados;

import java.util.Scanner;

/**
 * Gerencia a entrada de dados do usuário através do console.
 * @author Joao Pedro
 */
public class Console {
    private Scanner sc;

    /**
     * Inicializa um novo Scanner para leitura da entrada padrão.
     */
    public Console() {
        sc = new Scanner(System.in);
    }

    /**
     * Lê uma linha de texto da entrada padrão.
     *
     * @return A linha de texto lida.
     */
    public String ReceberEntrada() {
        return sc.nextLine();
    }
}
