package com.odinuts.booksearch.ui.main;

import com.odinuts.booksearch.data.response.Response;

public interface MainContract {

    interface View {

        void showLoading(boolean isLoading);

        void handleSuccess(Response response);

        void handleFailure(String message);
    }

    interface MainPresenter {

        void search(String isbn, String key);
    }
}