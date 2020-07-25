package com.dance.h2ostudioz.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.dance.h2ostudioz.Constant;
import com.dance.h2ostudioz.R;
import com.squareup.picasso.Picasso;

public class ClanDescription extends AppCompatActivity {

    ImageView clanProfile;
    TextView clanName, clanClasses, clanDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clan_description);

        clanProfile = (ImageView) findViewById(R.id.clan_profile_img);
        clanName = (TextView) findViewById(R.id.clan_name);
        clanClasses = (TextView) findViewById(R.id.class_name);
        clanDescription = (TextView) findViewById(R.id.clan_description);
//        Picasso.with(this).load(Constant.IMAGE_URL + getIntent().getIntExtra("Image", 00)+ ".jpg").into(clanProfile);

        Picasso.with(this)
                .load(Constant.IMAGE_URL +  getIntent().getStringExtra("Image")+ ".jpg")
                .placeholder(R.drawable.place_holder)
                .error(R.drawable.place_holder)
                .into(clanProfile);
//        clanProfile.setImageResource(getIntent().getIntExtra("Image", 00));
        clanName.setText(getIntent().getStringExtra("Name"));
        clanClasses.setText(getIntent().getStringExtra("Classes"));
        clanDescription.setText(getIntent().getStringExtra("Description"));
    }

}
