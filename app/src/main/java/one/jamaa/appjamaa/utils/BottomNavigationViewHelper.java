package one.jamaa.appjamaa.utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import one.jamaa.appjamaa.R;
import one.jamaa.appjamaa.main.contract.ContractActivity;
import one.jamaa.appjamaa.main.exchange.ExchangeActivity;
import one.jamaa.appjamaa.main.home.HomeActivity;
import one.jamaa.appjamaa.main.profile.ProfileListActivity;
import one.jamaa.appjamaa.main.wallet.WalletActivity;

public class BottomNavigationViewHelper {

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx){
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.setTextVisibility(true);
    }

    public static void enableNavigation(final Context context, BottomNavigationViewEx view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.navigation_home:
                        Intent intent1 = new Intent(context, HomeActivity.class);
                        context.startActivity(intent1);
                        break;
                    case R.id.navigation_contract:
                        Intent intent2 = new Intent(context, ContractActivity.class);
                        context.startActivity(intent2);
                        break;
                    case R.id.navigation_exchange:
                        Intent intent3 = new Intent(context, ExchangeActivity.class);
                        context.startActivity(intent3);
                        break;
                    case R.id.navigation_profile:
                        Intent intent4 = new Intent(context, ProfileListActivity.class);
                        context.startActivity(intent4);
                        break;
                    case R.id.navigation_wallet:
                        Intent intent5 = new Intent(context, WalletActivity.class);
                        context.startActivity(intent5);
                        break;
                }
                return false;
            }
        });
    }
}
