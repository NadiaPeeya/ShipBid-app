package com.nsu.shipbid.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.nsu.shipbid.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import androidx.annotation.NonNull;

import java.util.HashMap;

public class PostAd extends AppCompatActivity {

    private EditText oName, pName, pType, pSize, pWeight, pStartingValue, endingTime;
    private Button pButton, rButton, eButton;

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("post");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_ad);
        oName = findViewById(R.id.oName);
        pName = findViewById(R.id.pName);
        pType = findViewById(R.id.pType);
        pSize = findViewById(R.id.pSize);
        pWeight = findViewById(R.id.pWeight);
        pStartingValue = findViewById(R.id.startingValue);
        endingTime = findViewById(R.id.endingTime);
        pButton = findViewById(R.id.postButton);

        //Activities for post a bid after clicking "Post" button
        pButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ownerName = oName.getText().toString();
                String productName = pName.getText().toString();
                //root.child("01").setValue(productName);
                //root.setValue(productName);
                String productType = pType.getText().toString();
                String productSize = pSize.getText().toString();
                String productWeight = pWeight.getText().toString();
                String sValue = pStartingValue.getText().toString();
                String eTime = endingTime.getText().toString();

                HashMap<String, String> userMap = new HashMap<>();

                //storing data into HAshMap
                userMap.put("OwnerName", ownerName);
                userMap.put("ProductName", productName);
                userMap.put("ProductType", productType);
                userMap.put("Size", productSize);
                userMap.put("Weight", productWeight);
                userMap.put("StartingValue", sValue);
                userMap.put("BidEndingTime", eTime);

                root.push().setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(PostAd.this, "Data Stored Successfully!!!!",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }

}
