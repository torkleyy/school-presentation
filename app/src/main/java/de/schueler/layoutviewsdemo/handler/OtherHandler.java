package de.schueler.layoutviewsdemo.handler;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import de.schueler.layoutviewsdemo.R;
import de.schueler.layoutviewsdemo.activity.FabActivity;
import de.schueler.layoutviewsdemo.activity.ListActivity;
import de.schueler.layoutviewsdemo.activity.RecyclerActivity;
import de.schueler.layoutviewsdemo.fragment.FragmentHandler;
import de.schueler.layoutviewsdemo.fragment.FragmentHandlers;

public class OtherHandler implements FragmentHandler, View.OnClickListener {
    public static FragmentHandlers.HandlerId register() {
        return FragmentHandlers.put(new OtherHandler());
    }

    private OtherHandler() {
    }

    @Override
    public void onCreate(Context context, Bundle savedInstanceState) {

    }

    @Override
    public void onViewCreated(Context context, View view, Bundle savedInstanceState) {
        Button buttonList = (Button) view.findViewById(R.id.buttonList);
        Button buttonRecycler = (Button) view.findViewById(R.id.buttonRecycler);
        Button buttonFab = (Button) view.findViewById(R.id.buttonFab);

        buttonList.setOnClickListener(this);
        buttonRecycler.setOnClickListener(this);
        buttonFab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        Intent intent;
        Context context = v.getContext();
        switch (id) {
            case R.id.buttonList:
                intent = new Intent(context, ListActivity.class);
                break;
            case R.id.buttonRecycler:
                intent = new Intent(context, RecyclerActivity.class);
                break;
            case R.id.buttonFab:
                intent = new Intent(context, FabActivity.class);
                break;
            default:
                throw new RuntimeException();
        }
        v.getContext().startActivity(intent);
    }
}
