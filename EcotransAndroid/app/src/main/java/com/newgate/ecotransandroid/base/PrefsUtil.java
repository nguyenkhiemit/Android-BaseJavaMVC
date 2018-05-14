package com.newgate.ecotransandroid.base;

/**
 * Created by Khiem on 12/6/2016.
 */
import android.content.Context;
import android.content.SharedPreferences;

public class PrefsUtil {
    public static final String DATE_SELECT = "date_select";

    private final SharedPreferences sharedPreferences;
    private final SharedPreferences.Editor editor;

    private static PrefsUtil instance;
    private Context mContext;

    public static PrefsUtil getInstance(Context mContext) {
        if(instance == null) {
            instance = new PrefsUtil(mContext);
        }
        return instance;
    }

    public PrefsUtil(Context mContext) {
        this.mContext = mContext;
        String prefsFile = mContext.getPackageName();
        sharedPreferences = mContext.getSharedPreferences(prefsFile, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void delete(String key) {
        if(sharedPreferences.contains(key)) {
            editor.remove(key).commit();
        }
    }

    public void savePref(String key, Object value) {
        delete(key);
        if(value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if(value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if(value instanceof Float) {
            editor.putFloat(key, (Float) value);
        } else if(value instanceof Long) {
            editor.putLong(key, (Long) value);
        } else if(value instanceof String) {
            editor.putString(key, (String) value);
        } else if(value != null) {
            throw new RuntimeException();
        }
        editor.commit();
    }

    public <T> T getPref(String key) {
        return (T) sharedPreferences.getAll().get(key);
    }

    public <T> T getPref(String key, T defValue) {
        T returnValue = (T) sharedPreferences.getAll().get(key);
        return (returnValue == null ? defValue : returnValue);
    }

    public boolean checkPrefExits(String key) {
        return sharedPreferences.contains(key);
    }
}
