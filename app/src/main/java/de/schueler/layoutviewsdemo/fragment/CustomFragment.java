package de.schueler.layoutviewsdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CustomFragment extends Fragment {
    private static final String KEY_LAYOUT_ID = CustomFragment.class.getName() + ".LAYOUT_ID";

    public static CustomFragment newInstance(int layoutId) {
        Bundle args = new Bundle();
        args.putInt(KEY_LAYOUT_ID, layoutId);
        CustomFragment fragment = new CustomFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private int layoutId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        layoutId = getArguments().getInt(KEY_LAYOUT_ID, -1);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(layoutId, container, false);
    }
}
