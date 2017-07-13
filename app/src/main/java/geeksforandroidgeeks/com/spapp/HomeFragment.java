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
                Intent i = new Intent(getActivity(), CCCWebView.class);
                i.putExtra("key","library");
                startActivity(i);
                break;
            case R.id.library:
                Uri uri = Uri.parse("https://library.sp.edu.sg/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.live_cam:
                Intent in = new Intent(getActivity(), CCCWebView.class);
                in.putExtra("key","livecam");
                startActivity(in);
                break;
          /*  case R.id.ccc:
                Intent in1 = new Intent(getActivity(), CCCWebView.class);
                in1.putExtra("key","livecam");
                startActivity(in1);
                break;
            case R.id.acad_calendar:
                Intent in2 = new Intent(getActivity(), CCCWebView.class);
                in2.putExtra("key","livecam");
                startActivity(in2);
                break;
            case R.id.exam_timetable:
                Intent in3 = new Intent(getActivity(), CCCWebView.class);
                in3.putExtra("key","livecam");
                startActivity(in3);
                break;
            case R.id.feedback:
                Intent in4 = new Intent(getActivity(), CCCWebView.class);
                in4.putExtra("key","livecam");
                startActivity(in4);
                break;
            case R.id.wassup:
                Intent in5 = new Intent(getActivity(), CCCWebView.class);
                in5.putExtra("key","livecam");
                startActivity(in5);
                break;
            case R.id.time_table:
                Intent in6 = new Intent(getActivity(), CCCWebView.class);
                in6.putExtra("key","livecam");
                startActivity(in6);
                break;
            case R.id.staff_calendar:
                Intent in7 = new Intent(getActivity(), CCCWebView.class);
                in7.putExtra("key","livecam");
                startActivity(in7);
                break;
            case R.id.staff_directory:
                Intent in8 = new Intent(getActivity(), CCCWebView.class);
                in8.putExtra("key","livecam");
                startActivity(in8);
                break;
            case R.id.staff_timetable:
                Intent in9 = new Intent(getActivity(), CCCWebView.class);
                in9.putExtra("key","livecam");
                startActivity(in9);
                break;*/
        }
    }
}
