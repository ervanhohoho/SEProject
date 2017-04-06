package com.swipemarket.swipemarket;

import android.content.Intent;
import android.media.Image;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class MyProfile extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageButton logout;

        logout = (ImageButton) findViewById(R.id.logout);
        this.registerForContextMenu(logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.showContextMenu();
            }
        });
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.yes :
                SaveSharedPreference.setUserName(this,null);
                Intent i =  new Intent(this,LoginActivity.class);
                startActivity(i);
                finish();
                return true;

            case R.id.no :
                return true;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if(v.getId()==R.id.logout)
        {
            menu.setHeaderTitle("Log Out");
            this.getMenuInflater().inflate(R.menu.popupwindow , menu);
        }
        super.onCreateContextMenu(menu, v, menuInfo);
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
        /*else if(v == logout)
        {
            SaveSharedPreference.setUserName(this,null);
            Intent i =  new Intent(this,LoginActivity.class);
            startActivity(i);
            finish();
        }*/
    }
}
