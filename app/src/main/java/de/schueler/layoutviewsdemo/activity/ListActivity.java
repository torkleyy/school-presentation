package de.schueler.layoutviewsdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import de.schueler.layoutviewsdemo.R;
import de.schueler.layoutviewsdemo.fragment.NumberDetailFragment;
import de.schueler.layoutviewsdemo.fragment.NumberListFragment;

public class ListActivity extends AppCompatActivity implements NumberListFragment.Listener {

    private boolean twoPaneMode;
    private NumberDetailFragment detailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        twoPaneMode = getResources().getBoolean(R.bool.twoPaneMode);

        if (twoPaneMode) {
            detailFragment = (NumberDetailFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.fragmentNumberDetail);
        }
    }

    @Override
    public void onClickItem(int number) {
        if (twoPaneMode) {
            detailFragment.changeNumber(number);
        } else {
            Intent intent = new Intent(this, NumberActivity.class);
            intent.putExtra(NumberActivity.KEY_NUMBER, number);
            startActivity(intent);
        }
    }
}
