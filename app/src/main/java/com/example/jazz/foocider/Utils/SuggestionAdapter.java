package com.example.jazz.foocider.Utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jazz.foocider.Objects.Suggestion;
import com.example.jazz.foocider.R;

import java.util.List;

/**
 * Created by jazz on 12/9/17.
 */

public class SuggestionAdapter extends ArrayAdapter<Suggestion> {

    private List<Suggestion> suggestionList;

    public SuggestionAdapter(Context context, int resource, List<Suggestion> suggestions){
        super(context, resource, suggestions);
        this.suggestionList = suggestions;

    }

    private static class ViewHolder {
        TextView title;
        TextView visted;
        TextView preference;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;
        Suggestion suggestion = suggestionList.get(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        if (v == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            v = inflater.inflate(R.layout.listitems_view_options, parent, false);
            viewHolder.title = v.findViewById(R.id.list_item_title);
            viewHolder.visted = v.findViewById(R.id.list_item_visited);
            viewHolder.preference = v.findViewById(R.id.list_item_preference);

            v.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) v.getTag();
        }

        if (suggestion != null) {
            viewHolder.title.setText(suggestion.getName());
            StringBuilder stringVisit = new StringBuilder().append("Number of visit : ").append(suggestion.getVisted());
            viewHolder.visted.setText(stringVisit.toString());
            StringBuilder stringPreference = new StringBuilder().append("Preference         : ").append(suggestion.getPreference());
            viewHolder.preference.setText(stringPreference);
        }

        // Return the completed view to render on screen
        return v;
    }
}
