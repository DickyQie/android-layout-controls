# Android之 RecyclerView，CardView 详解和相对应的上拉刷新下拉加载 
 <p>随着 Google 推出了全新的设计语言 Material Design，还迎来了新的 Android 支持库 v7，其中就包含了 Material Design 设计语言中关于 Card 卡片概念的实现 —— CardView。RecyclerView也是谷歌V7包下新增的控件,用来替代ListView的使用,在RecyclerView标准化了ViewHolder类似于ListView中convertView用来做视图缓存.</p> 
<p>RecyclerView的优点就是,他可以通过设置LayoutManager来快速实现listview、gridview、瀑布流的效果，而且还可以设置横向和纵向显示，添加动画效果等。</p> 
<p>CardView实现卡片化效果。</p> 
<p>下拉加载使用SwipeRefreshLayout，是官方的下拉刷新控件，简洁美观的风格使其广泛应用在项目中。美中不足的是SwipeRefreshLayout缺少上拉加载的效果，今天结合RecyclerView实现一个支持下拉刷新与上拉加载的SwipeRefreshLayout。</p> 
<p>案例包含了：RecyclerView基本使用，RecyclerView上拉刷新下拉加载，RecyclerView多Item布局，CardView基本使用和CardView上拉刷新下拉加载。如图：（注：第三个案例线显示格式在模拟器上有问题，手机则没问题的,手机测试效果更佳）</p> 
<p><img alt="" height="578" src="https://static.oschina.net/uploads/space/2017/0207/172521_5zhM_2945455.gif" width="338"></p> 
<p>布局：</p> 
<pre><code class="language-html">&lt;android.support.v7.widget.RecyclerView
    android:id="@+id/my_recycler_view"
    android:scrollbars="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"/&gt;
</code></pre> 
<p>Activity：</p> 
<pre><code class="language-java">public class RecyclerViewActivity extends Activity {

    private RecyclerView recyclerView;
    private List&lt;String&gt; mDatas;
    private RecyclerAdapter1 adapter;
    @SuppressLint("InlinedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo1);
        initData();
        initView();
    }
    private void initView()
    {
        recyclerView=(RecyclerView) findViewById(R.id.demo1_recycler);
        // 设置布局管理LayoutManager
        LinearLayoutManager manager=new LinearLayoutManager(this);
        //设置水平或者垂直
        // manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        // （可选）如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        recyclerView.setHasFixedSize(true);
        adapter=new RecyclerAdapter1(this,mDatas);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new IOnClickListenter() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getApplicationContext(),position+"---"+mDatas.get(position),Toast.LENGTH_LONG).show();
            }
        });

    }
    private void initData() {
        mDatas = new ArrayList&lt;String&gt;();
        for (int i = 0; i &lt;= 50; i++) {
            mDatas.add("item---" +i);
        }
    }

}</code></pre> 
<p>Adapter：</p> 
<pre><code class="language-java">public class RecyclerAdapter1 extends RecyclerView.Adapter&lt;RecyclerAdapter1.ViewHolder&gt;{

    private Context context;
    private List&lt;String&gt; list;
    public RecyclerAdapter1(Context context, List&lt;String&gt; list){
        this.context=context;
        this.list=list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.demo1_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    private IOnClickListenter onClickListenter=null;
    public void setOnItemClickListener(IOnClickListenter listener)
    {
        this.onClickListenter=listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView textView;

        public ViewHolder(View view)
        {
            super(view);
            textView=(TextView)view.findViewById(R.id.textview1);
            textView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            if (onClickListenter != null) {
                onClickListenter.onItemClick(v,getPosition());
            }
        }
    }
}</code></pre> 
<p>上拉刷新下拉加载布局</p> 
<pre><code class="language-html">&lt;android.support.v4.widget.SwipeRefreshLayout
        android:id="@+id/swipeRefreshLayout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"&gt;

        &lt;android.support.v7.widget.RecyclerView
            android:id="@+id/recyclerView"
            android:layout_width="match_parent"
            android:layout_height="match_parent"&gt;

        &lt;/android.support.v7.widget.RecyclerView&gt;


&lt;/android.support.v4.widget.SwipeRefreshLayout&gt;</code></pre> 
<p>上拉刷新下拉加载Activity</p> 
<pre><code class="language-java">public class RecyclerViewPullActivity extends Activity {

    private SwipeRefreshLayout swipeRefreshLayout;
    private MyRefreshRecyclerView recyclerView;
    public static  List&lt;String&gt; list=new ArrayList&lt;String&gt;();
    private RecyclerAdapter2 adapter;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo2);
        initView();
    }
    private void initView(){
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_layout);
        recyclerView = (MyRefreshRecyclerView) findViewById(R.id.recycler);
        adapter=new RecyclerAdapter2();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        swipeRefreshLayout.setColorSchemeResources(R.color.blue,R.color.green);
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
            }
        });
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getData();
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        },1500);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getData();
                        recyclerView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 1500);
            }
        });
        recyclerView.setMyRefreshRecyclerViewListener(new MyRefreshRecyclerView.MyRefreshRecyclerViewListener() {
            @Override
            public void onLoadMore() {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (list.size() &gt; 14) {
                            recyclerView.setLoadMore(true);
                        } else {
                            int randomInt = new Random().nextInt(100);
                            list.add("上拉加载添加数字:" + randomInt);
                            adapter.notifyDataSetChanged();
                            recyclerView.setLoadMore(false);
                        }

                    }
                }, 1000);
            }
        });
    }

    private void getData() {
        list.clear();
        Random random = new Random();
        while (list.size() &lt; 12) {
            int randomInt = random.nextInt(100);
            list.add(String.valueOf(randomInt));
        }
    }
}</code></pre> 
<span id="OSC_h3_1"></span>
<h3>添加依赖库：</h3> 
<pre><code class="language-java">  compile 'com.android.support:recyclerview-v7:23.2.1'
  compile 'com.android.support:cardview-v7:23.2.1'</code></pre> 
