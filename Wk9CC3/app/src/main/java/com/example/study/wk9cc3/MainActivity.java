package com.example.study.wk9cc3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.nfc.Tag;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
                          implements SharedPreferences.OnSharedPreferenceChangeListener {

    SharedPreferences sharedPref;
    EditText searchLocation;
    Button getMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TO DO 0.1 - set up by establishing references to the searchLocation widget and the getMapButton

        //** PART 3 - READING FROM SharedPreferences **
        // TO DO 3.1 - [create a Preference Fragment and embed it in SettingsActivity]
        // TO DO 3.2 - read from SharedPreferences
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPref.registerOnSharedPreferenceChangeListener(this);


        //get the key attribute specified in the preferences.xml file
        String chkBoxLargeFontKey = getString(R.string.chkBoxLargeFontKey);

        //1st argument: using this key, get the value stored in sharedPreferences
        //2nd argument: if there is no value stored, then the default value is false
        boolean isButtonLargeFont = sharedPref.getBoolean(chkBoxLargeFontKey,false);

        //TO DO - write a method that makes use of the setting to change whatever attribute you like
        changeSomeAttribute(isButtonLargeFont);

    }

// ** PART 1 - CALLBACK FOR GET MAP BUTTON **
// TO DO 1 - onClick() callback

    public void onClick(View v){

    //TO DO 1.1 - get the search location from the EditText widget
        searchLocation =(EditText) findViewById(R.id.location);
        String myLocation;
        myLocation =searchLocation.getText().toString();

    //TO DO 1.2 - build the Universal Resource Indicator (URI) that
        Uri.Builder builder =new Uri.Builder();
        builder.scheme("geo").opaquePart("0,0").appendQueryParameter("q", myLocation);
//        Toast.makeText(getApplicationContext(), builder.toString(), Toast.LENGTH_SHORT).show();

        Uri geoLocation =builder.build();

    //TO DO 1.3 - write the intent
        Intent intent =new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void onClickNavigate(View v) {
        final RadioGroup mode_rgroup = (RadioGroup) findViewById(R.id.mode);
        int selectedId = mode_rgroup.getCheckedRadioButtonId();
        RadioButton mode_rbtn = (RadioButton) findViewById(selectedId);
        String mode = mode_rbtn.getText().toString();
        String mode_uri="";
        switch (mode) {
            case "Bicycle":
                mode_uri = "b";
                break;
            case "Walk":
                mode_uri = "w";
                break;
            case "Driving":
                mode_uri = "d";
                break;
            default:
                mode_uri = "d";
        }
        searchLocation =(EditText) findViewById(R.id.location);
        String myLocation;
        myLocation =searchLocation.getText().toString();

        Uri gmmIntentUri = Uri.parse("google.navigation:q=" +myLocation +"&mode=" +mode_uri);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }


// *** PART 2 - CREATING A MENU ***
// TO DO 2.1 - [in res/menu folder], create an xml file defining your menu
// TO DO 2.2 - inflate your menu in onCreateOptionsMenu()
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

// TO DO 2.3 - [Create a new activity called SettingsActivity]
// TO DO 2.4 - create an intent in onOptionsItemSelected()
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id =item.getItemId();

        if(id ==R.id.settings) {
            Intent intent =new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        } else if(id ==R.id.help) {
            Toast.makeText(this, "no help page", Toast.LENGTH_SHORT).show();
        }
        return false;
    }


// ** PART 3 - READING FROM SharedPreferences **
    public void changeSomeAttribute(boolean boo) {
        getMap =(Button) findViewById(R.id.btn_getMap);
        if(boo ==true) {
            getMap.setTextSize(50);
        }
    }

// TO DO 3.3 onSharedPreferencesListener
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        if (key.equals(getString(R.string.chkBoxLargeFontKey))){

            //same code as above
            boolean checked = sharedPreferences.getBoolean(key,false);

            //REMINDER - write code for this method
            changeSomeAttribute(checked);

        }
    }


}
