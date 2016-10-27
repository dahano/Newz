package ofirdahan.com.newz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private Hits mHits;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getTopStories();
    }

    public void getTopStories(){
        String newsUrl = "https://hn.algolia.com/api/v1/search?tags=front_page";

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                    .url(newsUrl).build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String jsonData = response.body().string();
                    if(response.isSuccessful()){
                        mHits = parseHitsDetails(jsonData);
                        Log.v(TAG, response.body().string());
                    }
                } catch (IOException e) {
                    Log.e(TAG, "Exception caught: ",e);
                }
            }
        });

    }

    private Hits parseHitsDetails(String jsonData) {
        Hits parsedHits = new Hits();
        return parsedHits;
    }


}
