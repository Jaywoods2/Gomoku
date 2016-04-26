package com.example.wuziqi2;

import com.example.ani.MyImageView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{
	private MyImageView left_top;
	private MyImageView left_bottom;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initView();
		initEvent();
	}

	public void initView(){
		left_top=(MyImageView) findViewById(R.id.left_top);
		left_bottom=(MyImageView) findViewById(R.id.left_bottom);
	}
	
	public void initEvent(){
		left_top.setOnClickListener(this);
		left_bottom.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.left_top:
			startActivity(new Intent(MainActivity.this,SelectDSActivity.class));
			break;
		case R.id.left_bottom:
			startActivity(new Intent(MainActivity.this,ManManActivity.class));
			break;
		}
	}

	
	
}
