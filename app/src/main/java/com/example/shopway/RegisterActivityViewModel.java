package com.example.shopway;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.shopway.model.Account;
import com.example.shopway.model.ProfileRepository;

public class RegisterActivityViewModel extends ViewModel {

    private ProfileRepository repository;
    private MutableLiveData<Integer> result;


    public RegisterActivityViewModel()
    {
        repository = ProfileRepository.getInstance();
        result = new MutableLiveData<>();
    }

    public LiveData<Integer> registerAttempt(Account account)
    {
       return repository.register(account);
    }


}
