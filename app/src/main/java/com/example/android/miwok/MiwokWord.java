package com.example.android.miwok;

/**
 * {@link MiwokWord}提供用户需要学习词汇的相关翻译
 * 包含1个默认语言的单词及其对应的Miwok语言单词
 */

class MiwokWord {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResId;

    MiwokWord(String dTranslation, String mTranslation, int imageResId){
        mDefaultTranslation = dTranslation;
        mMiwokTranslation = mTranslation;
        mImageResId = imageResId;
    }

    MiwokWord(String dTranslation, String mTranslation){
        mDefaultTranslation = dTranslation;
        mMiwokTranslation = mTranslation;
        mImageResId = 0;
    }

    String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    int getImageResId(){
        return mImageResId;
    }
}
