package com.example.youngshiny.recentsentence_fix;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecentSentenceDetailFragment extends Fragment {
    TextView nick, eventNo, eventNm, adjuDate, content;

    public RecentSentenceDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_recent_sentence_detail, container, false);
        nick = rootView.findViewById(R.id.nick_rsdetail);
        eventNo = rootView.findViewById(R.id.eventNo_rsdetail);
        eventNm = rootView.findViewById(R.id.eventNm_rsdetail);
        adjuDate = rootView.findViewById(R.id.adjuDate_rsdetail);
        content = rootView.findViewById(R.id.content_rsdetail);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();

        updateDetailView();
    }

    public void updateDetailView()
    {
        nick.setText(GetRecentSentenceDetailXMLTask.nick_str);
        eventNo.setText(GetRecentSentenceDetailXMLTask.eventNo_str);
        eventNm.setText(GetRecentSentenceDetailXMLTask.eventNm_str);
        adjuDate.setText(GetRecentSentenceDetailXMLTask.adjuDate_str);
        content.setText(GetRecentSentenceDetailXMLTask.content_str);
    }
}
