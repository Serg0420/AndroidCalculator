package com.example.androidcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


/*
Исползую алгоритм обратной польской нотации (RPN), нашёл его на Вики,
и пару примеров реализации на GitHub, это то что получилось у меня.
Тут не предусмотрен ввод десятичных чисел и отрицательных чисел вида -2*3,
но (0-2)*3 работать будет
*/

/*
Добавил ещё историю в виде списка прошлых мат операций, сделал старым способом, в будущем попробую
через ListAdapter сделать
*/

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        //компонент, содержащий список всех врагментов на activity
        supportFragmentManager
            .beginTransaction()
            //ради одной строки binding не вводил, использую его в GUIFragment
            //добавляем наш фрагмент
            .add(R.id.g_u_i_container, GUIFragment())
            .commit()

    }
}