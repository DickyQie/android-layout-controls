# 验证码倒计时
  <div class="blog-body" id="blogBody">
                                    <val data-name="blog_content_type" data-value="richtext"></val>
                    <div class='BlogContent'>
                        <p>在我们注册或者修改信息的时候，常会用到60s倒计时这个功能，写了这篇文章，大家共享一下：</p> 
<p>效果图：</p> 
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<img alt="" height="233" src="https://static.oschina.net/uploads/space/2016/1118/101815_wEvl_2945455.gif" width="346"></p> 
<p>直接上代码：</p> 
<span id="OSC_h3_1"></span>
<h3>activity.java</h3> 
<pre><code class="language-java">public class MainActivity extends Activity {

	private TimeCount mTiemTimeCount;
	private TextView tv_code;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mTiemTimeCount = new TimeCount(60000, 1000);
		initView();

	}

	private void initView() {
		// TODO Auto-generated method stub
		tv_code = (TextView) findViewById(R.id.verify_code);
		tv_code.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mTiemTimeCount.start();
			}
		});
	}

	// 计时重发
	private class TimeCount extends CountDownTimer {

		public TimeCount(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);
		}

		@Override
		public void onTick(long millisUntilFinished) {
			tv_code.setClickable(false);
			tv_code.setText(millisUntilFinished / 1000 + "秒后重新发送");
		}

		@Override
		public void onFinish() {
			tv_code.setText("获取验证码");
			tv_code.setClickable(true);
		}
	}
	@Override
	protected void onDestroy() {
	    super.onDestroy();
	    mTiemTimeCount.cancel();
	}
}</code></pre> 
<p>&nbsp;</p> 
<pre>mTiemTimeCount = new TimeCount(60000, 1000);可以自己更改时间</pre> 
<p>代码简单可直接使用</p> 

