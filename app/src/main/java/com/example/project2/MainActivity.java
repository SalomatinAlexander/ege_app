package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.project2.adapters.GridAdapter;
import com.example.project2.second_page.SecondActivity;

public class MainActivity extends AppCompatActivity {
    private GridView taskGrid;
    private GridAdapter gridAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //привязываем xml файл к java классу
        setContentView(R.layout.activity_main);

        //Метод для работы с элементами верстки(xml)
        initView();
    }

    void initView() {
        taskGrid = findViewById(R.id.task_grid);
        //Создаем адаптер, передаем в конструкторе контекст
        gridAdapter = new GridAdapter(this);
        //привязываем адаптер к GridView
        taskGrid.setAdapter(gridAdapter);
        //Привязываем метод который отвечает за нажатие на элементы
        taskGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Переходим на экран с заданием
                Intent intent = new Intent(MainActivity.this,
                        SecondActivity.class);
                //передаем номер вопроса
                intent.putExtra("number", i+1);
                startActivity(intent);
            }
        });
    }
}