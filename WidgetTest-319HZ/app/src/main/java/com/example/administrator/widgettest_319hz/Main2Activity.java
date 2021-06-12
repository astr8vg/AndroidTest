package com.example.administrator.widgettest_319hz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
    private Button btnclose;
        private TextView textView;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);
            Intent intent = getIntent();
            String str=intent.getStringExtra("param1");
            int n = intent.getIntExtra("param2",111);
            System.out.println("------"+str+"------"+String.valueOf(n));
            Toast.makeText(this,str+"------"+String.valueOf(n), Toast.LENGTH_SHORT).show();
            TextView tv=(TextView)findViewById(R.id.textView2);
            tv.setText(str+"------"+String.valueOf(n));

            Button btnclose=(Button)findViewById(R.id.button3);
            btnclose.setOnClickListener(this);


    }
    //private void init(){
        //获取六个控件
        //textView=(TextView)findViewById(R.id.textView2);
        //btnclose=(Button)findViewById(R.id.button3);

        //设置按钮监听器
        //btnclose.setOnClickListener(this);

    //}

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button3:
                finish();
                break;
        }

    }
}
