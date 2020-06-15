package com.malibin.acnh.wiki

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        CoroutineScope(Dispatchers.IO).launch {
//            FurnitureRemoteDataSource(FirebaseStorage.getInstance())
//                .getItemsOf(ItemType.WALL_MOUNTEDS)
//        }

    }
}