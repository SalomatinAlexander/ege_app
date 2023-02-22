package com.example.project2.second_page;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project2.Core;
import com.example.project2.R;

import java.util.Objects;

import kotlin.Function;

public class SecondActivity extends AppCompatActivity {
    private int num;
    private TextView numberTxt;
    private TextView questionTxt;
    private TextView questionDescriptionTxt;
    private AppCompatButton checkAnswerBtn;
    private ImageView backImage;
    private EditText answerEdit;



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
        backImage = findViewById(R.id.second_activity_back);
        answerEdit = findViewById(R.id.answer);


        //Устанавливаем значения
        questionDescriptionTxt = findViewById(R.id.description);
        numberTxt.setText("Задание "+num);
        questionTxt.setText(Core.questions.get(num));
        questionDescriptionTxt.setText(Core.questionsDescription.get(num));

        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondActivity.super.onBackPressed();
            }
        });

        //Устанавливаем прослушиватель на кнопку
        checkAnswerBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(checkAnswer()){
                    RightAnswerDialog rightAnswerDialog = new RightAnswerDialog();
                    FragmentManager manager = getSupportFragmentManager();
                    rightAnswerDialog.show(manager, "right");
                }else{
                    ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment(
                            Core.answers.get(num), SecondActivity.this);
                    FragmentManager manager = getSupportFragmentManager();
                    errorDialogFragment.show(manager, "error");
                }

            }
        });
    }

    Boolean checkAnswer(){
        return Core.answers.get(num).equals(answerEdit.getText().toString());
    }

    void tryAgain(){
        answerEdit.setText("");
    }



}