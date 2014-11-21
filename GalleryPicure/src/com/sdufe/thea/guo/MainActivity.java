package com.sdufe.thea.guo;

import java.util.ArrayList;
import java.util.List;

import com.sdufe.thea.guo.adapter.PictureAdapter;
import com.sdufe.thea.guo.model.GalleryModel;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Gallery;

public class MainActivity extends Activity {

	private Gallery gallery;
	private PictureAdapter adapter;
	private List<GalleryModel> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initData();
		initView();
	}

	private void initView() {
		gallery = (Gallery) findViewById(R.id.gallery);
		adapter = new PictureAdapter(this, list);

		gallery.setAdapter(adapter);


		gallery.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				adapter.setSelectItem(position);
				// ScaleAnimation animation = new ScaleAnimation(1, 1.5f, 1,
				// 1.5f,
				// Animation.RELATIVE_TO_SELF, 0.5f,
				// Animation.RELATIVE_TO_SELF, 0.5f);
				// animation.setDuration(2000);
				// view.startAnimation(animation);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
	}

	private void initData() {
		list = new ArrayList<GalleryModel>();

		list.add(new GalleryModel(R.drawable.one_select, "房产交易"));
		list.add(new GalleryModel(R.drawable.two_select, "附近洗车店"));
		list.add(new GalleryModel(R.drawable.three_select, "社区商城"));
	}

}
