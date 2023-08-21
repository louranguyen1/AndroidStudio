package com.example.contractorcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText labor;
    private EditText mat;
    private TextView Suboutput;
    private TextView Taxoutput;
    private TextView Totaloutput;

    private DecimalFormat df = new DecimalFormat("#.##");

    public void cal(View v) {
        double lcost = Double.parseDouble(labor.getText().toString());
        double mcost = Double.parseDouble(mat.getText().toString());

        double subtotal = lcost + mcost;
        Suboutput.setText(df.format(subtotal));
        Suboutput.setVisibility(View.VISIBLE);

        double tax = subtotal * .05;
        Taxoutput.setText(df.format(tax));
        Taxoutput.setVisibility(View.VISIBLE);

        double total = subtotal + tax;
        Totaloutput.setText(df.format(total));
        Totaloutput.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        labor = (EditText) findViewById(R.id.labor);
        mat = (EditText) findViewById(R.id.mat);
        Suboutput = (TextView) findViewById(R.id.Suboutput);
        Taxoutput = (TextView) findViewById(R.id.Taxoutput);
        Totaloutput = (TextView) findViewById(R.id.Totaloutput);
    }
}