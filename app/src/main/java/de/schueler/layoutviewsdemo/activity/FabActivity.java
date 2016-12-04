package de.schueler.layoutviewsdemo.activity;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import de.schueler.layoutviewsdemo.R;

public class FabActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String KEY_FAB_CLICKS = FabActivity.class.getName() + ".FAB_CLICKS";

    private int fabClicks;
    private TextView textView;

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        fabClicks = savedInstanceState.getInt(KEY_FAB_CLICKS, 0);
        updateClicks();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(KEY_FAB_CLICKS, fabClicks);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab);

        textView = (TextView) findViewById(R.id.textView);
        updateClicks();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        fabClicks++;
        updateClicks();
    }

    private void updateClicks() {
        textView.setText(getString(R.string.numFabClicks, fabClicks));
    }
}
