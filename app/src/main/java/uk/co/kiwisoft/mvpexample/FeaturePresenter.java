package uk.co.kiwisoft.mvpexample;

import java.lang.ref.WeakReference;

public class FeaturePresenter implements FeatureContract.Presenter {
    private WeakReference<FeatureContract.View> viewReference;

    @Override
    public void attachView(FeatureContract.View view) {
        viewReference = new WeakReference<>(view);
    }

    @Override
    public void textChanged(String newText) {
        if (newText.isEmpty()) {
            viewReference.get().disableButton();
        } else {
            viewReference.get().enableButton();
        }
    }
}
