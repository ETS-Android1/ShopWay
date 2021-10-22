package com.example.shopway.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class ProfileDAO {

    private MutableLiveData<List<Account>> profiles;
    private static ProfileDAO instance;


    private ProfileDAO()
    {
        profiles = new MutableLiveData<>();
        List<Account> newList = new ArrayList<>();
        newList.add(new Account("tati", "1234", "Tatiana Gori", "Hospitalsgade 4", "19834791"));
        newList.add(new Account("kiko", "123456", "Ilia Nikov", "Kamtjatka 11", "81906632"));

        profiles.setValue(newList);
    }

    public static ProfileDAO getInstance()
    {
        if(instance == null)
        {
            instance = new ProfileDAO();
        }
        return instance;
    }


    public LiveData<Account> getAccount(String username)
    {
        List<Account> currentAccounts = profiles.getValue();
        MutableLiveData<Account> account = new MutableLiveData<>();
        for(int i = 0; i < currentAccounts.size(); i++)
        {
            if(currentAccounts.get(i).getUsername().equals(username))
            {
                account.setValue(currentAccounts.get(i));
            }
        }
        return account;
    }

    public LiveData<Integer> registerAccount(Account account)
    {
        MutableLiveData<Integer> resultToSend =  new MutableLiveData<>();
        List<Account> currentProfiles = profiles.getValue();
        resultToSend.setValue(0);

        for(int i = 0; i < currentProfiles.size(); i++)
        {
            if(account.getUsername().equals(currentProfiles.get(i).getUsername()))
            {
                resultToSend.setValue(1);
            }
        }
        if(account.getPassword().length() < 3)
        {
            resultToSend.setValue(2);
        }

        if(resultToSend.getValue() == 0)
        {
            currentProfiles.add(account);
            profiles.setValue(currentProfiles);
        }

        return resultToSend;
    }


}
