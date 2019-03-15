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
public class TpvCommand extends TpvBaseCommand{
    private CommandDetails commandDetailsObject;

    public TpvCommand() {
       super();
    }

    public CommandDetails getCommandDetailsObject() {
        return commandDetailsObject;
    }

    public void setCommandDetailsObject(CommandDetails commandDetailsObject) {
        this.commandDetailsObject = commandDetailsObject;
    }

    @Override
    public String toString() {
        return "tpvCommand{" + "commandDetailsObject=" + commandDetailsObject + '}';
    }
    
    
    
}
