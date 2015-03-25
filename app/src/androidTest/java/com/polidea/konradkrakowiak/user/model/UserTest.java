package com.polidea.konradkrakowiak.user.model;


import android.os.Parcelable;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.parceler.Parcels;

public class UserTest extends TestCase {

    User user;

    @Override
    public void setUp() {
        user = new User();
        user.badgeCounts = new BadgeCounts();
        user.badgeCounts.gold = 1;
        user.badgeCounts.silver = 2;
        user.badgeCounts.bronze = 10;
        user.accountId = 100;
        user.isEmployee = false;
        user.lastModifiedDate = 1000l;
        user.lastAccessDate = 1001l;
        user.reputationChangeYear = 101;
        user.reputationChangeQuarter = 102;
        user.reputationChangeMonth = 103;
        user.reputationChangeWeek = 104;
        user.reputationChangeDay = 105;
        user.reputation = 22221;
        user.creationDate = 1005l;
        user.userType = UserType.REGISTERED;
        user.userId = 111111;
        user.age = 28;
        user.acceptRate = 12;
        user.location = "Poland, Warsaw";
        user.websiteUrl = "ouruser.com";
        user.displayName = "stackoverflow.com/user/12123/";
        user.displayName = "OurUser";
        user.profileImage = "test";
    }

    public void testParcelable() {
        Parcelable parcelable = Parcels.wrap(user);
        Assert.assertNotNull(parcelable);
    }


    public void testUnParcel() {
        Parcelable parcelable = Parcels.wrap(user);
        User user = Parcels.unwrap(parcelable);
        Assert.assertNotNull(user);
        Assert.assertEquals(user.badgeCounts.gold, this.user.badgeCounts.gold);
        Assert.assertEquals(user.badgeCounts.silver, this.user.badgeCounts.silver);
        Assert.assertEquals(user.badgeCounts.bronze, this.user.badgeCounts.bronze);
        Assert.assertEquals(user.accountId, this.user.accountId);
        Assert.assertEquals(user.isEmployee, this.user.isEmployee);
        Assert.assertEquals(user.lastModifiedDate, this.user.lastModifiedDate);
        Assert.assertEquals(user.lastAccessDate, this.user.lastAccessDate);
        Assert.assertEquals(user.reputationChangeYear, this.user.reputationChangeYear);
        Assert.assertEquals(user.reputationChangeQuarter, this.user.reputationChangeQuarter);
        Assert.assertEquals(user.reputationChangeMonth, this.user.reputationChangeMonth);
        Assert.assertEquals(user.reputationChangeWeek, this.user.reputationChangeWeek);
        Assert.assertEquals(user.reputationChangeDay, this.user.reputationChangeDay);
        Assert.assertEquals(user.reputation, this.user.reputation);
        Assert.assertEquals(user.creationDate, this.user.creationDate);
        Assert.assertEquals(user.userType, this.user.userType);
        Assert.assertEquals(user.userId, this.user.userId);
        Assert.assertEquals(user.age, this.user.age);
        Assert.assertEquals(user.acceptRate, this.user.acceptRate);
        Assert.assertEquals(user.location, this.user.location);
        Assert.assertEquals(user.websiteUrl, this.user.websiteUrl);
        Assert.assertEquals(user.link, this.user.link);
        Assert.assertEquals(user.displayName, this.user.displayName);
        Assert.assertEquals(user.profileImage, this.user.profileImage);
    }


}
