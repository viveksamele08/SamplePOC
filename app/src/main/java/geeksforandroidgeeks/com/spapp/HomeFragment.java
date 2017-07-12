package geeksforandroidgeeks.com.spapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class HomeFragment extends Fragment implements View.OnClickListener {

    private TextView ccc;
    private TextView acad_calendar;
    private TextView exam_timetable;
    private TextView library;
    private TextView live_cam;
    private TextView feedback;
    private TextView wassup;
    private TextView exam_results;
    private TextView timetable;
    private TextView staff_directory;
    private TextView staff_calendar;
    private TextView staff_timetable;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.home_fragment, container, false);
        ccc = (TextView) view.findViewById(R.id.ccc);
        acad_calendar = (TextView) view.findViewById(R.id.acad_calendar);
        exam_timetable = (TextView) view.findViewById(R.id.exam_timetable);
        library = (TextView) view.findViewById(R.id.library);
        live_cam = (TextView) view.findViewById(R.id.live_cam);
        feedback = (TextView) view.findViewById(R.id.feedback);
        wassup = (TextView) view.findViewById(R.id.wassup);
        exam_results = (TextView) view.findViewById(R.id.exam_results);
        timetable = (TextView) view.findViewById(R.id.time_table);
        staff_directory = (TextView) view.findViewById(R.id.staff_directory);
        staff_calendar = (TextView) view.findViewById(R.id.staff_calendar);
        staff_timetable = (TextView) view.findViewById(R.id.staff_timetable);
        ccc.setOnClickListener(this);
        acad_calendar.setOnClickListener(this);
        exam_timetable.setOnClickListener(this);
        library.setOnClickListener(this);
        live_cam.setOnClickListener(this);
        feedback.setOnClickListener(this);
        wassup.setOnClickListener(this);
        exam_results.setOnClickListener(this);
        timetable.setOnClickListener(this);
        staff_directory.setOnClickListener(this);
        staff_calendar.setOnClickListener(this);
        staff_timetable.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.exam_results:
                startActivity(new Intent(getActivity(), CCCWebView.class));
                break;
            case R.id.library:
                Uri uri = Uri.parse("https://library.sp.edu.sg/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
        }
    }
}
