package com.example.shopway;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.shopway.model.Account;
import com.example.shopway.model.ProfileRepository;

public class MainActivityViewModel extends ViewModel {

    private ProfileRepository repository;
    private MutableLiveData<Boolean> loginResult;

    public MainActivityViewModel()
    {
        repository = ProfileRepository.getInstance();
        loginResult = new MutableLiveData<>();

    }

    public LiveData<Boolean> verifyLogin(String username, String password) {

        Account account = repository.verifyLogin(username).getValue();
        if( account.getPassword().equals(password))
        {
            loginResult.setValue(true);
        } else
        {
            loginResult.setValue(false);
        }
        return loginResult;
    }
}
