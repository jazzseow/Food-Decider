package com.example.jazz.foocider.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jazz.foocider.Objects.Suggestion;
import com.example.jazz.foocider.R;
import com.example.jazz.foocider.Utils.SuggestionDBHandler;

public class AddReviewActivity extends AppCompatActivity {

    private EditText inputName;
    private SeekBar seekBar;
    private Button addButton;
    private TextView preference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_review);

        inputName = (EditText) findViewById(R.id.input_name);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        addButton = (Button) findViewById(R.id.add_button);
        preference = (TextView) findViewById(R.id.text_preference);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                preference.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = inputName.getText().toString().trim();
                double score = seekBar.getProgress();

                if (!name.isEmpty()){
                    SuggestionDBHandler suggestionDBHandler = new SuggestionDBHandler(AddReviewActivity.this);
                    suggestionDBHandler.addSuggestion(new Suggestion(name, null, 0, score));
                    AddReviewActivity.this.finish();
                }
                else{
                    Toast.makeText(AddReviewActivity.this,"Please enter name",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
