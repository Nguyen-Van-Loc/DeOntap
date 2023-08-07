package com.example.demo1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    FirebaseAuth auth;
    EditText tk,mk;
    Button btn_login,btn_nextLogup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth= FirebaseAuth.getInstance();
        tk=findViewById(R.id.tkdn);
        mk=findViewById(R.id.mkdn);
        btn_nextLogup.findViewById(R.id.btn_nextdk).setOnClickListener(v->{
            startActivity(new Intent(login.this, logup.class));
        });
        btn_login.findViewById(R.id.btndn).setOnClickListener(v -> {
            login();
        });
    }
    public void login(){
        String tkdn=tk.getText().toString().trim();
        String mkdn=mk.getText().toString().trim();
        auth.signInWithEmailAndPassword(tkdn,mkdn).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(login.this, MainActivity.class));
                    finish();
                }else {
                    Toast.makeText(login.this, "this bug", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}