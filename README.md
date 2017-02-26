# Android 之低版本高版本实现沉浸式状态栏
 <p><span style="background-color:rgb(255, 255, 255); color:rgb(68, 68, 68)">沉浸式状态栏确切的说应该叫做透明状态栏。一般情况下，状态栏的底色都为黑色，而沉浸式状态栏则是把状态栏设置为透明或者半透明。</span></p> 
<p><span style="background-color:rgb(255, 255, 255); color:rgb(68, 68, 68)">沉浸式状态栏是从android Kitkat（Android 4.4）开始出现的,它可以被设置成与APP顶部相同的颜色，这就使得切换APP时，整个界面就好似切换到了与APP相同的风格样式一样。在内容展示上会显得更加美观。</span></p> 
<p><span style="background-color:rgb(255, 255, 255); color:rgb(68, 68, 68)">功能：</span><span style="color:#B22222"><span style="background-color:rgb(255, 255, 255)"><strong>自行控制状态栏颜色，可以调节状态栏的亮度</strong></span><strong>，还可以把背景图片作为导航栏</strong></span></p> 
<p><span style="background-color:rgb(255, 255, 255); color:rgb(68, 68, 68)">本博客主要说的是</span><strong><span style="color:#800000"><span style="background-color:rgb(255, 255, 255)">低版本Android4.4以下或者高版本Android4.4以上都可实现来实现状态栏</span></span></strong><span style="background-color:rgb(255, 255, 255); color:rgb(68, 68, 68)">，效果如图：</span></p> 
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img alt="" src="https://static.oschina.net/uploads/space/2017/0226/135241_YXVH_2945455.gif"></p> 
<p>测试时，低版本高版本都是可行的。</p> 
<p>代码：</p> 
<p>父类Activity</p> 
<pre><code class="language-java">/**
 * Created by zq on 16/12/16.
 *
 * 此类便于其他Activity一同实现状态栏，只要集成此类就OK了
 *
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setMainLayout();
        setStatusBar();
    }

    /**
     * 初始化布局
     */
    protected abstract void setMainLayout();


    /***
     *状态栏 (自己选颜色即可)
     */
    protected void setStatusBar() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorAccent));
    }
}</code></pre> 
<p>MainActivity.java</p> 
<pre><code class="language-java">public class MainActivity extends BaseActivity {

    @Override
    protected void setMainLayout() {
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BackImaActivity.class));
            }
        });
    }
}</code></pre> 
<p>图片背景状态栏</p> 
<pre><code class="language-java">/**
 * Created by zq on 16/12/16.
 *
 */

public class BackImaActivity extends BaseActivity {

    @Override
    protected void setMainLayout() {
        setContentView(R.layout.back_activity);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StatusBarUtil.setTranslucent(BackImaActivity.this,111);
            }
        });
    }
    /****
     * 重写父类方法，覆盖的作用，可以实现状态栏的不同颜色或背景
     */
    protected void setStatusBar() {

        /**
         * 参数
         * 第一个：当前上下文
         * 第二个：状态栏透明程度，值越大就越暗 0表示完全安背景显示  之范围（0--&gt;255）
         */

        StatusBarUtil.setTranslucent(this,0);
    }
}</code></pre> 
<p>style.xml</p> 
<pre><code class="language-html">    &lt;style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar"&gt;
        &lt;!-- Customize your theme here. --&gt;
        &lt;item name="colorPrimary"&gt;@color/colorPrimary&lt;/item&gt;
        &lt;item name="colorPrimaryDark"&gt;@color/colorPrimaryDark&lt;/item&gt;
        &lt;item name="colorAccent"&gt;@color/colorAccent&lt;/item&gt;
        &lt;item name="windowNoTitle"&gt;true&lt;/item&gt;
        &lt;item name="windowActionBar"&gt;false&lt;/item&gt;
    &lt;/style&gt;</code></pre> 
<p>不需要其他配置，只需要在style.xml文件中添加这两行代码即可：</p> 
<pre><code class="language-html"> &lt;item name="windowNoTitle"&gt;true&lt;/item&gt;
 &lt;item name="windowActionBar"&gt;false&lt;/item&gt;</code></pre> 
<span id="OSC_h3_1"></span>
