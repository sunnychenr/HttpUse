package com.lionmobi.entry;

import android.support.annotation.NonNull;

/**
 * Created by ChenR on 2016/12/28.
 */

public class MyContacts {

    private String name;
    private String number;
    private String photoId;
    private String date;
    private String callType;
    private boolean isChecked;

    public MyContacts(String name, @NonNull String number) {
        this.name = name;
        this.number = number;
    }

    public MyContacts(String name, String number, String photoId, String date, String callType, boolean isChecked) {
        this.name = name;
        this.number = number;
        this.photoId = photoId;
        this.date = date;
        this.callType = callType;
        this.isChecked = isChecked;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}
