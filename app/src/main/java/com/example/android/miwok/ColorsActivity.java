package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a new ArrayList object to contain MiwokWord object
        ArrayList<MiwokWord> wordsList = new ArrayList<>();

        // Add new MiwokWord object to wordsList
        wordsList.add(new MiwokWord("red","weṭeṭṭi"));
        wordsList.add(new MiwokWord("green","chokokki"));
        wordsList.add(new MiwokWord("brown","ṭakaakki"));
        wordsList.add(new MiwokWord("gray","ṭopoppi"));
        wordsList.add(new MiwokWord("black","kululli"));
        wordsList.add(new MiwokWord("white","kelelli"));
        wordsList.add(new MiwokWord("dusty yellow","ṭopiisə"));
        wordsList.add(new MiwokWord("mustard yellow","chiwiiṭə"));

        // Create custom ArrayAdapter to bundle with wordsList
        WordAdapter listViewAdapter = new WordAdapter(this, wordsList);

        // Find the listView to contain list items and set it's adapter
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(listViewAdapter);
    }
}
