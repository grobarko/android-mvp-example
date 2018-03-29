package com.vlatko.mvp.ui.details;

import com.vlatko.mvp.R;
import com.vlatko.mvp.ui.base.BaseViewActivity;

public class DetailsActivity extends BaseViewActivity<DetailsContract.Presenter> implements
        DetailsContract.View {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_details;
    }
}
