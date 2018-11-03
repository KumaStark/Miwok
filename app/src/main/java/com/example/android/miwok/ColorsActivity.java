package com.example.android.miwok;

import android.annotation.SuppressLint;
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
        wordsList.add(new MiwokWord("red","weṭeṭṭi",R.drawable.color_red));
        wordsList.add(new MiwokWord("green","chokokki",R.drawable.color_green));
        wordsList.add(new MiwokWord("brown","ṭakaakki",R.drawable.color_brown));
        wordsList.add(new MiwokWord("gray","ṭopoppi",R.drawable.color_gray));
        wordsList.add(new MiwokWord("black","kululli",R.drawable.color_black));
        wordsList.add(new MiwokWord("white","kelelli",R.drawable.color_white));
        wordsList.add(new MiwokWord("dusty yellow","ṭopiisə",R.drawable.color_dusty_yellow));
        wordsList.add(new MiwokWord("mustard yellow","chiwiiṭə",R.drawable.color_mustard_yellow));
        // Create custom ArrayAdapter to bundle with wordsList
        WordAdapter listViewAdapter = new WordAdapter(this, wordsList);
        // Find the listView to contain list items and set it's adapter
        ListView listView = findViewById(R.id.list);
        listView.setBackgroundColor(getResources().getColor(R.color.category_colors));
        listView.setAdapter(listViewAdapter);
    }
}
