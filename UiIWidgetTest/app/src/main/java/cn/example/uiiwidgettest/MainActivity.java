package cn.example.uiiwidgettest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    private Button button;
    private Button buttond;
    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar!= null){
            actionBar.hide();
        }
/*

        button.setOnClickListener(this);
        buttond.setOnClickListener(this);*/
    }

  /*  @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                String inputText = editText.getText().toString();
                Toast.makeText(MainActivity.this, inputText, Toast.LENGTH_SHORT).show();

                imageView.setImageResource(R.drawable.green);

                int progress = progressBar.getProgress();
                progress = progress + 10;
                progressBar.setVisibility(progress);
                break;

            case R.id.buttond:
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("This is ProgressDialog");
                dialog.setMessage("Something important.");
                dialog.setCancelable(false);
                dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {}
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {}
                });
                dialog.show();
            default:
                break;
        }
    }*/

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("MainActivity", "onPause: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("MainActivity", "onResume: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("MainActivity", "onStop: ");
    }
}
