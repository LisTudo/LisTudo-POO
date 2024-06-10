import Sistema.Sistema;
import java.util.Scanner;

/**
 * Classe responsavel pela execucao do aplicativo
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Este objeto não está sendo utilizado.

        Sistema sistema = new Sistema();

        sistema.boasVindas();
        sistema.menuInicial();
    }
}
