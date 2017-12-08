package com.example.study.wk10cc2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SpendingDbHelper spendingDbHelper;
    private SQLiteDatabase spendingDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TO DO 3.1 Create a new instance of SpendingDbHelper
        spendingDbHelper = new SpendingDbHelper(this);
        //TO DO 3.2 Get an instance of the database that can be written to
        spendingDb = spendingDbHelper.getWritableDatabase();
    }

    public void onClickAddToDb(View view){

        //TO DO 3.3 Get instances of the edit text widgets and extract their contents
        EditText remark_txt =(EditText) findViewById(R.id.editTextRemarks);
        EditText amount_txt =(EditText) findViewById(R.id.editTextAmount);
        //TO DO 3.4 Store the contents into a ContentValues Object
        String amount = amount_txt.getText().toString();
        String remarks = remark_txt.getText().toString();

        ContentValues cv = new ContentValues();
        cv.put(SpendingContract.SpendingEntry.COL_AMOUNT, amount );
        cv.put(SpendingContract.SpendingEntry.COL_REMARKS, remarks);
        spendingDb.insert(SpendingContract.SpendingEntry.TABLE_NAME, null ,cv );
        //TO DO 3.5 Insert the ContentValues object into the database
        //TO DO 3.6 (Optional) Display a Toast Message
        Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();

    }

    public void onClickGetEntireDb(View view){

        //TO DO 3.7 Call the query or rawQuery method of the spendingDb object and
        //          store the result in a Cursor object
        Cursor cursor = spendingDb.rawQuery("SELECT * FROM " + SpendingContract.SpendingEntry.TABLE_NAME, null);

        // TO DO 3.8 Extract the data from the Cursor object and
        //          display it on the textView widget

        TextView textView =(TextView) findViewById(R.id.textViewEntireDatabase);

        String outstring = "";

        //Get the column index. The first one is done for you. Complete the rest.
        int indexRemarks = cursor.getColumnIndex(SpendingContract.SpendingEntry.COL_REMARKS);
        int indexAmount = cursor.getColumnIndex(SpendingContract.SpendingEntry.COL_AMOUNT);
        int indexID = cursor.getColumnIndex(SpendingContract.SpendingEntry._ID);

        while(cursor.moveToNext()){

            //Get the contents of the particular row in that column. The first one is done for you.
            String myRemarks = cursor.getString(indexRemarks);
            String myAmount = cursor.getString(indexAmount);
            String myID = cursor.getString(indexID);
            outstring += myID + " " + myRemarks + " " + myAmount + "\n";
            //format the output string and add it to outstring

        }

        textView.setText(outstring);
    }


    public void onClickDeleteFromDb(View view){
        EditText delete_txt =(EditText) findViewById(R.id.editTextID);
        String rowToDelete = delete_txt.getText().toString();

        try{
            spendingDb.delete(SpendingContract.SpendingEntry.TABLE_NAME, SpendingContract.SpendingEntry._ID + "= ?", new String[] {rowToDelete});
            //TO DO 3.9 Get an instance of the editText Widget
            //          and extract the contents
            //TO DO 3.10 Delete the entry

        }catch(Exception ex){
            ex.printStackTrace();
            //TO DO 3.11 Display a toast if an exception occurs
        }

    }
}
