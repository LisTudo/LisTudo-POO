import Sistema.Sistema;
import java.util.Scanner;

/**
 * Classe responsavel pela execucao do aplicativo
 */
public class App {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();

        sistema.boasVindas();
        sistema.menuInicial();
    }
}
