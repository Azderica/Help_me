package com.example.youngshiny.recentsentence_fix;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class RecentSentenceListAdapter extends BaseAdapter
{
    Context context;
    private ArrayList<RecentSentenceList> rslist = new ArrayList<>();

    public RecentSentenceListAdapter(Context context)
    {
        this.context = context;
    }

    @Override
    public int getCount()
    {
        return rslist.size();
    }

    @Override
    public RecentSentenceList getItem(int position)
    {
        return rslist.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.recentsentencesearchlist, parent, false);
        }

        TextView txt1 = convertView.findViewById(R.id.eventNo);
        TextView txt2 = convertView.findViewById(R.id.eventNm);
        TextView txt3 = convertView.findViewById(R.id.classNm);

        RecentSentenceList item = getItem(position);

        txt1.setText(item.getEventNo());
        txt2.setText(item.getEventNm());
        txt3.setText(item.getClassNm());

        return convertView;
    }

    public void addItem(String eventNo, String eventNm, String classNm)
    {
        RecentSentenceList item = new RecentSentenceList(eventNo, eventNm, classNm);

        rslist.add(item);
    }

    public void clear()
    {
        rslist.clear();
    }
}
