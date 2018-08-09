package com.example.android.miwok;

import android.app.Activity;
import android.media.Image;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId ){
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false
            );
        }

        // Get the word object located at this position in the list
        Word currentWord = getItem(position);

        //Find the TextView in the list_item.xml layout the ID version_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);

        //Get the Version Name from the current AndroidFlavor object and set this text on the v
        miwokTextView.setText(currentWord.getMiwokTranslation());

        //Find the TextView in the list_item.xml with the ID version_number
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        //Get the Version Number from the current AndroidFlavor object and set this on the
        defaultTextView.setText(currentWord.getDefaultTranslation());

        ImageView imageResourceId = (ImageView) listItemView.findViewById(R.id.imageResource);

        if(currentWord.hasImage()){
            imageResourceId.setImageResource(currentWord.getImageResourceId());
            imageResourceId.setVisibility(View.VISIBLE);

        }
else {
            imageResourceId.setVisibility(View.GONE);
        }

        //Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);

        //Find the color that the resoruce ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        //Set the background color of ghe text container View
        textContainer.setBackgroundColor(color);

        //Return the whole list item layout (containing 2 TextViews) so that
        return listItemView;

    }




}
