package de.schueler.layoutviewsdemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

public interface FragmentHandler {
    void onCreate(Context context, Bundle savedInstanceState);

    void onViewCreated(Context context, View view, Bundle savedInstanceState);
}
