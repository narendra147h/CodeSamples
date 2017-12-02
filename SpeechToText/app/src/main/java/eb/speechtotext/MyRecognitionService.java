package eb.speechtotext;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.speech.RecognitionService;
import android.speech.SpeechRecognizer;
import android.util.Log;

/**
 * Created by ubunto on 11/7/17.
 */

public class MyRecognitionService extends RecognitionService{


    public static String TAG = "MyRecognitionService";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG,": onCreate");

    }

    @Override
    protected void onStartListening(Intent recogniseIntent, Callback listener) {

        Log.e(TAG,": onStartListening");




    }

    @Override
    protected void onCancel(Callback listener) {

        Log.d(TAG,": onCancel");


    }

    @Override
    protected void onStopListening(Callback listener) {

        Log.d(TAG,": onStopListening");


    }


    //Handle intents coming from adbd
    //try without onReceive method for broadcast receiver

}
