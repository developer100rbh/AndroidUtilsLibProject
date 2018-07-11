package com.bhaskar.utils;

import android.content.SharedPreferences;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by saurabh_jain on 10/11/16.
 */
public class SharedPrefUtil {

    /**
     * @param sp
     * @param key
     * @param value
     */
    public static void addString(SharedPreferences sp, String key, String value) {
        SharedPreferences.Editor ed = sp.edit();
        ed.putString(key, value);
        ed.apply();
    }

    public static String getString(SharedPreferences sp, String key, String defaultValue) {
        return sp.getString(key, defaultValue);
    }

    /**
     * @param sp
     * @param key
     * @param inputMap
     */
    public static void addHashMap(SharedPreferences sp, String key, Map<String, String> inputMap) {

        JSONObject jsonObject = new JSONObject(inputMap);
        String jsonString = jsonObject.toString();
        SharedPreferences.Editor ed = sp.edit();
        ed.putString(key, jsonString);
        ed.apply();
    }

    /**
     * @param sp
     * @param key
     * @return
     */
    public static Map<String, String> getHashMap(SharedPreferences sp, String key) {
        Map<String, String> outputMap = new HashMap<String, String>();

        String jsonString = sp.getString(key, (new JSONObject()).toString());
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Iterator<String> keysItr = jsonObject.keys();
        while (keysItr.hasNext()) {
            String k = keysItr.next();
            String v = null;
            try {
                v = (String) jsonObject.get(k);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            outputMap.put(k, v);
        }
        return outputMap;
    }

    /**
     * @param sp
     * @param key
     * @param defaultValue
     * @return
     */
    public static int getInt(SharedPreferences sp, String key, int defaultValue) {
        return sp.getInt(key, defaultValue);
    }

    /**
     * @param sp
     * @param key
     * @param value
     */
    public static void addInt(SharedPreferences sp, String key, int value) {
        SharedPreferences.Editor ed = sp.edit();
        ed.putInt(key, value);
        ed.apply();

    }

    /**
     * @param sp
     * @param key
     * @param defaultValue
     * @return
     */
    public static long getLong(SharedPreferences sp, String key, int defaultValue) {
        return sp.getLong(key, defaultValue);
    }

    /**
     * @param sp
     * @param key
     * @param value
     */
    public static void addLong(SharedPreferences sp, String key, int value) {
        SharedPreferences.Editor ed = sp.edit();
        ed.putLong(key, value);
        ed.apply();

    }

    /**
     * @param sp
     * @param key
     * @param value
     */
    public static void addBoolean(SharedPreferences sp, String key, boolean value) {
        SharedPreferences.Editor ed = sp.edit();
        ed.putBoolean(key, value);
        ed.apply();
    }

    /**
     * @param sp
     * @param key
     * @param defaultValue
     * @return
     */
    public static boolean getBoolean(SharedPreferences sp, String key, boolean defaultValue) {
        return sp.getBoolean(key, defaultValue);
    }

//    /**
//     * @param sp
//     * @param key
//     * @param object
//     * @param objectClass
//     */
//    public static void addObjectInGsonString(SharedPreferences sp, String key, Object object, Class objectClass) {
//        if (object != null) {
//            String gsonString = new GsonBuilder().create().toJson(object, objectClass);
//            SharedPreferences.Editor ed = sp.edit();
//            ed.putString(key, gsonString);
//            ed.apply();
//        }
//    }
//
//    /**
//     * @param sp
//     * @param key
//     * @param objectClass
//     * @param <T>
//     * @return
//     */
//    public static <T extends Object> T getObjectFromGsonString(SharedPreferences sp, String key, Class<T> objectClass) {
//
//        String gsonString = sp.getString(key, "");
//        if (TextUtils.isEmpty(gsonString)) {
//            return null;
//        } else {
//            return new GsonBuilder().create().fromJson(gsonString, objectClass);
//        }
//    }

    /**
     * @param sp
     */
    public static void clearSharedPreference(SharedPreferences sp) {
        sp.edit().clear().apply();
    }
}