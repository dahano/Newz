package ofirdahan.com.newz;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Array;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private Story mStory[];
    StoryAdapter mAdapter;

    private ListView mainList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainList = (ListView) findViewById(R.id.myList);
        getTopStories();
    }

    public void getTopStories(){
        String newsUrl = "https://hn.algolia.com/api/v1/search?tags=front_page";

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                    .url(newsUrl).build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            Handler mainHandler = new Handler(MainActivity.this.getMainLooper());

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    if(response.isSuccessful()){
                        String jsonData = response.body().string();
                        try {
                            mStory = parseStoryDetails(jsonData);
                            mAdapter = new StoryAdapter(mStory,MainActivity.this);

                            mainHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    mainList.setAdapter(mAdapter);
                                }
                            });
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Log.v(TAG, "JSON Data: "+jsonData);
                    }
                } catch (IOException e) {
                    Log.e(TAG, "Exception caught: ",e);
                }
            }
        });

    }

    private Story[] parseStoryDetails(String jsonData)throws JSONException {
        JSONObject hitsBody = new JSONObject(jsonData);
        JSONArray hits = hitsBody.getJSONArray("hits");

        Story[] topStories = new Story[hits.length()];

        for(int i=0; i< topStories.length; i++){
            JSONObject jsonHits = hits.getJSONObject(i);
            Story story = new Story();
            story.setAuthor(jsonHits.getString("author"));
            story.setCreatedAt(jsonHits.getString("created_at"));
            story.setPoints(jsonHits.getInt("points"));
            story.setTitle(jsonHits.getString("title"));
            topStories[i] = story;
        }
        return topStories;
    }

}
