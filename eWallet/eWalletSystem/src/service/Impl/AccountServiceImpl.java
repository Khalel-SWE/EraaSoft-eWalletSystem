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

    //TODO create function for deposit
    //TODO create function for withdraw
    //TODO create function for transfer
    //TODO create function for show profile details
}
