package ofirdahan.com.newz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by ofirdahan on 11/3/16.
 */

public class StoryAdapter extends BaseAdapter {

    private final Story[] topStories;
    Context mContext;

    public StoryAdapter(Story[] topStories, Context context) {
        this.topStories = topStories;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return topStories.length;
    }

    @Override
    public Story getItem(int position) {
        return topStories[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Story story = getItem(position);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.activity_daily_story, parent, false);

        TextView title = (TextView) view.findViewById(R.id.titleLabel);
        TextView author = (TextView) view.findViewById(R.id.authorLabel);
        TextView points = (TextView) view.findViewById(R.id.pointsValue);

        title.setText(story.getTitle());
        author.setText(story.getAuthor());
        points.setText(story.getPoints());

        return view;
    }
}
