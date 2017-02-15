# Android之ToolBar和自定义ToolBar实现沉浸式状态栏 
   <p><span style="background-color:rgb(255, 255, 255); color:rgb(68, 68, 68)">沉浸式状态栏确切的说应该叫做透明状态栏。一般情况下，状态栏的底色都为黑色，而沉浸式状态栏则是把状态栏设置为透明或者半透明。</span></p> 
<p><span style="background-color:rgb(255, 255, 255); color:rgb(68, 68, 68)">沉浸式状态栏是从android Kitkat（Android 4.4）开始出现的,它可以被设置成与APP顶部相同的颜色，这就使得切换APP时，整个界面就好似切换到了与APP相同的风格样式一样。在内容展示上会显得更加美观。</span></p> 
<p><span style="background-color:rgb(255, 255, 255); color:rgb(68, 68, 68)">本博客主要说的是结合ToolBar来实现状态栏的两种实现方式，效果如图：</span></p> 
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img alt="" height="431" src="https://static.oschina.net/uploads/space/2017/0215/103043_917o_2945455.gif" width="325"></p> 
<p><span style="background-color:rgb(255, 255, 255); color:rgb(68, 68, 68)">前提条件是 Api得大于等于19（4.4版本以上）</span></p> 
<p><span style="background-color:rgb(255, 255, 255); color:rgb(68, 68, 68)">方式1：</span></p> 
<p>布局 <span style="color:#800000">toolbar1.xml</span></p> 
<pre><code class="language-html">&lt;LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"&gt;

    &lt;android.support.v7.widget.Toolbar
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
        app:title="App Title"
        app:subtitle="Sub Title"
        app:navigationIcon="@android:drawable/ic_input_add"
        android:layout_height="wrap_content"
        android:background="?attr/colorPrimary"
        android:fitsSystemWindows="true"
        android:theme="@style/ThemeOverlay.AppCompat.Dark.ActionBar"
        app:popupTheme="@style/ThemeOverlay.AppCompat.Light"/&gt;

    &lt;RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"&gt;
        &lt;TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_centerInParent="true"
            android:text="沉浸式状态栏"
            android:textSize="30sp" /&gt;
    &lt;/RelativeLayout&gt;
&lt;/LinearLayout&gt;</code></pre> 
<p><span style="color:#800000">Activity.Java</span></p> 
<pre><code class="language-java">public class TooBarStatusActivity1 extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去标题
        setContentView(R.layout.toolbar_layout);
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        //透明导航栏
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("App Title"); //设置Toolbar标题
        mToolbar.setSubtitle("Sub Title"); //设置Toolbar 副标题
        mToolbar.setLogo(R.mipmap.ic_launcher);//设置Toolbar的Logo
        mToolbar.setNavigationIcon(R.mipmap.abc_ic_ab_back_mtrl_am_alpha);
        setSupportActionBar(mToolbar);
    }
}</code></pre> 
<p><span style="background-color:rgb(255, 255, 255); color:rgb(68, 68, 68)">方式2：</span></p> 
<p>布局 <span style="color:#800000">toolbar2.xml</span></p> 
<pre><code class="language-html">&lt;LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@android:color/white"
    android:orientation="vertical"
   &gt;
    &lt;TextView
        android:layout_width="match_parent"
        android:layout_height="100dp"
        android:background="@color/colorAccent"
        android:fitsSystemWindows="true"
        android:clipToPadding="true"
        android:text="自定义的ToolBar布局"
        android:textSize="20sp"
        android:gravity="center_vertical"
        /&gt;
    &lt;TextView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="#FFFF00"
        android:text="主布局"
        android:textSize="22sp"
        android:gravity="center"
        /&gt;
&lt;/LinearLayout&gt;</code></pre> 
<p><span style="color:#800000">Activity.Java</span></p> 
<pre><code class="language-java">public class TooBarStatusActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar_layout2);
        if (Build.VERSION.SDK_INT &gt;= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }
}</code></pre> 
<p><span style="color:#800000">style.xml</span></p> 
<pre><code class="language-html">  &lt;style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar"&gt;
        &lt;!-- Customize your theme here. --&gt;
        &lt;item name="colorPrimary"&gt;@color/colorPrimary&lt;/item&gt;
        &lt;item name="colorPrimaryDark"&gt;@color/colorPrimaryDark&lt;/item&gt;
        &lt;item name="colorAccent"&gt;@color/colorAccent&lt;/item&gt;
        &lt;item name="windowActionBar"&gt;false&lt;/item&gt;
        &lt;item name="windowNoTitle"&gt;true&lt;/item&gt;
    &lt;/style&gt;</code></pre> 
<p>&nbsp;</p> 
