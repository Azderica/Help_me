package com.example.mh978.help_me;

import android.app.SearchManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.mh978.help_me.Law1.LawActivity;
import com.example.mh978.help_me.Law2.RecentSentenceActivity;
import com.example.mh978.help_me.Law3.PrecedenceSearch;
import com.example.mh978.help_me.Law4.LegalTerm;
import com.example.mh978.help_me.Law5.LawGPSActivity;
import com.example.mh978.help_me.Law6.MemberInfoActivity;

public class MainMenuActivity extends AppCompatActivity {
    String find_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Drawable main_image = ((ImageView)findViewById(R.id.main_imageView)).getDrawable();
        main_image.setAlpha(180);
    }

    public void onClickButton(View v){
        Intent intent;
        switch (v.getId()){
            case R.id.imageButton1:
                intent = new Intent(MainMenuActivity.this, LawActivity.class);
                startActivity(intent);
                break;
            case R.id.imageButton2:
                intent = new Intent(MainMenuActivity.this, RecentSentenceActivity.class);
                startActivity(intent);
                break;
            case R.id.imageButton3:
                intent = new Intent(MainMenuActivity.this, PrecedenceSearch.class);
                startActivity(intent);
                break;
            case R.id.imageButton4:
                intent = new Intent(MainMenuActivity.this, LegalTerm.class);
                startActivity(intent);
                break;
            case R.id.imageButton5:
                intent = new Intent(MainMenuActivity.this, LawGPSActivity.class);
                startActivity(intent);
                break;
            case R.id.imageButton6:
                intent = new Intent(MainMenuActivity.this, MemberInfoActivity.class);
                startActivity(intent);
                break;
            case R.id.Search_button:
                EditText editText = findViewById(R.id.Search_editText);
                find_item = editText.getText().toString();
                intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, find_item);
                startActivity(intent);
        }
    }
}
