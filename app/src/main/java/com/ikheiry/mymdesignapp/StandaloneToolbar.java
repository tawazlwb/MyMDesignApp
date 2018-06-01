package com.ikheiry.mymdesignapp;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class StandaloneToolbar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone_toolbar);

        Toolbar standaloneToolbar = findViewById(R.id.standaloneToolbar);
        standaloneToolbar.setTitle("Standalone Toolbar");
        standaloneToolbar.setSubtitle("by Ismail");
        //standaloneToolbar.setNavigationIcon(R.drawable.navigation_back);

        //if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        //   standaloneToolbar.setElevation(10f);

        standaloneToolbar.inflateMenu(R.menu.menu_main);
        standaloneToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                String title = item.getTitle().toString();
                Toast.makeText(StandaloneToolbar.this, title + " Selected !", Toast.LENGTH_SHORT).show();

                switch (item.getItemId()){
                    case R.id.save:
                        break;
                    case R.id.mail:
                        break;
                }

                return true;
            }
        });
    }
}
