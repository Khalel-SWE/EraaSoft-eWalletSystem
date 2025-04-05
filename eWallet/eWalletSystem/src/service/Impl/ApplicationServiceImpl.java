package service.Impl;

import service.ApplicationService;

import java.util.Scanner;

public class ApplicationServiceImpl implements ApplicationService {
    @Override
    public void start() {

        System.out.println("------------> HI Sir I hope to be good <------------");

        int counter
        while (true) {
            System.out.println("Please enter your choose...");
            System.out.println("1.login      2.create account    3.exit");

            Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();

            boolean exit = false;
            switch (choose) {
                case 1:
                    login();
                    break;
                case 2:
                    createAccount();
                    break;

                case 3:
                    System.out.println("Have a nice day Sir");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice please try another one...");
            }

            if (exit) {
                break;
            }
        }
    }

    private void login() {
        System.out.println("login");
    }

    private void createAccount() {
        System.out.println("create account");
    }
}
