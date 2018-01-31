### 自定义Dialog之信息提示
  <div class="blog-body" id="blogBody">
                                    <val data-name="blog_content_type" data-value="richtext"></val>
                    <div class='BlogContent'>
                        <p>对话框对于应用也是必不可少的一个组件，在Android中也不例外，对话框对于一些提示重要信息，或者一些需要用户额外交互的一些内容很有帮助。</p> 
<p>自定义Dialog步骤：&nbsp;<br> 1、主要创建Java类,并继承Dialog&nbsp;<br> 2、创建布局文件来加载和一些样式文件</p> 
<p>效果图：&nbsp;</p> 
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<img alt="" height="345" src="https://static.oschina.net/uploads/space/2016/1209/143344_NU0j_2945455.png" width="299"></p> 
<p>MainActivity.Java</p> 
<pre><code class="language-java">public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}


	public void showAlertDialog(View view) {

		DialogBox.Builder builder = new DialogBox.Builder(this);
		builder.setMessage("删除该商品？");
		builder.setTitle("温馨提示");
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				// 你的操作事项
			}
		});

		builder.setNegativeButton("取消",
				new android.content.DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});

		builder.create().show();

	}
}
</code></pre> 
<p>&nbsp;</p> 
