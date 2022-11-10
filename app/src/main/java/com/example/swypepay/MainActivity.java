package com.example.swypepay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.swypepay.Fragments.AccountFragment;
import com.example.swypepay.Fragments.HomeFragment;
import com.example.swypepay.Fragments.ShopFragment;
import com.example.swypepay.Fragments.SmsFragment;
import com.example.swypepay.Fragments.TransactionFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);

        bottomNavigationView=findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment;

                switch(item.getItemId()){

                    case  R.id.homeMenu :

                        fragment= new HomeFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainLayout,fragment).commit();

                    break;

                    case R.id.shopMenu:

                        fragment= new ShopFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainLayout,fragment).commit();


                    break;

                    case R.id.transactionMenu :

                        fragment= new TransactionFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainLayout,fragment).commit();

                    break;

                    case  R.id.smsMenu :

                        fragment= new SmsFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainLayout,fragment).commit();

                    break ;

                   case R.id.accountMenu :

                       fragment= new AccountFragment();
                       getSupportFragmentManager().beginTransaction().replace(R.id.mainLayout,fragment).commit();

                    break ;


                }


                return true;
            }
        });


        if (savedInstanceState==null) {

            bottomNavigationView.setSelectedItemId(R.id.homeMenu);
        }


    }

    public void toastMessage(String message){

        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();

    }


}