package com.example.note

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room

@Database(entities = arrayOf(Note::class), version = 1, exportSchema = false)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun getNotesDao(): NotesDao
// Singleton предотвращает одновременное открытие нескольких экземпляров базы данных.
    companion object {
        @Volatile
        private var INSTANCE: NoteDatabase? =null
        fun getDatabase(context: Context): NoteDatabase {
             // если экземпляр не равен null, то верните его,
            // если это так, то создайте базу данных
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "note_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}