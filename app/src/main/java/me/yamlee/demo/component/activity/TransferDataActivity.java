package me.yamlee.demo.component.activity;

import android.annotation.SuppressLint;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import me.yamlee.demo.BaseActivity;
import me.yamlee.demo.R;

public class TransferDataActivity extends BaseActivity {
	
	
	private EditText inputEt = null;
	public static String staticTextString = "";
	private static final String Tag = "TransferDataActivity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_base);
//		setShowCodeFragment(new TransferDataFunctionFragment());
		setShowFunctionFragment(new TransferDataFunctionFragment());
		setShowCodeFragment(new TransferDataCodeFragment());
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		Log.i("lee", "activity onactivityResult--" + "requestcode----" + requestCode + "  resultcode--" + resultCode);
	}

	@SuppressLint("ValidFragment")
    public  class TransferDataFunctionFragment extends BaseShowFunctionFragment{
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View  view = inflater.inflate(R.layout.activity_transferdata_a, null);
			Button intentBtn = (Button) view.findViewById(R.id.btn_transferdata_a_intent);
			intentBtn.setOnClickListener(new myListener());
			Button staticBtn = (Button) view.findViewById(R.id.btn_transferdata_a_staticfield);
			staticBtn.setOnClickListener(new myListener());
			Button clipboardBtn = (Button) view.findViewById(R.id.btn_transferdata_a_clipboard);
			clipboardBtn.setOnClickListener(new myListener());
			inputEt = (EditText) view.findViewById(R.id.tv_transferdata_a_input);
			return view;
		}

		@Override
		public void onActivityResult(int requestCode, int resultCode, Intent data) {
			Log.i("lee", "fragment onactivityresult---" + "requestcode:" + requestCode + "  resultcode---" + resultCode);
			super.onActivityResult(requestCode, resultCode, data);
		}
	}
	
	@SuppressLint("ValidFragment")
    public class TransferDataCodeFragment extends BaseShowCodeFragment{
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View view = inflater.inflate(R.layout.activity_transferdata_a_code, null);
			WebView codeWv = (WebView) view.findViewById(R.id.tv_activity_transferdata_code);
			WebSettings wSet = codeWv.getSettings();     
		     wSet.setJavaScriptEnabled(true);    
		     codeWv.loadUrl("http://note.youdao.com/share/?id=7f81e8027a8fa1e373e57f6e13821385&type=note");
			
			return view;
		}
	}

	
	class myListener implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			if (v.getId() == R.id.btn_transferdata_a_clipboard) {
				transferDataByClicpBoard();
				Intent intent = new Intent(TransferDataActivity.this, TransferDataActivityB.class);
				intent.setFlags(TransferDataActivityB.TRANSFER_DATA_CLIP_BOARD);
//				startActivity(intent);
				startActivityForResult(intent,1111);
			}
			if (v.getId() == R.id.btn_transferdata_a_intent) {
				trasferDataByIntent();

			}
			if (v.getId() == R.id.btn_transferdata_a_staticfield) {
				trasferDataByIntent();
				Intent intent = new Intent(TransferDataActivity.this, TransferDataActivityB.class);
				intent.setFlags(TransferDataActivityB.TRANSFER_DATA_STATIC_FIELD);
//				startActivity(intent);
				startActivityForResult(intent,1111);
			}
			
		}
		
	}

	public void trasferDataByIntent(){
			String inputTextString = inputEt.getText().toString();
			Intent intet = new Intent();
			intet.setClass(TransferDataActivity.this, TransferDataActivityB.class);
			intet.setFlags(TransferDataActivityB.TRANSFER_DATA_INTENT);
			intet.putExtra("key",inputTextString);
			startActivity(intet);
		
	}
	
	@SuppressWarnings("deprecation")
	public void transferDataByClicpBoard(){
			ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
			clipboardManager.setText(inputEt.getText().toString());
	}

	public void transferDataByStatic(){
		staticTextString = inputEt.getText().toString();
	}
	
	 public String getFromAssets(String fileName){ 
         try { 
              InputStreamReader inputReader = new InputStreamReader( getResources().getAssets().open(fileName) ); 
             BufferedReader bufReader = new BufferedReader(inputReader);
             String line="";
             String Result="";
             while((line = bufReader.readLine()) != null)
                 Result += line;
             return Result;
         } catch (Exception e) { 
             e.printStackTrace(); 
         }
         return null;
	 } 

	

	
	
}
