package com.example.vlatkopopovic.corso;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Vlatko Popovic on 3/3/2018.
 */
@Dao
public interface ItemDao {

    @Query("SELECT * FROM ItemModel")
    List<ItemModel> getAll();
/*
    @Query("SELECT * FROM ItemModel WHERE uid IN (:itemId)")
    List<ItemModel> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM ItemModel WHERE first_name LIKE :first AND "
            + "last_name LIKE :last LIMIT 1")
    ItemModel findByName(String first, String last);*/

    @Insert
    void insertAll(ItemModel... items);

    @Delete
    void delete(ItemModel item);



}
