package com.kadico.details.data.local



import androidx.room.TypeConverter
import com.kadico.details.domain.Category


class CategoryConverter {
    @TypeConverter
    fun fromCategory(category: Category): String = category.name

    @TypeConverter
    fun toCategory(categoryName: String): Category = Category.valueOf(categoryName)
}