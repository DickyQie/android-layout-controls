package com.example.dialogbox;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

/****
 * 
 * Dialog  温馨提示
 * 
 * @author zq
 *
 */
public class MainActivity extends Activity {

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
