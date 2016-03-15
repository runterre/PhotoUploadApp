package com.apps.ron.application;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Ron on 3/13/2016.
 */
public class JSONParser {
    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";

    // constructor
    public JSONParser() {

    }

    public JSONObject getJSONFromUrl(String url) {
        OkHttpClient httpclient = new OkHttpClient();
        // Making HTTP request
        Request httppost = new Request.Builder().url(url).build();
        Response response = null;

        try {
            response = httpclient.newCall(httppost).execute();
            String jsonData = response.body().string();
            jObj = new JSONObject(jsonData);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException je) {
            je.printStackTrace();
        }
        return jObj;
    }
}
