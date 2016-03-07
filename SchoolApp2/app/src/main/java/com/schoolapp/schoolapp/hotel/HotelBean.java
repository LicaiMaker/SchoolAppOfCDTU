package com.schoolapp.schoolapp.hotel;

/**
 * Created by LiCai on 2015/12/7.
 */
public class HotelBean {
    private int hotalImageId;
    private String hotalName;
    private String hotalService;
    private String hotalServiceprice;
    private String hotalLocation;
    private String hotalPhone;
    private String hotalPrice;
    private String hotalDistance;

    public HotelBean() {
    }

    public HotelBean(int hotalImageId, String hotalName, String hotalService,
                 String hotalServiceprice, String hotalLocation, String hotalPhone,
                 String hotalPrice, String hotalDistance) {
        super();
        this.hotalImageId = hotalImageId;
        this.hotalName = hotalName;
        this.hotalService = hotalService;
        this.hotalServiceprice = hotalServiceprice;
        this.hotalLocation = hotalLocation;
        this.hotalPhone = hotalPhone;
        this.hotalPrice = hotalPrice;
        this.hotalDistance = hotalDistance;
    }

    public int getHotalImageId() {
        return hotalImageId;
    }

    public void setHotalImageId(int hotalImageId) {
        this.hotalImageId = hotalImageId;
    }

    public String getHotalName() {
        return hotalName;
    }

    public void setHotalName(String hotalName) {
        this.hotalName = hotalName;
    }

    public String getHotalService() {
        return hotalService;
    }

    public void setHotalService(String hotalService) {
        this.hotalService = hotalService;
    }

    public String getHotalServiceprice() {
        return hotalServiceprice;
    }

    public void setHotalServiceprice(String hotalServiceprice) {
        this.hotalServiceprice = hotalServiceprice;
    }

    public String getHotalLocation() {
        return hotalLocation;
    }

    public void setHotalLocation(String hotalLocation) {
        this.hotalLocation = hotalLocation;
    }

    public String getHotalPhone() {
        return hotalPhone;
    }

    public void setHotalPhone(String hotalPhone) {
        this.hotalPhone = hotalPhone;
    }

    public String getHotalPrice() {
        return hotalPrice;
    }

    public void setHotalPrice(String hotalPrice) {
        this.hotalPrice = hotalPrice;
    }

    public String getHotalDistance() {
        return hotalDistance;
    }

    public void setHotalDistance(String hotalDistance) {
        this.hotalDistance = hotalDistance;
    }

}
