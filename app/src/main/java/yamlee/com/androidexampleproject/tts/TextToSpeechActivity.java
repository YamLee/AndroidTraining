package yamlee.com.androidexampleproject.tts;

import android.app.Activity;
import android.os.Environment;
import android.speech.tts.TextToSpeech;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Locale;

import yamlee.com.androidexampleproject.R;

public class TextToSpeechActivity extends Activity {
    TextToSpeech mTextToSpeech;
    EditText etInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_speech);
        etInput = (EditText) findViewById(R.id.ed_input);
         mTextToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int supported = mTextToSpeech.setLanguage(Locale.CHINA);
                    if ((supported != TextToSpeech.LANG_AVAILABLE) && (supported != TextToSpeech.LANG_COUNTRY_AVAILABLE)) {
                        displayToast("不支持当前语言！");
                    }
                }
            }
        });


    }

    public void displayToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_text_to_speech, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onRead(View view) {

        HashMap myHashRender = new HashMap();
        String wakeUpText = "Are you up yet?";
        String destFileName = Environment.getExternalStorageDirectory()+"/wakeUp.wav";
        myHashRender.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, wakeUpText);
        mTextToSpeech.synthesizeToFile(etInput.getText().toString(), myHashRender, destFileName);

//        mTextToSpeech.speak(etInput.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
//        mTextToSpeech.speak(,)
    }
}
