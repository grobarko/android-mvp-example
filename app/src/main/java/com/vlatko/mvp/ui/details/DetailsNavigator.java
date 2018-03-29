package com.vlatko.mvp.ui.details;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.vlatko.mvp.di.ActivityFragmentManager;
import com.vlatko.mvp.di.PerActivity;
import com.vlatko.mvp.ui.base.BaseNavigator;
import com.vlatko.mvp.ui.details.first_name.FirstNameFragment;
import com.vlatko.mvp.ui.details.last_name.LastNameFragment;
import com.vlatko.mvp.ui.details.summary.SummaryFragment;

import javax.inject.Inject;

@PerActivity
public class DetailsNavigator extends BaseNavigator implements DetailsContract.Navigator {

    @ActivityFragmentManager
    private final FragmentManager fragmentManager;

    @Inject
    DetailsNavigator(AppCompatActivity activity,
            @ActivityFragmentManager FragmentManager fragmentManager) {
        super(activity);
        this.fragmentManager = fragmentManager;
    }

    @Override
    public void goToFirstName(int containerViewId, boolean clearBackStack) {
        if (clearBackStack) {
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
        fragmentManager.beginTransaction()
                .replace(containerViewId, FirstNameFragment.newInstance())
                .commit();
    }

    @Override
    public void goToLastName(int containerViewId) {
        fragmentManager.beginTransaction()
                .replace(containerViewId, LastNameFragment.newInstance())
                .addToBackStack(LastNameFragment.class.getSimpleName())
                .commit();
    }

    @Override
    public void goToSummary(int containerViewId) {
        fragmentManager.beginTransaction()
                .replace(containerViewId, SummaryFragment.newInstance())
                .addToBackStack(SummaryFragment.class.getSimpleName())
                .commit();
    }
}
