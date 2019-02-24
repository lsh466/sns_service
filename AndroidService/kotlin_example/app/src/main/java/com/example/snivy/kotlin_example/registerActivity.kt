package com.example.snivy.kotlin_example

import android.app.DownloadManager
import android.app.VoiceInteractor
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.text.Editable
import android.text.TextWatcher
import android.view.ContextThemeWrapper
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_register.*

class registerActivity : AppCompatActivity() {

    val url = "http://snivy92.cafe24.com/sns_service/idConfirm.php"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
//#f20303  #1547fd #000000
        var id_op = 0
        ////////////아이디 중복확인

        et_id.addTextChangedListener(object : TextWatcher{

            //입력 끝났을 때
            override fun afterTextChanged(s: Editable?) {

            }
            //입력하기 전에
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            //타이핑 되는 텍스트에 변화가 있을 때
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                id_op = 0
                tv_idConfirm.setTextColor(Color.parseColor("#000000"))
                tv_idConfirm.text = "사용할 아이디를 입력해주세요."
            }
        })


        bt_idConfirm.setOnClickListener {
            var user_id = et_id.text.trim().toString()
            if (user_id.isNullOrEmpty()) {
                tv_idConfirm.setTextColor(Color.parseColor("#000000"))
                tv_idConfirm.text = "사용할 아이디를 입력해주세요."
            }
            else {

                val request = object : StringRequest(Request.Method.POST, url,
                        Response.Listener { response ->
                            if (response.equals("pass")) {
                                tv_idConfirm.setTextColor(Color.parseColor("#1547fd"))
                                tv_idConfirm.text = "사용가능한 아이디입니다."
                                id_op = 1
                            } else {
                                tv_idConfirm.setTextColor(Color.parseColor("#f20303"))
                                tv_idConfirm.text = "이미 존재하는 아이디입니다."
                            }
                        }, Response.ErrorListener {

                }) {
                    // request시 key, value 보낼 때
                    override fun getParams(): Map<String, String> {
                        val params = HashMap<String, String>()
                        params["id"] = et_id.text.trim().toString()
                        return params
                    }
                }
                val queue = Volley.newRequestQueue(this)
                queue.add(request)
            }
        }



        ////////////가입 확인
        bt_confirm.setOnClickListener{

            var user_id = et_id.text.trim().toString()
            var user_pw1 = et_pw1.text.trim().toString()
            var user_pw2 = et_pw2.text.trim().toString()
            var user_email = et_email.text.trim().toString()

            if(user_id.isNullOrEmpty() || user_pw1.isNullOrEmpty() || user_pw2.isNullOrEmpty()
                    || user_email.isNullOrEmpty()){
                //다이얼로그
                val alert1 = AlertDialog.Builder(this)
                alert1.setTitle("에러")
                alert1.setMessage("모든 항목을 입력해주세요.")
                alert1.setPositiveButton("닫기"){_,_ ->

                }

                val dialog1: AlertDialog = alert1.create()
                dialog1.show()
            }
            else if(!user_pw1.equals(user_pw2)){
                val alert2 = AlertDialog.Builder(this)
                alert2.setTitle("에러")
                alert2.setMessage("비밀번호를 다시 확인해주세요.")
                alert2.setPositiveButton("닫기"){_,_ ->

                }

                val dialog2: AlertDialog = alert2.create()
                dialog2.show()
            }
            else if(id_op == 0){
                val alert3 = AlertDialog.Builder(this)
                alert3.setTitle("에러")
                alert3.setMessage("ID중복 확인을 해주세요.")
                alert3.setPositiveButton("닫기"){_,_ ->

                }
                val dialog3: AlertDialog = alert3.create()
                dialog3.show()
            }
            else{
                //...회원 가입 완료!
                finish()
            }
        }
    }
}
