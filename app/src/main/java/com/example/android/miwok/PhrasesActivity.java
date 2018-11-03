package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        // Create a new ArrayList object to contain MiwokWord object
        ArrayList<MiwokWord> wordsList = new ArrayList<>();
        // Add new MiwokWord object to wordsList
        wordsList.add(new MiwokWord("Where are you going?","minto wuksus",0));
        wordsList.add(new MiwokWord("What is your name?","tinnə oyaase'nə",0));
        wordsList.add(new MiwokWord("My name is...","oyaaset...",0));
        wordsList.add(new MiwokWord("How are you feeling?","michəksəs?",0));
        wordsList.add(new MiwokWord("I’m feeling good.","kuchi achit",0));
        wordsList.add(new MiwokWord("Are you coming?","əənəs'aa?",0));
        wordsList.add(new MiwokWord("Yes, I’m coming.","həə’ əənəm",0));
        wordsList.add(new MiwokWord("I’m coming.","əənəm",0));
        wordsList.add(new MiwokWord("Let’s go.","yoowutis",0));
        wordsList.add(new MiwokWord("Come here.","ənni'nem",0));
        // Create custom ArrayAdapter to bundle with wordsList
        WordAdapter listViewAdapter = new WordAdapter(this, wordsList);
        // Find the listView to contain list items and set it's adapter
        ListView listView = findViewById(R.id.list);
        listView.setBackgroundColor(getResources().getColor(R.color.category_phrases));
        listView.setAdapter(listViewAdapter);
    }
}
