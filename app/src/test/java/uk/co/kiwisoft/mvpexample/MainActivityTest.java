package uk.co.kiwisoft.mvpexample;

import android.text.Editable;
import android.view.View;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {
    private MainActivity sut;
    private FeaturePresenter featurePresenter;

    @Before
    public void setUp() throws Exception {
        sut = Robolectric.setupActivity(MainActivity.class);
        featurePresenter = mock(FeaturePresenter.class);
        sut.featurePresenter = featurePresenter;
    }

    @Test
    public void textChanged_updatePresenterWithNewText() throws Exception {
        String expectedString = "HELLO WORLD";
        Editable editable = Editable.Factory.getInstance().newEditable(expectedString);

        sut.textChanged(editable);

        verify(featurePresenter).textChanged(expectedString);
    }

    @Test
    public void enableButton() {
        sut.button.setEnabled(false);

        sut.enableButton();

        assertThat(sut.button.isEnabled()).isTrue();
    }

    @Test
    public void disableButton() {
        sut.button.setEnabled(true);

        sut.disableButton();

        assertThat(sut.button.isEnabled()).isFalse();
    }
}