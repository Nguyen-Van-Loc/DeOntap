package com.example.demo1;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class logup extends AppCompatActivity {
    FirebaseAuth auth;
    EditText tkdk,mkdk;
    TextView back;
    Button btn_logup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logup);
        auth=FirebaseAuth.getInstance();
        tkdk=findViewById(R.id.tkdk);
        mkdk=findViewById(R.id.mkdk);
        back.findViewById(R.id.back).setOnClickListener(v->{
            startActivity(new Intent(logup.this,login.class));
        });
        btn_logup.findViewById(R.id.btn_dk).setOnClickListener(v->{
            Logup();
        });
    }
    public void Logup(){
        String email =tkdk.getText().toString().trim();
        String password =tkdk.getText().toString().trim();
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                FirebaseUser user = auth.getCurrentUser();
                if (user == null) {
                    return;
                }
                startActivity(new Intent(logup.this, login.class));
            } else {
                // If sign in fails, display a message to the user.
                Log.w(TAG, "signInWithEmail:failure", task.getException());
                Toast.makeText(logup.this, "Tai khoan da duoc su dung", Toast.LENGTH_SHORT).show();
            }
            }
        });
    }

}