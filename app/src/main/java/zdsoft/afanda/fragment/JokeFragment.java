package zdsoft.afanda.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import zdsoft.afanda.Adapter.JokeAdapter;
import zdsoft.afanda.R;

/**
 * Created by Administrator on 2016/11/24.
 */
public class JokeFragment extends Fragment {
    TextView joke_next;
    EditText joke_page;
    ListView joke_listshow;
    JokeAdapter jokeAdapter;
    List<String> list;
    String result;
    int page;
    String path="http://api.avatardata.cn/Joke/QueryJokeByTime";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.joke_fragment,null);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads().detectDiskWrites().detectNetwork()
                .penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects().detectLeakedClosableObjects()
                .penaltyLog().penaltyDeath().build());
        joke_next= (TextView) view.findViewById(R.id.joke_next);
        joke_page= (EditText) view.findViewById(R.id.joke_page);
        joke_listshow= (ListView) view.findViewById(R.id.joke_listshow);
        getJob();
        return view;
    }
    private void getJob(){
        try{
            page=Integer.parseInt(joke_page.getText().toString());
            String newpath=path+"?key=f5cc3b1c5bd448afa273b155b43683eb&page="+page+"&rows=100&sort=asc&time=1418745237";
            URL url=new URL(newpath);
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            InputStreamReader str=new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader=new BufferedReader(str);
            StringBuffer stringBuffer=new StringBuffer();
            String line=null;
            while((line=bufferedReader.readLine())!=null){
                stringBuffer.append(line);
            }
            result=stringBuffer.toString();
            parseJson(result);
        }catch (Exception e){
        }
    }

    public void parseJson(String result){
        try {
            JSONObject jsonObject=new JSONObject(result);
            String data=jsonObject.getString("result");
            JSONArray jsonArray=new JSONArray(data);
            list=new ArrayList<String>();
            for (int i=0;i<jsonArray.length();i++){
                JSONObject object=new JSONObject(jsonArray.getString(i));
                list.add(object.getString("content"));
            }
            jokeAdapter=new JokeAdapter(getContext(),list);
            joke_listshow.setAdapter(jokeAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
