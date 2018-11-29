package com.example.mh978.help_me;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainMenuActivity extends AppCompatActivity {

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
                intent = new Intent(MainMenuActivity.this, LegalInfo1.class);
                startActivity(intent);
                break;
            case R.id.imageButton2:
                intent = new Intent(MainMenuActivity.this, MajorCase2.class);
                startActivity(intent);
                break;
            case R.id.imageButton3:
                intent = new Intent(MainMenuActivity.this, CaseSearch3.class);
                startActivity(intent);
                break;
            case R.id.imageButton4:
                intent = new Intent(MainMenuActivity.this, LawTerm4.class);
                startActivity(intent);
                break;
            case R.id.imageButton5:
                intent = new Intent(MainMenuActivity.this, CloseCourt5.class);
                startActivity(intent);
                break;
            case R.id.imageButton6:
                intent = new Intent(MainMenuActivity.this, Profile6.class);
                startActivity(intent);
                break;
            case R.id.Search_button:
                //String search = (String)findViewById(R.id.Search_editText).toString();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com")));
                break;
        }
    }
}
