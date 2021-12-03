package com.example.shopway.model;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class UserSettingsLiveData extends LiveData<UserSettings> {
    private final ValueEventListener listener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
            UserSettings settings = snapshot.getValue(UserSettings.class);
            setValue(settings);
        }

        @Override
        public void onCancelled(@NonNull @NotNull DatabaseError error) {

        }
    };

    DatabaseReference reference;

    public UserSettingsLiveData(DatabaseReference reference)
    {
        this.reference = reference;
    }

    @Override
    protected void onActive() {
        super.onActive();
        reference.addValueEventListener(listener);
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        reference.removeEventListener(listener);
    }
}
