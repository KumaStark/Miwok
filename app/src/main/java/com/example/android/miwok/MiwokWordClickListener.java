package com.example.android.miwok;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class MiwokWordClickListener implements AdapterView.OnItemClickListener {

    private MediaPlayer mediaPlayer;
    private final String pronounceFilePrefix;
    private final String pronounceFilesuffix;
    private final Context context;
    private final String className;
    private ArrayList<MiwokWord> wordsList;

    MiwokWordClickListener(Context packageContext, String currentClassName, ArrayList<MiwokWord> miwokWordsList, String prefix, String suffix) {
        context = packageContext;
        className = currentClassName;
        mediaPlayer = new MediaPlayer();
        pronounceFilePrefix = prefix;
        pronounceFilesuffix = suffix;
        wordsList = miwokWordsList;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
        String pronounceFileName = wordsList.get(position).getDefaultTranslation().replace(" ","_");
        pronounceFileName = pronounceFileName.replace(".","");
        pronounceFileName = pronounceFileName.replace(",","");
        pronounceFileName = pronounceFileName.replace("?","");
        pronounceFileName = pronounceFileName.replace("'","");
        pronounceFileName = pronounceFileName.toLowerCase();
        pronounceFileName = pronounceFilePrefix + pronounceFileName + pronounceFilesuffix;
        mediaPlayer.reset();
        try{
            Log.i(className,"Pronounce file name is " + pronounceFileName);
            AssetFileDescriptor afd = context.getAssets().openFd(pronounceFileName);
            mediaPlayer.setDataSource(afd);
            mediaPlayer.prepare();
            mediaPlayer.start();
            Log.i(className,"The afd is " + afd.toString());
        }catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context, "Pronounce file not found !", Toast.LENGTH_SHORT).show();
        }
    }
}
