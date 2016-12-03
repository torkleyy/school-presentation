package de.schueler.layoutviewsdemo.handler;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import de.schueler.layoutviewsdemo.fragment.FragmentHandler;
import de.schueler.layoutviewsdemo.fragment.FragmentHandlers;

public class LinearHandler implements FragmentHandler {
    public static FragmentHandlers.HandlerId register() {
        return FragmentHandlers.put(new LinearHandler());
    }

    private LinearHandler() {
    }

    @Override
    public void onCreate(Context context, Bundle savedInstanceState) {

    }

    @Override
    public void onViewCreated(Context context, View view, Bundle savedInstanceState) {

    }
}
