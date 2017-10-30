package com.example.android.utsfahri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UtamaLogin extends AppCompatActivity {

    Button b1, b2;
    EditText ed1, ed2;
    TextView tx1;

    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_utama);

        b1 = (Button) findViewById(R.id.btnLogin);
        //b2 = (Button) findViewById(R.id.btnCancel);
        ed1 = (EditText) findViewById(R.id.editUser);
        ed2 = (EditText) findViewById(R.id.editPass);
        tx1 = (TextView) findViewById(R.id.textView2);
        tx1.setVisibility(View.GONE);

        b1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick (View v){
                if (ed1.getText().toString().equals("admin")&&
                        ed2.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(), "Login Sukses", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Username atau Password Anda Salah",
                            Toast.LENGTH_SHORT).show();
                    tx1.setVisibility(View.VISIBLE);
                    //tx1.setBackgroundColor(73328);  //Tambahan Fahri
                    counter--;
                    tx1.setText(Integer.toString(counter));

                    if(counter==0){
                        Toast.makeText(getApplicationContext(), "Anda telah melebihi batas tigas kali percobaan. Silahkan keluar.",
                                Toast.LENGTH_SHORT).show();
                        b1.setEnabled(false);
                    }

                }
            }
        });

    }
}

