package com.example.bayu.wisata_jogja;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bayu.wisata_jogja.Model.Ent_user;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrasiActivity extends AppCompatActivity {
private EditText etUsername,etPassword,etNama;
private Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

        etUsername = findViewById(R.id.etUsername);
        etNama = findViewById(R.id.etNama);
        etPassword = findViewById(R.id.etPassword);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(l->{

            Ent_user user = new Ent_user();
            user.setNama(etNama.getText().toString());
            user.setUsername(etUsername.getText().toString());
            user.setPassword(etPassword.getText().toString());

            DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
            mDatabase.child("user").push().setValue(user, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    //Problem with saving the data
                    if (databaseError != null) {
                        Toast.makeText(getApplicationContext(),"Insert Failed",Toast.LENGTH_LONG).show();
                    } else {
                        //Data uploaded successfully on the server
                        startActivity(new Intent(RegistrasiActivity.this,LoginActivity.class));
                        finish();
                    }

                }
            });


        });


    }
}
