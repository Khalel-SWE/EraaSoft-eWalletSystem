package service.Impl;

import model.Account;
import model.WalletSystem;
import service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    private WalletSystem walletSystem = new WalletSystem();

    @Override
    public boolean createAccount(Account account) {
        List<Account> accounts = walletSystem.getAccounts();

        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUserName().equals(account.getUserName())) {
                return false;
            }
        }
        walletSystem.getAccounts().add(account);
        return true;
    }

    @Override
    public boolean findAccount(Account account) {
        List<Account> accounts = walletSystem.getAccounts();

        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUserName().equals(account.getUserName())
            && accounts.get(i).getPassword().equals(account.getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deposit(Account account, double money) {
        //TODO
        // * check if account exist on eWallet if account not exist return false
        // * add money to account if success return true
        return false;
    }

    @Override
    public boolean withdraw(Account account, double money) {
        //TODO
        // * check if account exist on eWallet if account not exist return false
        // * check if money is greater than or equal balance of account return false
        // * cut money from account if success return true
        return false;
    }

    @Override
    public boolean transfer(Account account, String transferAccount, double money) {
        //TODO
        // * check if account exist on eWallet if account not exist return false
        // * check if transferAccount exist on eWallet if account not exist return false
        // * check if money is greater than or equal balance of account return false
        // * cut money from account and add it to transferAccount success return true
        return false;
    }

    @Override
    public Account showProfileDetails(Account account) {
        //TODO
        // * check if account exist on eWallet if account not exist return false
        // * if exist return account if not exist return null
        return null;
    }

    //TODO private function to check if the account exist on eWallet system.
}
