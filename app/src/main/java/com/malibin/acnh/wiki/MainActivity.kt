package com.malibin.acnh.wiki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.google.firebase.storage.FirebaseStorage
import java.io.File
import java.io.FileOutputStream
import java.lang.StringBuilder
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val urls = ArrayList<String>()

        FirebaseStorage.getInstance()
            .getReference()
            .child("villager/exterior")
            .listAll()
            .addOnSuccessListener {
                val totalSize = it.items.size
                for (item in it.items) {
                    item.downloadUrl.addOnSuccessListener {
                        urls.add(it.toString())
                        if (urls.size == totalSize) {
                            saveTextFileWithIndex(urls)
                        }
                    }
                }
            }
            .addOnFailureListener {
                println("Failed")
            }

//        val liveData1 = MutableLiveData<Int>()
//        val liveData2 = MutableLiveData<Int>()
//
//        val result = MediatorLiveData<Int>()
//
//        result.addSource(liveData1) {
//            result.setValue(it)
//        }
//        result.addSource(liveData2) {
//            result.value = it
//        }
//
//        result.observe(this, Observer {
//            Log.d("Malibin Debug", "Observing.... $it")
//        })
//
//        val worker1 = Thread {
//            for (i in 1..5) {
//                liveData1.value = i
//                Thread.sleep(1_000)
//            }
//        }
//        Handler().post(worker1)
//
//        val worker2 = Thread {
//            for (i in 10 downTo 6) {
//                liveData2.value = i
//                Thread.sleep(500)
//            }
//        }
//        Handler().post(worker2)


    }

    fun saveTextFileWithIndex(urls: List<String>) {
        val regex = "exterior_(.*)_"
        val pattern = Pattern.compile(regex)

        println(getExternalFilesDir(null)?.absolutePath)
        val file = File(getExternalFilesDir(null), "villager_exterior_urls.txt")
        val stream = FileOutputStream(file)
        val stringBuilder = StringBuilder()
        for (url in urls.sorted()) {
            val matcher = pattern.matcher(url)
            var index: Int? = null
            if (matcher.find()) {
                index = matcher.group(1).toInt()
            }
            stringBuilder.append(index).append(",").append(url).append("\n")
        }
        stream.write(stringBuilder.toString().toByteArray())
        stream.close()

        println(stringBuilder.toString())
    }

    fun saveTextFileWithStringIndex(urls: List<String>) {
        val regex = "reaction_(.*).png"
        val pattern = Pattern.compile(regex)
//t.com/o/fish%2Ficon%2Fic_fish_002_palechub.png?alt=media&token=8a8436b8-5f59-4fa7-b641-c4017d49058b
        println(getExternalFilesDir(null)?.absolutePath)
        val file = File(getExternalFilesDir(null), "reaction_urls.txt")
        val stream = FileOutputStream(file)
        val stringBuilder = StringBuilder()
        for (url in urls.sorted()) {
            val matcher = pattern.matcher(url)
            var stringIndex: String? = null
            if (matcher.find()) {
                stringIndex = matcher.group(1)
            }
            stringBuilder.append(stringIndex).append(",").append(url).append("\n")
        }
        stream.write(stringBuilder.toString().toByteArray())
        stream.close()

        println(stringBuilder.toString())
    }

    fun saveTextFile(urls: List<String>) {
        println(getExternalFilesDir(null)?.absolutePath)
        val file = File(getExternalFilesDir(null), "bug_detail_urls.txt")
        val stream = FileOutputStream(file)
        val stringBuilder = StringBuilder()
        for (url in urls.sorted()) {
            stringBuilder.append(url).append("\n")
        }
        stream.write(stringBuilder.toString().toByteArray())
        stream.close()

        println(stringBuilder.toString())
    }
}
