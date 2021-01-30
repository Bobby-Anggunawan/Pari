package com.genm.pari.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Parcel
import android.os.Parcelable
import android.provider.BaseColumns
import com.genm.pari.database.User.DatabaseContract.NoteColumns.Companion.TABLE_NAME
import java.sql.SQLException

class User {
    data class user(
            var username: String? = null,
            var email: String? = null,
            var nama_asli: String? = null,
            var password: String? = null,
            var foto: String? = null,
            var is_nelayan: Int? = null
    ): Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readValue(Int::class.java.classLoader) as? Int) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(username)
            parcel.writeString(email)
            parcel.writeString(nama_asli)
            parcel.writeString(password)
            parcel.writeString(foto)
            parcel.writeValue(is_nelayan)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<user> {
            override fun createFromParcel(parcel: Parcel): user {
                return user(parcel)
            }

            override fun newArray(size: Int): Array<user?> {
                return arrayOfNulls(size)
            }
        }
    }

    //===============================================================================================

    internal class DatabaseContract {
        internal class NoteColumns : BaseColumns {
            companion object {
                const val TABLE_NAME = "user"
                const val _ID = "username"
                const val EMAIL = "email"
                const val NAMA = "nama"
                const val password = "password"
                const val foto = "foto"
                const val nelayan = "nelayan"
            }
        }
    }

    internal class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

        override fun onCreate(db: SQLiteDatabase) {
            db.execSQL(SQL_CREATE_TABLE_NOTE)
        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
            onCreate(db)
        }

        companion object {
            private const val DATABASE_NAME = "dbpari"
            private const val DATABASE_VERSION = 1
            private const val SQL_CREATE_TABLE_NOTE = "CREATE TABLE ${TABLE_NAME}" +
                    " (${DatabaseContract.NoteColumns._ID} TEXT PRIMARY KEY," +
                    " ${DatabaseContract.NoteColumns.EMAIL} TEXT NOT NULL," +
                    " ${DatabaseContract.NoteColumns.NAMA} TEXT NOT NULL," +
                    " ${DatabaseContract.NoteColumns.password} TEXT NOT NULL," +
                    " ${DatabaseContract.NoteColumns.foto} TEXT," +
                    " ${DatabaseContract.NoteColumns.nelayan} INT NOT NULL)"
        }
    }


    class NoteHelper(context: Context) {
        private var dataBaseHelper: DatabaseHelper = DatabaseHelper(context)
        private lateinit var database: SQLiteDatabase

        companion object {
            private const val DATABASE_TABLE = TABLE_NAME
            private var INSTANCE: NoteHelper? = null

            fun getInstance(context: Context): NoteHelper =
                    INSTANCE ?: synchronized(this) {
                        INSTANCE ?: NoteHelper(context)
                    }
        }

        @Throws(SQLException::class)
        fun open() {
            database = dataBaseHelper.writableDatabase
        }

        fun close() {
            dataBaseHelper.close()

            if (database.isOpen)
                database.close()
        }

        fun queryAll(): Cursor {
            return database.query(
                    DATABASE_TABLE,
                    null,
                    null,
                    null,
                    null,
                    null,
                    "${DatabaseContract.NoteColumns._ID} ASC",
                    null)
        }

        fun queryById(id: String): Cursor {
            return database.query(DATABASE_TABLE, null, "${DatabaseContract.NoteColumns._ID} = ?", arrayOf(id), null, null, null, null)
        }

        fun insert(values: ContentValues?): Long {
            return database.insert(DATABASE_TABLE, null, values)
        }

        fun update(id: String, values: ContentValues?): Int {
            return database.update(DATABASE_TABLE, values, "${DatabaseContract.NoteColumns._ID} = ?", arrayOf(id))
        }

        fun deleteById(id: String): Int {
            return database.delete(DATABASE_TABLE, "${DatabaseContract.NoteColumns._ID} = '$id'", null)
        }
    }

    //============================================================================================================================

    object MappingHelper {
        fun mapCursorToArrayList(notesCursor: Cursor?): ArrayList<user> {
            val notesList = ArrayList<user>()
            notesCursor?.apply {
                while (moveToNext()) {
                    val id = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns._ID))
                    val email = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.EMAIL))
                    val nama = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.NAMA))
                    val passwd = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.password))
                    val foto = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.foto))
                    val nelayan = getInt(getColumnIndexOrThrow(DatabaseContract.NoteColumns.nelayan))

                    notesList.add(user(id, email, nama, passwd, foto, nelayan))
                }
            }
            return notesList
        }
    }


}