package com.test.dice;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.dice_sound);
        final int [] diceList ={R.drawable.dice1,R.drawable.dice2,
                R.drawable.dice3,R.drawable.dice4,
                R.drawable.dice5,R.drawable.dice6,};
        final ImageView Dice1 = findViewById(R.id.Dice1);
        final ImageView Dice2 = findViewById(R.id.Dice2);
        Button rollButton = findViewById(R.id.RollButton);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rndObject = new Random();
                int myRandomNumber;
                myRandomNumber = rndObject.nextInt(6);
                Dice1.setImageResource(diceList[myRandomNumber]);
                myRandomNumber =rndObject.nextInt(6);
                Dice2.setImageResource(diceList[myRandomNumber]);
                //Below Code is Take from https://github.com/daimajia/AndroidViewAnimations

                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .playOn(findViewById(R.id.Dice1));
                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .playOn(findViewById(R.id.Dice2));
                mediaPlayer.start();
            }
        });

    }

}