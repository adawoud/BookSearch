package com.odinuts.booksearch.data.request;

import com.odinuts.booksearch.data.response.Response;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BooksService {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/books/v1/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build();

    @GET("volumes")
    Call<Response> getBook(@Query("q") String isbn, @Query("key") String key);
}
