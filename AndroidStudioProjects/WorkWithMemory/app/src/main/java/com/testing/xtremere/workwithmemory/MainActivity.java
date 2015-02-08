package com.testing.xtremere.workwithmemory;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_close) {
            finish();

        }

        return super.onOptionsItemSelected(item);
    }

    public void startClick(View view) {
        try {
            long i = Runtime.getRuntime().freeMemory();
            TextView textView = (TextView)findViewById(R.id.infoTextView);
            textView.setText("Количество свободной памяти: " + i + " bytes \n\n");
            i = Runtime.getRuntime().totalMemory();
            textView.append("Общее количество памяти " + i + " bytes \n\n");
            i = Runtime.getRuntime().maxMemory();
            textView.append("Максимальное количество памяти " + i + " bytes \n\n");
            i = Runtime.getRuntime().availableProcessors();
            textView.append("Количество доступных процессоров " + i + "\n\n");
            System.gc();
            textView.append("Количество свободной памяти: " + Runtime.getRuntime().freeMemory());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
