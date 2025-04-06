package service.Impl;

import model.Account;
import model.WalletSystem;
import service.AccountService;

public class AccountServiceImpl implements AccountService {

    private WalletSystem walletSystem = new WalletSystem();
    @Override
    public boolean createAccount(Account account) {
        walletSystem.getAccounts().add(account);
        return true;
    }
}
