package com.polidea.konradkrakowiak.user.network;

import com.polidea.konradkrakowiak.user.model.Order;
import com.polidea.konradkrakowiak.user.model.Sort;
import com.polidea.konradkrakowiak.user.model.UserList;
import java.util.Date;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Retrofit;

public class UsersRequest {

    private static final String SIDE = "stackoverflow";

    private Integer page;

    private Integer pagesize;

    private Date fromdate;

    private Date todate;

    private Order order = Order.asc;

    private Integer min;

    private Integer max;

    private Sort sort = Sort.creation;

    private String inname;

    @Inject
    Retrofit retrofit;

    @Inject
    UsersRequest() {
    }

    public Call<UserList> callUserReqquest() {
        return retrofit.create(UserApiClient.class).getUsers(page, pagesize, fromdate, todate, order, min, max, sort, inname, SIDE);
    }


    public UsersRequest setSort(Sort sort) {
        this.sort = sort;
        return this;
    }

    public UsersRequest setOrder(Order order) {
        this.order = order;
        return this;
    }


    public UsersRequest setPage(Integer page) {
        this.page = page;
        return this;
    }

    public UsersRequest setPageSize(Integer pagesize) {
        this.pagesize = pagesize;
        return this;
    }

    public UsersRequest setFromDate(Date fromdate) {
        this.fromdate = fromdate;
        return this;
    }

    public UsersRequest setToDate(Date todate) {
        this.todate = todate;
        return this;
    }

    public UsersRequest setMin(Integer min) {
        this.min = min;
        return this;
    }

    public UsersRequest setMax(Integer max) {
        this.max = max;
        return this;
    }

    public UsersRequest setInName(String inname) {
        this.inname = inname;
        return this;
    }
}
