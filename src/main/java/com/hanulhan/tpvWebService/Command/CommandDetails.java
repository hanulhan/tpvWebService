/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hanulhan.tpvWebService.Command;

import java.util.ArrayList;

/**
 *
 * @author UHansen
 */
public class CommandDetails {

    private ArrayList< Object> ActiveApplications;
    private WebServiceParameters webServiceParametersObject;

    public CommandDetails() {
        super();
    }

    public ArrayList<Object> getActiveApplications() {
        return ActiveApplications;
    }

    public void setActiveApplications(ArrayList<Object> ActiveApplications) {
        this.ActiveApplications = ActiveApplications;
    }

    public WebServiceParameters getWebServiceParametersObject() {
        return webServiceParametersObject;
    }

    public void setWebServiceParametersObject(WebServiceParameters webServiceParametersObject) {
        this.webServiceParametersObject = webServiceParametersObject;
    }
    
    

}
