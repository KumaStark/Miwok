package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<MiwokWord> {

    public WordAdapter(Activity content, ArrayList<MiwokWord> wordsList){
        super(content, 0, wordsList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the {@link MiwokWord} object located at this position in the list
        MiwokWord currentWord = getItem(position);

        // Check if the existing view is being reused, otherwise inflate the view
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Find specific TextView to set words
        TextView miwokTextView = (TextView) convertView.findViewById(R.id.miwok_text);
        TextView defaultTextView = (TextView) convertView.findViewById(R.id.default_text);

        // Set text of TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Return list item to ListView
        return convertView;
    }
}
