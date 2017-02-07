package http.asjiwd;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.joybar.librarycalendar.data.CalendarDate;
import com.joybar.librarycalendar.fragment.CalendarViewFragment;
import com.joybar.librarycalendar.fragment.CalendarViewPagerFragment;
import com.joybar.librarycalendar.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements
        CalendarViewPagerFragment.OnPageChangeListener,
        CalendarViewFragment.OnDateClickListener,
        CalendarViewFragment.OnDateCancelListener {

    private TextView tv_date;
    private List<CalendarDate> mListDate = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_date = (TextView) findViewById(R.id.tv_date);
        initFragment();
    }

    private void initFragment() {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction tx = fm.beginTransaction();
        Fragment fragment = CalendarViewPagerFragment.newInstance();
        tx.replace(R.id.fl_content, fragment);
        tx.commit();
    }

    @Override
    public void onDateClick(CalendarDate calendarDate) {

        int year = calendarDate.getSolar().solarYear;
        int month = calendarDate.getSolar().solarMonth;
        int day = calendarDate.getSolar().solarDay;
        String data;
        if (day < 10) {
            data = DateUtils.getWeekday(year + "-" + month + "-0" + day);
            tv_date.setText(year + "-" + month + "-0" + day + " " + month + "月" + "  " + data);
        } else {
            data = DateUtils.getWeekday(year + "-" + month + "-" + day);
            tv_date.setText(year + "-" + month + "-" + day + " " + month + "月" + "  " + data);
        }

    }

    @Override
    public void onDateCancel(CalendarDate calendarDate) {
    }

    @Override
    public void onPageChange(int year, int month) {
        tv_date.setText(year + "-" + month);
        mListDate.clear();
    }

}
