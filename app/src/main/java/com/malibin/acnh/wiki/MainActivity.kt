package com.malibin.acnh.wiki

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.storage.FirebaseStorage
import java.io.File


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


        val toolTsvUrl =
            "https://firebasestorage.googleapis.com/v0/b/acnh-wiki-f8aa7.appspot.com/o/item%2Fcatalog_%EB%8F%84%EA%B5%AC.txt?alt=media&token=a74445ed-a291-48d0-97fd-b64da38a25f7"
        val toolFile = File.createTempFile("tool", "txt")

        FirebaseStorage.getInstance()
            .getReference("item/catalog_도구.txt")
            .getFile(toolFile)
            .addOnSuccessListener {
                toolFile.forEachLine { println(it) }
            }
            .addOnFailureListener {
                Log.d("Malibin Debug", TextUtils.join("\n", it.stackTrace))
            }

    }
}