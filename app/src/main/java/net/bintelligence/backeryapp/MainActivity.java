package net.bintelligence.backeryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

import net.bintelligence.backeryapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
//    private MasterProductListFragment masterProductListFragment;
//    private DetailProcessProductListFragment detailProcessProductListFragment;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        masterProductListFragment = new MasterProductListFragment();
//        detailProcessProductListFragment = new DetailProcessProductListFragment();
        navController = ((NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment))
                .getNavController();
    }

//codigo para probar un view model para manejar navigations
    //https://medium.com/@itscorey/android-data-binding-makes-navigation-better-f09f2f39744c
}