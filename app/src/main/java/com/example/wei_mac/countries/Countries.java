package com.example.wei_mac.countries;

import android.app.Activity;
import android.util.Log;

import org.apache.http.util.EncodingUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;

/**
 * Created by wei-mac on 2017/7/25.
 */

public class Countries {

    private String[] countriesName,countriesShorthand,countriesCode;

    public Countries(Activity activity){
        String json;
        try {
            InputStream fin = activity.getResources().openRawResource(R.raw.countries);
            int length = fin.available();
            byte[] buffer = new byte[length];
            fin.read(buffer);
            String type = "UTF-8";
            json = EncodingUtils.getString(buffer, type);
            JSONObject jsonObject = new JSONObject(json);
            JSONArray countries = jsonObject.getJSONArray("countries");
            countriesName = new String[countries.length()];
            countriesShorthand = new String[countries.length()];
            countriesCode = new String[countries.length()];
            for (int i = 0 ; i < countries.length() ; i++){
                JSONArray arr = (JSONArray) countries.get(i);
                countriesName[i] = arr.getString(0);
                countriesShorthand[i] = arr.getString(1);
                countriesCode[i] = arr.getString(2);
            }
        }
        catch(Exception e) {
            Log.e("Countries", String.valueOf(e));
        }
    }

    public String[] getCountriesName(){
        return countriesName;
    }

    public String[] getCountriesShorthand(){
        return countriesShorthand;
    }

    public String[] getCountriesCode(){
        return countriesCode;
    }
}