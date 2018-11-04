package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MediaPlayerActivity extends AppCompatActivity implements View.OnClickListener {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);
        mediaPlayer = MediaPlayer.create(this, R.raw.sample_music);
        setOnClickListeners(this.findViewById(R.id.player_control));
    }

    private void setOnClickListeners(View view) {
        ViewGroup menulist = (ViewGroup) view;
        for (int i = 0; i < menulist.getChildCount(); i++) {
            View menuitem = menulist.getChildAt(i);
            menuitem.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button_play:
                Toast.makeText(this, "Play !", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
                break;
            case R.id.button_pause:
                Toast.makeText(this, "Pause !", Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
                break;
        }
    }
}
