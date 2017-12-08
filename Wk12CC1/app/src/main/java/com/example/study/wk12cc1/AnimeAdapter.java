package com.example.study.wk12cc1;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by study on 30/11/17.
 */

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder> {

    private MainActivity.AnimeJsonData[] data;
    private static int viewHolderCount = 0;
    Context parentContext;

    //TODO 4.4 - Constructor
    //TODO 4.5 - onCreateViewHolder
    //TODO 4.7 - onBindViewHolder
    //TODO 4.8 - getItemCount
    AnimeAdapter(Context context, MainActivity.AnimeJsonData[] data) {
        this.data = data;
        this.parentContext = context;
    }
    @Override
    public AnimeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        int layoutIDForListItem = R.layout.recycler_item;
        LayoutInflater inflater = LayoutInflater.from(parentContext);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIDForListItem,parent,shouldAttachToParentImmediately);

        AnimeViewHolder animeViewHolder = new AnimeViewHolder(view);
        viewHolderCount++;
        Log.i("haha","oncreateViewHOlder");
        return animeViewHolder;
    }




    @Override
    public void onBindViewHolder(AnimeViewHolder holder, int position) {
        holder.bind(position);
        Log.i("haha","onBindViewHolder");
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class AnimeViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{
        TextView characterName;
        TextView itemNumber;
        ImageView picture;

        AnimeViewHolder(View v){
            super(v);
            picture = (ImageView) v.findViewById(R.id.item_image);
            characterName = (TextView) v.findViewById(R.id.item_text);
            itemNumber = (TextView) v.findViewById(R.id.item_count);
            //TODO 4.3 Invoke the superclass constructor
            // and get references to the various widgets in the List Item Layout
            v.setOnClickListener(this);
        }

        //TODO 4.6 - write a bind method to attach content
        //            to the respective widgets
        public void bind(int position){

            //TODO 4.6A - get the filename of the image
            String filename = data[position].file;

            String packageName = parentContext.getPackageName();
            String typeOfResource = "drawable";

            int resID = parentContext.getResources().getIdentifier(filename, typeOfResource, packageName);
            //TODO 4.6 B pass the resource ID to the image widget
            picture.setImageResource(resID);

            //TODO 4.6 C pass the character name to the characterName widget
            characterName.setText(data[position].name);

            //TODO 4.6 D display the position number
            itemNumber.setText(String.valueOf(position));

        }
        @Override
        public void onClick(View view) {
            int clickedPosition = getPosition();
            AlertDialog.Builder builder
                    = new AlertDialog.Builder(parentContext);
            String animeName = data[clickedPosition].anime;
            builder.setMessage("Anime:" + animeName);
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }

    }
}