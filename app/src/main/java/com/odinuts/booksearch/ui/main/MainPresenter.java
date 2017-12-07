package com.odinuts.booksearch.ui.main;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;


import com.odinuts.booksearch.data.request.BooksService;
import com.odinuts.booksearch.data.response.Response;

import retrofit2.Call;
import retrofit2.Callback;

public class MainPresenter implements MainContract.MainPresenter {
    private MainContract.View view;

    MainPresenter(@NonNull MainContract.View view) {
        this.view = view;
    }

    @Override
    public void search(String isbn, String key) {
        Call<Response> call = BooksService
                .retrofit
                .create(BooksService.class)
                .getBook(isbn, key);

        view.showLoading(true);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(@Nullable Call<Response> call,
                                   @Nullable retrofit2.Response<Response> response) {
                if (response != null && response.isSuccessful()) {
                    view.showLoading(false);
                    view.handleSuccess(response.body());
                }
            }

            @Override
            public void onFailure(@Nullable Call<Response> call,
                                  @Nullable Throwable t) {
                if (t != null) {
                    view.showLoading(false);
                    view.handleFailure(t.getMessage());
                }
            }
        });
    }
}
