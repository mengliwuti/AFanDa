package zdsoft.afanda.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zdsoft.afanda.R;

/**
 * Created by Administrator on 2016/11/24.
 */
public class WeatherFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.weath_fragment,null);
        return view;
    }
//    {"result":{"realtime":{"wind":{"windspeed":null,"direct":"北风","power":"2级","offset":null},"time":"22:00:00","weather":{"humidity":"57","img":"2","info":"阴","temperature":"5"},"dataUptime":"1480084503","date":"2016-11-25","city_code":"101200101","city_name":"武汉","week":"5","moon":"十月廿六"},"life":{"date":"2016-11-25","info":{"kongtiao":["开启制暖空调","您将感到有些冷，可以适当开启制暖空调调节室内温度，以免着凉感冒。"],"yundong":["较适宜","天气较好，但考虑气温较低，推荐您进行室内运动，若户外适当增减衣物并注意防晒。"],"ziwaixian":["弱","紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"],"ganmao":["较易发","天凉，昼夜温差较大，较易发生感冒，请适当增减衣服，体质较弱的朋友请注意适当防护。"],"xiche":["较适宜","较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"],"wuran":null,"chuanyi":["较冷","建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。"]}},"weather":[{"date":"2016-11-25","week":"五","nongli":"十月廿六","info":{"dawn":null,"day":["2","阴","7","","微风","06:57"],"night":["1","多云","2","","微风","17:22"]}},{"date":"2016-11-26","week":"六","nongli":"十月廿七","info":{"dawn":["1","多云","2","无持续风向","微风","17:22"],"day":["1","多云","11","","微风","06:58"],"night":["0","晴","1","","微风","17:22"]}},{"date":"2016-11-27","week":"日","nongli":"十月廿八","info":{"dawn":["0","晴","1","无持续风向","微风","17:22"],"day":["0","晴","14","","微风","06:59"],"night":["0","晴","3","","微风","17:21"]}},{"date":"2016-11-28","week":"一","nongli":"十月廿九","info":{"dawn":["0","晴","3","无持续风向","微风","17:21"],"day":["1","多云","14","","微风","07:00"],"night":["1","多云","3","","微风","17:21"]}},{"date":"2016-11-29","week":"二","nongli":"十一月初一","info":{"dawn":["1","多云","3","无持续风向","微风","17:21"],"day":["2","阴","11","","微风","07:00"],"night":["0","晴","3","","微风","17:21"]}}],"pm25":{"key":"Wuhan","show_desc":"0","pm25":{"curPm":"55","pm25":"35","pm10":"56","level":"2","quality":"良","des":"可以接受的，除极少数对某种污染物特别敏感的人以外，对公众健康没有危害。"},"dateTime":"2016年11月25日22时","cityName":"武汉"},"isForeign":0},"error_code":0,"reason":"Succes"}
}
