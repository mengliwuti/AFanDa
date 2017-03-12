package zdsoft.afanda.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import zdsoft.afanda.Bean.CelebrityBean;
import zdsoft.afanda.R;

/**
 * Created by Administrator on 2016/11/25.
 */
public class CelebritytAdapter extends BaseAdapter{
    Context context;
    List<CelebrityBean> list;

    public CelebritytAdapter(Context context, List<CelebrityBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
//        if(list!=null){
//            return list.size();
//        }
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.celebrity_item,null);
        TextView content_tv= (TextView) convertView.findViewById(R.id.content_tv);
        TextView celerity_tv= (TextView) convertView.findViewById(R.id.celerity_tv);
        content_tv.setText(list.get(position).getContent());
        celerity_tv.setText(list.get(position).getCelebrity());
        return convertView;
    }
}
