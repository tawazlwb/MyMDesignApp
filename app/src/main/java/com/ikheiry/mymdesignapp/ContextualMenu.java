package com.ikheiry.mymdesignapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ContextualMenu extends AppCompatActivity {

    private Button button;
    ActionMode actionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contextual_menu);

        Toolbar standaloneToolbar = findViewById(R.id.toolbar);
        standaloneToolbar.setTitle("Standalone Toolbar");
        standaloneToolbar.setSubtitle("by Ismail");

        button = findViewById(R.id.button);
        standaloneToolbar.inflateMenu(R.menu.menu_main);

        standaloneToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                String title = item.getTitle().toString();
                Toast.makeText(ContextualMenu.this, title + " Selected !", Toast.LENGTH_SHORT).show();

                switch (item.getItemId()){
                    case R.id.save:
                        break;
                    case R.id.mail:
                        break;
                }

                return true;
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionMode = ContextualMenu.this.startActionMode(new ContextualCallbak());
            }
        });
    }

    class ContextualCallbak implements ActionMode.Callback {
        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(R.menu.contextual_menu, menu);

            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {

            actionMode.setTitle("My Action Mode");
            actionMode.setSubtitle("By Ismail");
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {

            // add some functionality to Menu items
            // switch case statements
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {
            // Action mode completed
        }
    }
}
