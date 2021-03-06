package me.yamlee.demo.component.activity;


import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import me.yamlee.demo.R;


public class TransferDataActivityB extends Activity{
	public static final int TRANSFER_DATA_INTENT = 0;
	public static final int TRANSFER_DATA_STATIC_FIELD = 1;
	public static final int TRANSFER_DATA_CLIP_BOARD = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_transferdata_b);
		setResult(Activity.RESULT_OK);
		TextView getTextView = (TextView) findViewById(R.id.tv_transferdata_b);
		if (getIntent().getFlags() == TRANSFER_DATA_INTENT) {
			getTextView.setText("ͨ��intent��ʽ������ݣ�"+getStrFromIntent());
		}
		if(getIntent().getFlags() == TRANSFER_DATA_STATIC_FIELD){
			getTextView.setText("ͨ��̬�����ķ�ʽ�յ����:"+getStrFromStatic());
		}
		if(getIntent().getFlags() == TRANSFER_DATA_CLIP_BOARD){
			getTextView.setText("ͨ��clicpboard��ʽ�յ����"+getStrFromClipBoard());
		}
	}
	
	private CharSequence getStrFromClipBoard() {
		ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
		@SuppressWarnings("deprecation")
		CharSequence text = clipboardManager.getText();
		return text;
		
	}

	private CharSequence getStrFromStatic() {
		String srtString = TransferDataActivity.staticTextString;
		
		return srtString;
	}

	public String getStrFromIntent(){
		Intent intent = getIntent();
		String string = intent.getStringExtra("key");
		return string;
	}

}
