package com.example.android.trainingtask3;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private Button redRectangle, blueRectangle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the Button's objects
        redRectangle = (Button) findViewById(R.id.red_rectangle);
        blueRectangle = (Button) findViewById(R.id.blue_rectangle);

        // Get the SeekBar object
        SeekBar seekBar = (SeekBar) findViewById(R.id.change_color_seek_bar);
        seekBar.setOnSeekBarChangeListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.more_info:
                // Inflate the Dialog
                InformationDialog dialog = new InformationDialog();
                dialog.show(getSupportFragmentManager(), "more_info");
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        // 200 is the value of blue and red in the RGB value
        int redColorChange = Color.rgb(200, i, i);
        int blueColorChange = Color.rgb(i, i, 200);

        // Set the correct color value
        redRectangle.setBackgroundColor(redColorChange);
        blueRectangle.setBackgroundColor(blueColorChange);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // No need for this method
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // No need for this method
    }

}
