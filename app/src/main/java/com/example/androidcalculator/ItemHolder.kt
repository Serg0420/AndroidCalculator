package com.example.androidcalculator

import androidx.recyclerview.widget.RecyclerView
import com.example.androidcalculator.databinding.ItemPrevCalcBinding

class ItemHolder(private val binding:ItemPrevCalcBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(history:History){
        //подвязываем текст к ячейке
        binding.txtPrevCalc.text= history.prevCalc
    }
}