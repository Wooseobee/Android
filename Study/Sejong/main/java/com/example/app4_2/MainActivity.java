package com.example.app4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;
    Button btn;
    CheckBox chkbox;
    RadioGroup rgroup;
    RadioButton dog, cat;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.bulldog);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        setTitle("애완동물 사진 보기");

        text1 = (TextView)findViewById(R.id.textView);
        text2 = (TextView)findViewById(R.id.textView2);

        chkbox = (CheckBox)findViewById(R.id.checkBox);

        rgroup = (RadioGroup)findViewById(R.id.rGroup);
        dog = (RadioButton)findViewById(R.id.radioButton);
        cat = (RadioButton)findViewById(R.id.radioButton2);

        btn = (Button)findViewById(R.id.button);

        img = (ImageView)findViewById(R.id.imageView);

        chkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(chkbox.isChecked() == true) {
                    text2.setVisibility(View.VISIBLE);
                    rgroup.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.VISIBLE);
                    img.setVisibility(View.VISIBLE);
                }
                else{
                    text2.setVisibility(View.INVISIBLE);
                    rgroup.setVisibility(View.INVISIBLE);
                    btn.setVisibility(View.INVISIBLE);
                    img.setVisibility(View.INVISIBLE);
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rgroup.getCheckedRadioButtonId()){
                    case R.id.radioButton:
                        img.setImageResource(R.drawable.pug);
                        break;
                    case R.id.radioButton2:
                        img.setImageResource(R.drawable.cat2);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "동물 먼저 선택하세요!", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });
    }
}