package com.vlatko.mvp.ui.details.last_name;

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

public class LastNameFragment extends BaseViewFragment<LastNameContract.Presenter>
        implements LastNameContract.View {

    public static LastNameFragment newInstance() {
        return new LastNameFragment();
    }

    @BindView(R.id.tvLastName)
    TextView tvLastName;

    @BindView(R.id.etLastNameExtra)
    TextInputEditText etLastNameExtra;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_last_name, container, false);
    }

    @Override
    public void setLastName(String lastName) {
        tvLastName.setText(lastName);
    }

    @OnClick(R.id.btnGoToSummary)
    public void onGoToSummaryClicked() {
        presenter.onGoToSummaryClicked(etLastNameExtra.getText().toString());
    }
}
