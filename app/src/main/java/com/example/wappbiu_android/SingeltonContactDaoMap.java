package com.example.wappbiu_android;

import android.content.Context;

import com.example.wappbiu_android.daos.ContactDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingeltonContactDaoMap {
    private static SingeltonContactDaoMap instance = null;
    public Map<String, ContactDao> map;
    private SingeltonContactDaoMap() {
        map = new HashMap<>();
    }
    public static SingeltonContactDaoMap getInstance()
    {
        if (instance == null)
            instance = new SingeltonContactDaoMap();

        return instance;
    }
}
