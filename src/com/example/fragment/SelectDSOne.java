package com.example.fragment;


import com.example.wuziqi2.ManManActivity;
import com.example.wuziqi2.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

public class SelectDSOne extends Fragment {
	private ImageView easy_ds;
	private Context context;
	private View view;
	public SelectDSOne(Context context){
		this.context=context;
	}
@SuppressLint("InflateParams")
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	// TODO Auto-generated method stub//"@+id/easy_ds"
	 view=inflater.inflate(R.layout.select_ds_item1, null);	
	//initView();
	//initEvent();
	return view;
}
	public void initView(){
		easy_ds=(ImageView) view.findViewById(R.id.easy_ds);
	}
	public void initEvent(){
		easy_ds.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
