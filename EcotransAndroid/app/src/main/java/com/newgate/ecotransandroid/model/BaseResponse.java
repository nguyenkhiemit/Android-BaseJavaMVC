package com.newgate.ecotransandroid.model;

import com.google.gson.annotations.SerializedName;

public class BaseResponse {

    @SerializedName("success")
    private Boolean success;

    @SerializedName("message")
    private String message;

    public Boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
