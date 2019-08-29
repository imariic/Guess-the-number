package com.example.ivanmariic.guessthenumber.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ivanmariic.guessthenumber.R;

import java.util.Random;

public class PlayActivity extends AppCompatActivity {

    private int randomNumber;
    private EditText guessEditText;
    private Button guessButton;
    private Random random;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        random = new Random();

        randomNumber = random.nextInt(101-1) + 1;
        guessEditText = findViewById(R.id.guess_edit_text);
        guessButton = findViewById(R.id.guess_button);
        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guessLogic();
            }
        });


    }


    private void guessLogic(){
        int myGuess = Integer.parseInt(guessEditText.getText().toString());
        if(myGuess > randomNumber){
            Toast.makeText(this,"Your guess number is bigger than random number!",Toast.LENGTH_SHORT).show();
        } else if(myGuess == randomNumber){
            randomNumber = random.nextInt(101-1) + 1;
            Toast.makeText(this, "Congratulations! You won!",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"Your guess number is lower than random number!",Toast.LENGTH_SHORT).show();
        }
        guessEditText.setText("");
    }


}
