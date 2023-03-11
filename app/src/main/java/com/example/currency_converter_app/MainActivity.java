package com.example.currency_converter_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.exchange_app.R;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    Button convertButton;

    EditText amount,firstText,secondText;
    Spinner spinner_currency;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    convertButton=findViewById(R.id.btn);

    amount=findViewById(R.id.text1);
    spinner_currency=findViewById(R.id.spinner);
    firstText=findViewById(R.id.text3);
    secondText=findViewById(R.id.text4);

    String[] from={"USD","EURO","MAD"};
    ArrayAdapter adapter=new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
    spinner_currency.setAdapter(adapter);



    convertButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            double total1;
            double total2;
            double ammount=Double.parseDouble(amount.getText().toString());
            if(spinner_currency.getSelectedItem().toString()=="USD"){
                total1=ammount * 10.34;
                total2=ammount * 0.94;

                firstText.setText(new DecimalFormat("##.##").format(total1)+" MAD");
                secondText.setText(new DecimalFormat("##.##").format(total2)+" EURO");
            }else if(spinner_currency.getSelectedItem().toString()=="MAD"){
                total1=ammount * 0.097;
                total2=ammount * 0.091;

                firstText.setText(new DecimalFormat("##.##").format(total1)+" USD");
                secondText.setText(new DecimalFormat("##.##").format(total2)+" EURO");
            }else{
                total1=ammount * 1.06;
                total2=ammount * 11.01;

                firstText.setText(new DecimalFormat("##.##").format(total1)+" USD");
                secondText.setText(new DecimalFormat("##.##").format(total2)+" MAD");
            }

        }
    });

    }
}