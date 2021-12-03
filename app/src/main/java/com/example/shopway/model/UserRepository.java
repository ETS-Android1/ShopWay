package com.example.shopway.model;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserRepository {
    private final UserLiveData currentUser;
    private final Application application;
    private static UserRepository instance;

    private DatabaseReference reference;
    private UserSettingsLiveData settingsLiveData;

    private UserRepository(Application app)
    {
        this.application = app;
        currentUser = new UserLiveData();
    }

    public static synchronized UserRepository getInstance(Application app)
    {
        if(instance == null)
        {
            instance = new UserRepository(app);
        }
        return instance;
    }

    public void init(String userId)
    {
        reference = FirebaseDatabase.getInstance().getReference().child("shopway-4ff4f-default-rtdb").child(userId);
        settingsLiveData = new UserSettingsLiveData(reference);
    }

    public LiveData<FirebaseUser> getCurrentUser()
    {
        return currentUser;
    }

    public void signOut()
    {
        AuthUI.getInstance().signOut(application.getApplicationContext());
    }

    public void saveSettings(String sName, String sAge, String sAddress, String sCity, String sPost)
    {
        reference.setValue(new UserSettings(sName, sAge, sAddress, sCity, sPost));
    }

    public UserSettingsLiveData getSettingsLiveData()
    {
        return settingsLiveData;
    }

}
