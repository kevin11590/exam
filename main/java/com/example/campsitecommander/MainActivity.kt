package com.example.campsitecommander

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    companion object{
        val itemArray = ArrayList<String>(listOf("Tent", "Marshmallow", "Flashlight"))
        val categoryArray = ArrayList<String>(listOf("Shelter", "Food", "Lighting"))
        val quantityArray = ArrayList<String>(listOf("1", "2", "1"))
        val commentsArray = ArrayList<String>(listOf("4-person tent", "Bag of 50", "LED"))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        
        val edtItem = findViewById<EditText>(R.id.edtItem)
        val edtCategory = findViewById<EditText>(R.id.edtCategory)
        val edtQuantity = findViewById<EditText>(R.id.edtQuantity)
        val edtComments = findViewById<EditText>(R.id.edtComments)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSecond = findViewById<Button>(R.id.btnSecond)
        val btnExit = findViewById<Button>(R.id.btnExit)

        btnAdd.setOnClickListener {
            val item = edtItem.text.toString()
            val category = edtCategory.text.toString()
            val quantity = edtQuantity.text.toString()
            val comments = edtComments.text.toString()

            if (item.isEmpty() || category.isEmpty() || quantity.isEmpty() || comments.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                Log.e("INPUT_ERROR", "Empty fields detected")
            } else {
                try {
                    quantity.toInt() // Validate numeric input
                    
                    itemArray.add(item)
                    categoryArray.add(category)
                    quantityArray.add(quantity)
                    commentsArray.add(comments)

                    Toast.makeText(this, "Item Added Successfully", Toast.LENGTH_SHORT).show()
                    Log.d("PACKING_APP", "Item Added: $item")
                    
                    edtItem.text.clear()
                    edtCategory.text.clear()
                    edtQuantity.text.clear()
                    edtComments.text.clear()
                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Quantity must be a number", Toast.LENGTH_SHORT).show()
                    Log.e("INPUT_ERROR", "Invalid quantity")
                }
            }
        }
        
        btnSecond.setOnClickListener {
            val intent = Intent(this, SecondActivity2::class.java)
            startActivity(intent)
        }

        btnExit.setOnClickListener{
            finishAffinity()
        }
    }
}