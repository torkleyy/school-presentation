package de.schueler.layoutviewsdemo.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import de.schueler.layoutviewsdemo.R;
import de.schueler.layoutviewsdemo.adapter.ListAdapter;
import de.schueler.layoutviewsdemo.data.Tabs;
import de.schueler.layoutviewsdemo.handler.*;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Tabs tabs = new Tabs();
        tabs.addTab(R.layout.fragment_linear, R.string.linear, LinearHandler.register());
        tabs.addTab(R.layout.fragment_linear_weight, R.string.linearWeight, LinearWeightHandler.register());
        tabs.addTab(R.layout.fragment_relative, R.string.relative, RelativeHandler.register());
        tabs.addTab(R.layout.fragment_relative_find, R.string.relative_find, RelativeComplexHandler.register());
        tabs.addTab(R.layout.fragment_other, R.string.other, OtherHandler.register());

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new ListAdapter(getSupportFragmentManager(), tabs, this));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
