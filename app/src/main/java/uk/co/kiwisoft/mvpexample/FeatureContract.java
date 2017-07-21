package uk.co.kiwisoft.mvpexample;

public interface FeatureContract {
    interface View {
        void enableButton();
        void disableButton();
    }

    interface Presenter {
        void attachView(View view);
        void textChanged(String newText);
    }
}
