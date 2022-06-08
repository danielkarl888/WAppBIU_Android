package com.example.wappbiu_android;

import androidx.room.TypeConverter;

import com.example.wappbiu_android.entities.Contact;
import com.example.wappbiu_android.entities.Message;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class ContactConvertor {


    @TypeConverter
    public static List<Contact> stringToSomeObjectList(String data) {
        Gson gson = new Gson();
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Contact>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String someObjectListToString(List<Contact> someObjects) {
        Gson gson = new Gson();
        return gson.toJson(someObjects);
    }
}
