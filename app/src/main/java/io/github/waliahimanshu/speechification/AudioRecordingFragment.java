package io.github.waliahimanshu.speechification;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AudioRecordingFragment extends Fragment {
    @BindView(R.id.listening) TextView listening;
    @BindView(R.id.stop_button) Button stopRecordingButton;

    boolean mStartRecording = true;
    private RecordAudioHelper mRecordAudioHelper;

    public AudioRecordingFragment() {
        // Required empty public constructor
    }

    @SuppressLint("SetTextI18n")
    @OnClick(R.id.stop_button)
    public void onStopRecording() {
        mRecordAudioHelper.stopRecording();
        listening.setText("Recording stopped");
        startActivity(HomeActivity.getIntent(getContext()));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRecordAudioHelper = new RecordAudioHelper(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_audio_recording, container, false);
        ButterKnife.bind(view);
        return view;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onResume() {
        super.onResume();
        mRecordAudioHelper.recordAudio();
    }
}
