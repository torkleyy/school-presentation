package de.schueler.layoutviewsdemo.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import de.schueler.layoutviewsdemo.R;
import de.schueler.layoutviewsdemo.adapter.DemoAdapter;
import de.schueler.layoutviewsdemo.data.Tab;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        List<Tab> tabs = new ArrayList<>();
        tabs.add(new Tab(R.layout.fragment_linear1, R.string.linear1));
        tabs.add(new Tab(R.layout.fragment_linear1, R.string.linear1));

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new DemoAdapter(getSupportFragmentManager(), tabs, this));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
