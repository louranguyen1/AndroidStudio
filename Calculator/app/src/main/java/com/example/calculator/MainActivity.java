package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText first;
    private EditText second;
    private TextView output;
    private DecimalFormat df = new DecimalFormat("#.##");

    public void add(View v) {
        double num1 = Double.parseDouble(first.getText().toString());
        double num2 = Double.parseDouble(second.getText().toString());
        double result = num1 + num2;
        output.setText(df.format(result));
        output.setVisibility(View.VISIBLE);
    }

    public void subtract(View v) {
        double num1 = Double.parseDouble(first.getText().toString());
        double num2 = Double.parseDouble(second.getText().toString());
        double result = num1 - num2;
        output.setText(df.format(result));
        output.setVisibility(View.VISIBLE);
    }

    public void multiply(View v) {
        double num1 = Double.parseDouble(first.getText().toString());
        double num2 = Double.parseDouble(second.getText().toString());
        double result = num1 * num2;
        output.setText(df.format(result));
        output.setVisibility(View.VISIBLE);
    }

    public void divide(View v) {
        double num1 = Double.parseDouble(first.getText().toString());
        double num2 = Double.parseDouble(second.getText().toString());
        double result = num1 / num2;
        output.setText(df.format(result));
        output.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        first = (EditText) findViewById(R.id.first);
        second = (EditText) findViewById(R.id.second);
        output = (TextView) findViewById(R.id.output);
    }
}