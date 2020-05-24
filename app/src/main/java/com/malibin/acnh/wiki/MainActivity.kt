package com.malibin.acnh.wiki

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.malibin.acnh.wiki.data.source.remote.VillagersRemoteDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        CoroutineScope(Dispatchers.IO).launch {
//            val source = VillagersRemoteDataSource(FirebaseFirestore.getInstance())
//            val data = source.getAllVillagers()
//            data.forEach { Log.d("Malibin Debug", it.toString()) }
//        }

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