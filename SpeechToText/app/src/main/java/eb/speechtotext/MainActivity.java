package eb.speechtotext;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import static android.app.Activity.RESULT_OK;

public class MainActivity extends AppCompatActivity implements RecognitionListener {

    private final int SPEECH_RECOGNITION_CODE = 1;

    private TextView txtOutput;
    private ImageButton btnMicrophone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtOutput = (TextView) findViewById(R.id.txt_output);
        btnMicrophone = (ImageButton) findViewById(R.id.btn_mic);

        btnMicrophone.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startSpeechToText();
            }
        });
    }

    private void startSpeechToText() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                "Speak something...");
        try {
            startActivityForResult(intent, SPEECH_RECOGNITION_CODE);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    "Sorry! Speech recognition is not supported in this device.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Callback for speech recognition activity
     * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case SPEECH_RECOGNITION_CODE: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String text = result.get(0);
                    txtOutput.setText(text);
                }
                break;
            }

        }
    }

    @Override
    public void onReadyForSpeech(Bundle bundle) {
        Log.v("RESULT","onReadyForSpeech");
    }

    @Override
    public void onBeginningOfSpeech() {
        Log.v("RESULT","onBeginningOfSpeech");
    }

    @Override
    public void onRmsChanged(float v) {
        Log.v("RESULT","onRmsChanged");
    }

    @Override
    public void onBufferReceived(byte[] bytes) {
        Log.v("RESULT","onBufferReceived");
    }

    @Override
    public void onEndOfSpeech() {
        Log.v("RESULT","onEndOfSpeech");
    }

    @Override
    public void onError(int i) {
        Log.v("RESULT","onError");
    }

    @Override
    public void onResults(Bundle bundle) {
        Log.v("RESULT","onResults");
    }

    @Override
    public void onPartialResults(Bundle bundle) {
        Log.v("RESULT","onPartialResults");
    }

    @Override
    public void onEvent(int i, Bundle bundle) {
        Log.v("RESULT","onEvent");
    }
}
