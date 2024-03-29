package Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.quizapp.R;

import Students.QuestionShow;

public class topicAdapter extends BaseAdapter {

    private int numSets;

    public topicAdapter(int numSets) {
        this.numSets=numSets;
    }

    @Override
    public int getCount() {
        return numSets;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        View view;
        if(convertView==null){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.set_items,parent,false);
        }
        else{
            view = convertView;
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parent.getContext(), QuestionShow.class);
                intent.putExtra("SETID",position);
                parent.getContext().startActivity(intent);
            }
        });

        ((TextView) view.findViewById(R.id.set_name)).setText("Chapter "+String.valueOf(position+1));
        return view;
    }
}

