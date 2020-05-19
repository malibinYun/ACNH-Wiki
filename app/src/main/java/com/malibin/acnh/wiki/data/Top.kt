package com.malibin.acnh.wiki.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class Top(
    id: Int,
    name: String,

    @ColumnInfo(name = "style")
    val style: String

) : Catalog(id, name) {

    override fun toString(): String {
        return "Top(id=$id, name='$name',style='$style')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if (!super.equals(other)) return false

        other as Top

        if (style != other.style) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + style.hashCode()
        return result
    }
}
