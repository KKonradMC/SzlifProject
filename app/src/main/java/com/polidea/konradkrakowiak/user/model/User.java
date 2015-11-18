package com.polidea.konradkrakowiak.user.model;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import org.parceler.Parcel;

/**POJO for json like:
 *                                                                                                                   <br />
 *   {                                                                                                               <br />
 *       "badge_counts": {                                                                                           <br />
 *           ...                                                                                                     <br />
 *       },                                                                                                          <br />
 *       "account_id": 11683,                                                                                        <br />
 *       "is_employee": false,                                                                                       <br />
 *       "last_modified_date": 1426863582,                                                                           <br />
 *       "last_access_date": 1427096216,                                                                             <br />
 *       "reputation_change_year": 22917,                                                                            <br />
 *       "reputation_change_quarter": 22917,                                                                         <br />
 *       "reputation_change_month": 6492,                                                                            <br />
 *       "reputation_change_week": 400,                                                                              <br />
 *       "reputation_change_day": 155,                                                                               <br />
 *       "reputation": 762033,                                                                                       <br />
 *       "creation_date": 1222430705,                                                                                <br />
 *       "user_type": "registered",                                                                                  <br />
 *       "user_id": 22656,                                                                                           <br />
 *       "age": 38,                                                                                                  <br />
 *       "accept_rate": 83,                                                                                          <br />
 *       "location": "Reading, United Kingdom",                                                                      <br />
 *       "website_url": "http://csharpindepth.com",                                                                  <br />
 *       "link": "http://stackoverflow.com/users/22656/jon-skeet",                                                   <br />
 *       "display_name": "Jon Skeet",                                                                                <br />
 *       "profile_image": "https://www.gravatar.com/avatar/6d8ebb117e8d83d74ea95fbdd0f87e13?s=128&d=identicon&r=PG"  <br />
 *   }
 */

@Parcel
public class User {

    interface Metadata {
        String BADGE_COUNTS = "badge_counts";
        String ACCOUNT_ID ="account_id";
        String IS_EMPLOYEE ="is_employee";
        String LAST_MODIFIED_DATE ="last_modified_date";
        String LAST_ACCESS_DATE ="last_access_date";
        String REPUTATION_CHANGE_YEAR ="reputation_change_year";
        String REPUTATION_CHANGE_QUARTER ="reputation_change_quarter";
        String REPUTATION_CHANGE_MONTH ="reputation_change_month";
        String REPUTATION_CHANGE_WEEK ="reputation_change_week";
        String REPUTATION_CHANGE_DAY ="reputation_change_day";
        String REPUTATION ="reputation";
        String CREATION_DATE ="creation_date";
        String USER_TYPE ="user_type";
        String USER_ID ="user_id";
        String AGE ="age";
        String ACCEPT_RATE ="accept_rate";
        String LOCATION ="location";
        String WEBSITE_URL ="website_url";
        String LINK ="link";
        String DISPLAY_NAME ="display_name";
        String PROFILE_IMAGE ="profile_image";



    }

    @SerializedName(Metadata.BADGE_COUNTS)
    BadgeCounts badgeCounts;

    @SerializedName(Metadata.ACCOUNT_ID)
    long accountId;

    @SerializedName(Metadata.IS_EMPLOYEE)
    boolean isEmployee;

    @SerializedName(Metadata.LAST_MODIFIED_DATE)
    long lastModifiedDate;

    @SerializedName(Metadata.LAST_ACCESS_DATE)
    long lastAccessDate;

    @SerializedName(Metadata.REPUTATION_CHANGE_YEAR)
    int reputationChangeYear;

    @SerializedName(Metadata.REPUTATION_CHANGE_QUARTER)
    int reputationChangeQuarter;

    @SerializedName(Metadata.REPUTATION_CHANGE_MONTH)
    int reputationChangeMonth;

    @SerializedName(Metadata.REPUTATION_CHANGE_WEEK)
    int reputationChangeWeek;

    @SerializedName(Metadata.REPUTATION_CHANGE_DAY)
    int reputationChangeDay;

    @SerializedName(Metadata.REPUTATION)
    int reputation;

    @SerializedName(Metadata.CREATION_DATE)
    long creationDate;

    @SerializedName(Metadata.USER_TYPE)
    UserType userType;

    @SerializedName(Metadata.USER_ID)
    long userId;

    @SerializedName(Metadata.AGE)
    int age;

    @SerializedName(Metadata.ACCEPT_RATE)
    int acceptRate;

    @SerializedName(Metadata.LOCATION)
    String location;

    @SerializedName(Metadata.WEBSITE_URL)
    String websiteUrl;

    @SerializedName(Metadata.LINK)
    String link;

    @SerializedName(Metadata.DISPLAY_NAME)
    String displayName;

    @SerializedName(Metadata.PROFILE_IMAGE)
    String profileImage;


    public BadgeCounts getBadgeCounts() {
        return badgeCounts;
    }

    public long getAccountId() {
        return accountId;
    }

    public boolean isEmployee() {
        return isEmployee;
    }

    public long getLastModifiedDate() {
        return lastModifiedDate;
    }

    public long getLastAccessDate() {
        return lastAccessDate;
    }

    public int getReputationChangeYear() {
        return reputationChangeYear;
    }

    public int getReputationChangeQuarter() {
        return reputationChangeQuarter;
    }

    public int getReputationChangeMonth() {
        return reputationChangeMonth;
    }

    public int getReputationChangeWeek() {
        return reputationChangeWeek;
    }

    public int getReputationChangeDay() {
        return reputationChangeDay;
    }

    public int getReputation() {
        return reputation;
    }

    public long getCreationDate() {
        return creationDate;
    }

    public UserType getUserType() {
        return userType;
    }

    public long getUserId() {
        return userId;
    }

    public int getAge() {
        return age;
    }

    public int getAcceptRate() {
        return acceptRate;
    }

    public String getLocation() {
        return location;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public String getLink() {
        return link;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getProfileImage() {
        return profileImage;
    }
}
