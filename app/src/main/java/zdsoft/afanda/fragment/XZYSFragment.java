package zdsoft.afanda.fragment;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import zdsoft.afanda.Bean.ConstelBean;
import zdsoft.afanda.R;

/**
 * Created by Administrator on 2016/11/24.
 */
public class XZYSFragment extends Fragment{
    private View view;
    private String result;
    TextView name_show,datetime_show,all_show,color_show,health_show,money_show,qfriend_show,summary_show;
    String path="http://api.avatardata.cn/Constellation/Query?key=331ea425cc694d5fbcd8e09eadb455de&consName=狮子座&type=today";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.constellation_fragment,null);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads().detectDiskWrites().detectNetwork()
                .penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects().detectLeakedClosableObjects()
                .penaltyLog().penaltyDeath().build());
        into();
        getJob();
        return view;
    }
    /**实例化控件*/
    private void into(){
        name_show= (TextView) view.findViewById(R.id.name_show);
        datetime_show= (TextView) view.findViewById(R.id.datetime_show);
        all_show= (TextView) view.findViewById(R.id.all_show);
        color_show= (TextView) view.findViewById(R.id.color_show);
        health_show= (TextView) view.findViewById(R.id.health_show);
        money_show= (TextView) view.findViewById(R.id.money_show);
        qfriend_show= (TextView) view.findViewById(R.id.qfriend_show);
        summary_show= (TextView) view.findViewById(R.id.summary_show);
    }
    private void getJob(){
    try{
        URL url=new URL(path);
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
        Log.e("result",result);
    }catch (Exception e){
    }
    }


    public void parseJson(String result){
        try {
            JSONObject jsonObject=new JSONObject(result);
            String data=jsonObject.getString("result");
            Log.e("+++data+++",data);
//            JSONArray jsonArray=new JSONArray(data);
//            for (int i=0;i<jsonArray.length();i++){
//                JSONObject object=new JSONObject(jsonArray.getString(i));
//                Log.e("=========",object.getString("content"));
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }







/**
 *     {"result1":{"resultcode":"200","error_code":"0","name":"狮子座",
 *                    "datetime":"2016年11月25日","date":"20161125",
 *                    "all":"40%",
 *                    "color":"黄色",
 *                    "health":"79%",
 *                    "love":"60%",
 *                    "money":"40%",
 *                    "number":"1",
 *                    "QFriend":"天秤座",
 *                    "summary":"今天朋友们能够给你提供很多新鲜的灵感，带给你一些你所未闻的消息，也间接地提升了你的眼界。面对一些乱局，和不够清晰的地方，可以试着思考，也许会有不错的成绩出来。",
 *                    "work":"40%"},"result2":null,"error_code":0,"reason":"Succes"}
*/
}
