package com.example.shopway.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shopway.R;
import com.example.shopway.model.UserSettings;
import com.firebase.ui.auth.data.model.User;

public class SettingsFragment extends Fragment {

    TextView name;
    TextView age;
    TextView address;
    TextView city;
    TextView postCode;
    EditText nameField;
    EditText ageField;
    EditText cityField;
    EditText addressField;
    EditText postField;
    Button saveSettings;

    private SettingsViewModel viewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        viewModel = new ViewModelProvider(this).get(SettingsViewModel.class);
        viewModel.init();

        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        name = view.findViewById(R.id.name_text);
        age = view.findViewById(R.id.age_text);
        address = view.findViewById(R.id.address_text);
        city = view.findViewById(R.id.city_text);
        postCode = view.findViewById(R.id.post_text);
        nameField = view.findViewById(R.id.name_field);
        ageField = view.findViewById(R.id.age_field);
        cityField = view.findViewById(R.id.city_field);
        addressField = view.findViewById(R.id.addres_field);
        postField = view.findViewById(R.id.post_field);
        saveSettings = view.findViewById(R.id.save_button);



        viewModel.getSettings().observe(getViewLifecycleOwner(), setSettings -> {
            if(setSettings != null) {
                nameField.setText(setSettings.getName());
                ageField.setText(setSettings.getAge());
                addressField.setText(setSettings.getAddress());
                cityField.setText(setSettings.getCity());
                postField.setText(setSettings.getPostCode());
            }
        });



        saveSettings.setOnClickListener(v -> {
            UserSettings settings = new UserSettings(nameField.getText().toString(),
                    ageField.getText().toString(), addressField.getText().toString(),
                    cityField.getText().toString(), postField.getText().toString());
            saveUserSettings(settings);

        });



        return view;
    }

    private void saveUserSettings(UserSettings settings)
    {
        viewModel.saveSettings(settings);
    }
}