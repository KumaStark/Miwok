package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a new ArrayList object to contain MiwokWord object
        ArrayList<MiwokWord> wordsList = new ArrayList<>();

        // Add new MiwokWord object to wordsList
        wordsList.add(new MiwokWord("father","əpə"));
        wordsList.add(new MiwokWord("mother","əṭa"));
        wordsList.add(new MiwokWord("son","angsi"));
        wordsList.add(new MiwokWord("daughter","tune"));
        wordsList.add(new MiwokWord("older brother","taachi"));
        wordsList.add(new MiwokWord("younger brother","chalitti"));
        wordsList.add(new MiwokWord("older sister","teṭe"));
        wordsList.add(new MiwokWord("younger sister","kolliti"));
        wordsList.add(new MiwokWord("grandmother","ama"));
        wordsList.add(new MiwokWord("grandfather","paapa"));

        // Create custom ArrayAdapter to bundle with wordsList
        WordAdapter listViewAdapter = new WordAdapter(this, wordsList);

        // Find the listView to contain list items and set it's adapter
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(listViewAdapter);
    }
}
