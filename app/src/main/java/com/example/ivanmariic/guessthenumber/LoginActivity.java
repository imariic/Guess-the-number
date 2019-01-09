package com.example.ivanmariic.guessthenumber;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ivanmariic.guessthenumber.Model.MyDatabase;
import com.example.ivanmariic.guessthenumber.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

   private Button loginButton;
   private Button registerButton;
   public static MyDatabase db;
   private EditText usernameEditText;
   private EditText passwordEditText;


    @Override
    protected void onResume() {
        super.onResume();
        usernameEditText.setText("");
        passwordEditText.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = Room.databaseBuilder(this,MyDatabase.class,"my_database").allowMainThreadQueries().fallbackToDestructiveMigration().build();

        usernameEditText = findViewById(R.id.name_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        loginButton = findViewById(R.id.login_button);
        registerButton = findViewById(R.id.register_button);


        loginButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.login_button :
                if(usernameEditText.getText().toString().equals(db.getPlayerDAO().getUsername(usernameEditText.getText().toString())) && passwordEditText.getText().toString().equals(db.getPlayerDAO().getPassword(passwordEditText.getText().toString()))){
                  Intent  intent = new Intent(LoginActivity.this,PlayActivity.class);
                    startActivity(intent);
                    break;
                } else {
                    Toast.makeText(this, "Wrong username or password!",Toast.LENGTH_LONG).show();
                    break;
                }

            case R.id.register_button:
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
        }
        

    }
}
