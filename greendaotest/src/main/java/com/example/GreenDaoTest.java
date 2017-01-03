package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

public class GreenDaoTest {

    public static void main (String [] args) {
        Schema schema = new Schema(1, "com.lionmobi.greendao");

        Entity contact = schema.addEntity("PhoneNumber");
        Property.PropertyBuilder numberId = contact.addIdProperty();
        contact.addStringProperty("number").notNull();
        contact.addStringProperty("name");
        contact.addStringProperty("operator");
        contact.addStringProperty("country");
        contact.addStringProperty("provider");
        contact.addStringProperty("city");
        contact.addStringProperty("company");
        contact.addLongProperty("update_time");
        contact.addIntProperty("phone_id");
        contact.addIntProperty("block_type");
        contact.addBooleanProperty("indentified");

        Entity tagInfo = schema.addEntity("TagInfo");
        Property.PropertyBuilder tagId = tagInfo.addIdProperty();
        tagInfo.addStringProperty("code");
        tagInfo.addStringProperty("name");
        tagInfo.addStringProperty("desc");

        Entity numberTag = schema.addEntity("NumberTag");
        numberTag.addIdProperty();
        numberTag.addToOne(contact, numberId.getProperty());
        numberTag.addToOne(tagInfo, tagId.getProperty());
        numberTag.addIntProperty("count");
        numberTag.addLongProperty("update_time");

        try {
            new DaoGenerator().generateAll(schema, "E:\\My Work\\Android Project\\HttpUse\\testcallerdemo\\src\\main\\java");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
