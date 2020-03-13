package cn.example.activitytest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.util.Log.e("FirstActivity", "Task id is :"+getTaskId());
        setContentView(R.layout.first_layout);

        Button button1 = findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //隐式(通过AndroidManifest, 额外增加一个my_category作为验证
              /* Intent intent = new Intent("cn.example.activitytest.ACTION_START");
               intent.addCategory("cn.example.activitytest.MY_CATEGORY");
               startActivity(intent);*/

                //显式
               /* String data = "Hello SecondActivity";
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("extra_data", data);
                startActivityForResult(intent, 1);*/

               SecondActivity.actionStart(FirstActivity.this,"data1","data2");
               /* Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);*/

            }
        });
    }

    //接受销毁的activity返回的数据, 先根据requestcode判断是哪个activity被销毁
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");
                    Log.e("FirstActivity", returnedData);
                }
                break;
            default:
        }
    }

    //增加一个menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //增加按钮被按下的事件
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("FirstActivity", "onRestart: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("FirstActivity", "onDestory: ");
    }
}
