package com.example.shopway.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.shopway.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    NavController navController;
    NavigationView navigationDrawer;
    DrawerLayout drawerLayout;
    FloatingActionButton fabCart;

    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.init();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fabCart = findViewById(R.id.fab);
        fabCart.setOnClickListener(v -> navController.navigate(R.id.nav_cart));

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        navigationDrawer = findViewById(R.id.navigation_drawer);

        NavigationUI.setupWithNavController(navigationDrawer, navController);

        checkIfSignedIn();

    }

    public void signOut(MenuItem item)
    {
        viewModel.signOut();
    }

    private void checkIfSignedIn()
    {
        viewModel.getCurrentUser().observe(this, user ->
        {
            if(user != null)
            {
                String message = "Welcome back " + user.getDisplayName() + "!";
                //welcome.setText(message);
            } else {
                startLoginActivity();
            }
        });
    }

    private void startLoginActivity()
    {
        startActivity(new Intent(this, SignInActivity.class));
        finish();
    }

}
