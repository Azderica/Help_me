package com.example.youngshiny.memberinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MemberInfoActivity extends AppCompatActivity {
    private String curPW = "12345678";
    private int curRegion = 0;
    private String email_id = "lushin3";
    private String email_site = "knu.ac.kr";
    private EditText email_1, email_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_info);

        Spinner spinner = findViewById(R.id.regionSpinner);
        spinner.setSelection(curRegion);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                curRegion = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        email_1 = findViewById(R.id.email_id);
        email_2 = findViewById(R.id.email_site);

        email_1.setText(email_id);
        email_2.setText(email_site);
    }

    public void ChangeInfo(View view)
    {
        EditText prePW = findViewById(R.id.prevPassword);
        EditText newPW = findViewById(R.id.NewPassword);
        EditText renewPW = findViewById(R.id.reNewPassword);
        Toast toast;

        if (prePW.getText().toString().equals("") && newPW.getText().toString().equals("") && renewPW.getText().toString().equals(""))
        {
            if (email_1.getText().toString().equals(email_id) && email_2.getText().toString().equals(email_site))
            {
                toast = Toast.makeText(this, "변경 된 정보가 없습니다.", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
        }

        if (!prePW.getText().toString().equals("") || !newPW.getText().toString().equals("") || !renewPW.getText().toString().equals(""))
        {
            if (!curPW.equals(prePW.getText().toString()))
            {
                toast = Toast.makeText(this, "이전 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }

            if (!newPW.getText().toString().equals(renewPW.getText().toString()))
            {
                toast = Toast.makeText(this, "새로운 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
        }

        if (email_1.getText().toString().equals("") || email_2.getText().toString().equals(""))
        {
            toast = Toast.makeText(this, "이메일 주소를 입력해주세요.", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        curPW = newPW.getText().toString();
        email_id = email_1.getText().toString();
        email_site = email_2.getText().toString();
        prePW.setText("");
        newPW.setText("");
        renewPW.setText("");

        toast = Toast.makeText(this, "정보가 변경되었습니다.", Toast.LENGTH_SHORT);
        toast.show();
    }
}
