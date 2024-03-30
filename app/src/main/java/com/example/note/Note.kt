package com.example.note

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// в строке ниже мы указываем название нашей таблицы
@Entity(tableName = "notesTable")
class Note(
    // в строке ниже мы указываем информацию о нашем столбце
// и внутри нее мы передаем название нашего столбца
    @ColumnInfo(name = "title")val noteTitle:String,
    @ColumnInfo(name = "description")val noteDescription:String,
    @ColumnInfo(name = "timestamp")val timeStamp: String
) {
    // в строке ниже мы указываем наш ключ и
// затем автоматически генерируем значение true и мы
// указываем его начальное значение как 0
    @PrimaryKey(autoGenerate = true)
    var id = 0
}