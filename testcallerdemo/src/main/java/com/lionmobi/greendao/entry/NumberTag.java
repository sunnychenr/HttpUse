package com.lionmobi.greendao.entry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinProperty;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.List;
import org.greenrobot.greendao.DaoException;
import com.lionmobi.greendao.gen.DaoSession;
import com.lionmobi.greendao.gen.NumberTagDao;
import com.lionmobi.greendao.gen.TagInfoDao;
import com.lionmobi.greendao.gen.PhoneNumberDao;

/**
 * Created by ChenR on 2016/12/30.
 */
@Entity
public class NumberTag {

    @Id
    private Long _id;
    private Integer count;

    @NotNull
    private Long update_time;

    @ToOne (joinProperty = "_id")
    private TagInfo tagInfo;

    @ToOne (joinProperty = "_id")
    private PhoneNumber phoneNumber;
    @Generated(hash = 35348665)
    private transient Long phoneNumber__resolvedKey;
    @Generated(hash = 99971160)
    private transient Long tagInfo__resolvedKey;
    /** Used for active entity operations. */
    @Generated(hash = 1640245386)
    private transient NumberTagDao myDao;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    @Generated(hash = 1821221880)
    public NumberTag(Long _id, Integer count, @NotNull Long update_time) {
        this._id = _id;
        this.count = count;
        this.update_time = update_time;
    }
    @Generated(hash = 798567860)
    public NumberTag() {
    }
    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Long update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "NumberTag{" +
                "_id=" + _id +
                ", count=" + count +
                ", update_time=" + update_time +
                ", tagInfo=" + tagInfo +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 160046231)
    public void setPhoneNumber(PhoneNumber phoneNumber) {
        synchronized (this) {
            this.phoneNumber = phoneNumber;
            _id = phoneNumber == null ? null : phoneNumber.get_id();
            phoneNumber__resolvedKey = _id;
        }
    }
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1240734203)
    public PhoneNumber getPhoneNumber() {
        Long __key = this._id;
        if (phoneNumber__resolvedKey == null || !phoneNumber__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PhoneNumberDao targetDao = daoSession.getPhoneNumberDao();
            PhoneNumber phoneNumberNew = targetDao.load(__key);
            synchronized (this) {
                phoneNumber = phoneNumberNew;
                phoneNumber__resolvedKey = __key;
            }
        }
        return phoneNumber;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1504590693)
    public void setTagInfo(TagInfo tagInfo) {
        synchronized (this) {
            this.tagInfo = tagInfo;
            _id = tagInfo == null ? null : tagInfo.get_id();
            tagInfo__resolvedKey = _id;
        }
    }
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1305535925)
    public TagInfo getTagInfo() {
        Long __key = this._id;
        if (tagInfo__resolvedKey == null || !tagInfo__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TagInfoDao targetDao = daoSession.getTagInfoDao();
            TagInfo tagInfoNew = targetDao.load(__key);
            synchronized (this) {
                tagInfo = tagInfoNew;
                tagInfo__resolvedKey = __key;
            }
        }
        return tagInfo;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1711907351)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getNumberTagDao() : null;
    }
}
