package com.example.to_dolistandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseBooleanArray
//import android.view.View
import android.widget.ArrayAdapter
//import android.widget.ListView
import com.example.to_dolistandroidapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //var binding: ActivityMainBinding? = null
        var binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var itemlist = arrayListOf<String>()
        var adapter = ArrayAdapter(this,android.R.layout.simple_list_item_multiple_choice,itemlist)

        binding.add.setOnClickListener{
            itemlist.add(binding.editText.text.toString())
            binding.listView.adapter=adapter
            adapter.notifyDataSetChanged()
            binding.editText.text.clear()
        }

        binding.clear.setOnClickListener{
            itemlist.clear()
            adapter.notifyDataSetChanged()
        }

        binding.listView.setOnItemClickListener { adapterView, view, i, l ->
            android.widget.Toast.makeText(this, "You Selected the item --> "+ itemlist[i], android.widget.Toast.LENGTH_SHORT).show()
        }

        binding.delete.setOnClickListener{
            val position:SparseBooleanArray = binding.listView.checkedItemPositions
            val count =binding.listView.count
            var item=count -1
            while(item >= 0){
                if(position.get(item))
                {
                    adapter.remove(itemlist[item])
                }
                item--
            }
            position.clear()
            adapter.notifyDataSetChanged()

        }
    }
}
