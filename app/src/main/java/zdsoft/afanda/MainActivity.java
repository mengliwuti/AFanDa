package zdsoft.afanda;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import zdsoft.afanda.Adapter.MyAdapter;
import zdsoft.afanda.fragment.JokeFragment;
import zdsoft.afanda.fragment.MRMYFragment;
import zdsoft.afanda.fragment.WeatherFragment;
import zdsoft.afanda.fragment.XZYSFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,ViewPager.OnPageChangeListener{
    TextView joke_tv,celebrity_tv,weath_tv,constellation_tv;
    Fragment jokeFragment,mRMYFragment,weatherFragment,xZYSFragment;
    List<Fragment> list;
    ViewPager viewPager;
    MyAdapter myAdapter;
    FragmentManager fragmentManager;
    Resources resources;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        into();
        intoPager();
        cleanIcon();
        first();

    }
    /**
     * 实例化控件*/
    private void into(){
        joke_tv= (TextView) findViewById(R.id.joke_tv);
        celebrity_tv= (TextView) findViewById(R.id.celebrity_tv);
        weath_tv= (TextView) findViewById(R.id.weath_tv);
        constellation_tv= (TextView) findViewById(R.id.constellation_tv);
        viewPager= (ViewPager) findViewById(R.id.viewpager_show);
        joke_tv.setOnClickListener(this);
        celebrity_tv.setOnClickListener(this);
        weath_tv.setOnClickListener(this);
        constellation_tv.setOnClickListener(this);
        viewPager.setOnPageChangeListener(this);
        fragmentManager=getSupportFragmentManager();
        resources=getResources();

    }
    /**
     * 初始化页面*/
    private void intoPager(){
        list=new ArrayList<Fragment>();
        jokeFragment=new JokeFragment();
        mRMYFragment=new MRMYFragment();
        weatherFragment=new WeatherFragment();
        xZYSFragment=new XZYSFragment();
        list.add(jokeFragment);
        list.add(mRMYFragment);
        list.add(weatherFragment);
        list.add(xZYSFragment);
        myAdapter=new MyAdapter(fragmentManager,list);
        viewPager.setAdapter(myAdapter);
    }
    /**
     * 第一次进入界面*/
    private void first(){
        joke_tv.setTextSize(30);
        joke_tv.setTextColor(resources.getColor(R.color.blue));
    }

    @Override
    public void onClick(View v) {
        changFragment(v.getId());
    }
    public void changFragment(int i){
        cleanIcon();
        switch (i) {
            case R.id.joke_tv:case 0:
                joke_tv.setTextSize(30);
                joke_tv.setTextColor(resources.getColor(R.color.blue));
                viewPager.setCurrentItem(0);
                break;
            case R.id.celebrity_tv:case 1:
                celebrity_tv.setTextSize(30);
                celebrity_tv.setTextColor(resources.getColor(R.color.blue));
                viewPager.setCurrentItem(1);
                break;
            case R.id.weath_tv:case 2:
                weath_tv.setTextSize(30);
                weath_tv.setTextColor(resources.getColor(R.color.blue));
                viewPager.setCurrentItem(2);
                break;
            case R.id.constellation_tv:case 3:
                constellation_tv.setTextSize(30);
                constellation_tv.setTextColor(resources.getColor(R.color.blue));
                viewPager.setCurrentItem(3);
                break;
        }
    }
    /**
     * 清空字体颜色*/
    private void cleanIcon(){
        joke_tv.setTextColor(resources.getColor(R.color.gray));
        celebrity_tv.setTextColor(resources.getColor(R.color.gray));
        weath_tv.setTextColor(resources.getColor(R.color.gray));
        constellation_tv.setTextColor(resources.getColor(R.color.gray));
        joke_tv.setTextSize(20);
        celebrity_tv.setTextSize(20);
        weath_tv.setTextSize(20);
        constellation_tv.setTextSize(20);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        changFragment(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
