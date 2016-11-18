package com.example.codedemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
/****
 * 验证码
 * @author zq
 *
 */
public class MainActivity extends Activity {

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
}
