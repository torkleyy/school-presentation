package de.schueler.layoutviewsdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import de.schueler.layoutviewsdemo.R;
import de.schueler.layoutviewsdemo.fragment.NumberDetailFragment;

public class NumberActivity extends AppCompatActivity {
    static final String KEY_NUMBER = ListActivity.class.getName() + "KEY_NUMBER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        int number = getIntent().getIntExtra(KEY_NUMBER, -1);
        if (number == -1) {
            throw new RuntimeException("No number argument");
        }

        NumberDetailFragment fragment = (NumberDetailFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragmentNumberDetail);
        fragment.changeNumber(number);
    }
}
