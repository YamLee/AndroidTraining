package me.yamlee.demo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public abstract class BaseActivity extends Activity{
	
	protected View fragmentContent = null;
	protected Button functionBtn = null;
	protected Button codeBtn = null;
	private BaseShowFunctionFragment baseShowFunctionFragment = null;
	private BaseShowCodeFragment baseShowCodeFragment = null;
	
	private static final String Tag = "BaseActivity";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base);
		fragmentContent  = findViewById(R.id.content);
		functionBtn = (Button) findViewById(R.id.btn_baseactivity_show_funtion);
		codeBtn =(Button) findViewById(R.id.btn_baseactivity_show_code);
	
		
	}
	
	public void setShowFunctionFragment(BaseShowFunctionFragment bff){
		this.baseShowFunctionFragment = bff;
	}
	
	public void setShowCodeFragment(BaseShowCodeFragment bcf){
		this.baseShowCodeFragment = bcf;
	}
	
	
	public void onClick(View v){
		FragmentTransaction fTransaction = getFragmentManager().beginTransaction();
		if (v.getId() == functionBtn.getId()) {
			Log.i(Tag, "base showFunctionBtn clicked!");
			if(null == baseShowFunctionFragment){
				try {
					throw new Exception("fagmentΪ�գ������baseActivity�е�setShowFunctionFragment����");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			fTransaction.add(R.id.content, baseShowFunctionFragment);
//			fTransaction.add(baseShowFunctionFragment , "show_function_fragment");
		}
		if (v.getId() == codeBtn.getId()) {
			Log.i(Tag, "base showcodeBtn clicked!");
			if(null == baseShowCodeFragment){
				try {
					throw new Exception("fagmentΪ�գ������baseActivity�е�setShowCodeFragment����");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			fTransaction.add(R.id.content, baseShowCodeFragment);
		}
		
		fTransaction.commit();
	}
	
	
	
	@SuppressLint("ValidFragment")
    public class BaseShowFunctionFragment extends Fragment{

	}


	@SuppressLint("ValidFragment")
    public class BaseShowCodeFragment extends Fragment {

	}
	
	
	
}
