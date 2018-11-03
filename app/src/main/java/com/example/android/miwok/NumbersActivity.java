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
        wordsList.add(new MiwokWord("one","lutti",R.drawable.number_one));
        wordsList.add(new MiwokWord("two","otiiko",R.drawable.number_two));
        wordsList.add(new MiwokWord("three","tolookosu",R.drawable.number_three));
        wordsList.add(new MiwokWord("four","oyyisa",R.drawable.number_four));
        wordsList.add(new MiwokWord("five","massokka",R.drawable.number_five));
        wordsList.add(new MiwokWord("six","temmokka",R.drawable.number_six));
        wordsList.add(new MiwokWord("seven","kenekaku",R.drawable.number_seven));
        wordsList.add(new MiwokWord("eight","kawinta",R.drawable.number_eight));
        wordsList.add(new MiwokWord("nine","wo’e",R.drawable.number_nine));
        wordsList.add(new MiwokWord("ten","na’aacha",R.drawable.number_ten));
        // Create custom ArrayAdapter to bundle with wordsList
        WordAdapter listViewAdapter = new WordAdapter(this, wordsList);
        // Find the listView to contain list items and set it's adapter
        ListView listView = findViewById(R.id.list);
        listView.setBackgroundColor(getResources().getColor(R.color.category_numbers));
        listView.setAdapter(listViewAdapter);
    }
}
