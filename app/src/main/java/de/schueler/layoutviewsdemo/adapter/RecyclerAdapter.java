package de.schueler.layoutviewsdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import de.schueler.layoutviewsdemo.R;
import de.schueler.layoutviewsdemo.data.Topic;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<TopicViewHolder> {
    private final Context context;
    private final List<Topic> topics;

    public RecyclerAdapter(Context context, List<Topic> topics) {
        this.context = context;
        this.topics = topics;
    }

    @Override
    public TopicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view_topic, parent, false);
        return new TopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TopicViewHolder holder, int position) {
        holder.onDataSetChanged(context, topics.get(position));
    }

    @Override
    public int getItemCount() {
        return topics.size();
    }
}
