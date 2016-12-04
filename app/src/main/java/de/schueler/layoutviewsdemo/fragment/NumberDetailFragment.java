package de.schueler.layoutviewsdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import de.schueler.layoutviewsdemo.R;
import de.schueler.layoutviewsdemo.view.NumberLine;

@SuppressWarnings({"unused", "WeakerAccess"})
public class NumberDetailFragment extends Fragment {
    private static final String KEY_NUMBER = NumberDetailFragment.class.getName() + ".NUMBER";

    public static NumberDetailFragment newInstance(int number) {
        Bundle args = new Bundle();
        args.putInt(KEY_NUMBER, number);
        NumberDetailFragment fragment = new NumberDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private boolean created;
    private int number;
    private TextView textView;
    private NumberLine numberLine;

    public NumberDetailFragment() {
        created = false;
        number = -1;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle arguments = getArguments();

        if (arguments != null && number == -1) {
            number = arguments.getInt(KEY_NUMBER, -1);
            if (number == -1) {
                throw new RuntimeException("You have to use newInstance to instantiate the fragment");
            }
        }

        created = true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        created = false;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_number_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        textView = (TextView) view.findViewById(R.id.textInfo);
        numberLine = (NumberLine) view.findViewById(R.id.numberLine);
        changeNumber(number);
    }

    public void changeNumber(int number) {
        this.number = number;

        if(!created) {
            return;
        }

        textView.setText(getActivity().getString(R.string.numberText, number));
        numberLine.setNumber(number);
    }
}
