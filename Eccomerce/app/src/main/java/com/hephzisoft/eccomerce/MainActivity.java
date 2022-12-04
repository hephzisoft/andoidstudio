package com.hephzisoft.eccomerce;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.sidenav);
        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);
        homepage();
        navigationView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    homepage();
                    break;
                case R.id.store:
                    storePage();
                    break;
                case R.id.cart:
                    cartPage();
                    break;

                default:

            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


    }

    public void homepage() {
//        Fragment fragment = new Home();
//        FragmentManager fm  = get
//        SupportFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.replace(R.id.pages, fragment);
//        ft.commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.pages, new Home()).commit();
    }

    public void cartPage() {
        getSupportFragmentManager().beginTransaction().replace(R.id.pages, new Cart()).commit();
    }
    public void storePage() {
        getSupportFragmentManager().beginTransaction().replace(R.id.pages, new Store()).commit();
    }


}