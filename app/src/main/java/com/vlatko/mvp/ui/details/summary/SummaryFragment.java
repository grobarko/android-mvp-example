package com.vlatko.mvp.ui.details.summary;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vlatko.mvp.R;
import com.vlatko.mvp.ui.base.BaseViewFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class SummaryFragment extends BaseViewFragment<SummaryContract.Presenter>
        implements SummaryContract.View {

    public static SummaryFragment newInstance() {
        return new SummaryFragment();
    }

    @BindView(R.id.tvMessage)
    TextView tvMessage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_summary, container, false);
    }

    @Override
    public void setMessage(String message) {
        tvMessage.setText(message);
    }

    @OnClick(R.id.btnReset)
    public void onResetClicked() {
        presenter.onResetClicked();
    }
}
