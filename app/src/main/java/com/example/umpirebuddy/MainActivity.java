package com.example.umpirebuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int no_of_balls;
    int no_of_strikes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        no_of_balls=0;
        no_of_strikes=0;
        View BallButton = findViewById(R.id.ball);
        BallButton.setOnClickListener(this);
        updateBalls();

        View StrikeButton = findViewById(R.id.strike);
        StrikeButton.setOnClickListener(this);
        updateStrikes();

        View ResetButton = findViewById(R.id.reset);
        ResetButton.setOnClickListener(this);

        View ExitButton = findViewById(R.id.exit);
        ExitButton.setOnClickListener(this);

        View AboutButton = findViewById(R.id.about);
        AboutButton.setOnClickListener(this);

    }

    protected void updateBalls() {
        TextView text = findViewById(R.id.ballText);
        text.setText("Balls\n"+no_of_balls);
    }
    protected void updateStrikes(){
            TextView text = findViewById(R.id.strikeText);
            text.setText("Strikes\n"+no_of_strikes);
    }

    public void onClick(View view){
        View BallButton = findViewById(R.id.ball);
        BallButton.setOnClickListener(this);
        View StrikeButton = findViewById(R.id.strike);
        StrikeButton.setOnClickListener(this);
        TextView text = findViewById(R.id.OutWalkText);
        switch(view.getId()){
            case R.id.ball:
                no_of_balls++;
                if(no_of_balls==4){
                    text.setText("Walked");
                    text.setVisibility(TextView.VISIBLE);
                    BallButton.setVisibility(View.GONE);
                    StrikeButton.setVisibility(View.GONE);
                }
                break;
            case R.id.strike:
                no_of_strikes++;
                if(no_of_strikes==3){
                    text.setText("Strike Out");
                    text.setVisibility(TextView.VISIBLE);
                    BallButton.setVisibility(View.GONE);
                    StrikeButton.setVisibility(View.GONE);
                }
                break;
            case R.id.reset:
                no_of_strikes=0;
                no_of_balls=0;
                if(BallButton.getVisibility()==View.GONE){
                    BallButton.setVisibility(View.VISIBLE);
                    StrikeButton.setVisibility(View.VISIBLE);
                    text.setVisibility(TextView.INVISIBLE);
                }

                break;
            case R.id.exit:
                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(startMain);
                finish();
                break;
            case R.id.about:
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                break;
        }
        updateBalls();
        updateStrikes();
    }
}
