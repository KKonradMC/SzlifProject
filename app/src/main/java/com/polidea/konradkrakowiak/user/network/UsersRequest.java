package com.polidea.konradkrakowiak.user.network;

import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;
import com.polidea.konradkrakowiak.user.model.Order;
import com.polidea.konradkrakowiak.user.model.Sort;
import com.polidea.konradkrakowiak.user.model.UserList;
import java.util.Date;

public class UsersRequest extends RetrofitSpiceRequest<UserList, UserApiClient> {

    private static final String SIDE = "stackoverflow";
    private final Integer page;

    private final Integer pagesize;

    private final Date fromdate;

    private final Date todate;

    private final Order order;

    private final Integer min;

    private final Integer max;

    private final Sort sort;

    private final String inname;

    private UsersRequest(Builder builder) {
        super(UserList.class, UserApiClient.class);
        page = builder.page;
        pagesize = builder.pagesize;
        fromdate = builder.fromdate;
        todate = builder.todate;
        order  = builder.order;
        min = builder.min;
        max = builder.max;
        sort = builder.sort;
        inname = builder.inname;
    }

    @Override
    public UserList loadDataFromNetwork() throws Exception {
        return getService().getUsers(page, pagesize, fromdate, todate, order, min, max, sort, inname, SIDE);
    }

    public static class Builder {

        private Integer page;

        private Integer pagesize;

        private Date fromdate;

        private Date todate;

        private final Order order;

        private Integer min;

        private Integer max;

        private final Sort sort;

        private String inname;

        public Builder(Order order, Sort sort){
            this.order = order;
            this.sort = sort;
        }

        public Builder setPage(Integer page){
            this.page = page;
            return this;
        }
        public Builder setPageSize(Integer pagesize){
            this.pagesize = pagesize;
            return this;
        }
        public Builder setFromDate(Date fromdate){
            this.fromdate = fromdate;
            return this;
        }
        public Builder setToDate(Date todate){
            this.todate = todate;
            return this;
        }
        public Builder setMin(Integer min){
            this.min = min;
            return this;
        }
        public Builder setMax(Integer max){
            this.max = max;
            return this;
        }
        public Builder setInName(String inname){
            this.inname = inname;
            return this;
        }

        public UsersRequest build(){
            return new UsersRequest(this);
        }
    }
}
