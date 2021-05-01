package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText val1  , val2 ;
    private TextView val3 ;
    private Button val4 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val1 = findViewById(R.id.editTextNumber) ;
        val2 = findViewById(R.id.editTextNumber2) ;
        val3 = findViewById(R.id.Ans) ;
        val4 = findViewById(R.id.Add) ;

        val4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(val1.getText().toString().length() == 0){
                    val1.setText("0");
                }

                if(val2.getText().toString().length() == 0){
                    val2.setText("0");
                }

                int num1 = Integer.parseInt(val1.getText().toString()) ;
                int num2 = Integer.parseInt(val2.getText().toString()) ;
                int sum = num1 + num2 ;
                val3.setText(String.valueOf(sum));
            }
        });


    }
}