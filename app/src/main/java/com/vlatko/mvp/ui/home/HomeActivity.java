package com.vlatko.mvp.ui.home;

import android.widget.TextView;

import com.vlatko.mvp.R;
import com.vlatko.mvp.ui.base.BaseViewActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeActivity extends BaseViewActivity<HomeContract.Presenter> implements
        HomeContract.View {

    @BindView(R.id.tvMessage)
    TextView tvMessage;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_home;
    }

    @Override
    public void setMessage(String message) {
        tvMessage.setText(message);
    }

    @OnClick(R.id.btnGoToDetails)
    public void onGoToDetailsClicked() {
        presenter.onGoToDetailsClicked();
    }

    @OnClick(R.id.btnLogout)
    public void onLogoutClicked() {
        presenter.onLogoutClicked();
    }
}
