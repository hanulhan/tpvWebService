/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hanulhan.tpvWebService.response;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author uli
 */
public class MultipartResponseList {
    private List<MultipartResponse> responseList = new ArrayList<>();

    public List<MultipartResponse> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<MultipartResponse> responseList) {
        this.responseList = responseList;
    }
    

    
    
}
