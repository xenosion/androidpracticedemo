package cn.example.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {
    private int recourseId;

    //构造方法 ( 上下文, listview子项布局的id, 要适配的数据List )
    public WordAdapter(Context context, int textViewResourceId, List<Word> objects) {
        super(context, textViewResourceId, objects);
        recourseId = textViewResourceId;
    }

    //重写了getview(), 这个方法在每个子项被滚动到屏幕内的时候会被调用
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Word word = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(recourseId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.wordImage = view.findViewById(R.id.word_image);
            viewHolder.wordName = view.findViewById(R.id.word_name);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.wordImage.setImageResource(word.getImageId());
        viewHolder.wordName.setText(word.getName());
        return view;
    }
}

class ViewHolder {
    ImageView wordImage;
    TextView wordName;
}