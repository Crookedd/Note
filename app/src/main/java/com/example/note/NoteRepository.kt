package com.example.note

import androidx.lifecycle.LiveData

class NoteRepository(private val notesDao: NotesDao) {
    // в строке ниже мы создаем переменную для нашего списка
// и мы получаем все заметки из нашего класса DAO.
    val allNotes: LiveData<List<Note>> = notesDao.getAllNotes()

    suspend fun insert(note: Note) {
        notesDao.insert(note)
    }

    suspend fun delete(note: Note) {
        notesDao.delete(note)
    }

    suspend fun update(note: Note) {
        notesDao.update(note)
    }
}