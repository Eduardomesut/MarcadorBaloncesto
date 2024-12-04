package com.example.marcadorbaloncesto

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ScoreDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "scores.db"
        private const val DATABASE_VERSION = 1
        const val TABLE_NAME = "scores"
        const val COLUMN_ID = "id"
        const val COLUMN_QUARTER = "quarter"
        const val COLUMN_LOCAL_SCORE = "local_score"
        const val COLUMN_VISITOR_SCORE = "visitor_score"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = """
            CREATE TABLE $TABLE_NAME (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_QUARTER INTEGER,
                $COLUMN_LOCAL_SCORE INTEGER,
                $COLUMN_VISITOR_SCORE INTEGER
            )
        """.trimIndent()
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun saveScore(quarter: Int, localScore: Int, visitorScore: Int) {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_QUARTER, quarter)
            put(COLUMN_LOCAL_SCORE, localScore)
            put(COLUMN_VISITOR_SCORE, visitorScore)
        }
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun getScores(): List<Pair<Int, Pair<Int, Int>>> {
        val db = readableDatabase
        val scores = mutableListOf<Pair<Int, Pair<Int, Int>>>()
        val cursor = db.query(
            TABLE_NAME,
            arrayOf(COLUMN_QUARTER, COLUMN_LOCAL_SCORE, COLUMN_VISITOR_SCORE),
            null,
            null,
            null,
            null,
            "$COLUMN_QUARTER ASC"
        )
        while (cursor.moveToNext()) {
            val quarter = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_QUARTER))
            val localScore = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_LOCAL_SCORE))
            val visitorScore = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_VISITOR_SCORE))
            scores.add(quarter to (localScore to visitorScore))
        }
        cursor.close()
        db.close()
        return scores
    }
}
