package com.example.umpirebuddy;

import androidx.appcompat.app.AppCompatActivity;
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
        switch(view.getId()){
            case R.id.ball:
                no_of_balls++;
                break;
            case R.id.strike:
                no_of_strikes++;
                break;
            case R.id.reset:
                no_of_strikes=0;
                no_of_balls=0;
                break;
            case R.id.exit:
                finish();
                System.exit(0);
        }
        updateBalls();
        updateStrikes();
    }
}
