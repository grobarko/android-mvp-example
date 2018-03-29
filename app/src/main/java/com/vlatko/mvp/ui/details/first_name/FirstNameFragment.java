package com.vlatko.mvp.ui.details.first_name;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vlatko.mvp.R;
import com.vlatko.mvp.ui.base.BaseViewFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class FirstNameFragment extends BaseViewFragment<FirstNameContract.Presenter>
        implements FirstNameContract.View {

    public static FirstNameFragment newInstance() {
        return new FirstNameFragment();
    }

    @BindView(R.id.tvFirstName)
    TextView tvFirstName;

    @BindView(R.id.etFirstNameExtra)
    TextInputEditText etFirstNameExtra;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first_name, container, false);
    }

    @Override
    public void setFirstName(String firstName) {
        tvFirstName.setText(firstName);
    }

    @OnClick(R.id.btnGoToLastName)
    public void onGoToLastNameClicked() {
        presenter.onGoToLastNameClicked(etFirstNameExtra.getText().toString());
    }
}
