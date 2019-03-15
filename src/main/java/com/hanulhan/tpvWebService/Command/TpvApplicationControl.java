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
public class TpvApplicationControl extends TpvBaseCommand {

    private CommandDetails commandDetailsObject;

    private class CommandDetails {

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

        @Override
        public String toString() {
            return "CommandDetails{" + "ActiveApplications=" + ActiveApplications + ", webServiceParametersObject=" + webServiceParametersObject + '}';
        }
    }

    public CommandDetails getCommandDetailsObject() {
        return commandDetailsObject;
    }

    public void setCommandDetailsObject(CommandDetails commandDetailsObject) {
        this.commandDetailsObject = commandDetailsObject;
    }

    @Override
    public String toString() {
        return "tpvApplicationControl{" + "commandDetailsObject=" + commandDetailsObject + '}';
    }

    
    
}
