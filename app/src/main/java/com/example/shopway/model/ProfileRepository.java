package com.example.shopway.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ProfileRepository {

    private ProfileDAO profileDAO;
    private static ProfileRepository instance;

    private ProfileRepository()
    {
        profileDAO = ProfileDAO.getInstance();
    }

    public static ProfileRepository getInstance()
    {
        if(instance == null)
        {
            instance = new ProfileRepository();
        }
        return instance;
    }

    public LiveData<Account> verifyLogin(String username)
    {
     return profileDAO.getAccount(username);
    }

    public LiveData<Integer> register(Account account)
    {
      return profileDAO.registerAccount(account);
    }

}
