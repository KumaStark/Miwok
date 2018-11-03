package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<MiwokWord> {

    private class ViewHolder {
        TextView tvMiwok;
        TextView tvDefault;
        ImageView ivTextIcon;
    }

    WordAdapter(Activity content, ArrayList<MiwokWord> wordsList){
        super(content, 0, wordsList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the {@link MiwokWord} object located at this position in the list
        MiwokWord currentWord = getItem(position);
        ViewHolder viewHolder;
        // Check if the existing view is being reused, otherwise inflate the view
        if(convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
            // Find specific TextView to set words
            viewHolder.tvMiwok =  convertView.findViewById(R.id.miwok_text);
            viewHolder.tvDefault = convertView.findViewById(R.id.default_text);
            viewHolder.ivTextIcon = convertView.findViewById(R.id.icon_text);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Set text of TextView & ImageView
        if(currentWord == null) {
            currentWord = new MiwokWord("Oops","Stub !");
        }
        viewHolder.tvMiwok.setText(currentWord.getMiwokTranslation());
        viewHolder.tvDefault.setText(currentWord.getDefaultTranslation());
        viewHolder.ivTextIcon.setImageResource(currentWord.getImageResId());
        // Return list item to ListView
        return convertView;
    }
}
