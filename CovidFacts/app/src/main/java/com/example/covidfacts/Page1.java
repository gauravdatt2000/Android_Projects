package com.example.covidfacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static com.example.covidfacts.R.id.Started;

public class Page1 extends AppCompatActivity {

    BroadcastReceiver brdcstntwrk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        brdcstntwrk = new NetworkChange();
        registerNetworkChange();

        Button Pg2 = (Button) findViewById(R.id.Page2) ;

        Pg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Page1.this , Page2.class) ;
                startActivity(i);
                Toast.makeText(Page1.this, "page 2 opened", Toast.LENGTH_SHORT).show();
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