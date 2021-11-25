package com.example.shopway.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.shopway.model.UserRepository;
import com.google.firebase.auth.FirebaseUser;

import org.jetbrains.annotations.NotNull;

public class SignInViewModel extends AndroidViewModel {
    private final UserRepository repository;

    public SignInViewModel(Application application) {
        super(application);
        repository = UserRepository.getInstance(application);
    }

    public LiveData<FirebaseUser> getCurrentUser()
    {
        return repository.getCurrentUser();
    }
}
