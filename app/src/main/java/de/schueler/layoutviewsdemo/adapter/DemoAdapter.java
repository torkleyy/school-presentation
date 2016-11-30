package de.schueler.layoutviewsdemo.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import de.schueler.layoutviewsdemo.data.Tab;
import de.schueler.layoutviewsdemo.fragment.CustomFragment;

import java.util.List;

public class DemoAdapter extends FragmentPagerAdapter {
    private final List<Tab> tabs;
    private final Context context;

    public DemoAdapter(FragmentManager fm, List<Tab> tabs, Context context) {
        super(fm);
        this.tabs = tabs;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        Tab tab = tabs.get(position);
        return CustomFragment.newInstance(tab.getLayoutId());
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Tab tab = tabs.get(position);
        return context.getString(tab.getStringId());
    }

    @Override
    public int getCount() {
        return tabs.size();
    }
}
