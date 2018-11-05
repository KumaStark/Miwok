package com.example.android.miwok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.android.miwok.MiwokWordContract.INTENT_EXTRA_BACKGROUND_COLOR;
import static com.example.android.miwok.MiwokWordContract.INTENT_EXTRA_CATEGORY;

public class MiwokActivity extends AppCompatActivity{

    private MiwokWordClickListener miwokWordClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        Intent i = getIntent();
        String activityCategory = i.getStringExtra(INTENT_EXTRA_CATEGORY);
        int activityBackgroundColorId = i.getIntExtra(INTENT_EXTRA_BACKGROUND_COLOR,
                R.color.default_background_color);
        // Find the listView to contain list items and set it's adapter
        ListView listView = findViewById(R.id.list);
        // Set Background color of Miwok Words List
        listView.setBackgroundColor(getResources().getColor(activityBackgroundColorId,null));
        // Get specific ArrayList Object of Miwok Words
        ArrayList<MiwokWord> wordsList = MiwokWordContract.getMiwokWordList(activityCategory);
        // Create custom ArrayAdapter to bundle with wordsList
        MiwokWordAdapter listViewAdapter = new MiwokWordAdapter(this, wordsList);
        // Set the ArrayAdapter for Miwok Words List
        listView.setAdapter(listViewAdapter);
        // Create onItemClickListener for ListView
        miwokWordClickListener= new MiwokWordClickListener(this,
                this.getLocalClassName(), activityCategory);
        listView.setOnItemClickListener(miwokWordClickListener);
    }

    @Override
    protected void onStop() {
        if(miwokWordClickListener != null){
            miwokWordClickListener.releaseMediaPlayer();
        }
        super.onStop();
    }
}
