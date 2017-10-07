package com.example.jazz.foocider.Activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jazz.foocider.Objects.Suggestion;
import com.example.jazz.foocider.R;
import com.example.jazz.foocider.Utils.SuggestionAdapter;
import com.example.jazz.foocider.Utils.SuggestionDBHandler;

import java.util.List;

public class ViewOptionsActivity extends AppCompatActivity {

    private TextView noOption;
    private SuggestionAdapter adapter;
    private List<Suggestion> suggestionList;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_options);

        listView = (ListView) findViewById(R.id.list_options);

        FloatingActionButton addButton = (FloatingActionButton) findViewById(R.id.add_option);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddReviewActivity.class);
                startActivity(intent);
            }
        });
    }

    private void populateList() {

        SuggestionDBHandler dbHandler = new SuggestionDBHandler(getApplicationContext());
        suggestionList = dbHandler.getAllSuggestions();

        noOption = (TextView) findViewById(R.id.no_option);

        if (!suggestionList.isEmpty()) {
            Log.i("ViewOption", String.valueOf(suggestionList.size()));
            noOption.setVisibility(View.GONE);

            adapter = new SuggestionAdapter(this, R.layout.listitems_view_options, suggestionList);
            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        }
        else{
            noOption.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        populateList();
    }
}
