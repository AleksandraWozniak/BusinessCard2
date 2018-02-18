package com.example.ola.businesscard2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // A TextView which, when clicked, opens the phone keyboard and inserts the phone number written in that TextView
        TextView phone = (TextView) findViewById(R.id.phone);
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:  +48 22 536 36 36"));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        // A TextView which, when clicked opens the webpage
        TextView www = (TextView) findViewById(R.id.www);
        www.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://pizzahut.pl";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                if (i.resolveActivity(getPackageManager()) != null) {
                    startActivity(i);
                }
            }
        });

        // Use an intent to launch an email app
        TextView email = (TextView) findViewById(R.id.email);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"mojapizzahut@amrest.eu"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Order for Pizzeria Pizza Hut");
                intent.putExtra(Intent.EXTRA_TEXT, "Order");

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        /**
         * this Texview directs to google map when address icon is clicked
         */

        TextView address = (TextView) findViewById(R.id.address);
        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapIntent = new Intent ( Intent.ACTION_VIEW );
                mapIntent.setData ( Uri.parse ( "geo: 52.155687, 21.034599") );
                if (mapIntent.resolveActivity ( getPackageManager () ) != null) {
                    startActivity ( mapIntent );
                }
            }
        });

    }


}