package com.example.mh978.help_me.Law2;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mh978.help_me.R;

import java.util.ArrayList;

public class RecentSentenceSearchFragment extends Fragment {
    static String seq_str = "";
    String searchCode_str = "";
    String full_url = "";
    String gubun_str = "";
    String searchValue_str = "";
    String chgDate_str = "";
    String max_count = "&numOfRows=99999";
    String RecentSentenceListUrl = "http://openapi.ccourt.go.kr/openapi/services/PrecedentInfoSvc/getRealmMainPrcdntSearchInfo?";
    String RecentSentenceDetailUrl = "http://openapi.ccourt.go.kr/openapi/services/PrecedentInfoSvc/getRealmMainPrcdntDetailInfo?";
    String serviceKey = "ServiceKey=I+yoGyGw2w0UZoW0QYKBTllUZFMQD7ZgpoaC6knTumVQIK4Se9R6LVUFKttTQjB1idX7N4kjaSr7WBsXDssVXQ==";

    static ArrayList<String> seqList;
    static RecentSentenceListAdapter rslistAdapter;
    static ListView mListView;

    OnRecentSentenceSelectedListener mCallback;

    public interface OnRecentSentenceSelectedListener {
        public void OnRecentSentenceSelected();
    }

    public RecentSentenceSearchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallback = (OnRecentSentenceSelectedListener)getActivity();
        } catch (ClassCastException cce)
        {
            throw new ClassCastException(getActivity().toString() + " must implement OnRecentSentenceSelectedListener");
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("full_url", full_url);
        if (full_url != null && !full_url.equals(""))
        {
            GetRecentSentenceListXMLTask task = new GetRecentSentenceListXMLTask();
            task.execute(full_url);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_recent_sentence_search, container, false);

        seqList = new ArrayList<>();
        mListView = rootView.findViewById(R.id.searchList);
        mListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                seq_str = seqList.get(position);
                String url = RecentSentenceDetailUrl + serviceKey + seq_str;
                GetRecentSentenceDetailXMLTask task = new GetRecentSentenceDetailXMLTask();
                task.execute(url);
                Log.i("onItemClick", url);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {

                }
                mCallback.OnRecentSentenceSelected();
            }
        });
        rslistAdapter = new RecentSentenceListAdapter(getContext());

        Spinner spinner = (Spinner)rootView.findViewById(R.id.searchCode);
        ArrayAdapter sAdapter = ArrayAdapter.createFromResource(getContext(), R.array.searchCode, android.R.layout.simple_spinner_item);
        sAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0: searchCode_str = "";
                        break;
                    case 1: searchCode_str = "&searchCode=1";
                        break;
                    case 2: searchCode_str = "&searchCode=3";
                        break;
                    case 3: searchCode_str = "&searchCode=4";
                        break;
                    case 4: searchCode_str = "&searchCode=5";
                        break;
                    case 5: searchCode_str = "&searchCode=6";
                        break;
                    case 6: searchCode_str = "&searchCode=7";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getContext(), "분류를 선택하세요.", Toast.LENGTH_SHORT).show();
            }
        });
        spinner.setAdapter(sAdapter);

        Spinner spinner2 = (Spinner)rootView.findViewById(R.id.gubun);
        ArrayAdapter sAdapter2 = ArrayAdapter.createFromResource(getContext(), R.array.gubun, android.R.layout.simple_spinner_item);
        sAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0: gubun_str = "";
                        break;
                    case 1: gubun_str = "&gubun=1"; // 제목
                        break;
                    case 2: gubun_str = "&gubun=2"; // 결정문
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner2.setAdapter(sAdapter2);

        Button btn = rootView.findViewById(R.id.searchButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seqList.clear();
                rslistAdapter.clear();

                EditText searchValue, chgDate;

                searchValue = getView().findViewById(R.id.editText3);
                chgDate = getView().findViewById(R.id.editText4);

                if (searchCode_str.equals(""))
                {
                    Toast.makeText(getContext(), "분류를 선택하세요.", Toast.LENGTH_SHORT).show();
                }
                else if (!gubun_str.equals("") && searchValue.getText().toString().equals(""))
                {
                    Toast.makeText(getContext(), "검색어를 입력하세요.", Toast.LENGTH_SHORT).show();
                }
                else if (gubun_str.equals("") && !searchValue.getText().toString().equals(""))
                {
                    Toast.makeText(getContext(), "구분을 선택하세요.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    searchValue_str = "";
                    chgDate_str = "";

                    if (!searchValue.getText().toString().equals("")) {
                        searchValue_str = "&searchValue=" + searchValue.getText();
                    }

                    if (!chgDate.getText().toString().equals("")) {
                        chgDate_str = "&chgDate=" + chgDate.getText();
                    }

                    full_url = RecentSentenceListUrl + serviceKey + searchCode_str + gubun_str + searchValue_str + chgDate_str + max_count;

                    Log.i("full_url", full_url);

                    GetRecentSentenceListXMLTask task = new GetRecentSentenceListXMLTask();
                    task.execute(full_url);
                }
            }
        });

        return rootView;
    }
}
