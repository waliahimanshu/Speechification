package io.github.waliahimanshu.speechification;

import android.content.Context;
import android.media.MediaRecorder;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

public class RecordAudioHelper {

    final int SAMPLE_RATE = 44100; // The sampling rate
    private final Context mContext;
    boolean mShouldContinue; // Indicates if recording / playback should stop


    private String mFileName;
    private static final String LOG_TAG = AudioRecordingFragment.class.getSimpleName();
    private MediaRecorder mMediaRecorder;

    public RecordAudioHelper(Context context) {
        mContext = context;
    }


   public void recordAudio() {
       Toast.makeText(mContext, "Recording Started", Toast.LENGTH_SHORT).show();
        mFileName = Environment.getExternalStorageDirectory().getAbsolutePath() + "/audiorecordtest.3gp";

        // Create the recorder
        mMediaRecorder = new MediaRecorder();
        // Set the audio format and encoder
        mMediaRecorder.reset();
        mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        //                mMediaRecorder.setAudioSamplingRate(SAMPLE_RATE);
        mMediaRecorder.setOutputFile(mFileName);

        // Setup the output location
        // Start the recording
        try {
            mMediaRecorder.prepare();
            mMediaRecorder.start();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }

    }

    public void stopRecording() {
        mMediaRecorder.stop();
        mMediaRecorder.release();
        Toast.makeText(mContext, "Stop recording", Toast.LENGTH_SHORT).show();

    }
}
