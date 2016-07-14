package com.addie.newlife.net;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by di.bian on 2016/7/14.
 */
public class NetWorkTask extends AsyncTask<String ,Integer ,String > {

    private ProgressBar progressBar;
    private TextView textView;

    public NetWorkTask (ProgressBar bar,TextView text) {
        progressBar = bar;
        textView = text;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        textView.setText("开始了");
    }

    @Override
    protected String doInBackground(String... params) {
        String a = params[0];
        for (int i = 0; i < 10 ;i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(i);
        }
        return a;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        progressBar.setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        textView.setText(s);
    }


}
