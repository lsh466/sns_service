package com.example.snivy.kotlin_example

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bt_login.setOnClickListener{

            var user_id = et_id.text.trim().toString()
            var user_pw = et_pw.text.trim().toString()
            if(user_id.isNullOrEmpty() || user_pw.isNullOrEmpty()){
                Toast.makeText(this, "ID와 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
            else{
                //여기서 로그인 후 다음화면 ㄱㄱ
            }
        }

        bt_register.setOnClickListener{
            val nextIntent = Intent(this, registerActivity::class.java)
            startActivity(nextIntent)
        }
    }
}
