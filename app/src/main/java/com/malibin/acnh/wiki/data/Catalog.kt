package com.malibin.acnh.wiki.data

import androidx.room.Entity
import androidx.room.PrimaryKey

//interface Catalog {
//    val id: Int
//    val name: String
//}

@Entity
open class Catalog(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String
) {

    override fun toString(): String {
        return "Catalog(id=$id, name='$name')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Catalog

        if (id != other.id) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        return result
    }

}