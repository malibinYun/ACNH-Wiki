package com.malibin.acnh.wiki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            .child("bug/detail")
            .listAll()
            .addOnSuccessListener {
                val totalSize = it.items.size
                for (item in it.items) {
                    item.downloadUrl.addOnSuccessListener {
                        urls.add(it.toString())
                        if (urls.size == totalSize) {
                            saveTextFile(urls)
                        }
                    }
                }
            }
            .addOnFailureListener {
                println("Failed")
            }

    }

    fun saveTextFileWithIndex(urls: List<String>) {
        val regex = "villager_poster_(.*)_"
        val pattern = Pattern.compile(regex)

        println(getExternalFilesDir(null)?.absolutePath)
        val file = File(getExternalFilesDir(null), "villager_poster_urls.txt")
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
        val regex = "_(.*).png"
        val pattern = Pattern.compile(regex)
//t.com/o/fish%2Ficon%2Fic_fish_002_palechub.png?alt=media&token=8a8436b8-5f59-4fa7-b641-c4017d49058b
        println(getExternalFilesDir(null)?.absolutePath)
        val file = File(getExternalFilesDir(null), "fish_detail_urls.txt")
        val stream = FileOutputStream(file)
        val stringBuilder = StringBuilder()
        for (url in urls.sorted()) {
            val matcher = pattern.matcher(url)
            var stringIndex: String? = null
            if (matcher.find()) {
                stringIndex = matcher.group(1).split("_")[2]
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
