package com.example.android.miwok;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MiwokWordClickListener implements AdapterView.OnItemClickListener,
        AudioManager.OnAudioFocusChangeListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener {

    private final Context mContext;
    private final String mClassName;
    private final String mActivityCategory;
    // 设置和使用AudioManager所需对象及变量
    private MediaPlayer mMediaPlayer;
    private final AudioManager mAudioManager;
    private final AudioFocusRequest mFocusRequest;
    private boolean mPlaybackDelayed = false;   // 标记获取AudioFocus前是否被延迟
    private boolean mResumeOnFocusGain = false; // 标记获得AudioFocus时是否继续播放
    // 以下变量用于避免点击相同Miwok单词时，重复创建相同附件的AssetFileDescriptor对象
    private AssetFileDescriptor afd;
    // 以下变量用于检测是否点击了相同的Miwok单词
    private String previouslyWord = "";

    MiwokWordClickListener(Context packageContext, String currentClassName, String activityCategory) {
        mContext = packageContext;
        mClassName = currentClassName;
        mActivityCategory = activityCategory;
        /*
         * 获取系统的AudioManager服务
         */
        mAudioManager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
        /*
         * 创建音频属性AudioAttributes对象，随后用于创建系统音频FocusRequest对象
         */
        AudioAttributes mPlaybackAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                .build();
        /*
         * 创建系统音频FocusRequest对象，其中引入AudioAttributes对象，
         * 并指定OnAudioFocusChangeListener
         */
        mFocusRequest = new AudioFocusRequest.Builder(AudioManager.AUDIOFOCUS_GAIN_TRANSIENT)
                .setAudioAttributes(mPlaybackAttributes)
                .setAcceptsDelayedFocusGain(true)
                .setWillPauseWhenDucked(true)
                .setOnAudioFocusChangeListener(this)
                .build();
    }

    @Override
    public void onAudioFocusChange(int focusChange) {
        switch (focusChange) {
            case AudioManager.AUDIOFOCUS_GAIN:
                Toast.makeText(mContext, "AUDIOFOCUS_GAIN",
                        Toast.LENGTH_SHORT).show();
                if (mPlaybackDelayed || mResumeOnFocusGain) {
                    synchronized (this) {
                        mPlaybackDelayed = false;
                        mResumeOnFocusGain = false;
                    }
                    mMediaPlayer.start();
                }
                break;
            case AudioManager.AUDIOFOCUS_GAIN_TRANSIENT:
                Toast.makeText(mContext, "AUDIOFOCUS_GAIN_TRANSIENT",
                        Toast.LENGTH_SHORT).show();
                if (mPlaybackDelayed || mResumeOnFocusGain) {
                    synchronized (this) {
                        mPlaybackDelayed = false;
                        mResumeOnFocusGain = false;
                    }
                    mMediaPlayer.start();
                }
                break;
            case AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE:
                // 获得专有模式，系统提示音等均不会播放，用于语音备忘录或语音识别时使用
                Toast.makeText(mContext, "AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE",
                        Toast.LENGTH_SHORT).show();
                break;
            case AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK:
                // 其他播放音频已收到"可降低音量播放"的通知
                Toast.makeText(mContext, "AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK",
                        Toast.LENGTH_SHORT).show();
                break;
            case AudioManager.AUDIOFOCUS_LOSS:
                Toast.makeText(mContext, "AUDIOFOCUS_LOSS",
                        Toast.LENGTH_SHORT).show();
                synchronized (this) {
                    mPlaybackDelayed = false;
                    mResumeOnFocusGain = false;
                }
                mMediaPlayer.stop();
                mAudioManager.abandonAudioFocusRequest(mFocusRequest);
                break;
            case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                Toast.makeText(mContext, "AUDIOFOCUS_LOSS_TRANSIENT",
                        Toast.LENGTH_SHORT).show();
                synchronized (this) {
                    mPlaybackDelayed = false;
                    // 临时中断时，如果正在播放，则重新获得AudioFocus时继续播放（与上文AUDIOFOCUS_GAIN对应）
                    mResumeOnFocusGain = mMediaPlayer.isPlaying();
                }
                mMediaPlayer.pause();
                break;
            case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                Toast.makeText(mContext, "AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK",
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        Log.i(mClassName, "Media file prepared !");
        int res = mAudioManager.requestAudioFocus(mFocusRequest);
        synchronized (this) {
            switch(res){
                case AudioManager.AUDIOFOCUS_REQUEST_FAILED:
                    mPlaybackDelayed = false;
                    Toast.makeText(mContext, "AUDIOFOCUS_REQUEST_FAILED",
                            Toast.LENGTH_SHORT).show();
                    break;
                case AudioManager.AUDIOFOCUS_REQUEST_GRANTED:
                    mPlaybackDelayed = false;
                    mMediaPlayer.start();
                    Toast.makeText(mContext, "AUDIOFOCUS_REQUEST_GRANTED",
                            Toast.LENGTH_SHORT).show();
                    break;
                case AudioManager.AUDIOFOCUS_REQUEST_DELAYED:
                    mPlaybackDelayed = true;
                    Toast.makeText(mContext, "AUDIOFOCUS_REQUEST_DELAYED",
                            Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        mAudioManager.abandonAudioFocusRequest(mFocusRequest);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(mMediaPlayer == null){
            mMediaPlayer = new MediaPlayer();
            mMediaPlayer.setOnCompletionListener(this);
            mMediaPlayer.setOnPreparedListener(this);
        }
        if(mMediaPlayer.isPlaying()) {
            mMediaPlayer.stop();
        }

        String defaultWord = (String)((TextView)view.findViewById(R.id.default_text)).getText();
        String pronounceFileName = MiwokWordContract.getPronounceFileName(mActivityCategory, defaultWord);
        mMediaPlayer.reset();
        if(defaultWord.equals(previouslyWord)){
            try {
                Log.i(mClassName, "Using the previously Pronounce file : " + pronounceFileName);
                mMediaPlayer.setDataSource(afd);
                mMediaPlayer.prepareAsync();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(mContext, "Met error when using previously afd!",
                        Toast.LENGTH_SHORT).show();
            }
        }else{
            // 准备音频文件
            try {
                Log.i(mClassName, "Pronounce file name is " + pronounceFileName);
                afd = mContext.getAssets().openFd(pronounceFileName);
                mMediaPlayer.setDataSource(afd);
                mMediaPlayer.prepareAsync();
                previouslyWord = defaultWord;
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(mContext, "file: " + pronounceFileName + " not found !",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    void releaseMediaPlayer(){
        if(mMediaPlayer != null){
            mMediaPlayer.release();
            mMediaPlayer = null;
            Log.i(mClassName, mActivityCategory.toUpperCase() + "'s MediaPlayer Destroyed !");
        }
    }
}
