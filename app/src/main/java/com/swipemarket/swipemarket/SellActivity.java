package com.swipemarket.swipemarket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class SellActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell2);
        Button upload;
        upload = (Button) findViewById(R.id.uploadbutton);
        this.registerForContextMenu(upload);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.showContextMenu();
            }
        });
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if(v.getId()== R.id.uploadbutton)
        {
            menu.setHeaderTitle("Upload");
            this.getMenuInflater().inflate(R.menu.popupupload,menu);
        }
        super.onCreateContextMenu(menu,v,menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.choosegallery :
                return true;

            case R.id.takephoto :
                return true;
        }
        return super.onContextItemSelected(item);
    }
}
