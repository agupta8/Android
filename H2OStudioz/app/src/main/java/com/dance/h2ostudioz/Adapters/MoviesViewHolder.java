package com.dance.h2ostudioz.Adapters;

/**
 * Created by aman on 9/9/17.
 */

import android.view.View;
import android.widget.TextView;

import com.dance.h2ostudioz.Models.DayOfTheWeek;
import com.dance.h2ostudioz.Models.Movies;
import com.dance.h2ostudioz.R;

public class MoviesViewHolder extends ChildViewHolder {

    private TextView mMoviesTextView;
    private TextView dayName;
    private TextView eveningTimnings;
    private TextView morningTimings;

    public MoviesViewHolder(View itemView) {
        super(itemView);
        mMoviesTextView = (TextView) itemView.findViewById(R.id.lblListItem);
        dayName = (TextView) itemView.findViewById(R.id.day);
        eveningTimnings = (TextView) itemView.findViewById(R.id.evening);
        morningTimings = (TextView) itemView.findViewById(R.id.morning);
    }

    public void bind(Movies movies) {
        if(movies.getCHILD_TYPE() == Movies.DESC_CHILD) {
            mMoviesTextView.setVisibility(View.VISIBLE);
            mMoviesTextView.setText(movies.getDescription());
            dayName.setVisibility(View.GONE);
            eveningTimnings.setVisibility(View.GONE);
            morningTimings.setVisibility(View.GONE);
        }else if(movies.getCHILD_TYPE() == Movies.DOW){
            dayName.setText("Days");
            morningTimings.setText("Morning");
            eveningTimnings.setText("Evening");
            mMoviesTextView.setVisibility(View.GONE);
            dayName.setVisibility(View.VISIBLE);
            eveningTimnings.setVisibility(View.VISIBLE);
            morningTimings.setVisibility(View.VISIBLE);
        }else if(movies.getCHILD_TYPE() == Movies.DOW_CHILD){
            mMoviesTextView.setVisibility(View.GONE);
            dayName.setVisibility(View.VISIBLE);
            eveningTimnings.setVisibility(View.VISIBLE);
            morningTimings.setVisibility(View.VISIBLE);
            DayOfTheWeek dayOfTheWeek = movies.getDayOfTheWeek();
            dayName.setText(dayOfTheWeek.getDayName());
            String morningTimeString = "";
                    for (String timing : dayOfTheWeek.getMorning()) {
                        if (morningTimeString.equalsIgnoreCase(""))
                            morningTimeString = morningTimeString + timing;
                        else {
                            morningTimeString = morningTimeString + "," + timing;
                        }
                    }
            morningTimings.setText(morningTimeString);
            String eveningTimeString = "";
            for (String timing : dayOfTheWeek.getEvening()) {
                if (eveningTimeString.equalsIgnoreCase(""))
                    eveningTimeString = eveningTimeString + timing;
                else {
                    eveningTimeString = eveningTimeString + "," + timing;
                }
            }
            eveningTimnings.setText(eveningTimeString);
        }
    }
}
