package com.vlatko.mvp.ui.login;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;

import com.vlatko.mvp.R;
import com.vlatko.mvp.ui.base.BaseViewActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseViewActivity<LoginContract.Presenter> implements
        LoginContract.View {

    @BindView(R.id.etUsername)
    TextInputEditText etUsername;

    @BindView(R.id.tilPassword)
    TextInputLayout tilPassword;

    @BindView(R.id.etPassword)
    TextInputEditText etPassword;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    public void clearPassword() {
        etPassword.setText(null);
    }

    @Override
    public void setErrorMessage(String errorMessage) {
        tilPassword.setError(errorMessage);
    }

    @OnClick(R.id.btnLogin)
    public void onLoginClicked() {
        presenter.onLoginClicked(etUsername.getText().toString(), etPassword.getText().toString());
    }
}
