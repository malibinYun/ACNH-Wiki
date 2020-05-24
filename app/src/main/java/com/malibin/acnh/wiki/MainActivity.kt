package com.malibin.acnh.wiki

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.room.Room
import com.google.firebase.firestore.FirebaseFirestore
import com.malibin.acnh.wiki.data.AppDataBase
import com.malibin.acnh.wiki.data.Top
import com.malibin.acnh.wiki.data.source.remote.VillagerRemoteDataSource
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.log


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            val source = VillagerRemoteDataSource(FirebaseFirestore.getInstance())
            val data = source.getAllVillagers()
            data.forEach { Log.d("Malibin Debug", it.toString()) }
        }

//        val db = Room.databaseBuilder(this, AppDataBase::class.java, "database").build()
//
//        val topDao = db.topsDao()
//
//        val liveData = topDao.getTops()
//
//        liveData.observe(this, Observer {
//            Log.d("Malibin Debug", it.toString())
//        })
//
//        button.setOnClickListener {
//            val text = editText.text.toString()
//            CoroutineScope(Dispatchers.IO).launch {
//                topDao.insertTop(Top(0, "name", text))
//
//
//                Log.d("Malibin Debug", topDao.getTopsOfCatalog().toString())
//            }
//        }
//
//        button2.setOnClickListener {
//            CoroutineScope(Dispatchers.IO).launch {
//                topDao.deleteTops()
//            }
//        }

    }
}