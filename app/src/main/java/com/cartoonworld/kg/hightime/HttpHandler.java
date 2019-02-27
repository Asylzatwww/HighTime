package com.cartoonworld.kg.hightime;


import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HttpHandler {

    private static final String TAG = HttpHandler.class.getSimpleName();

    public HttpHandler() {
    }

    public String makePostCall(String reqUrl, String siteUrl) {
        String response = null;


            InputStream DataInputStream = null;
            try {

                //Post parameters
                String PostParam = reqUrl;

                Log.e("Running HTTP ", PostParam);

                //Preparing
                URL url = new URL("http://apitest.htlife.biz/" + siteUrl);

                HttpURLConnection cc = (HttpURLConnection)
                        url.openConnection();
                //set timeout for reading InputStream
                cc.setReadTimeout(5000);
                // set timeout for connection
                cc.setConnectTimeout(5000);
                //set HTTP method to POST
                cc.setRequestMethod("POST");
                //set it to true as we are connecting for input
                cc.setDoInput(true);
                //opens the communication link
                cc.setRequestProperty("content-type", "application/json;  charset=utf-8");
                cc.connect();

                Writer writer = new BufferedWriter(new OutputStreamWriter(cc.getOutputStream(), "UTF-8"));
                writer.write(reqUrl);
                writer.close();

                //Getting HTTP response code
                int response2 = cc.getResponseCode();

                String errorResponse=cc.getResponseMessage();
                Log.e("Return HTTP Code ", String.valueOf(response2));
                Log.e("Return URL ", "http://apitest.htlife.biz/" + siteUrl);

                //if response code is 200 / OK then read Inputstream
                //HttpURLConnection.HTTP_OK is equal to 200
                if(response2 == HttpURLConnection.HTTP_OK) {
                    DataInputStream = cc.getInputStream();
                }

            } catch (Exception e) {
                Log.e("Error", "Error in GetData", e);
            }
        return response;
    }

    public String makeServiceCall(String reqUrl) {
        String response = null;
        try {
            URL url = new URL(reqUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());
            response = convertStreamToString(in);
        } catch (MalformedURLException e) {
            Log.e(TAG, "MalformedURLException: " + e.getMessage());
        } catch (ProtocolException e) {
            Log.e(TAG, "ProtocolException: " + e.getMessage());
        } catch (IOException e) {
            Log.e(TAG, "IOException: " + e.getMessage());
        } catch (Exception e) {
            Log.e(TAG, "Exception: " + e.getMessage());
        }
        return response;
    }


    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }
}