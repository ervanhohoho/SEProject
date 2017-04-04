package com.swipemarket.swipemarket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Chat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
    }
    public void Click(View v)
    {
        ImageButton home = (ImageButton) findViewById(R.id.homebtn);
        ImageButton chat = (ImageButton) findViewById(R.id.chatbtn);
        ImageButton profile = (ImageButton) findViewById(R.id.profilebtn);
        if(v == home)
        {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            finish();
        }
        else if(v == profile)
        {
            Intent i = new Intent(this, MyProfile.class);
            startActivity(i);
            finish();
        }
    }
}
