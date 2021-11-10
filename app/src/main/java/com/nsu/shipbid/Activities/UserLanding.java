package com.nsu.shipbid.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import com.nsu.shipbid.R;
import android.os.Bundle;

public class UserLanding extends AppCompatActivity {
    private Button postAdBtn, userPanelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_landing);

        postAdBtn = findViewById(R.id.postAdBtn);
        userPanelBtn = findViewById(R.id.userPanelBtn);

        postAdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserLanding.this, PostAd.class));
            }
        });

        userPanelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserLanding.this, FindShipperActivity.class));
            }
        });

    }


}