package com.example.androidcalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcalculator.databinding.FragmentGUIBinding

class GUIFragment : Fragment() {

    private var _binding: FragmentGUIBinding? = null

    //избавляемся от null в байндинге
    private val binding: FragmentGUIBinding
        get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return FragmentGUIBinding.inflate(inflater, container, false)
            //получаем ссылку на binding
            .also { _binding = it }
            .root

    }

    //работаем с нашей View
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        val lstHistory = mutableListOf<History>()

        /*
        задаю слушатели для простых кнопок, которые просто добавляют символ к строке, мог сюда
        и остальное кинуть, но мне показалось так нагляднее будет
        */
        simpleButtonsInit()

        with(binding) {

            /*расставляем элементы списка, попутно кастомим список на
            горизонтальную прокрутку
            */
            lstView.layoutManager = LinearLayoutManager(
                requireContext(), RecyclerView.HORIZONTAL, false)

            //слушатель кнопки очистки
            btnClr.setOnClickListener { inputField.text.clear() }

            //слушатель кнопки удаления одного символа
            btnBackspace.setOnClickListener {

                val inputValue = inputField.text.toString()
                inputField.text.clear()

                if (inputValue.isNotEmpty()) {

                    inputField.append(inputValue.substring(0, inputValue.length - 1))

                }

            }

            //слушатель кнопки равно, выводит результат и добавляет его в историю
            btnEquals.setOnClickListener {

                val calc = RPNCalculation()
                val inputString: String = inputField.text.toString()

                if (inputString.isNotEmpty()) {

                    //вывожу ответ в поле с исходным мат выражением
                    inputField.append(" = " + calc.calculate(inputString, requireContext()))
                    //добаляю в список-историю получившееся мат выражение
                    lstHistory.add(0,History(inputField.text.toString()))
                    //кидаем список в адаптер
                    lstView.adapter = ItemAdapter(lstHistory)

                }

            }

        }

    }

    //очищаем _binding
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun simpleButtonsInit() {

        //не самый элегантный способ задать слушатели, сделал пока так
        with(binding) {

            btn0.setOnClickListener { binding.inputField.append("0") }

            btn1.setOnClickListener { binding.inputField.append("1") }

            btn2.setOnClickListener { binding.inputField.append("2") }

            btn3.setOnClickListener { binding.inputField.append("3") }

            btn4.setOnClickListener { binding.inputField.append("4") }

            btn5.setOnClickListener { binding.inputField.append("5") }

            btn6.setOnClickListener { binding.inputField.append("6") }

            btn7.setOnClickListener { binding.inputField.append("7") }

            btn8.setOnClickListener { binding.inputField.append("8") }

            btn9.setOnClickListener { binding.inputField.append("9") }

            btnOpen.setOnClickListener { binding.inputField.append("(") }

            btnClose.setOnClickListener { binding.inputField.append(")") }

            btnMultiply.setOnClickListener { binding.inputField.append("*") }

            btnDiv.setOnClickListener { binding.inputField.append("/") }

            btnDivRem.setOnClickListener { binding.inputField.append("%") }

            btnMinus.setOnClickListener { binding.inputField.append("-") }

            btnPlus.setOnClickListener { binding.inputField.append("+") }

        }

    }
}