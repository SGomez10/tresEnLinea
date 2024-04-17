import java.util.Locale;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);

        while (1>0){
            System.out.println("1. Nova partida\n2. Carregar partida\n3. Configuració\n4. Sortir");
            char input = sc.next().charAt(0);
            switch (input){
                case '1':
                    System.out.println("1. Nova partida");
                    break;
                case '2':
                    System.out.println("2. Carregar partida");
                    break;
                case '3':
                    System.out.println("3. Configuració");
                    break;
                case '4':
                    System.out.println("4. Sortir");
                    break;
                default:
                    break;
            }
            System.out.println();
        }
    }
}