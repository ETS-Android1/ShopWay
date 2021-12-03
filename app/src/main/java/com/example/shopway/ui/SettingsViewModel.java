package com.example.shopway.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.shopway.model.UserRepository;
import com.example.shopway.model.UserSettings;

import org.jetbrains.annotations.NotNull;

public class SettingsViewModel extends AndroidViewModel {

    UserRepository repository;

    public SettingsViewModel(Application application) {
        super(application);
        repository = UserRepository.getInstance(application);
    }

    public void init()
    {
        String userId = repository.getCurrentUser().getValue().getUid();
        repository.init(userId);
    }

    public void saveSettings(String sName, String sAge, String sAddress, String sCity, String sPost)
    {
        repository.saveSettings(sName, sAge, sAddress, sCity, sPost);
    }

    public LiveData<UserSettings> getSettings()
    {
        return repository.getSettingsLiveData();
    }

}
