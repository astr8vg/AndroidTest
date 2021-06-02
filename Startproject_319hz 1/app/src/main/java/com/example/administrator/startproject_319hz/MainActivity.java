package com.example.administrator.startproject_319hz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.startproject_319hz.bean.WeatherInfo;
import com.example.administrator.startproject_319hz.iface.WeatherListener;
import com.example.administrator.startproject_319hz.model.Weather51Model;
import com.example.administrator.startproject_319hz.model.WeatherModel;

public class MainActivity extends AppCompatActivity implements WeatherListener, View.OnClickListener{
    private EditText editText;
    private Button button,button2;
    private TextView tvcityname,city,cityid,temp,wd,ws,sd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


    }
    private void init(){
        editText=(EditText)findViewById(R.id.editText);
        button=(Button)findViewById(R.id.button);
        button2=(Button)findViewById(R.id.button2);
        tvcityname=(TextView)findViewById(R.id.TextView);
        city=(TextView)findViewById(R.id.textView2);
        cityid=(TextView)findViewById(R.id.textView3);
        temp=(TextView)findViewById(R.id.textView4);
        wd=(TextView)findViewById(R.id.textView5);
        ws=(TextView)findViewById(R.id.textView6);
        sd=(TextView)findViewById(R.id.textView7);

        button.setOnClickListener(this);

        button2.setOnClickListener(this);


    }

    @Override
    public void onResponse(WeatherInfo weatherInfo) {
        if (weatherInfo!=null){
            tvcityname.setText(weatherInfo.getCity());
            city.setText(weatherInfo.getCity());
            cityid.setText(weatherInfo.getCityid());
            temp.setText(weatherInfo.getTemp());
            wd.setText(weatherInfo.getWD());
            ws.setText(weatherInfo.getWS());
            sd.setText(weatherInfo.getSD());
        }else {
            tvcityname.setText("未知");
        }
    }

    @Override
    public void onFail(String msg) {
        tvcityname.setText(msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button:
                WeatherModel weatherModel = new WeatherModel();
                weatherModel.getWeather(editText.getText().toString(),this);
                break;
            case R.id.button2:
                Weather51Model weather51Model = new Weather51Model();
                weather51Model.getWeather(editText.getText().toString(),this);
                break;
            default:
                break;
        }
    }
}
