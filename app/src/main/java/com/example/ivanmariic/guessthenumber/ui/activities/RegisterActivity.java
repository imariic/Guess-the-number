package com.example.ivanmariic.guessthenumber.ui.activities;

import android.database.sqlite.SQLiteConstraintException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ivanmariic.guessthenumber.GuessTheNumber;
import com.example.ivanmariic.guessthenumber.R;
import com.example.ivanmariic.guessthenumber.model.PlayerEntity;
import com.example.ivanmariic.guessthenumber.repository.PlayerRepository;

public class RegisterActivity extends AppCompatActivity {

    EditText usernameEditText, passwordEditText, firstNameEditText, lastNameEditText, dateOfBirthEditText;
    Button registerButton;
    private PlayerRepository playerRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        playerRepository = PlayerRepository.getInstance();

        usernameEditText = findViewById(R.id.username_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        firstNameEditText = findViewById(R.id.first_name_edit_text);
        lastNameEditText = findViewById(R.id.last_name_edit_text);
        dateOfBirthEditText = findViewById(R.id.birithday_edit_text);
        registerButton = findViewById(R.id.register_button);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isSuccessful = false;
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String name = firstNameEditText.getText().toString();
                String lastName = firstNameEditText.getText().toString();
                String dateOfBirth = dateOfBirthEditText.getText().toString();
                try {
                    PlayerEntity player = new PlayerEntity(username, password, dateOfBirth, name, lastName);
                    playerRepository.insertPlayer(player);
                    Toast.makeText(getApplicationContext(), "Successful!", Toast.LENGTH_LONG).show();
                    isSuccessful = true;
                } catch (SQLiteConstraintException e){
                    Toast.makeText(RegisterActivity.this,"Username vec postoji",Toast.LENGTH_LONG).show();

                }
                if(isSuccessful) {
                    usernameEditText.setText("");
                    passwordEditText.setText("");
                    firstNameEditText.setText("");
                    lastNameEditText.setText("");
                    dateOfBirthEditText.setText("");
                }
            }
        });
    }

}
