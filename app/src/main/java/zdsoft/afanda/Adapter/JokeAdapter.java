package zdsoft.afanda.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import zdsoft.afanda.R;

/**
 * Created by Administrator on 2016/11/24.
 */
public class JokeAdapter extends BaseAdapter{
    Context context;
    List<String> list;

    public JokeAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        if(list!=null){
            return list.size();
        }
        return 0;
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
        convertView= LayoutInflater.from(context).inflate(R.layout.joke_item,null);
        TextView joke_item= (TextView) convertView.findViewById(R.id.joke_item);
        joke_item.setText(list.get(position));
        return convertView;
    }
}
