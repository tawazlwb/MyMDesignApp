package com.ikheiry.mymdesignapp;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

public class SnackBarActivity extends AppCompatActivity {

    // 5.1 FAB
    CoordinatorLayout rootLayout;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);

        rootLayout = findViewById(R.id.myLayout);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(SnackBarActivity.this, "Floating Action Button Clicked", Toast.LENGTH_SHORT).show();
                Snackbar.make(rootLayout, "Floating Action Button Clicked", Snackbar.LENGTH_LONG).show();
            }
        });

        Toolbar standaloneToolbar = findViewById(R.id.snackbar);
        standaloneToolbar.setTitle("Basic Components");
        standaloneToolbar.setSubtitle("by Ismail");

        standaloneToolbar.inflateMenu(R.menu.snackbar_main);

        standaloneToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                String title = item.getTitle().toString();
                //Toast.makeText(SnackBarActivity.this, title + " Selected !", Toast.LENGTH_SHORT).show();

                switch (item.getItemId()){
                    case R.id.simple_snackbar:
                        showSimpleSnackBar();
                        break;
                    case R.id.snackbar_action_callback:
                        showSnackBarWithAction();
                        break;
                    case R.id.custom_snackbar:
                        showSnackBarWithColoredText();
                        break;
                }
                return true;
            }
        });
    }

    private void showSnackBarWithColoredText() {
    }

    private void showSnackBarWithAction() {
        Snackbar snackbar = Snackbar.make(rootLayout, "File Deleted Successfully", Snackbar.LENGTH_LONG);
        snackbar.setAction("UNDO", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(rootLayout, "File Recovered Successfully", Snackbar.LENGTH_LONG).show();
            }
        });
        snackbar.show();
    }

    private void showSimpleSnackBar() {
        Snackbar.make(rootLayout, "Simple Snack Bar Example", Snackbar.LENGTH_LONG).show();
    }
}
