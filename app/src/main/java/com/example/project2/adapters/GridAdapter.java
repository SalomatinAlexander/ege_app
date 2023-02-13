package com.example.project2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.project2.Core;
import com.example.project2.R;

import java.util.List;


//Отвечает за работу GridView, задает элементы списка и их порядок
public class GridAdapter extends BaseAdapter {
    Context mContext;

    //Конструктор
    public GridAdapter(Context context){
        mContext = context;
    }



    //Метод создает View элементы которые пользователь видит на экране
    //NonNull означает, что метод не возвращает нулевые значения
    @NonNull
    //Override означает, что метод унаследован от родительского класса
    @Override
    public View getView(int position,
                        @Nullable View convertView, @NonNull ViewGroup parent) {
        View grid;
        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater)
                    mContext.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            //Находим xml файл элемента
            grid = inflater.inflate(R.layout.itemnew1, parent, false);
        } else {
            grid = (View) convertView;
        }
        //находим текст в элементе по его id
        TextView number = grid.findViewById(R.id.question_number);
        //устанавливаем текст, находим элемент в списке по позиции
            number.setText(Core.numbers.get(position));

        return grid;
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return Core.numbers.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    //Указываем сколько у нас элементов на экране
    @Override
    public int getCount() {
        return Core.numbers.size()-1;
    }
}
