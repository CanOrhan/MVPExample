package uk.co.kiwisoft.mvpexample;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FeaturePresenterTest {

    private FeaturePresenter sut;
    private FeatureContract.View view;

    @Before
    public void setUp() {
        sut = new FeaturePresenter();
        view = mock(FeatureContract.View.class);
        sut.attachView(view);
    }

    @Test
    public void textChanged_textIsEmpty_callViewToDisableButton() {
        sut.textChanged("");

        verify(view).disableButton();
    }

    @Test
    public void textChanged_textIsNotEmpty_callViewToEnableButton() {
        sut.textChanged("HELLO WORLD");

        verify(view).enableButton();
    }
}