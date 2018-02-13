package com.example.atharva.scarnesdice;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    int uts=0,uos=0,cts=0,cos=0, c;

     ImageView dice;

    TextView yscore,cscore,tscore;



     Button reset,roll,hold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tscore = findViewById(R.id.tscore);

        cscore = findViewById(R.id.cscore);

        yscore = findViewById(R.id.yscore);

        reset = findViewById(R.id.reset);

        roll = findViewById(R.id.roll);

        hold = findViewById(R.id.hold);

        dice = findViewById(R.id.dice);


        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                int n = rand.nextInt(6) + 1;

                if(n==1){

                    dice.setImageResource(R.drawable.dice1);



                }
                else if(n==2){
                    dice.setImageResource(R.drawable.dice2);

                }
                else if(n==3){
                    dice.setImageResource(R.drawable.dice3);

                }
                else if(n==4){
                    dice.setImageResource(R.drawable.dice4);

                }
                else if(n==5){
                    dice.setImageResource(R.drawable.dice5);


                }
                else if(n==6){
                    dice.setImageResource(R.drawable.dice6);

                }





                if(n==1){
                    uts=0;
                    computerTurn();


                }
                else{
                    uts+=n;

                }

                tscore.setText("Current Turn Score: " + uts);
            }

        });

        hold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uos+=uts;
                uts=0;
                win();
                tscore.setText("Current Turn Score: " + 0);
                yscore.setText("Your Score: " + uos);

                computerTurn();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uos=0;
                uts=0;
                cts=0;
                cos=0;
                tscore.setText("Current Turn Score: " + 0);
                yscore.setText("Your Score: " + 0);
                cscore.setText("Computer Score: " + 0);

                roll.setVisibility(View.VISIBLE);

                hold.setVisibility(View.VISIBLE);

            }
        });



    }




    public void computerTurn(){

        roll.setVisibility(View.INVISIBLE);

        hold.setVisibility(View.INVISIBLE);

        c=0;

        while(true){


            Random rand = new Random();
            int n = rand.nextInt(6) + 1;

            if(n==1){

               dice.setImageResource(R.drawable.dice1);


            }
            else if(n==2){
               dice.setImageResource(R.drawable.dice2);

            }
            else if(n==3){
             dice.setImageResource(R.drawable.dice3);
            }
            else if(n==4){
            dice.setImageResource(R.drawable.dice4);
            }
            else if(n==5){
                dice.setImageResource(R.drawable.dice5);


            }
            else if(n==6){

                dice.setImageResource(R.drawable.dice6);
            }

            if(n==1){
                cts=0;
                computerTurnDone();
                break;
            }
            else{
                cts+=n;
            }

            if(c>=7){

                computerTurnDone();
                break;
            }

            c++;


        }


    }
    public void computerTurnDone(){

        Toast.makeText(this, "Computer turn over", Toast.LENGTH_SHORT).show();
        roll.setVisibility(View.VISIBLE);
        hold.setVisibility(View.VISIBLE);
        c=0;
        cos+=cts;
        cts=0;
        win();
        cscore.setText("Computer Score: " + cos);
    }
    public void win(){

        if(uos>=100){
            Toast.makeText(this, "User wins congrats", Toast.LENGTH_SHORT).show();
            roll.setVisibility(View.INVISIBLE);
            hold.setVisibility(View.INVISIBLE);
        }
        if(cos>=100){
            Toast.makeText(this, "Computer wins congrats", Toast.LENGTH_SHORT).show();
            roll.setVisibility(View.INVISIBLE);
            hold.setVisibility(View.INVISIBLE);

        }
        if(uos==cos && uos==100){
            Toast.makeText(this, "Game tied", Toast.LENGTH_SHORT).show();
            roll.setVisibility(View.INVISIBLE);
            hold.setVisibility(View.INVISIBLE);
        }

    }
    /*public void slow(final int a){
       final Handler handler = new Handler();
        Runnable runnable = new Runnable() {


            public void run() {
                dice.setImageResource(a);

                handler.postDelayed(this, 2000);
            }
        };
        handler.postDelayed(runnable, 2000);
        //handler.removeCallbacks(null);
    }*/
}
