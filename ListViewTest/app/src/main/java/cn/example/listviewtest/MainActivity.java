package cn.example.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.rtt.WifiRttManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Word> wordList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //准备entity数据,存成list
        initWords();

        //wordList数组中数据无法直接传递给listView,需要借助适配器,ArrayAdapter最合适
        WordAdapter wordAdapter = new WordAdapter(MainActivity.this, R.layout.fruit_item, wordList);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(wordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = wordList.get(position);
                Toast.makeText(MainActivity.this,word.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initWords() {
        for (int i = 0; i < 8; i++) {
            Word a = new Word("A", R.drawable.back_bg);
            wordList.add(a);

            Word b = new Word("B", R.drawable.edit_bg);
            wordList.add(b);
            
            Word c = new Word("C", R.drawable.title_bg);
            wordList.add(c);

        }
    }
}
