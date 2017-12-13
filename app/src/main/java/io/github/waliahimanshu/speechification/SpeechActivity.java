package io.github.waliahimanshu.speechification;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class SpeechActivity extends Activity implements RecognitionListener, View.OnClickListener {

    private EditText editText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_audio_recording);
        editText = (EditText) findViewById(R.id.editText2);
        findViewById(R.id.icon).setOnClickListener(this);
    }

    @Override
    public void onReadyForSpeech(Bundle params) {
        Log.e("Speech", "Ready");
    }

    @Override
    public void onBeginningOfSpeech() {
        Log.e("Speech", "Begin");
    }

    @Override
    public void onRmsChanged(float rmsdB) {
        Log.e("Speech", "Rms");
    }

    @Override
    public void onBufferReceived(byte[] buffer) {
        Log.e("Speech", "Buffer Received");
    }

    @Override
    public void onEndOfSpeech() {
        Log.e("Speech", "End");
    }

    @Override
    public void onError(int error) {
        Log.e("Speech", "Error");
    }

    @Override
    public void onResults(Bundle results) {
        Log.e("Speech", "Result");
        if (results != null) {
            Log.e("Speech", results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION).toString());
            ArrayList<String> result = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
            editText.setText(result.get(0));
        }
    }

    @Override
    public void onPartialResults(Bundle partialResults) {
        Log.e("Speech", "Partial Result");
        if (partialResults != null) {
            Log.e("Speech", partialResults.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION).toString());
            ArrayList<String> result = partialResults.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
            editText.setText(result.get(0));
        }
    }

    @Override
    public void onEvent(int eventType, Bundle params) {
        Log.e("Speech", "OnEvent");
    }

    @Override
    public void onClick(View v) {
        SpeechRecognizer speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "AndroidBite Voice Recognition...");
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, this.getPackageName());
        speechRecognizer.setRecognitionListener(this);
        speechRecognizer.startListening(intent);
    }
}