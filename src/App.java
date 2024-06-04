import Sistema.Sistema;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Boas Vindas!");
        Sistema sistema = new Sistema();
        sistema.menuInicial(scanner);
    }
}
