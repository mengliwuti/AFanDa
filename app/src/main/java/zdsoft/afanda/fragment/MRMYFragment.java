package zdsoft.afanda.fragment;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import zdsoft.afanda.Adapter.CelebritytAdapter;
import zdsoft.afanda.Bean.CelebrityBean;
import zdsoft.afanda.R;

/**
 * Created by Administrator on 2016/11/24.
 */
public class MRMYFragment extends Fragment{
    String path="http://api.avatardata.cn/Joke/QueryJokeByTime";
    List<CelebrityBean> list=new ArrayList<CelebrityBean>();
    CelebritytAdapter celebritytAdapter;
    ListView celebrity_listshow;
    String result;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.celebrity_fragment,null);
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        celebrity_listshow= (ListView) view.findViewById(R.id.celebrity_listshow);
        getJob();
        return view;
    }
    private void getJob(){
        try{
            String newpath="http://api.avatardata.cn/MingRenMingYan/LookUp?key=ae7a46be2e71477ca542702da292c633&keyword=%E5%A4%A9%E6%89%8D&page=1&rows=100";
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
            Log.e("!!!!!!!!!!!!",e+"");
        }
    }

    public void parseJson(String result){
        try {
            JSONObject jsonObject=new JSONObject(result);
            String data=jsonObject.getString("result");
            JSONArray jsonArray=new JSONArray(data);
            for (int i=0;i<jsonArray.length();i++){
                JSONObject object=new JSONObject(jsonArray.getString(i));
                CelebrityBean celebrityBean=new CelebrityBean();
                celebrityBean.setContent(object.getString("famous_saying"));
                celebrityBean.setCelebrity(object.getString("famous_name"));
                list.add(celebrityBean);
            }
            celebritytAdapter=new CelebritytAdapter(getContext(),list);
            celebrity_listshow.setAdapter(celebritytAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
