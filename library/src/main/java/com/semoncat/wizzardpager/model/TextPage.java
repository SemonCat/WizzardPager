package com.semoncat.wizzardpager.model;

import android.app.Fragment;
import android.text.TextUtils;
import com.semoncat.wizzardpager.ui.PageFragmentCallbacks;
import com.semoncat.wizzardpager.ui.TextFragment;

import java.util.ArrayList;

public class TextPage extends Page {

	public TextPage(PageFragmentCallbacks mPageFragmentCallbacks,ModelCallbacks callbacks, String title) {
		super(mPageFragmentCallbacks,callbacks, title);
	}

	@Override
	public Fragment createFragment() {
		return TextFragment.create(getKey(), getPageFragmentCallbacks());
	}

	@Override
	public void getReviewItems(ArrayList<ReviewItem> dest) {
		dest.add(new ReviewItem(getTitle(), mData.getString(SIMPLE_DATA_KEY),
				getKey()));

	}

	@Override
	public boolean isCompleted() {
		return !TextUtils.isEmpty(mData.getString(SIMPLE_DATA_KEY));
	}

	public TextPage setValue(String value) {
		mData.putString(SIMPLE_DATA_KEY, value);
		return this;
	}
}
