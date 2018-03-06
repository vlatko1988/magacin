package com.example.vlatkopopovic.corso;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Vlatko Popovic on 3/3/2018.
 */

@Database(entities = {ItemModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ItemDao itemDao();
}