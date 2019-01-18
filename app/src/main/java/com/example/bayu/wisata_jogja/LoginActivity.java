package com.example.bayu.wisata_jogja;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bayu.wisata_jogja.Model.Ent_user;
import com.example.bayu.wisata_jogja.Model.SharedPref;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
private Button btnLogin,btnResgister;
private EditText etUsername, etPassword;
    String username ="";
    String password = "";
    SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etPassword = findViewById(R.id.etPassword);
        etUsername = findViewById(R.id.etUsername);
        btnLogin = findViewById(R.id.btnLogin);
        btnResgister = findViewById(R.id.btnRegister);
        sharedPref = new SharedPref(this);

        if(sharedPref.getSPSudahLogin())
        {
            Intent intent = new Intent(LoginActivity.this,Tampil_WisataActivity.class);
            startActivity(intent);
            finish();

        }
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("user");


        btnLogin.setOnClickListener(l->{

            if(etUsername.getText().toString().equals("") && etPassword.getText().toString().equals(""))
            {
                Toast.makeText(getApplicationContext(),"Lengkapi Username dan Password",Toast.LENGTH_LONG).show();
            }
            else if(!etPassword.getText().toString().equals("") || !etUsername.getText().toString().equals(""))
            {
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot postSnapShot: dataSnapshot.getChildren())
                        {
                            Ent_user getUser = postSnapShot.getValue(Ent_user.class);
                            if(etPassword.getText().toString().equals(getUser.getPassword()) &&
                                    etUsername.getText().toString().equals(getUser.getUsername()))
                            {
                                username = getUser.getUsername();
                                password = getUser.getPassword();
                            }
                        }

                        if(etPassword.getText().toString().equals(password) &&
                                etUsername.getText().toString().equals(username))
                        {
                            sharedPref.saveSPBoolean(SharedPref.SP_SUDAH_LOGIN,true);
                            Intent intent = new Intent(LoginActivity.this,Tampil_WisataActivity.class)
                                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                            sharedPref.saveSPString("username",username);
                            sharedPref.saveSPString("password",password);
                            startActivity(intent);
                            finish();

                        }
                        else if(!etPassword.getText().toString().equals(password) &&
                                !etUsername.getText().toString().equals(username))
                        {
                            Toast.makeText(getApplicationContext(),"Login Gagal Cek Username dan Password",Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(getApplicationContext(),databaseError.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

            }
            else
            {
                Toast.makeText(getApplicationContext(),"Login Gagal",Toast.LENGTH_LONG).show();
            }
        });

        btnResgister.setOnClickListener(l->{
            startActivity(new Intent(LoginActivity.this,RegistrasiActivity.class));
        });
    }
}
