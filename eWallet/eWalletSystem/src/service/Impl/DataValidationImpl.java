package service.Impl;

import service.DataValidation;

public class DataValidationImpl implements DataValidation {
    @Override
    public boolean validateUserName(String userName) {
        //TODO check if username size is >= 3 and first char is upper return True, else return false.
        return false;
    }

    @Override
    public boolean validatePassword(String password) {
        //TODO check if password size >= 6 and must contain number, upper char, lower char and special char return true
        return false;
    }
}
