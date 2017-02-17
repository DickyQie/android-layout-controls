# Android之侧滑菜单DrawerLayout的使用
 <p>在<span style="color:#008080">android&nbsp;support.v4</span> 中有一个抽屉视图控件<span style="color:#008080">DrawerLayout</span>。使用这个控件，可以生成通过在屏幕上水平滑动打开或者关闭菜单，能给用户一个不错的体验效果。</p> 
<p><span style="color:#008080">DrawerLayout</span>分为侧边菜单和主内容区两部分，侧边菜单可以根据手势展开与隐藏，主内容区的部分可以随着菜单的点击而变化。<span style="color:#008080">DrawerLayout</span>其实是一个控件，跟<span style="color:#008080">LinearLayout</span>差不多，直接使用即可。</p> 
<p><span style="color:#008080">DrawerLayout属性</span></p> 
<p>drawerPosition：指定 drawer 将从屏幕的一侧滑动。</p> 
<p>drawerWidth :指定 drawer 的宽度，即从窗口的边缘拉到视图更精确的宽度。</p> 
<p>keyboardDismissMode :确定键盘是否响应拖动被驳回。</p> 
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 'none' (默认值), 拖动不影响键盘。<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 'on-drag', 拖动开始，键盘被驳回。</p> 
<p>onDrawerClose :导航视图关闭时调用函数。</p> 
<p>onDrawerOpen :导航视图打开时调用函数。</p> 
<p>onDrawerSlide ：与导航视图交互时调用函数。</p> 
<p>onDrawerStateChanged ：当 Drawer 状态发生变化时调用函数，drawer 有 3 种状态:</p> 
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; idle -- 表示与导航视图没有交互<br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; dragging -- 表示目前有与导航视图的交互<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; settling -- 表示有与导航视图的交互，并且导航视图正在的关闭或打开。</p> 
<p>renderNavigationView ：导航图将被渲染到屏幕的一侧，并且可以拉出。</p> 
<p>案例</p> 
<p>使用导入依赖库</p> 
<pre><code class="language-java">compile 'com.android.support:appcompat-v7:24.2.1'</code></pre> 
<p>布局文件</p> 
<pre><code class="language-html">&lt;?xml version="1.0" encoding="utf-8"?&gt;
&lt;android.support.v4.widget.DrawerLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/v4_drawerlayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"&gt;

    &lt;FrameLayout
        android:id="@+id/v4_drawerlayout_frame"
        android:layout_width="match_parent"
        android:layout_height="match_parent" &gt;
        &lt;TextView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:id="@+id/v4_text"
            android:textSize="22sp"
            android:textColor="@color/colorAccent"
            android:gravity="center"
            /&gt;
    &lt;/FrameLayout&gt;

    &lt;ListView
        android:layout_width="200dp"
        android:layout_height="match_parent"
        android:layout_gravity="left"
        android:id="@+id/v4_listview"
        android:choiceMode="singleChoice"
        android:background="@android:color/white" /&gt;

&lt;/android.support.v4.widget.DrawerLayout&gt;</code></pre> 
<p>Activity</p> 
<pre><code class="language-java">public class DrawerActivity extends AppCompatActivity {

    private ListView listView;

    private DrawerLayout drawerLayout;

    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_activity);
        initView();
    }

    private void initView()
    {
        listView=(ListView) findViewById(R.id.v4_listview);
        drawerLayout=(DrawerLayout) findViewById(R.id.v4_drawerlayout);
        textView=(TextView) findViewById(R.id.v4_text);
        initDate();
    }

    private void initDate(){
        final List&lt;String&gt; list = new ArrayList&lt;String&gt;();
        list.add("网易");
        list.add("腾讯");
        list.add("新浪");
        list.add("搜狐");
        ArrayAdapter&lt;String&gt; adapter = new ArrayAdapter&lt;&gt;(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView&lt;?&gt; parent, View view, int position, long id) {
                textView.setText(list.get(position));
                showDrawerLayout();
            }
        });
        drawerLayout.openDrawer(Gravity.LEFT);//侧滑打开  不设置则不会默认打开
    }

    private void showDrawerLayout() {
        if (!drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            drawerLayout.openDrawer(Gravity.LEFT);
        } else {
            drawerLayout.closeDrawer(Gravity.LEFT);
        }
    }
}
</code></pre> 
<p>&nbsp;</p> 
<p>运行效果如图：</p> 
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img alt="" src="https://static.oschina.net/uploads/space/2017/0217/163814_fkrM_2945455.gif"></p> 
<p>&nbsp;</p> 
