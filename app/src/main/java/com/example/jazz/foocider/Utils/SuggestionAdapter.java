package com.example.jazz.foocider.Utils;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.jazz.foocider.Objects.Suggestion;

import java.util.List;

/**
 * Created by jazz on 12/9/17.
 */

public class SuggestionAdapter extends ArrayAdapter<Suggestion> {

    public SuggestionAdapter(Context context, int resource, List<Suggestion> suggestions){
        super(context, resource);

    }

}
