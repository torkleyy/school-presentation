package de.schueler.layoutviewsdemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import de.schueler.layoutviewsdemo.R;

public class NumberListFragment extends Fragment implements AdapterView.OnItemClickListener {
    public interface Listener {
        void onClickItem(int number);
    }

    private static final Integer[] values = new Integer[]{
            6, 8, 10, 13, 15, 18, 125, 160,
    };

    public static NumberListFragment newInstance() {
        return new NumberListFragment();
    }

    private ListView listView;
    private Listener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof Listener) {
            listener = (Listener) context;
        } else {
            throw new RuntimeException("Underlying context has to implement " + Listener.class.getName());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        listView = (ListView) view.findViewById(R.id.listView);

        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(getActivity(), R.layout.view_number, R.id.textView);

        adapter.addAll(values);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        listener.onClickItem(values[position]);
    }
}
