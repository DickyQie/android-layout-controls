# Android之ToolBar的使用 
  <p style="text-align:left">Toolbar是在 Android 5.0 开始推出的一个 Material Design 风格的导航控件 ，Google 非常推荐大家使用&nbsp;<strong>Toolbar</strong>&nbsp;来作为Android客户端的导航栏，以此来取代之前的&nbsp;<strong>Actionbar</strong>&nbsp;。与&nbsp;<strong>Actionbar</strong>&nbsp;相比，&nbsp;<strong>Toolbar</strong>&nbsp;明显要灵活的多。它不像&nbsp;<strong>Actionbar</strong>&nbsp;一样，一定要固定在Activity的顶部，而是可以放到界面的任意位置。除此之外，在设计&nbsp;<strong>Toolbar</strong>&nbsp;的时候，Google也留给了开发者很多可定制修改的余地，这些可定制修改的属性在API文档中都有详细介绍，如：</p> 
<ul> 
 <li><strong>设置导航栏图标；</strong></li> 
 <li><strong>设置App的logo；</strong></li> 
 <li><strong>支持设置标题和子标题；</strong></li> 
 <li><strong>支持添加一个或多个的自定义控件；</strong></li> 
 <li><strong>支持Action Menu；</strong></li> 
</ul> 
<p>那么它怎么使用呢，首先我们一样要用到v7的支持包，然后定义程序的主题样式，在style里得先把Actionbar去掉，如下：</p> 
<pre><code class="language-html">&lt;resources&gt;
  &lt;style name="AppTheme" parent="AppTheme.Base"&gt;
  &lt;/style&gt;

  &lt;style name="AppTheme.Base" parent="Theme.AppCompat"&gt;
    &lt;item name="windowActionBar"&gt;false&lt;/item&gt;
    &lt;item name="android:windowNoTitle"&gt;true&lt;/item&gt;

    &lt;item name="android:fitsSystemWindows"&gt;true&lt;/item&gt;
    &lt;!-- toolbar栏的颜色 --&gt;
    &lt;item name="colorPrimary"&gt;@color/accent_material_dark&lt;/item&gt;
    &lt;!-- 状态栏颜色 --&gt;
    &lt;item name="colorPrimaryDark"&gt;@color/accent_material_light&lt;/item&gt;
    &lt;!--窗口的背景颜色--&gt;
    &lt;item name="android:windowBackground"&gt;@color/dim_foreground_material_dark&lt;/item&gt;
  &lt;/style&gt;
&lt;/resources&gt;</code></pre> 
<p>还有我们可以在values-v21给API21的系统版本设置默认的底部导航栏默认的颜色：</p> 
<p><span style="background-color:rgb(255, 255, 255); color:rgb(85, 85, 85)">/res/values-v21/styles.xml</span></p> 
<pre><code class="language-html">&lt;?xml version="1.0" encoding="utf-8"?&gt;
&lt;resources&gt;
    &lt;style name="AppTheme" parent="AppTheme.Base"&gt;
      &lt;!-- 底部导航栏颜色 --&gt; 
      &lt;item name="android:navigationBarColor"&gt;@color/accent_material_light&lt;/item&gt;
    &lt;/style&gt;
&lt;/resources&gt;</code></pre> 
<p>activity.xml</p> 
<pre><code class="language-html">&lt;RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:background="@android:color/white"
    &gt;

    &lt;TextView
        android:layout_below="@+id/toolbar"
        android:text="hello_world"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="18sp"
        android:textColor="@android:color/black"
        android:layout_marginTop="5dp"
        /&gt;

    &lt;android.support.v7.widget.Toolbar
        android:id="@+id/toolbar"
        android:layout_height="?attr/actionBarSize"
        android:layout_width="match_parent"
        android:background="?attr/colorPrimary" &gt;

    &lt;/android.support.v7.widget.Toolbar&gt;

&lt;/RelativeLayout&gt;
</code></pre> 
<p>Activity</p> 
<pre><code class="language-java">public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        // App Logo
        toolbar.setLogo(R.mipmap.ic_launcher);
        // Title
        toolbar.setTitle("标题");
        setSupportActionBar(toolbar);
        // Navigation Icon 要設定在 setSupoortActionBar 才有作用
        // 否則會出現 back bottom
        toolbar.setNavigationIcon(R.drawable.ab_android);
        // Menu item click 的監聽事件一樣要設定在 setSupportActionBar 才有作用
        toolbar.setOnMenuItemClickListener(onMenuItemClick);
    }

    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            String msg = "";
            switch (menuItem.getItemId()) {
                case R.id.action_edit:
                    msg += "编辑";
                    break;
                case R.id.action_share:
                    msg += "分享";
                    break;
                case R.id.action_settings:
                    msg += "Setting";
                    break;
            }

            if(!msg.equals("")) {
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 為了讓 Toolbar 的 Menu 有作用，這邊的程式不可以拿掉
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}</code></pre> 
<span id="OSC_h3_1"></span>
<h3>添加依赖库：</h3> 
<pre><code class="language-java"> compile 'com.android.support:appcompat-v7:21.0.0'</code></pre> 
<span id="OSC_h2_2"></span>
<p>运行效果如图：</p> 
<p><img alt="" height="662" src="https://static.oschina.net/uploads/space/2017/0208/100851_Jo7r_2945455.png" width="537"></p> 
<p>&nbsp;</p>
