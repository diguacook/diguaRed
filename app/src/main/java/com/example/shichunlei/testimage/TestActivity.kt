package com.example.shichunlei.testimage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity(), View.OnClickListener {

    private val userName = "username"
    private val passWord = "password"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        tv_test.text = "lkaflnlweklnkwl"
        tv_test.setOnClickListener(this)
        bt_test.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_test ->
                    Toast.makeText(this,"1111",Toast.LENGTH_SHORT).show()
            R.id.bt_test ->
                Toast.makeText(this,"22222",Toast.LENGTH_SHORT).show()
        }
    }
}
