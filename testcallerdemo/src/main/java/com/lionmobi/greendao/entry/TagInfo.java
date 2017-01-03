package com.lionmobi.greendao.entry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * Created by ChenR on 2016/12/30.
 */
@Entity
public class TagInfo {

    @Id
    private Long _id;
    @NotNull
    private Integer code;
    @NotNull
    private String name;

    private String desc;

    @Generated(hash = 2065824372)
    public TagInfo(Long _id, @NotNull Integer code, @NotNull String name,
            String desc) {
        this._id = _id;
        this.code = code;
        this.name = name;
        this.desc = desc;
    }

    @Generated(hash = 792670162)
    public TagInfo() {
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "TagInfo{" +
                "_id=" + _id +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
