package de.schueler.layoutviewsdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import de.schueler.layoutviewsdemo.R;
import de.schueler.layoutviewsdemo.adapter.RecyclerAdapter;
import de.schueler.layoutviewsdemo.data.Topic;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        List<Topic> topics = new ArrayList<>();
        topics.add(new Topic(R.string.github, R.mipmap.github, R.string.githubDesc));
        topics.add(new Topic(R.string.cpp, R.mipmap.cpp_logo, R.string.cppDesc));
        topics.add(new Topic(R.string.rust, R.mipmap.rust_logo, R.string.rustDesc));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerAdapter(topics));
    }
}
