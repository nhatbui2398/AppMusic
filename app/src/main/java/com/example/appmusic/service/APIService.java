package com.example.appmusic.service;

public class APIService {
    private static final String base_url = "https://appmusicou.000webhostapp.com/server/";

    public static DataService getService(){
        return APIRetrofitClient.getClient(base_url).create(DataService.class);
    }
}
