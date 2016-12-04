package de.schueler.layoutviewsdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import de.schueler.layoutviewsdemo.R;
import de.schueler.layoutviewsdemo.fragment.NumberDetailFragment;
import de.schueler.layoutviewsdemo.fragment.NumberEmptyFragment;
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
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.frameLayout, NumberEmptyFragment.newInstance())
                    .commit();
        }
    }

    @Override
    public void onClickItem(final int number) {
        if (twoPaneMode) {
            if (detailFragment == null) {
                detailFragment = NumberDetailFragment.newInstance(number);
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, detailFragment)
                        .commit();
            }
            detailFragment.changeNumber(number);
        } else {
            Intent intent = new Intent(this, NumberActivity.class);
            intent.putExtra(NumberActivity.KEY_NUMBER, number);
            startActivity(intent);
        }
    }
}
