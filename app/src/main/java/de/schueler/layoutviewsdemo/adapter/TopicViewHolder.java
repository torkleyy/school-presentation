package de.schueler.layoutviewsdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import de.schueler.layoutviewsdemo.data.Topic;

class TopicViewHolder extends RecyclerView.ViewHolder {
    TopicViewHolder(View itemView) {
        super(itemView);
    }

    void onDataSetChanged(Context context, Topic topic) {

    }
}
