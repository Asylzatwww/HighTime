package com.cartoonworld.kg.hightime;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.cartoonworld.kg.hightime.test.GetCallListener;

/**
 * Created by User on 27.01.2019.
 */

public class GetCallClass extends AsyncTask<Void, Void, String> {

    private String url;
    private GetCallListener listener;

    public GetCallClass(Context context, String url){
        this.url = url;
        listener = (GetCallListener) context;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Void... arg0) {
        HttpHandler sh = new HttpHandler();
        // Making a request to url and getting response
        String jsonStr = sh.makeServiceCall(url);

        return jsonStr;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        listener.updateResult(result, url);
    }

}
