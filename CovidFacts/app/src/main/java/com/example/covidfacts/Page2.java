package com.example.covidfacts;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Page2 extends AppCompatActivity {

    BroadcastReceiver brdcstntwrk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        brdcstntwrk = new NetworkChange();
        registerNetworkChange();

        Button Pg2 = (Button) findViewById(R.id.Page3) ;

        Pg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Page2.this , Page3.class) ;
                startActivity(i);
                Toast.makeText(Page2.this, "page 3 opened", Toast.LENGTH_SHORT).show();
            }
        });
    }

    protected  void registerNetworkChange(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN){
            registerReceiver(brdcstntwrk,new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }
    }

    protected  void unregisterNetwork(){
        try{
            unregisterReceiver(brdcstntwrk);
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterNetwork();
    }

}