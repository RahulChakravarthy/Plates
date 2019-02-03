package com.enghack2018.Model.dataobject;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.enghack2018.Model.DataObject;

import java.io.Serializable;

@Entity(tableName = "PlateDO")
public class PlateDO extends DataObject implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private Long id;

    @ColumnInfo(name = "imageUrl")
    private String imageUrl;

    @ColumnInfo(name = "type")
    private String type;

    @ColumnInfo(name = "dollar")
    private String dollar;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "avgReviews")
    private String avgReviews;

    //Obligatory empty constructor
    public PlateDO(){}

    public PlateDO(String imageUrl, String type, String dollar, String description, String avgReviews){
        this.imageUrl = imageUrl;
        this.type = type;
        this.dollar = dollar;
        this.name = description;
        this.avgReviews = avgReviews;
    }

    public Long getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getType() {
        return type;
    }

    public String getDollar() {
        return dollar;
    }

    public String getName() {
        return name;
    }

    public String getAvgReviews() {
        return avgReviews;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDollar(String dollar) {
        this.dollar = dollar;
    }

    public void setAvgReviews(String avgReviews) {
        this.avgReviews = avgReviews;
    }
}
