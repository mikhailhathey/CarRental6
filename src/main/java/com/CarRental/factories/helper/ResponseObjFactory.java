package com.CarRental.factories.helper;

import com.CarRental.domain.helper.ResponseObj;

public class ResponseObjFactory {

    public static ResponseObj buildGenericResponseObj(String responseCode, String responseDescription){
        return new ResponseObj(responseCode, responseDescription);
    }
}
