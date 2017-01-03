package com.lionmobi.greendao.entry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * Created by ChenR on 2016/12/30.
 */
@Entity
public class PhoneNumber {

    @Id
    private Long _id;

    @NotNull
    private Integer number;
    private Integer phone_id;
    private Integer block_type;
    private Integer hide_type;

    @NotNull
    private Long update_time;
    private Long user_id;

    private String user_name;
    private String operators;
    private String country;
    private String provider;
    private String city;
    private String company;
    private Boolean indentitied;

    @Generated(hash = 1712205305)
    public PhoneNumber(Long _id, @NotNull Integer number, Integer phone_id, Integer block_type,
            Integer hide_type, @NotNull Long update_time, Long user_id, String user_name,
            String operators, String country, String provider, String city, String company,
            Boolean indentitied) {
        this._id = _id;
        this.number = number;
        this.phone_id = phone_id;
        this.block_type = block_type;
        this.hide_type = hide_type;
        this.update_time = update_time;
        this.user_id = user_id;
        this.user_name = user_name;
        this.operators = operators;
        this.country = country;
        this.provider = provider;
        this.city = city;
        this.company = company;
        this.indentitied = indentitied;
    }

    @Generated(hash = 857563609)
    public PhoneNumber() {
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPhone_id() {
        return phone_id;
    }

    public void setPhone_id(Integer phone_id) {
        this.phone_id = phone_id;
    }

    public Integer getBlock_type() {
        return block_type;
    }

    public void setBlock_type(Integer block_type) {
        this.block_type = block_type;
    }

    public Integer getHide_type() {
        return hide_type;
    }

    public void setHide_type(Integer hide_type) {
        this.hide_type = hide_type;
    }

    public Long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Long update_time) {
        this.update_time = update_time;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getOperators() {
        return operators;
    }

    public void setOperators(String operators) {
        this.operators = operators;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Boolean getIndentitied() {
        return indentitied;
    }

    public void setIndentitied(Boolean indentitied) {
        this.indentitied = indentitied;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "_id=" + _id +
                ", number=" + number +
                ", phone_id=" + phone_id +
                ", block_type=" + block_type +
                ", hide_type=" + hide_type +
                ", update_time=" + update_time +
                ", user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", operators='" + operators + '\'' +
                ", country='" + country + '\'' +
                ", provider='" + provider + '\'' +
                ", city='" + city + '\'' +
                ", company='" + company + '\'' +
                ", indentitied=" + indentitied +
                '}';
    }
}
