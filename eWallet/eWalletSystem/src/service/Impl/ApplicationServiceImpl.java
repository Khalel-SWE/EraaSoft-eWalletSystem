package service.Impl;

import model.Account;
import service.AccountService;
import service.ApplicationService;
import service.DataValidation;

import java.util.Objects;
import java.util.Scanner;

public class ApplicationServiceImpl implements ApplicationService {

    private Scanner scanner = new Scanner(System.in);

    private AccountService accountService = new AccountServiceImpl();

    private DataValidation dataValidation = new DataValidationImpl();

    @Override
    public void start() {

        System.out.println("------------> HI Sir I hope to be good <------------");

        int counter = 0;
        while (true) {
            System.out.println("Please enter your choose...");
            System.out.println("1.login      2.create account    3.exit");

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
                    counter++;
                    if (counter != 4){
                        System.out.println("Invalid choice please try another one...");
                    }
            }

            if (exit) {
                break;
            }

            if (counter == 4) {
                System.out.println("Please try after an hour");
                break;
            }
        }
    }

    private void login() {

        scanner.nextLine();

        Account account = extractAccount();

        if (Objects.isNull(account)) {
            return;
        }

        boolean accountExist = accountService.findAccount(account);

        if (accountExist) {
            mainPage(account);
        } else {
            System.out.println("Invalid username or password, please create an account or double check with what you inserted ");
        }
    }

    private void mainPage(Account account) {
        System.out.println("a.deposit     b.withdraw    c.transfer   d.show profile details  e.exit");

        //TODO please create switch case
        //TODO every case must match function and apply feature for ( multi loop, 4 chance to insert a valid case or keck the user out..)
        int counter = 0;
        while (true) {
            char choose = scanner.next().charAt(0);

            boolean exit = false;
            switch (choose) {
                case 'a':
                    deposit(account);
                    break;
                case 'b':
                    withdraw(account);
                    break;
                case 'c':
                    transfer(account);
                    break;
                case 'd':
                    showProfileDetails(account);
                    break;
                case 'e':
                    System.out.println("Thanks your time, we hope we served you as you want");
                    break;
                default:
                    counter++;
                    if (counter != 4) {
                        System.out.println("Sorry invalid choice, please redo the process");
                    }
                    
            }
        }
    }

    private void showProfileDetails(Account account) {
    }

    private void transfer(Account account) {
    }

    private void withdraw(Account account) {
    }

    private void deposit(Account account) {
    }

    private void createAccount() {

        scanner.nextLine();

        Account account = extractAccount();

        if (Objects.isNull(account)) {
            return;
        }

        boolean account1Created = accountService.createAccount(account);

        if (account1Created) {
            System.out.println("Account created successfully");
        } else {
            System.out.println("The username you used has been already used, please try another one");
        }
    }

    private Account extractAccount(){
        System.out.println("*** Please enter username ***");
        String userName = scanner.nextLine();

        if (!dataValidation.validateUserName(userName)) {
            System.out.println("invalid username please enter a username size >= 3 and first char must be Uppercase");
            return null;
        }
        System.out.println("*** Please enter password ***");
        String password = scanner.nextLine();

        if (!dataValidation.validatePassword(password)) {
            System.out.println("invalid password size it must be >= 6 and must contain number, upper char, lower char and special char");
            return null;
        }

        return new Account(userName, password);
    }
}
