#Andorid 之日历控件,可左右滑动，包含公历，农历，节假日等 
p><span style="background-color:rgb(255, 255, 255); color:rgb(85, 85, 85)">公司项目需要日历这个功能，经过查阅资料写了个demo，包含</span>公历，农历，节假日等，还可左右滑动。</p> 
<p>效果图：</p> 
<p><img alt="" src="https://static.oschina.net/uploads/space/2017/0207/094638_J0sU_2945455.gif"></p> 
<p>代码：</p> 
<pre><code class="language-java">public class MainActivity extends AppCompatActivity implements
        CalendarViewPagerFragment.OnPageChangeListener,
        CalendarViewFragment.OnDateClickListener,
        CalendarViewFragment.OnDateCancelListener {

    private TextView tv_date;
    private List&lt;CalendarDate&gt; mListDate = new ArrayList&lt;&gt;();

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
        if (day &lt; 10) {
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

}</code></pre> 
