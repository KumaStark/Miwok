package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    private static final String PRONOUNCE_FILE_PREFIX = "family_";
    private static final String PRONOUNCE_FILE_SUFFIX = ".mp3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        // Create a new ArrayList object to contain MiwokWord object
        ArrayList<MiwokWord> wordsList = new ArrayList<>();
        // Add new MiwokWord object to wordsList
        wordsList.add(new MiwokWord("father","əpə",R.drawable.family_father ));
        wordsList.add(new MiwokWord("mother","əṭa",R.drawable.family_mother));
        wordsList.add(new MiwokWord("son","angsi",R.drawable.family_son));
        wordsList.add(new MiwokWord("daughter","tune",R.drawable.family_daughter));
        wordsList.add(new MiwokWord("older brother","taachi",R.drawable.family_older_brother));
        wordsList.add(new MiwokWord("younger brother","chalitti",R.drawable.family_younger_brother));
        wordsList.add(new MiwokWord("older sister","teṭe",R.drawable.family_older_sister));
        wordsList.add(new MiwokWord("younger sister","kolliti",R.drawable.family_younger_sister));
        wordsList.add(new MiwokWord("grandfather","paapa",R.drawable.family_grandfather));
        wordsList.add(new MiwokWord("grandmother","ama",R.drawable.family_grandmother));
        // Create custom ArrayAdapter to bundle with wordsList
        MiwokWordAdapter listViewAdapter = new MiwokWordAdapter(this, wordsList);
        // Find the listView to contain list items and set it's adapter
        ListView listView = findViewById(R.id.list);
        listView.setBackgroundColor(getResources().getColor(R.color.category_family,null));
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(new MiwokWordClickListener(this, this.getLocalClassName(), wordsList, PRONOUNCE_FILE_PREFIX, PRONOUNCE_FILE_SUFFIX));
    }
}
