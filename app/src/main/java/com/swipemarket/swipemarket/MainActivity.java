package com.swipemarket.swipemarket;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

public class MainActivity extends AppCompatActivity {

    private SwipePlaceHolderView mSwipeView;
    private Context mContext;

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.popupchat :
                Intent i = new Intent(this,Chat.class);
                startActivity(i);
                finish();
                return true;

            case R.id.popupcart :
                Intent i1 = new Intent(this,Chat.class);
                startActivity(i1);
                finish();
                return true;

            case R.id.popupcancel :
                return true;

        }

        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if(v.getId()==R.id.acceptBtn)
        {
            menu.setHeaderTitle("I WANT THIS!");
            this.getMenuInflater().inflate(R.menu.popupmain , menu);
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton accept;

        accept = (ImageButton) findViewById(R.id.acceptBtn);
        this.registerForContextMenu(accept);


        if (SaveSharedPreference.getUserName(this).length() == 0) {
            // call Login Activity
            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);
            this.finish();

        } else {
            mSwipeView = (SwipePlaceHolderView) findViewById(R.id.swipeView);
            mContext = getApplicationContext();




            int bottomMargin = Utils.dpToPx(160);
            Point windowSize = Utils.getDisplaySize(getWindowManager());
            mSwipeView.getBuilder()
                    .setDisplayViewCount(3)
                    .setHeightSwipeDistFactor(10)
                    .setWidthSwipeDistFactor(5)
                    .setSwipeDecor(new SwipeDecor()
                            .setViewWidth(windowSize.x)
                            .setViewHeight(windowSize.y - bottomMargin)
                            .setViewGravity(Gravity.TOP)
                            .setPaddingTop(20)
                            .setRelativeScale(0.01f)
                            .setSwipeInMsgLayoutId(R.layout.tinder_swipe_in_msg_view)
                            .setSwipeOutMsgLayoutId(R.layout.tinder_swipe_out_msg_view));


            for (Profile profile : Utils.loadProfiles(this.getApplicationContext())) {
                mSwipeView.addView(new TinderCard(mContext, profile, mSwipeView));
            }

            findViewById(R.id.rejectBtn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mSwipeView.doSwipe(false);
                }
            });

            findViewById(R.id.acceptBtn).setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    mSwipeView.doSwipe(true);
                    v.showContextMenu();
                }
            });

        }
    }




    public void Click(View v)
    {
        ImageButton home = (ImageButton) findViewById(R.id.homebtn);
        ImageButton profile  = (ImageButton) findViewById(R.id.profilebtn);
        ImageButton chat = (ImageButton) findViewById(R.id.chatbtn);
        if(v == chat)
        {
            Intent i = new Intent(this, Chat.class);
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
