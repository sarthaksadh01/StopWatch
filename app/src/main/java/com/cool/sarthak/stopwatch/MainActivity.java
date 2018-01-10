package com.cool.sarthak.stopwatch;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int miliseconds=0;
    private int seconds;

    private int count=0;
    private boolean running;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        runTimer();



        }
    public void start(View view) {
        ImageView imageView =findViewById(R.id.start);
        TextView textView = findViewById(R.id.starttime);

        if (count == 0) {

            running = true;
            count++;


            imageView.setImageResource(R.drawable.stop);
            textView.setText("STOP");

        }
        else if(count>0){
            count=0;



            imageView.setImageResource(R.drawable.start);
            textView.setText("START");
            running=false;
        }
    }
    public void reset(View view)

    {
        ImageView imageView =findViewById(R.id.start);
        TextView textView = findViewById(R.id.starttime);
        imageView.setImageResource(R.drawable.start);
        textView.setText("START");
        count=0;

        running=false;

        miliseconds=0;
        seconds=0;

    }
    private void runTimer()

    {

        final TextView timeView= (TextView)findViewById(R.id.time);

        final Handler handler = new Handler();

        handler.post(new Runnable() {

            @Override

            public void run() {

                int hours = seconds / 3600;

                int minutes = (seconds % 3600) / 60;

                int secs = seconds % 60;
                int msec = miliseconds%10;

                String time = String.format("%2d:%02d:%02d:%02d", hours, minutes, secs,msec);

                timeView.setText(time);

                if (running) {

                    miliseconds++;
                    seconds = miliseconds/10;


                }

                handler.postDelayed(this,100);

            }

        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout sarthak;
        sarthak=findViewById(R.id.relative);
        int id = item.getItemId();

        if (id == R.id.bck1) {
            sarthak.setBackgroundColor(Color.parseColor("#e7f2ff"));
            return true;
        }
       else if (id == R.id.bck2) {
            sarthak.setBackgroundColor(Color.parseColor("#008080"));
            return true;
        }
       else if (id == R.id.bck3) {
            sarthak.setBackgroundColor(Color.parseColor("#f9edf5"));
            return true;
        }
        else if (id == R.id.bck4) {
            sarthak.setBackgroundColor(Color.parseColor("#ffc0cb"));
            return true;
        }
       else  if (id == R.id.bck5) {
            sarthak.setBackgroundColor(Color.parseColor("#aa9588"));
            return true;
        }



        return super.onOptionsItemSelected(item);
    }
}
