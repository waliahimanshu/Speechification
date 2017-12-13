package io.github.waliahimanshu.speechification;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

public class ExoPlayer {

    public void initExoPlayer(Context context) {

        // 1. Create a default TrackSelector
        Handler mainHandler = new Handler();
        DefaultRenderersFactory defaultRenderersFactory = new DefaultRenderersFactory(context, null,
                DefaultRenderersFactory.EXTENSION_RENDERER_MODE_OFF);

        TrackSelector trackSelector = new DefaultTrackSelector();

        // 2. Create the player
        SimpleExoPlayer player = ExoPlayerFactory.newSimpleInstance(defaultRenderersFactory, trackSelector);

        String userAgent = Util.getUserAgent(context, "Specification");// TODO: 03/12/2017

        Uri parse = Uri.parse(Environment.getExternalStorageDirectory().getAbsolutePath() + "/audiorecordtest.3gp");
        DefaultDataSourceFactory defaultDataSourceFactory = new DefaultDataSourceFactory(context, userAgent);

        ExtractorMediaSource extractorMediaSource = new ExtractorMediaSource(parse, defaultDataSourceFactory,
                new DefaultExtractorsFactory(), null, null);

        player.prepare(extractorMediaSource);
        player.setPlayWhenReady(true);

//        simpleExoplayerView.setPlayer(player);

    }
}
