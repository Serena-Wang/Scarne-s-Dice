package com.example.demouser.dicegame;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;



public class MainActivity extends AppCompatActivity {
    private int uOS, uTS, cOS,cTS;
    private Button roll, hold, reset;
    private ImageView diceView;
    private TextView uTSText,cTSText, uOSText, cOSText;
    private String TAG = "a";
    private final Handler handler = new Handler();
    int randomComputerNum;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        uOS=0;
        uTS=0;
        cOS=0;
        cTS=0;
        uOSText = (TextView)findViewById(R.id.textView3);
        cOSText = (TextView)findViewById(R.id.textView4);
        uTSText = (TextView) findViewById(R.id.textView5);
        cTSText = (TextView)findViewById(R.id.textView6);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        diceView = findViewById(R.id.imageView);
        roll = findViewById(R.id.button);
        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int random = (int)((Math.random())*6)+1;
                Log.d(TAG,"random is:"+random);
                switch(random){

                    case 1:
                        diceView.setImageResource(R.drawable.dice1);
                        uOS+=uTS;
                        uTSText.setText("Your Turn Score:" + uTS+".");
                        uOSText.setText("Your Overall Score:" + uOS);
                        uTS=0;
                        computerTurn();
                        break;

                    case 2:
                        diceView.setImageResource(R.drawable.dice2);
                        uTS+=2;
                        uTSText.setText("Your Turn Score:" + uTS+".");
                        break;
                    case 3:
                        diceView.setImageResource(R.drawable.dice3);
                        uTS+=3;
                        uTSText.setText("Your Turn Score:" + uTS+".");
                        break;
                    case 4:
                        diceView.setImageResource(R.drawable.dice4);
                        uTS+=4;
                        uTSText.setText("Your Turn Score:" + uTS+".");
                        break;
                    case 5:
                        diceView.setImageResource(R.drawable.dice5);
                        uTS+=5;
                        uTSText.setText("Your Turn Score:" + uTS+".");
                        break;
                    case 6:
                        diceView.setImageResource(R.drawable.dice6);
                        uTS+=6;
                        uTSText.setText("Your Turn Score:" + uTS+".");
                        break;
                }

            }
        });

        hold = findViewById(R.id.button3);
        hold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uOS+=uTS;
                uTS=0;
                uTSText.setText("Your Turn Score:" + uTS);
                uOSText.setText("Your Overall Score:" + uOS);
                //delayedComputerTurn();
                computerTurn();
            }
        });

        reset = findViewById(R.id.button2);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uOS=0;
                uTS=0;
                cOS=0;
                cTS=0;
                uTSText.setText("Your Turn Score:" + uTS);
                uOSText.setText("Your Overall Score:" + uOS);
                cTSText.setText("Computer Turn Score:" + cTS);
                cOSText.setText("Computer Overall Score:" + cOS);
            }
        });

    }

    public void delayedComputerTurn(){
        Log.d(TAG,"in delay");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        },2000);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void computerTurn (){
        roll.setEnabled(false);
        hold.setEnabled(false);
        randomComputerNum=(int)((Math.random())*6);
        while (randomComputerNum!=1){
            Log.d(TAG,"computer random is:"+randomComputerNum);
            switch(randomComputerNum){

                case 0:
                    //diceView.setImageResource(R.drawable.dice1);
                    //cTS=0;
                    //cOS+= cTS;
                    //cOSText.setText("Computer Overall Score is:" + cOS+".");
                    cTSText.setText("Computer Turn Score:" + cTS+".");
                    roll.setEnabled(true);
                    hold.setEnabled(true);
                    cOS+= cTS;
                    cOSText.setText("Computer Overall Score:" + cOS+".");
                    cTS=0;
                    roll.setEnabled(true);
                    hold.setEnabled(true);
                    return;

                case 2:
                    diceView.setImageResource(R.drawable.dice2);
                    cTS+=2;
                    cTSText.setText("Computer Turn Score:" + cTS+".");
                    break;
                case 3:
                    diceView.setImageResource(R.drawable.dice3);
                    cTS+=3;
                    cTSText.setText("Computer Turn Score:" + cTS+".");
                    break;
                case 4:
                    diceView.setImageResource(R.drawable.dice4);
                    cTS+=4;
                    cTSText.setText("Computer Turn Score:" + cTS+".");
                    break;
                case 5:
                    diceView.setImageResource(R.drawable.dice5);
                    cTS+=5;
                    cTSText.setText("Computer Turn Score:" + cTS+".");
                    break;
                case 6:
                    diceView.setImageResource(R.drawable.dice6);
                    cTS+=6;
                    cTSText.setText("Computer Turn Score:" + cTS+".");
                    break;
            }
            //delayedComputerTurn();
            randomComputerNum=(int)((Math.random())*6);

        }
        if (randomComputerNum==1) {
            roll.setEnabled(true);
            hold.setEnabled(true);
            cTS=0;
        }
        cOS+= cTS;
        cOSText.setText("Computer Overall Score:" + cOS+".");


     }
    }
