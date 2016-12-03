package de.schueler.layoutviewsdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CustomFragment extends Fragment {
    private static final String KEY_LAYOUT_ID = CustomFragment.class.getName() + ".LAYOUT_ID";
    private static final String KEY_HANDLER_ID = CustomFragment.class.getName() + ".HANDLER_ID";

    public static CustomFragment newInstance(int layoutId, FragmentHandlers.HandlerId handlerId) {
        Bundle args = new Bundle();
        args.putInt(KEY_LAYOUT_ID, layoutId);
        args.putParcelable(KEY_HANDLER_ID, handlerId);
        CustomFragment fragment = new CustomFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private int layoutId;
    private FragmentHandler handler;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle arguments = getArguments();
        layoutId = arguments.getInt(KEY_LAYOUT_ID, -1);
        FragmentHandlers.HandlerId handlerId = arguments.getParcelable(KEY_HANDLER_ID);

        if (handlerId == null) {
            throw new IllegalArgumentException("Failed to create fragment. Please use the newInstance method.");
        }

        handler = handlerId.dereference();
        handler.onCreate(getContext(), savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(layoutId, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        handler.onViewCreated(getContext(), view, savedInstanceState);
    }
}
