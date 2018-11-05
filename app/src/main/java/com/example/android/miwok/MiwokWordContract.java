package com.example.android.miwok;

import java.util.ArrayList;

public class MiwokWordContract {
    public static final String IMIWOK_FILE_PREFIX = "_";
    public static final String IMIWOK_FILE_SUFFIX = ".mp3";
    public static final String INTENT_EXTRA_TITLE = "title";
    public static final String INTENT_EXTRA_CATEGORY = "category";
    public static final String INTENT_EXTRA_BACKGROUND_COLOR = "background_color";
    public static final int INTENT_TITLE_COLOR = R.string.category_colors;
    public static final int INTENT_TITLE_FAMILY = R.string.category_family;
    public static final int INTENT_TITLE_NUMBERS = R.string.category_numbers;
    public static final int INTENT_TITLE_PHRASES = R.string.category_phrases;
    public static final String INTENT_CATEGORY_COLOR = "color";
    public static final String INTENT_CATEGORY_FAMILY = "family";
    public static final String INTENT_CATEGORY_NUMBERS = "number";
    public static final String INTENT_CATEGORY_PHRASES = "phrase";
    private static final ArrayList<MiwokWord> WORD_LIST_COLOR = new ArrayList<>();
    private static final ArrayList<MiwokWord> WORD_LIST_FAMILY = new ArrayList<>();
    private static final ArrayList<MiwokWord> WORD_LIST_NUMBERS = new ArrayList<>();
    private static final ArrayList<MiwokWord> WORD_LIST_PHRASES = new ArrayList<>();

    public static String getPronounceFileName(String category, String defaultWord){
        String pronounceFileName = defaultWord;
        pronounceFileName = pronounceFileName.replace(" ","_");
        pronounceFileName = pronounceFileName.replace(".","");
        pronounceFileName = pronounceFileName.replace(",","");
        pronounceFileName = pronounceFileName.replace("?","");
        pronounceFileName = pronounceFileName.replace("’","");
        pronounceFileName = category + IMIWOK_FILE_PREFIX + pronounceFileName + IMIWOK_FILE_SUFFIX;
        pronounceFileName = pronounceFileName.toLowerCase();
        return pronounceFileName;
    }

    public static ArrayList<MiwokWord> getMiwokWordList(String category){
        switch(category){
            case INTENT_CATEGORY_COLOR:
                return WORD_LIST_COLOR;
            case INTENT_CATEGORY_FAMILY:
                return WORD_LIST_FAMILY;
            case INTENT_CATEGORY_NUMBERS:
                return WORD_LIST_NUMBERS;
            case INTENT_CATEGORY_PHRASES:
                return WORD_LIST_PHRASES;
            default:
                return null;
        }
    }

    public static void createMiwokWordList(){
        // Add new MiwokWord object to wordsList
        WORD_LIST_COLOR.add(new MiwokWord("red","weṭeṭṭi",R.drawable.color_red));
        WORD_LIST_COLOR.add(new MiwokWord("green","chokokki",R.drawable.color_green));
        WORD_LIST_COLOR.add(new MiwokWord("brown","ṭakaakki",R.drawable.color_brown));
        WORD_LIST_COLOR.add(new MiwokWord("gray","ṭopoppi",R.drawable.color_gray));
        WORD_LIST_COLOR.add(new MiwokWord("black","kululli",R.drawable.color_black));
        WORD_LIST_COLOR.add(new MiwokWord("white","kelelli",R.drawable.color_white));
        WORD_LIST_COLOR.add(new MiwokWord("dusty yellow","ṭopiisə",R.drawable.color_dusty_yellow));
        WORD_LIST_COLOR.add(new MiwokWord("mustard yellow","chiwiiṭə",R.drawable.color_mustard_yellow));
        //
        WORD_LIST_FAMILY.add(new MiwokWord("father","əpə",R.drawable.family_father ));
        WORD_LIST_FAMILY.add(new MiwokWord("mother","əṭa",R.drawable.family_mother));
        WORD_LIST_FAMILY.add(new MiwokWord("son","angsi",R.drawable.family_son));
        WORD_LIST_FAMILY.add(new MiwokWord("daughter","tune",R.drawable.family_daughter));
        WORD_LIST_FAMILY.add(new MiwokWord("older brother","taachi",R.drawable.family_older_brother));
        WORD_LIST_FAMILY.add(new MiwokWord("younger brother","chalitti",R.drawable.family_younger_brother));
        WORD_LIST_FAMILY.add(new MiwokWord("older sister","teṭe",R.drawable.family_older_sister));
        WORD_LIST_FAMILY.add(new MiwokWord("younger sister","kolliti",R.drawable.family_younger_sister));
        WORD_LIST_FAMILY.add(new MiwokWord("grandfather","paapa",R.drawable.family_grandfather));
        //
        WORD_LIST_NUMBERS.add(new MiwokWord("one","lutti",R.drawable.number_one));
        WORD_LIST_NUMBERS.add(new MiwokWord("two","otiiko",R.drawable.number_two));
        WORD_LIST_NUMBERS.add(new MiwokWord("three","tolookosu",R.drawable.number_three));
        WORD_LIST_NUMBERS.add(new MiwokWord("four","oyyisa",R.drawable.number_four));
        WORD_LIST_NUMBERS.add(new MiwokWord("five","massokka",R.drawable.number_five));
        WORD_LIST_NUMBERS.add(new MiwokWord("six","temmokka",R.drawable.number_six));
        WORD_LIST_NUMBERS.add(new MiwokWord("seven","kenekaku",R.drawable.number_seven));
        WORD_LIST_NUMBERS.add(new MiwokWord("eight","kawinta",R.drawable.number_eight));
        WORD_LIST_NUMBERS.add(new MiwokWord("nine","wo’e",R.drawable.number_nine));
        WORD_LIST_NUMBERS.add(new MiwokWord("ten","na’aacha",R.drawable.number_ten));
        //
        WORD_LIST_PHRASES.add(new MiwokWord("Where are you going?","minto wuksus"));
        WORD_LIST_PHRASES.add(new MiwokWord("What is your name?","tinnə oyaase'nə"));
        WORD_LIST_PHRASES.add(new MiwokWord("My name is...","oyaaset..."));
        WORD_LIST_PHRASES.add(new MiwokWord("How are you feeling?","michəksəs?"));
        WORD_LIST_PHRASES.add(new MiwokWord("I’m feeling good.","kuchi achit"));
        WORD_LIST_PHRASES.add(new MiwokWord("Are you coming?","əənəs'aa?"));
        WORD_LIST_PHRASES.add(new MiwokWord("Yes, I’m coming.","həə’ əənəm"));
        WORD_LIST_PHRASES.add(new MiwokWord("I’m coming.","əənəm"));
        WORD_LIST_PHRASES.add(new MiwokWord("Let’s go.","yoowutis"));
        WORD_LIST_PHRASES.add(new MiwokWord("Come here.","ənni'nem"));
    }
}
