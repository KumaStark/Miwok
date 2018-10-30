package com.example.android.miwok;

/**
 * {@link MiwokWord}提供用户需要学习词汇的相关翻译
 * 包含1个默认语言的单词及其对应的Miwok语言单词
 */

public class MiwokWord {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private String mImageResId;
    private String mPronounceResId;

    public MiwokWord(String dTranslation, String mTranslation){
        mDefaultTranslation = dTranslation;
        mMiwokTranslation = mTranslation;
    }

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }
}
