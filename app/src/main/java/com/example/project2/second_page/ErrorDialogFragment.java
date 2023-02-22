package com.example.project2.second_page;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.project2.R;

import kotlin.Function;


public class ErrorDialogFragment extends DialogFragment {
    final String answerToQuestion;
    final SecondActivity activity;
    public  ErrorDialogFragment(String answer, SecondActivity act){
        answerToQuestion = answer;
        activity = act;
    }

    private ImageView backImage;
    private LinearLayout answerLinear;
    private AppCompatButton tryAgainBtn;
    private AppCompatButton menuBtn;
    private TextView answerTxt;
    private LinearLayout showAnswerLinear;





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_error_dialog, container, false);
        init(view);
        return view;
    }

    void init(View view){
        backImage = view.findViewById(R.id.error_dialog_back);
        answerLinear = view.findViewById(R.id.answer_linear);
        menuBtn = view.findViewById(R.id.go_to_menu_btn);
        tryAgainBtn = view.findViewById(R.id.try_again);
        answerTxt = view.findViewById(R.id.answer_id_txt);
        showAnswerLinear = view.findViewById(R.id.show_answer_linear);


        answerTxt.setText("Ответ:"+answerToQuestion);

        answerLinear.setVisibility(View.GONE);

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMenu();
            }
        });

        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                goBack();
            }
        });

        showAnswerLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAnswer();
            }
        });

        tryAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tryAgain();
            }
        });
    }

    void tryAgain(){
        activity.tryAgain();
        this.dismiss();
    }

    void showAnswer(){
       answerLinear.setVisibility(View.VISIBLE);
        showAnswerLinear.setVisibility(View.GONE);

    }

    void goBack(){
        this.dismiss();
    }

    void goToMenu(){
        activity.finish();
        this.dismiss();
    }
}