package com.example.administrator.widgettest_319hz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    private EditText editText;
    private Button Button1,Button2,Button4,Button5;
    private ImageButton ImageButton;
    private ImageView ImageView;
    private RadioButton radioButtonnan, radioButtonnv;
    private CheckBox checkfootball,checkbasketball,checksswim;
    private RadioGroup rg;
    private String strfun="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        //获取控件
        textView=(TextView)findViewById(R.id.textView);
        editText=(EditText)findViewById(R.id.editText);
        Button1=(Button)findViewById(R.id.button);
        Button2=(Button)findViewById(R.id.button2);
        Button4=(Button)findViewById(R.id.button4);
        Button5=(Button)findViewById(R.id.button5);
        radioButtonnv=(RadioButton)findViewById(R.id.radioButton4);
        radioButtonnan=(RadioButton)findViewById(R.id.radioButton5);
        checkfootball=(CheckBox)findViewById(R.id.checkBox);
        checksswim=(CheckBox)findViewById(R.id.checkBox2);
        checkbasketball=(CheckBox)findViewById(R.id.checkBox3);
        ImageView=(ImageView)findViewById(R.id.imageView);
        ImageButton=(ImageButton)findViewById(R.id.imageButton);
        rg=(RadioGroup)findViewById(R.id.radioGroup);
        //设置按钮监听器
        Button1.setOnClickListener(this);
        Button2.setOnClickListener(this);
        ImageButton.setOnClickListener(this);
        Button4.setOnClickListener(this);
        Button5.setOnClickListener(this);
        checkfootball.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    strfun+="football+";
                else
                    strfun=strfun.replace("football+","");
                textView.setText(strfun);
            }
        });
        checksswim.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    strfun+="swim+";
                else
                    strfun=strfun.replace("swim+","");
                textView.setText(strfun);
            }
        });
        checkbasketball.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    strfun+="basketball+";
                else
                    strfun=strfun.replace("basketball+","");
                    textView.setText(strfun);

            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButton5:
                        textView.setText("man");
                        break;
                    case R.id.radioButton4:
                        textView.setText("woman");
                        break;
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button:
                String str=editText.getText().toString();
                textView.setText(str);
                break;
            case R.id.button2:
                ImageView.setImageResource(R.drawable.xxx);
                break;
            case R.id.imageButton:
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("param1",editText.getText().toString());
                intent.putExtra("param2",3);
                startActivity(intent);
                break;
            case R.id.button4:
                if(radioButtonnv.isChecked()) textView.setText("女");
                if(radioButtonnan.isChecked()) textView.setText("男");
                break;
            case R.id.button5:
                String msg="";
                if(checksswim.isChecked()) msg+="游泳+";
                if(checkfootball.isChecked()) msg+="足球+";
                if(checkbasketball.isChecked()) msg+="篮球";
                textView.setText(msg);
                break;

        }

    }
}
