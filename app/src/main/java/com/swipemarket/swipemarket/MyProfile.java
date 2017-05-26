package com.swipemarket.swipemarket;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MyProfile extends AppCompatActivity {
    public String location;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        String username;
        SharedPreferences sp1 = PreferenceManager.getDefaultSharedPreferences(MyProfile.this);
        username = getIntent().getStringExtra("Username");
        TextView txusername = (TextView) findViewById(R.id.myprof_username);
        txusername.setText("Username: "+username);
        Button logout;
        logout = (Button) findViewById(R.id.logout);
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
        if(v.getId()== R.id.logout)
        {
            menu.setHeaderTitle("Log Out");
            this.getMenuInflater().inflate(R.menu.popupwindow , menu);
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    public void Click(View v)
    {
        ImageButton home = (ImageButton) findViewById(R.id.homebtn);
        ImageButton chat = (ImageButton) findViewById(R.id.chatbtn);
        Button logout = (Button) findViewById(R.id.logout);
        Button sell = (Button) findViewById(R.id.sellitembutton);
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
        }
        else if(v == sell)
        {
            Intent i = new Intent(this,SellActivity.class);
            startActivity(i);
        }
        else if(v == logout)
        {
            SaveSharedPreference.setUserName(this,null);
            Intent i =  new Intent(this,LoginActivity.class);
            startActivity(i);
            finish();
        }
    }
    /*
    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        new MyProfile.AsyncCaller().execute();
    }

    String jsonString;
    private class AsyncCaller extends AsyncTask<Void, Void, Void>
    {
        ProgressDialog pdLoading = new ProgressDialog(MyProfile.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //this method will be running on UI thread
            pdLoading.setMessage("\tLoading...");
            pdLoading.show();
        }
        @Override
        protected Void doInBackground(Void... params) {
            //this method will be running on background thread so don't update UI frome here
            //do your long running http tasks here,you dont want to pass argument and u can access the parent class' variable url over here
            URL url = null;
            try {
                url = new URL("https://ervandh.000webhostapp.com/getUserData.php");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            HttpURLConnection urlConnection = null;
            try {
                urlConnection = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                BufferedInputStream in = new BufferedInputStream(urlConnection.getInputStream());
                jsonString = IOUtils.toString(in,"UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                urlConnection.disconnect();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            //this method will be running on UI thread
            //Toast.makeText(MainActivity.this, test, Toast.LENGTH_SHORT).show();
            //JSONArray jsonArray = new JSONArray(jsonString);
            pdLoading.dismiss();
        }

    }
     */
}
