package com.dance.h2ostudioz.Fragments;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.dance.h2ostudioz.Activity.AboutUs;
import com.dance.h2ostudioz.Activity.Enquiry;
import com.dance.h2ostudioz.Adapters.CustomSwipeAdapter;
import com.dance.h2ostudioz.Transformation.CircleTransformation;
import com.dance.h2ostudioz.R;
import com.squareup.picasso.Picasso;

public class AboutFragment extends Fragment {

    private ViewPager viewPager;
    private CustomSwipeAdapter customSwipeAdapter;
    private ImageView instructor1, instructor2, instructor3,instructor4, profile_image;
    private ImageButton fb, insta, youtube;
    FloatingActionButton fab_plus, fab_enquiry, fab_about_us;
    Animation Fab_open, Fab_close, Rotate_clockwise, Rotate_anticlockwise;
    boolean isOpen = false;
    Uri url = Uri.parse("https://www.facebook.com/photo.php?fbid=1582856175078170&set=a.484991238198008.110137.100000614076984&type=3&theater");

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_about, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        customSwipeAdapter = new CustomSwipeAdapter(getActivity());
        viewPager.setAdapter(customSwipeAdapter);

        instructor1 = (ImageView) view.findViewById(R.id.instructor1);
        instructor1.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog1 = new Dialog(getActivity(), android.R.style.Theme_Black_NoTitleBar_Fullscreen);
                dialog1.setContentView(R.layout.instructor_popup);
                ImageView profileImage = (ImageView) dialog1.findViewById(R.id.profile);
                profileImage.setImageResource(R.drawable.instructor1);
                TextView instructorName = (TextView) dialog1.findViewById(R.id.instructor_name);
                instructorName.setText("Karthik");
                TextView instrDance = (TextView) dialog1.findViewById(R.id.instructor_danceform);
                instrDance.setText("Main Instructor");
                TextView aboutInstructor = (TextView) dialog1.findViewById(R.id.about_constructor);
                aboutInstructor.setText(R.string.karthik);
                Picasso.with(getActivity()).load(R.drawable.instructor1).into(profileImage);
                dialog1.show();
            }
        });
        instructor2 = (ImageView) view.findViewById(R.id.instructor2);
        instructor2.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog2 = new Dialog(getActivity(), android.R.style.Theme_Black_NoTitleBar_Fullscreen);
                dialog2.setContentView(R.layout.instructor_popup);
                ImageView profileImage = (ImageView) dialog2.findViewById(R.id.profile);
                profileImage.setImageResource(R.drawable.instructor2);
                TextView instructorName = (TextView) dialog2.findViewById(R.id.instructor_name);
                instructorName.setText("Ramesh");
                TextView instrDance = (TextView) dialog2.findViewById(R.id.instructor_danceform);
                instrDance.setText("Kids Instructor");
                TextView aboutInstructor = (TextView) dialog2.findViewById(R.id.about_constructor);
                aboutInstructor.setText(R.string.ramesh);
                Picasso.with(getActivity()).load(R.drawable.instructor2).into(profileImage);
                dialog2.show();
            }
        });
        instructor3 = (ImageView) view.findViewById(R.id.instructor3);
        instructor3.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog3 = new Dialog(getActivity(), android.R.style.Theme_Black_NoTitleBar_Fullscreen);
                dialog3.setContentView(R.layout.instructor_popup);
                ImageView profileImage = (ImageView) dialog3.findViewById(R.id.profile);
                profileImage.setImageResource(R.drawable.instructor3);
                TextView instructorName = (TextView) dialog3.findViewById(R.id.instructor_name);
                instructorName.setText("Nidhi - Abhishek");
                TextView instrDance = (TextView) dialog3.findViewById(R.id.instructor_danceform);
                instrDance.setText("Salsa Instructors");
                TextView aboutInstructor = (TextView) dialog3.findViewById(R.id.about_constructor);
                aboutInstructor.setText(R.string.nidhi_abhishek);
                Picasso.with(getActivity()).load(R.drawable.instructor3).into(profileImage);
                dialog3.show();
            }
        });

        instructor4 = (ImageView) view.findViewById(R.id.instructor4);
        instructor4.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog4 = new Dialog(getActivity(), android.R.style.Theme_Black_NoTitleBar_Fullscreen);
                dialog4.setContentView(R.layout.instructor_popup);
                ImageView profileImage = (ImageView) dialog4.findViewById(R.id.profile);
                profileImage.setImageResource(R.drawable.kavya);
                TextView instructorName = (TextView) dialog4.findViewById(R.id.instructor_name);
                instructorName.setText("Kavya");
                TextView instrDance = (TextView) dialog4.findViewById(R.id.instructor_danceform);
                instrDance.setText("Music Instructor");
                TextView aboutInstructor = (TextView) dialog4.findViewById(R.id.about_constructor);
                aboutInstructor.setText(R.string.kavya);
                Picasso.with(getActivity()).load(R.drawable.kavya).into(profileImage);
                dialog4.show();
            }
        });


        fb = (ImageButton) view.findViewById(R.id.fb_button);
        fb.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.facebook.com/h2oblore/"));
                getActivity().startActivity(i);
            }
        });
        insta = (ImageButton) view.findViewById(R.id.insta_button);
        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                Uri uri = Uri.parse("https://www.instagram.com/h2odancestudio/");
                Intent instaIntent = new Intent(Intent.ACTION_VIEW, uri);

                instaIntent.setPackage("com.instagram.android");
                    startActivity(instaIntent);
                }
                catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.instagram.com/h2odancestudio/")));
                }
            }
        });
        youtube = (ImageButton) view.findViewById(R.id.youtube_button);
        youtube.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.youtube.com/channel/UC4lBquxz8XG0Gd9tOsVi3Zg"));
                getActivity().startActivity(i);
            }
        });

        fab_plus = (FloatingActionButton) view.findViewById(R.id.fab_plus);
        fab_enquiry = (FloatingActionButton) view.findViewById(R.id.fab_enquiry);
        fab_about_us = (FloatingActionButton) view.findViewById(R.id.fab_about_us);
        Fab_open = AnimationUtils.loadAnimation(getContext(), R.anim.fab_open);
        Fab_close = AnimationUtils.loadAnimation(getContext(), R.anim.fab_close);
        Rotate_clockwise = AnimationUtils.loadAnimation(getContext(), R.anim.rotate_clockwise);
        Rotate_anticlockwise = AnimationUtils.loadAnimation(getContext(), R.anim.rotate_anticlockwise);
        fab_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOpen) {
                    fab_enquiry.startAnimation(Fab_close);
                    fab_about_us.startAnimation(Fab_close);
                    fab_plus.startAnimation(Rotate_anticlockwise);
                    fab_enquiry.setClickable(false);
                    fab_about_us.setClickable(false);
                    isOpen = false;
                } else {
                    fab_enquiry.startAnimation(Fab_open);
                    fab_about_us.startAnimation(Fab_open);
                    fab_plus.startAnimation(Rotate_clockwise);
                    fab_enquiry.setClickable(true);
                    fab_about_us.setClickable(true);
                    isOpen = true;
                }
            }
        });

        fab_enquiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fab_enquiry.startAnimation(Fab_close);
                fab_about_us.startAnimation(Fab_close);
                fab_plus.startAnimation(Rotate_anticlockwise);
                fab_enquiry.setClickable(false);
                fab_about_us.setClickable(false);
                isOpen = false;
                goToEnquiry();
            }
        });
        fab_about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fab_enquiry.startAnimation(Fab_close);
                fab_about_us.startAnimation(Fab_close);
                fab_plus.startAnimation(Rotate_anticlockwise);
                fab_enquiry.setClickable(false);
                fab_about_us.setClickable(false);
                isOpen = false;

                goToAboutUs();
            }
        });
        return view;
    }

    public void goToEnquiry() {
        Intent intent = new Intent(getActivity(), Enquiry.class);
        startActivity(intent);
    }

    public void goToAboutUs() {
        Intent intent = new Intent(getActivity(), AboutUs.class);
        startActivity(intent);
    }

}
