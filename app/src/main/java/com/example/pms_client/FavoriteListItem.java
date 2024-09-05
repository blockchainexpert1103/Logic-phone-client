package com.example.pms_client;

public class FavoriteListItem {

    private String name = "";
    private String phone = "";
    private String phoneTitle = "";
    private int color = 0;

    public FavoriteListItem(String name, String phone, String phoneTitle, int color) {

        this.name = name;
        this.phone = phone;
        this.phoneTitle = phoneTitle;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getNickName() {
        return name.substring(0, 1);
    }

    public String getPhone() {
        return phone;
    }

    public String getPhoneTitle() {
        return phoneTitle;
    }

    public int getIconColor() {
        return color;
    }
}
