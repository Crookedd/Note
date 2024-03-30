package com.example.note

import androidx.lifecycle.LiveData
import androidx.room.*

// annotation for dao class.
@Dao
interface NotesDao {
    // ниже приведен метод вставки для
// добавления новой записи в нашу базу данных
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)
    // приведенный ниже метод используется для обновления заметки.
    @Update
    suspend fun update(note: Note)
    // ниже приведен метод удаления
// для удаления нашей заметки.
    @Delete
    suspend fun delete(note: Note)
    // ниже приведен метод для чтения всех примечаний
// из нашей базы данных мы указали запрос для этого.
// внутри запроса мы упорядочиваем его по возрастанию
// порядок в строке ниже и указываем
// имя таблицы, из которой
// мы должны получить данные.
    @Query("Select * from notesTable order by id ASC")
    fun getAllNotes(): LiveData<List<Note>>
}