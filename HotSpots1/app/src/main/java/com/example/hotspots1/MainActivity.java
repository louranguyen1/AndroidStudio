package com.example.hotspots1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button rating;
    TextView rate;
    private EditText name;
    private EditText address;
    private HotSpotDataSource dataSource;
    private float avg = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.resName);
        address = findViewById(R.id.addressName);
        dataSource = new HotSpotDataSource(this);

        rating = (Button)findViewById(R.id.rate);
        rate = findViewById(R.id.rateView);
        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                try {

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    View layout= null;
                    LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    layout = inflater.inflate(R.layout.rating, null);
                    final RatingBar ratingBar1 = layout.findViewById(R.id.BeerR);
                    final RatingBar ratingBar2 = layout.findViewById(R.id.MusicR);
                    final RatingBar ratingBar3 = layout.findViewById(R.id.WineR);
                    builder.setPositiveButton("submit", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Float value1 = ratingBar1.getRating();
                            Float value2 = ratingBar2.getRating();
                            Float value3 = ratingBar3.getRating();
                            avg = (float) ((value1 + value2 + value3)/3);
                            Toast.makeText(MainActivity.this, "Average Rating is : " + String.format("%.1f", avg), Toast.LENGTH_LONG).show();
                            save();

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    rate.setText(String.format("%.1f", avg));
                                }
                            });
                        }
                    });

                    builder.setCancelable(false);
                    builder.setView(layout);
                    builder.show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
    public void save() {
        String Name = name.getText().toString();
        String Address = address.getText().toString();
        String Rating  = rate.getText().toString();
        if(Name.isEmpty() || Address.isEmpty())
        {
            Toast.makeText(this,"Enter values in each field",Toast.LENGTH_LONG).show();
        }
        else {
            long id  = dataSource.insertData(Name, Address, Rating);
            if(id < 0)
            {
                Toast.makeText(this,"Data is not saved",Toast.LENGTH_LONG).show();
                name.setText("");
                address.setText("");
                rate.setText("");
            }
            else
            {
                Toast.makeText(this,"Data is saved",Toast.LENGTH_LONG).show();
                name.setText("");
                address.setText("");
                rate.setText("");
            }
        }
    }
}