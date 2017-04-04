package com.swipemarket.swipemarket;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MyProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
    public void Click(View v)
    {
        ImageButton home = (ImageButton) findViewById(R.id.homebtn);
        ImageButton profile  = (ImageButton) findViewById(R.id.profilebtn);
        ImageButton chat = (ImageButton) findViewById(R.id.chatbtn);
        ImageButton logout = (ImageButton) findViewById(R.id.logout);
        if(v == home)
        {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            finish();
        }
        else if(v == chat)
        {
            Intent i = new Intent(this, Chat.class);
            startActivity(i);
            finish();
        }
        else if(v == logout)
        {
            SaveSharedPreference.setUserName(this,null);
            Intent i =  new Intent(this,LoginActivity.class);
            startActivity(i);
            finish();
        }
    }
}
