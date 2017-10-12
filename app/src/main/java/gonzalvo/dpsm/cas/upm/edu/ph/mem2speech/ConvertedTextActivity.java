package gonzalvo.dpsm.cas.upm.edu.ph.mem2speech;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConvertedTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converted_text);

        Intent intent = getIntent();
        final String recognizedText = intent.getStringExtra(ToText.EXTRA_RECOGNIZED_TEXT);

        final TextView textView =  (TextView) findViewById(R.id.converted_text);
        textView.setText(recognizedText);

        Button toSpeechButton = (Button) findViewById(R.id.button_toSpeech);
        toSpeechButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ToSpeech(ConvertedTextActivity.this).execute(textView.getText().toString());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.converted_text_menu, menu);
        return true;
    }
}
