package com.polidea.konradkrakowiak.user.network;

import com.polidea.konradkrakowiak.user.model.Order;
import com.polidea.konradkrakowiak.user.model.Sort;
import com.polidea.konradkrakowiak.user.model.UserList;
import java.util.Date;
import retrofit.http.GET;
import retrofit.http.Query;

public interface UserApiClient {


    @GET("/2.2/users")
    UserList getUsers(@Query("page") Integer page,
                      @Query("pagesize") Integer pagesize,
                      @Query("fromdate") Date fromdate,
                      @Query("todate") Date todate,
                      @Query("order") Order order,
                      @Query("min") Integer min,
                      @Query("max") Integer max,
                      @Query("sort") Sort sort,
                      @Query("inname") String inname,
                      @Query("site") String site);
}
