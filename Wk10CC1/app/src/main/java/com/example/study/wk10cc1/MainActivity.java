package com.example.study.wk10cc1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    EditText editTextComicNo;
    ImageView imageViewComic;
    TextView textViewURL;
    TextView textViewJSON;

    //TO DO 2.2 assign these static variables to help you build the URL
    final String xkcd_BASE = "xkcd.com";
    final String xkcd_TAIL = "info.0.json";
    final String xkcd_SCHEME = "https";

    String imgUrlString;
    String comicJsonResultString = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextComicNo = (EditText)findViewById(R.id.comic_number);
        imageViewComic = (ImageView)findViewById(R.id.comic_placeholder);
        textViewURL = (TextView)findViewById(R.id.comic_url);
        textViewJSON = (TextView)findViewById(R.id.comic_json);

    }

    private URL buildURL(){
        URL xkcdURL = null;
        String comic_no = editTextComicNo.getText().toString();
        //TO DO 2.1  get the comic number from the editText widget
        //TO DO 2.1  (only if you are interested) write a Regex to ensure that the comic number is valid
        //TO DO 2.2  fill in the URL static variables above
        //TO DO 2.3  build the URL
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(xkcd_SCHEME).authority(xkcd_BASE).appendPath(comic_no).appendPath(xkcd_TAIL);
        Uri uri = builder.build();
        try{
            xkcdURL = new URL(uri.toString());
        }catch(Exception e){
            e.printStackTrace();
        }
        //TO DO 2.4  [within the android manifest] add the permissions to connect to the internet
        return xkcdURL;
    }

    private String getHttpURL(URL url){
        InputStream inputStream;
        String output = "";
        String line;
        try {
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();   //can get input stream straight away
            conn.setReadTimeout(10000 /*milliseconds */);
            conn.setConnectTimeout(15000 /*milliseconds */);
            //Start Query
            conn.connect();
            int response = conn.getResponseCode();
            Log.d("Mok", "The response is " + response);
            inputStream = conn.getInputStream();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(inputStream, "UTF-8")
            );
            while((line = reader.readLine()) != null ){
                output += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //TO DO 3.1 query the API with a URL
        return output;
    }


    protected void onClickGetComic(View view){

        URL url = buildURL();
        textViewURL.setText(url.toString());

        //istantiate the GetComicTask class and call the execute method
        GetComicTask getComicTask = new GetComicTask();
        getComicTask.execute(url);

        //TO DO 2 Build the query url method in BuildURL() and display the result in a widget

        //TO DO 3 Write the various steps in the GetComicTask inner class

        //TO DO 4.1 Determine if a network connection exists
        //TO DO 4.2 If a network connection exists then execute GetComicTask, else display an error message

    }

    public void parseJson(String jsonString){
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            imgUrlString = jsonObject.getString("img");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public class GetComicTask extends AsyncTask<URL, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(URL... urls) {
            URL url = urls[0];
            Bitmap xkcdPic = null;

            try{
                //TO DO 3.1 (see above) write getHttpURL();
                comicJsonResultString = getHttpURL(url);
                Log.i("Mok", comicJsonResultString);

                parseJson(comicJsonResultString);

                URL imageURL = new URL(imgUrlString);
                InputStream in = imageURL.openStream();
                xkcdPic = BitmapFactory.decodeStream(in);
                //TO DO 3.2 (see above) complete parseJson() method to extract the image URL
                //           and invoke it here
                //TO DO 3.3 (write code here) Download the image

            }catch(Exception e){
                //TO DO 3.1a do what helps you
            }

            return xkcdPic;
        }

        @Override
        protected void onPostExecute(Bitmap s) {

            //TO DO 3.1b (if you wish) display the JSON result in a text view widget for verification purpose

            //TO DO 3.5 Assign it to the text view widget
            imageViewComic.setImageBitmap(s);
        }
    }


}

//todo:check wifi
//    ConnectivityManager mgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//    NetworkInfo networkInfo = mgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
//connected = networkInfo != null && networkInfo.isConnected();


//todo:publish process
//private class DownloadFilesTask extends AsyncTask<URL, Integer, Long> {
//    protected Long doInBackground(URL... urls) {
//        int count = urls.length;
//        long totalSize = 0;
//        for (int i = 0; i < count; i++) {
//            totalSize += Downloader.downloadFile(urls[i]);
//            publishProgress((int) ((i / (float) count) * 100));
//            // Escape early if cancel() is called
//            if (isCancelled()) break;
//        }
//        return totalSize;
//    }
//
//    protected void onProgressUpdate(Integer... progress) {
//        setProgressPercent(progress[0]);
//    }
//
//    protected void onPostExecute(Long result) {
//        showDialog("Downloaded " + result + " bytes");
//    }
//}