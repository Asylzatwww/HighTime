package com.cartoonworld.kg.hightime.level;

import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.cartoonworld.kg.hightime.R;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);


        String LINK = "http://htlife.biz/uploads/videos/levels/alphabet/letter-b/432a2122cd7fe4b85cb5335d4c4daccd.mp4";

        LINK = getIntent().getStringExtra("EXTRA_VIDEO_URL");

        VideoView videoView =(VideoView)findViewById(R.id.myVideo);
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri=Uri.parse(LINK);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();

        //videoView.start();


        RelativeLayout video_relative_layout = (RelativeLayout) findViewById( R.id.video_relative_layout );

        DisplayMetrics metrics = new DisplayMetrics(); getWindowManager().getDefaultDisplay().getMetrics(metrics);

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) videoView.getLayoutParams();
        params.width =  metrics.widthPixels;
        //params.height = metrics.heightPixels;
        params.leftMargin = 0;
        videoView.setLayoutParams(params);


        videoView.start();


        getWindow().getDecorView().setBackgroundColor(Color.BLACK);

    }
}
