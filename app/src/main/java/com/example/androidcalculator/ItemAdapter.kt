package com.example.androidcalculator

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcalculator.databinding.ItemPrevCalcBinding

//передаёт список прошлых мат операций
class ItemAdapter(private val historyLst: List<History>):RecyclerView.Adapter<ItemHolder>() {

    //отрисовываем элемент списка
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {

        val layoutInflater=LayoutInflater.from(parent.context)
        return ItemHolder(binding = ItemPrevCalcBinding.inflate(layoutInflater,parent,false))

    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        val history=historyLst[position]
        holder.bind(history)

    }

    override fun getItemCount(): Int {
        //вернули размер листа
        return historyLst.size
    }
}