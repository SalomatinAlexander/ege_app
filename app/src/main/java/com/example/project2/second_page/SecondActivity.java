package com.example.project2.second_page;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.project2.Core;
import com.example.project2.R;

public class SecondActivity extends AppCompatActivity {
    private int num;
    private TextView numberTxt;
    private TextView questionTxt;
    private TextView questionDescriptionTxt;
    private AppCompatButton checkAnswerBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        num = intent.getIntExtra("number", 1);
        initView();
    }

    void initView(){
        //Инициализируем переменные
        numberTxt = findViewById(R.id.number);
        questionTxt = findViewById(R.id.question);
        checkAnswerBtn = findViewById(R.id.check_answer);

        //Устанавливаем значения
        questionDescriptionTxt = findViewById(R.id.description);
        numberTxt.setText("Задание "+num);
        questionTxt.setText(Core.questions.get(num));
        questionDescriptionTxt.setText(Core.questionsDescription.get(num));

        //Устанавливаем прослушиватель на кнопку
        checkAnswerBtn.setOnClickListener(new View.OnClickListener() {
            //
            //
            @Override
            public void onClick(View view) {
                ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
                FragmentManager manager = getSupportFragmentManager();
                errorDialogFragment.show(manager, "error");
            }
        });
    }
}