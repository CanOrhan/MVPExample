package uk.co.kiwisoft.mvpexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;

public class MainActivity extends AppCompatActivity implements FeatureContract.View {
    @BindView(R.id.button)
    Button button;

    public FeaturePresenter featurePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        featurePresenter = new FeaturePresenter();
        featurePresenter.attachView(this);

        ButterKnife.bind(this);
    }

    @OnTextChanged(R.id.editText)
    void textChanged(Editable editable) {
        featurePresenter.textChanged(editable.toString());
    }

    @Override
    public void enableButton() {
        button.setEnabled(true);
    }

    @Override
    public void disableButton() {
        button.setEnabled(false);
    }
}
