package cn.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("ThirdActivity","Task id is:"+getTaskId()  );
        setContentView(R.layout.third_layout);

        Button button3 = findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCollector.finishAll();
                /*
                //杀死当前进程,直接终止,不显示ondestroy
                android.os.Process.killProcess(android.os.Process.myPid());*/
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("ThirdActivity", "onDestory: ");
    }
}