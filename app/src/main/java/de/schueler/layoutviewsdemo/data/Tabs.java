package de.schueler.layoutviewsdemo.data;

import de.schueler.layoutviewsdemo.fragment.FragmentHandlers;

import java.util.ArrayList;
import java.util.List;

public class Tabs {
    private final List<Tab> tabs;

    public Tabs() {
        tabs = new ArrayList<>();
    }

    public void addTab(int layoutId, int stringId, FragmentHandlers.HandlerId handlerId) {
        tabs.add(new Tab(layoutId, stringId, handlerId));
    }

    public Tab get(int index) {
        return tabs.get(index);
    }

    public int size() {
        return tabs.size();
    }
}
