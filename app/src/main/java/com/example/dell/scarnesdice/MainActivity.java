package com.example.dell.scarnesdice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView dice;
    Button roll;
    Button hold ;
    Button reset ;
    TextView textView ;
    TextView textView2 ;
    TextView textView3;
    TextView textView4;

    Random rand = new Random();

    int rolledNumber;

    int my_total_score=0, my_current_score=0, pc_total_score=0, pc_current_score=0;
    int turn= 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dice = (ImageView) findViewById(R.id.dice);
        roll = (Button) findViewById(R.id.roll);
        hold = (Button) findViewById(R.id.hold);
        reset = (Button) findViewById(R.id.reset);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        roll.setOnClickListener(this);
        hold.setOnClickListener(this);
        reset.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()== R.id.roll && turn==1){
            rolledNumber = rand.nextInt(6) +1;

            if (rolledNumber == 1)
            {
                dice.animate().rotationBy(250f).setDuration(100);
                dice.setImageResource(R.drawable.dice1);
                my_current_score = 0;
                turn = 2;
                textView2.setText("Your Current Score: "+my_current_score);
            }
            else if (rolledNumber == 2)
            {
                dice.animate().rotationBy(250f).setDuration(100);
                dice.setImageResource(R.drawable.dice2);
                my_current_score = my_current_score + 2;
                textView2.setText("Your Current Score: "+ my_current_score);
            }
            else if (rolledNumber == 3)
            {
                dice.animate().rotationBy(250f).setDuration(100);
                dice.setImageResource(R.drawable.dice3);
                my_current_score = my_current_score + 3;
                textView2.setText("Your Current Score: "+ my_current_score);
            }
            else if (rolledNumber == 4)
            {
                dice.animate().rotationBy(250f).setDuration(100);
                dice.setImageResource(R.drawable.dice4);
                my_current_score = my_current_score + 4;
                textView2.setText("Your Current Score: "+ my_current_score);
            }
            else if (rolledNumber == 5)
            {
                dice.animate().rotationBy(250f).setDuration(100);
                dice.setImageResource(R.drawable.dice5);
                my_current_score = my_current_score + 5;
                textView2.setText("Your Current Score: "+ my_current_score);
            }
            else if (rolledNumber == 6)
            {
                dice.animate().rotationBy(250f).setDuration(100);
                dice.setImageResource(R.drawable.dice6);
                my_current_score = my_current_score + 6;
                textView2.setText("Your Current Score: "+ my_current_score);
            }
        }
        if (view.getId()== R.id.hold && turn==1)
        {
            my_total_score += my_current_score;
            my_current_score=0;
            turn = 2;

            textView.setText("Your Score: "+my_total_score);
            textView2.setText("Your Current Score: "+my_current_score);
        }
        if (view.getId()== R.id.reset)
        {
            my_current_score = 0;
            my_total_score = 0;
            pc_current_score = 0;
            pc_total_score = 0;
            turn=1;
            textView.setText("Your Score: "+my_total_score);
            textView2.setText("Your Current Score: "+my_current_score);
            textView3.setText("Computer's Score: "+pc_total_score);
            textView4.setText("Computer's Current score: "+pc_current_score);
        }
        if(turn == 2)
        {
            rolledNumber = 0;
            while(rolledNumber!=1 && pc_current_score<=20)
            {
                rolledNumber = rand.nextInt(6)+1;
                pc_current_score += rolledNumber;
                textView4.setText("Computer's Current score: "+pc_current_score);
                Log.i("computer dice value",""+rolledNumber);
            }

            if (rolledNumber == 1)
            {
                pc_current_score = 0;
                turn =1;
                textView3.setText("Computer's Score: "+pc_total_score);
                textView4.setText("Computer's Current score: "+pc_current_score);
            }
            else
            {

                turn = 1;
                pc_total_score += pc_current_score;
                pc_current_score = 0;
                textView3.setText("Computer's Score: "+pc_total_score);
                textView4.setText("Computer's Current score: "+pc_current_score);
            }
        }
        if(pc_total_score >=40)
        {
            Toast.makeText(this, "Computer wins", Toast.LENGTH_LONG).show();
        }
        if(my_total_score >=40)
        {
            Toast.makeText(this, "You win", Toast.LENGTH_LONG).show();

        }
    }
}
