package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a new ArrayList object to contain MiwokWord object
        ArrayList<MiwokWord> wordsList = new ArrayList<>();

        // Add new MiwokWord object to wordsList
        wordsList.add(new MiwokWord("one","lutti"));
        wordsList.add(new MiwokWord("two","otiiko"));
        wordsList.add(new MiwokWord("three","tolookosu"));
        wordsList.add(new MiwokWord("four","oyyisa"));
        wordsList.add(new MiwokWord("five","massokka"));
        wordsList.add(new MiwokWord("six","temmokka"));
        wordsList.add(new MiwokWord("seven","kenekaku"));
        wordsList.add(new MiwokWord("eight","kawinta"));
        wordsList.add(new MiwokWord("nine","wo’e"));
        wordsList.add(new MiwokWord("ten","na’aacha"));

        // Create custom ArrayAdapter to bundle with wordsList
        WordAdapter listViewAdapter = new WordAdapter(this, wordsList);

        // Find the listView to contain list items and set it's adapter
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(listViewAdapter);
    }
}
