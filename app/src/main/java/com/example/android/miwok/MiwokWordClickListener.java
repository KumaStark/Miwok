package com.example.android.miwok;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MiwokWordClickListener implements AdapterView.OnItemClickListener {

    private MediaPlayer mediaPlayer;
    private final Context mContext;
    private final String mClassName;
    private final String mActivityCategory;

    MiwokWordClickListener(Context packageContext, String currentClassName, String activityCategory) {
        mContext = packageContext;
        mClassName = currentClassName;
        mActivityCategory = activityCategory;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(mediaPlayer == null){
            mediaPlayer = new MediaPlayer();
        }
        if(mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        String defaultWord = (String)((TextView)view.findViewById(R.id.default_text)).getText();
        String pronounceFileName = MiwokWordContract.getPronounceFileName(mActivityCategory, defaultWord);
        mediaPlayer.reset();
        try{
            Log.i(mClassName,"Pronounce file name is " + pronounceFileName);
            AssetFileDescriptor afd = mContext.getAssets().openFd(pronounceFileName);
            mediaPlayer.setDataSource(afd);
            mediaPlayer.prepare();//TODO Try to use .prepareAsync()
            mediaPlayer.start();
        }catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(mContext, "file: " + pronounceFileName + " not found !",
                    Toast.LENGTH_SHORT).show();
        }
    }

    void releaseMediaPlayer(){
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
            Log.i(mClassName, mActivityCategory + "'s MediaPlayer Destroyed !");
        }
    }
}
