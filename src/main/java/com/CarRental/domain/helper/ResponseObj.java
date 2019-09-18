package com.CarRental.domain.helper;

public class ResponseObj {
    private String responseCode, responseDescription;
    private Object responseBody;

    public ResponseObj(String responseCode, String responseDescription/*, Object responseBody*/) {
        this.responseCode = responseCode;
        this.responseDescription = responseDescription;
        //this.responseBody = responseBody;
    }

    /*public ResponseObj(String responseCode, String responseDescription) {
    }*/

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseDescription() {
        return responseDescription;
    }

    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
    }

    public Object getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(Object responseBody) {
        this.responseBody = responseBody;
    }



    @Override
    public String toString() {
        return "ResponseObj{" +
                "responseCode='" + responseCode + '\'' +
                ", responseDescription='" + responseDescription + '\'' +
                ", responseBody=" + responseBody +
                '}';
    }
}
