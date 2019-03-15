/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hanulhan.tpvWebService.Command;

/**
 *
 * @author UHansen
 */
public class TpvBaseCommand {
    protected String CmdType;
    protected int Cookie;
    protected String Fun;
    protected String Svc;
    protected String SvcVer;
    

    public String getCmdType() {
        return CmdType;
    }

    public void setCmdType(String CmdType) {
        this.CmdType = CmdType;
    }

    public int getCookie() {
        return Cookie;
    }

    public void setCookie(int Cookie) {
        this.Cookie = Cookie;
    }

    public String getFun() {
        return Fun;
    }

    public void setFun(String Fun) {
        this.Fun = Fun;
    }

    public String getSvc() {
        return Svc;
    }

    public void setSvc(String Svc) {
        this.Svc = Svc;
    }

    public String getSvcVer() {
        return SvcVer;
    }

    public void setSvcVer(String SvcVer) {
        this.SvcVer = SvcVer;
    }

    @Override
    public String toString() {
        return "tpvCommand{" + "CmdType=" + CmdType + ", Cookie=" + Cookie + ", Fun=" + Fun + ", Svc=" + Svc + ", SvcVer=" + SvcVer + '}';
    }

    
}
