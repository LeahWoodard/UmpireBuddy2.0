package com.example.umpirebuddy;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import android.os.Bundle;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        View BackButton = findViewById(R.id.back);
        BackButton.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.back) {
            Intent intent = new Intent(view.getContext(), MainActivity.class);
            startActivity(intent);
        }
    }
}
