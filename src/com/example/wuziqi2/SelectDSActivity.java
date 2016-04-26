package com.example.wuziqi2;

import java.util.ArrayList;
import java.util.List;

import com.example.fragment.SelectDSOne;
import com.example.fragment.SelectDSThree;
import com.example.fragment.SelectDSTwo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;

public class SelectDSActivity extends FragmentActivity {
	private LinearLayout viewPagerContainer;
	private ViewPager viewPager;	
	private List<Fragment> fl=new ArrayList<Fragment>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_ds);
		initView();
		initFragPage();
		setViewpagerEvent();
	}
	public void initView(){
		viewPager = (ViewPager) findViewById(R.id.select_dsvp);
		viewPagerContainer = (LinearLayout) findViewById(R.id.select_dslayout);		
	}

	public void initFragPage(){
		SelectDSOne one=new SelectDSOne(this);
		SelectDSTwo two=new SelectDSTwo();
		SelectDSThree three=new SelectDSThree();
		fl.add(one);
		fl.add(two);
		fl.add(three);
	}
	
	public void setViewpagerEvent(){
		viewPager.setOffscreenPageLimit(3);
		viewPager.setPageMargin(30);
		MyAdapter myadapter=new MyAdapter(getSupportFragmentManager());
		viewPager.setAdapter(myadapter);		
		/*MyOnPageChangeListener myOnPageChangeListener = new MyOnPageChangeListener();*/
		viewPagerContainer.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				return viewPager.dispatchTouchEvent(event);
			}
		});
		

	}
	/*class MyPagerAdapter extends PagerAdapter {
		@Override
		public int getCount() {
			return TOTAL_COUNT;
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return (view == object);
		}

		@Override

		public Object instantiateItem(ViewGroup container, int position) {

			ImageView imageView = new ImageView(SelectDSActivity.this);

			imageView.setImageResource(R.drawable.ai_1);
			((ViewPager) container).addView(imageView, position);
			return imageView;
		}

		@Override

		public void destroyItem(ViewGroup container, int position, Object object) {
			((ViewPager) container).removeView((ImageView) object);

		}

	}*/

	class MyAdapter extends FragmentPagerAdapter{
		
		public MyAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int arg0) {
			// TODO Auto-generated method stub
			return fl.get(arg0);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 3;
		}
		
		
	}
	/*public class MyOnPageChangeListener implements OnPageChangeListener {
		@Override
		public void onPageSelected(int position) {
		}

		@Override
		public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
			// to refresh frameLayout
			if (viewPagerContainer != null) {
				viewPagerContainer.invalidate();
			}
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
		}
	}
*/
}
