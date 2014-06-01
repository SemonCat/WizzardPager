package com.semoncat.wizzardpager.model;

import android.app.Fragment;
import com.semoncat.wizzardpager.ui.NumberFragment;
import com.semoncat.wizzardpager.ui.PageFragmentCallbacks;

public class NumberPage extends TextPage {

	public NumberPage(PageFragmentCallbacks mPageFragmentCallbacks,ModelCallbacks callbacks, String title) {
		super(mPageFragmentCallbacks,callbacks, title);
	}

	@Override
	public Fragment createFragment() {
		return NumberFragment.create(getKey(), getPageFragmentCallbacks());
	}

}
