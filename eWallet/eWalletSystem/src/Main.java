import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("------------> HI Sir I hope to be good <------------");

        System.out.println("Please enter your choose...");
        System.out.println("1.login      2.create account    3.exit");

        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();

        switch (choose) {
            case 1:

                break;
            case 2:

                break;

            case 3:

                break;

            default:
                System.out.println("Invalid choice please try another one...");
        }
    }
}