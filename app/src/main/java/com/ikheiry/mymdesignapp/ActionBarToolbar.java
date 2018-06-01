package com.ikheiry.mymdesignapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class ActionBarToolbar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_toolbar);

        Toolbar aToolbar = findViewById(R.id.actionToolbar);
        setSupportActionBar(aToolbar);

        getSupportActionBar().setTitle("Action Bar Toolbar");
        getSupportActionBar().setSubtitle("Ismail");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg = "";
        switch (item.getItemId()){
            case R.id.save:
                msg = getString(R.string.save);
                break;
            case R.id.mail:
                msg = getString(R.string.mail);
                break;
            case R.id.camera:
                msg = getString(R.string.camera);
                break;
            case R.id.settings:
                msg = getString(R.string.settings);
                break;
            case R.id.web_search:
                msg = getString(R.string.web_search);
                break;
            case R.id.help:
                msg = getString(R.string.help);
                break;
        }

        Toast.makeText(this, msg + " Clicked !", Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);
    }
}
