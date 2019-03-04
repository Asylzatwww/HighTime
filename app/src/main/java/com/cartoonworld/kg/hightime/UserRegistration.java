package com.cartoonworld.kg.hightime;

import android.os.AsyncTask;

/**
 * Created by User on 27.01.2019.
 */

public class UserRegistration extends AsyncTask<Void, Void, Void> {
    private String postUrl;
    private String apiUrl;
    public UserRegistration(String postUrl, String apiUrl){
        this.postUrl = postUrl;
        this.apiUrl = apiUrl;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... arg0) {
        HttpHandler sh = new HttpHandler();
        // Making a request to url and getting response

        String jsonStr = sh.makePostCall(postUrl, apiUrl);

        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);

    }

}
