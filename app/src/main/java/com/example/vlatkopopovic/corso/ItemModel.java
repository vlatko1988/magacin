package com.example.vlatkopopovic.corso;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Vlatko Popovic on 3/2/2018.
 */
//MODEL
@Entity
public class ItemModel {

    @PrimaryKey(autoGenerate = true)
    private int id;
    //sifra artikla
    @ColumnInfo(name = "item_id")
    private int itemId;
    //naziv artikla
    @ColumnInfo(name = "item_name")
    private String itemName;
    //kolicina
    @ColumnInfo(name = "item_count")
    private int itemCount;
    //datum poslednje izmene
    @ColumnInfo(name = "item_date")
    private String itemDate;


    //Constructor
    public ItemModel(int itemId, String itemName, int itemCount, String itemDate) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemCount = itemCount;
        this.itemDate = itemDate;
    }

    //GETTERS AND SETTERS

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public String getItemDate() {
        return itemDate;
    }

    public void setItemDate(String itemDate) {
        this.itemDate = itemDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
