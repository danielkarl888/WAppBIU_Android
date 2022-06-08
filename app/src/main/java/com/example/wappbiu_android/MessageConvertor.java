package com.example.wappbiu_android;

import androidx.room.TypeConverter;

import com.example.wappbiu_android.entities.Message;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MessageConvertor {


    @TypeConverter
    public static List<Message> stringToSomeObjectList(String data) {
        Gson gson = new Gson();
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Message>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String someObjectListToString(List<Message> someObjects) {
        Gson gson = new Gson();
        return gson.toJson(someObjects);
    }


}
