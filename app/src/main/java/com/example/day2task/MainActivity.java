package com.example.day2task;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String s1;
    String s2;
    String s3;
    String s;
    TextView t;
    Button one;
    Button two;
    Button three;
    EditText name;
    EditText mail;
    EditText mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one=findViewById(R.id.button);
        two=findViewById(R.id.button2);
        three=findViewById(R.id.button3);
        name=findViewById(R.id.editTextTextPersonName);
        mail=findViewById(R.id.editTextTextPersonName2);
        mobile=findViewById(R.id.editTextTextPersonName3);
        t=findViewById(R.id.textView);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s= name.getText().toString()+"\n"+mail.getText().toString()+"\n"+mobile.getText().toString();
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });


        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s= name.getText().toString()+"\n"+mail.getText().toString()+"\n"+mobile.getText().toString();
                t.setText(s);
            }
        });


        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1= name.getText().toString();
                s2= mail.getText().toString();
                s3= mobile.getText().toString();
                Intent nextpg= new Intent(MainActivity.this,MainActivity2.class);
                nextpg.putExtra("xyz",s1);
                nextpg.putExtra("abc",s2);
                nextpg.putExtra("pqr",s3);
                startActivity(nextpg);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void alert(MenuItem item) {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Alert!")
                .setMessage("Choose any one")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent obj = new Intent(MainActivity.this,MainActivity2.class);
                        startActivity(obj);
                        Toast.makeText(MainActivity.this, "Hey you clicked ok and was redirected to this page ", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", null)
                .setNeutralButton("Cancel",null)
                .show();

    }

    public void web(MenuItem item) {
        Toast.makeText(this, "website menu got clicked", Toast.LENGTH_SHORT).show();
        Intent obj = new Intent(MainActivity.this,MainActivity3.class);
        startActivity(obj);

    }

    public void dialogue(MenuItem item) {
        Dialog dia = new Dialog(MainActivity.this);
        dia.setContentView(R.layout.dialogue);
        dia.show();
    }


}