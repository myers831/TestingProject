package com.example.admin.testingproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    public static final String RESULT_KEY = "resultKey";
    @BindView(R.id.tvText)
    TextView tvText;
    @BindView(R.id.btnPress)
    Button btnPress;
    @BindView(R.id.etValOne)
    EditText etValOne;
    @BindView(R.id.etValTwo)
    EditText etValTwo;
    @BindView(R.id.btnPress2)
    Button btnPress2;
    private int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.btnPress)
    public void onViewClicked() {
        int first = Integer.parseInt(etValOne.getText().toString());
        int second = Integer.parseInt(etValTwo.getText().toString());

        result = first + second;
        tvText.setText(String.valueOf(result));

    }

    @OnClick(R.id.btnPress2)
    public void onViewClicked2() {
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra(RESULT_KEY, String.valueOf(result));
        startActivity(intent);
    }
}
