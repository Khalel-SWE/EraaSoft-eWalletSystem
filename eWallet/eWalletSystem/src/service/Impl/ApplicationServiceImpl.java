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
                    exit = true;
                    break;
                default:
                    counter++;
                    if (counter != 4) {
                        System.out.println("Sorry invalid choice, please redo the process");
                    } else {
                        System.out.println("You tried 4 times, please try again later");
                        exit = true;
                    }
            }

            if (exit) {
                break;
            }
        }
    }

    private void showProfileDetails(Account account) {
        //TODO call account service to showProfileDetails
        //TODO display (account username, account password, account balance).


    }

    private void transfer(Account account) {
        //TODO take username of user you need to transfer
        //TODO cut the money amount from the user account
        //TODO call account service to withdraw

        scanner.nextLine(); // consume newline
        System.out.println("Enter the username to transfer to:");
        String targetUsername = scanner.nextLine();

        System.out.println("Enter the amount to transfer:");
        double amount = scanner.nextDouble();

        boolean result = accountService.transfer(account, targetUsername, amount);

        if (result) {
            System.out.println("Transfer successful!");
        } else {
            System.out.println("Transfer failed. Please check account names or balance.");
        }
    }

    private void withdraw(Account account) {
        //TODO take money from user
        //TODO call account service to withdraw

        Account fullDetails = accountService.showProfileDetails(account);

        if (fullDetails != null) {
            System.out.println("Username: " + fullDetails.getUserName());
            System.out.println("Password: " + fullDetails.getPassword());
            System.out.println("Balance: " + fullDetails.getBalance());
        } else {
            System.out.println("Could not retrieve account details.");
        }

        System.out.println("Enter amount to withdraw:");
        double amount = scanner.nextDouble();

        boolean result = accountService.withdraw(account, amount);

        if (result) {
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Withdrawal failed. Please check your account balance or username.");
        }
    }

    private void deposit(Account account) {

        //TODO take money from user
        //TODO call account service to deposit

        System.out.println("Enter amount to deposit:");
        double amount = scanner.nextDouble();

        boolean result = accountService.deposit(account, amount);

        if (result) {
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Deposit failed. Please check your account.");
        }
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
