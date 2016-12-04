package de.schueler.layoutviewsdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import de.schueler.layoutviewsdemo.R;
import de.schueler.layoutviewsdemo.data.Topic;

class TopicViewHolder extends RecyclerView.ViewHolder {
    private final TextView textTitle;
    private final ImageView imageView;
    private final TextView textDescription;

    TopicViewHolder(View itemView) {
        super(itemView);

        textTitle = (TextView) itemView.findViewById(R.id.textTitle);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);
        textDescription = (TextView) itemView.findViewById(R.id.textDescription);
    }

    void onDataSetChanged(Topic topic) {
        textTitle.setText(topic.getTitleId());
        imageView.setImageResource(topic.getImageId());
        textDescription.setText(topic.getDescriptionId());
    }
}
