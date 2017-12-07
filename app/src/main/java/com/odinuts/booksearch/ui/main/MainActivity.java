package com.odinuts.booksearch.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import com.odinuts.booksearch.R;
import com.odinuts.booksearch.data.response.Response;
import com.odinuts.booksearch.ui.capture.BarcodeCaptureActivity;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    private static final int RC_BARCODE_CAPTURE = 9001;

    private FloatingActionButton fab;
    private ProgressBar progressBar;
    private ImageView thumbnail;
    private TextView title;
    private TextView author;
    private TextView rating;
    private TextView description;
    private MainContract.MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenter(this);
        thumbnail = findViewById(R.id.iv_thumbnail);
        title = findViewById(R.id.tv_title);
        author = findViewById(R.id.tv_author);
        rating = findViewById(R.id.tv_average_rating);
        description = findViewById(R.id.tv_description);
        fab = findViewById(R.id.fab);
        progressBar = findViewById(R.id.pb_progress);
        fabOnClick();
    }

    private void fabOnClick() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BarcodeCaptureActivity.class);
                startActivityForResult(intent, RC_BARCODE_CAPTURE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RC_BARCODE_CAPTURE) {
            if (resultCode == CommonStatusCodes.SUCCESS) {
                if (data != null) {
                    Barcode barcode = data.getParcelableExtra(BarcodeCaptureActivity.BarcodeObject);
                    mainPresenter.search(barcode.displayValue,
                            getResources().getString(R.string.api_key));
                } else {
                    Snackbar.make(fab, R.string.barcode_failure, Snackbar.LENGTH_SHORT).show();
                }
            } else {
                Snackbar.make(fab, String.format(getString(R.string.barcode_error),
                        CommonStatusCodes.getStatusCodeString(resultCode)), Snackbar.LENGTH_SHORT)
                        .show();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void showLoading(boolean isLoading) {
        if (isLoading) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void handleSuccess(Response response) {

        if (response.getItems() != null || response.getItems().size() == 0) {
            Picasso.with(this)
                    .load(response.getItems().get(0).getVolumeInfo().getImageLinks().getThumbnail())
                    .into(thumbnail);
            title.setText(response.getItems().get(0).getVolumeInfo().getTitle());
            author.setText(response.getItems().get(0).getVolumeInfo().getAuthors().get(0));
            rating.setText(String.valueOf(response.getItems().get(0).getVolumeInfo().getAverageRating()));
            description.setText(response.getItems().get(0).getVolumeInfo().getDescription());
        } else {
            handleFailure("Can't find this book");
        }
    }

    @Override
    public void handleFailure(String message) {
        Snackbar.make(fab, message, Snackbar.LENGTH_SHORT).show();
    }
}