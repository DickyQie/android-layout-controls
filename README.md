# 自定义Dialog之信息提示
  <div class="blog-body" id="blogBody">
                                    <val data-name="blog_content_type" data-value="richtext"></val>
                    <div class='BlogContent'>
                        <p>对话框对于应用也是必不可少的一个组件，在Android中也不例外，对话框对于一些提示重要信息，或者一些需要用户额外交互的一些内容很有帮助。</p> 
<p>自定义Dialog步骤：&nbsp;<br> 1、主要创建Java类,并继承Dialog&nbsp;<br> 2、创建布局文件来加载和一些样式文件</p> 
<p>效果图：&nbsp;</p> 
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<img alt="" height="345" src="https://static.oschina.net/uploads/space/2016/1209/143344_NU0j_2945455.png" width="299"></p> 
<p>DialogBox.java</p> 
<pre><code class="language-java">public class DialogBox extends Dialog {

	public DialogBox(Context context) {
		super(context);
	}

	public DialogBox(Context context, int theme) {
		super(context, theme);
	}

	public static class Builder {
		private Context context;
		private String title;
		private String message;
		private String positiveButtonText;
		private String negativeButtonText;
		private View contentView;
		private DialogInterface.OnClickListener positiveButtonClickListener;
		private DialogInterface.OnClickListener negativeButtonClickListener;

		public Builder(Context context) {
			this.context = context;
		}

		public Builder setMessage(String message) {
			this.message = message;
			return this;
		}

		/**
		 * Set the Dialog message from resource
		 * 
		 * @param title
		 * @return
		 */
		public Builder setMessage(int message) {
			this.message = (String) context.getText(message);
			return this;
		}

		/**
		 * Set the Dialog title from resource
		 * 
		 * @param title
		 * @return
		 */
		public Builder setTitle(int title) {
			this.title = (String) context.getText(title);
			return this;
		}

		/**
		 * Set the Dialog title from String
		 * 
		 * @param title
		 * @return
		 */

		public Builder setTitle(String title) {
			this.title = title;
			return this;
		}

		public Builder setContentView(View v) {
			this.contentView = v;
			return this;
		}

		/**
		 * Set the positive button resource and it's listener
		 * 
		 * @param positiveButtonText
		 * @return
		 */
		public Builder setPositiveButton(int positiveButtonText,
				DialogInterface.OnClickListener listener) {
			this.positiveButtonText = (String) context
					.getText(positiveButtonText);
			this.positiveButtonClickListener = listener;
			return this;
		}

		public Builder setPositiveButton(String positiveButtonText,
				DialogInterface.OnClickListener listener) {
			this.positiveButtonText = positiveButtonText;
			this.positiveButtonClickListener = listener;
			return this;
		}

		public Builder setNegativeButton(int negativeButtonText,
				DialogInterface.OnClickListener listener) {
			this.negativeButtonText = (String) context
					.getText(negativeButtonText);
			this.negativeButtonClickListener = listener;
			return this;
		}

		public Builder setNegativeButton(String negativeButtonText,
				DialogInterface.OnClickListener listener) {
			this.negativeButtonText = negativeButtonText;
			this.negativeButtonClickListener = listener;
			return this;
		}

		public DialogBox create() {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			final DialogBox dialog = new DialogBox(context, R.style.Dialog);
			View layout = inflater.inflate(R.layout.dialog_normal_layout, null);
			dialog.addContentView(layout, new LayoutParams(
					LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
			((TextView) layout.findViewById(R.id.title)).setText(title);
			if (positiveButtonText != null) {
				((Button) layout.findViewById(R.id.positiveButton))
						.setText(positiveButtonText);
				if (positiveButtonClickListener != null) {
					((Button) layout.findViewById(R.id.positiveButton))
							.setOnClickListener(new View.OnClickListener() {
								public void onClick(View v) {
									positiveButtonClickListener.onClick(dialog,
											DialogInterface.BUTTON_POSITIVE);
								}
							});
				}
			} else {
				layout.findViewById(R.id.positiveButton).setVisibility(
						View.GONE);
			}
			if (negativeButtonText != null) {
				((Button) layout.findViewById(R.id.negativeButton))
						.setText(negativeButtonText);
				if (negativeButtonClickListener != null) {
					((Button) layout.findViewById(R.id.negativeButton))
							.setOnClickListener(new View.OnClickListener() {
								public void onClick(View v) {
									negativeButtonClickListener.onClick(dialog,
											DialogInterface.BUTTON_NEGATIVE);
								}
							});
				}
			} else {
				layout.findViewById(R.id.negativeButton).setVisibility(
						View.GONE);
			}
			if (message != null) {
				((TextView) layout.findViewById(R.id.message)).setText(message);
			} else if (contentView != null) {
				((LinearLayout) layout.findViewById(R.id.content))
						.removeAllViews();
				((LinearLayout) layout.findViewById(R.id.content)).addView(
						contentView, new LayoutParams(LayoutParams.FILL_PARENT,
								LayoutParams.FILL_PARENT));
			}
			dialog.setContentView(layout);
			return dialog;
		}

	}
}
</code></pre> 
<p>自定义View的布局文件：</p> 
<pre><code class="language-html">&lt;?xml version="1.0" encoding="utf-8"?&gt;
&lt;FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:clickable="true"
    android:orientation="vertical"
    android:padding="20.0dip" &gt;

    &lt;LinearLayout
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:background="#FA90BC"
        android:orientation="vertical" &gt;

        &lt;TextView
            android:id="@+id/title"
            style="@style/text_18_ffffff"
            android:layout_width="fill_parent"
            android:layout_height="40.0dip"
            android:gravity="center"
            android:text="提示"
            android:visibility="visible" /&gt;

        &lt;LinearLayout
            android:id="@+id/content"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:background="#ffffff"
            android:gravity="center" &gt;

            &lt;TextView
                android:id="@+id/message"
                style="@style/text_16_666666"
                android:layout_width="fill_parent"
                android:layout_height="wrap_content"
                android:gravity="left|center"
                android:lineSpacingMultiplier="1.5"
                android:minHeight="65.0dip"
                android:paddingBottom="15.0dip"
                android:paddingLeft="20.0dip"
                android:paddingRight="20.0dip"
                android:paddingTop="15.0dip" /&gt;
        &lt;/LinearLayout&gt;

        &lt;View
            android:layout_width="fill_parent"
            android:layout_height="1.0px"
            android:background="#ffd0d0d0" /&gt;

        &lt;LinearLayout
            android:layout_width="fill_parent"
            android:layout_height="60.0dip"
            android:layout_gravity="bottom"
            android:background="@drawable/dialog_bottom_bg"
            android:gravity="center"
            android:orientation="horizontal" &gt;

            &lt;Button
                android:id="@+id/positiveButton"
                style="@style/text_15_ffffff_sdw"
                android:layout_width="114.0dip"
                android:layout_height="40.0dip"
                android:background="#FA90BC"
                android:gravity="center"
                android:text="确定" /&gt;

            &lt;Button
                android:id="@+id/negativeButton"
                style="@style/text_15_666666_sdw"
                android:layout_width="114.0dip"
                android:layout_height="40.0dip"
                android:layout_marginLeft="20.0dip"
                android:background="#ffffff"
                android:gravity="center"
                android:text="取消" /&gt;
        &lt;/LinearLayout&gt;
    &lt;/LinearLayout&gt;

&lt;/FrameLayout&gt;</code></pre> 
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
