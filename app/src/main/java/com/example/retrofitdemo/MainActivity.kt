package com.example.retrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        request()
    }

    private fun request() {

        //步骤4:创建Retrofit对象
        val retrofit = Retrofit.Builder()
            .baseUrl("http://fy.iciba.com/") // 设置 网络请求 Url
            .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
            .build()

        // 步骤5:创建 网络请求接口 的实例
        val request = retrofit.create(GetRequest_Interface::class.java)

        //对 发送请求 进行封装
        val call = request.call

        //步骤6:发送网络请求(异步)
        call.enqueue(object : Callback<Translation> {
            //请求成功时回调
            override fun onResponse(call: Call<Translation>, response: Response<Translation>) {
                // 步骤7：处理返回的数据结果
                response.body()?.show()
            }

            //请求失败时回调
            override fun onFailure(call: Call<Translation>, throwable: Throwable) {
                println("连接失败")
            }
        })
    }
}
