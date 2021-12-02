package com.example.shopway.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.shopway.model.ItemRepository;
import com.example.shopway.model.UserRepository;
import com.google.firebase.auth.FirebaseUser;

import org.jetbrains.annotations.NotNull;

public class MainActivityViewModel extends AndroidViewModel {
    private final UserRepository repository;
    private final ItemRepository itemRepository;

    public MainActivityViewModel(Application application) {
        super(application);
        repository = UserRepository.getInstance(application);
        itemRepository = ItemRepository.getInstance();
    }

    public void init()
    {
        String userId = repository.getCurrentUser().getValue().getUid(); //Probably will need this for the cart
    }

    public LiveData<FirebaseUser> getCurrentUser()
    {
        return repository.getCurrentUser();
    }

    public void signOut()
    {
        repository.signOut();
    }

}
