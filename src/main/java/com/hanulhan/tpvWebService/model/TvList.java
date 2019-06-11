/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hanulhan.tpvWebService.model;

import com.hanulhan.tpvWebService.command.CommandDetails;
import com.hanulhan.tpvWebService.command.TpvCommand;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author uli
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class TvList {

    private Map<String, TvType> tvList = new HashMap<>();
    private static final Logger LOGGER = LogManager.getLogger(TvList.class);
    private static int instances = 0;

    public TvList() {
        TvList.instances++;
    }

    public void update(TpvCommand aCommand) {
        TvType myTv = null;
        String myUniqueId = null;
        CommandDetails myDetails = aCommand.getCommandDetails();

        if (myDetails.getWebServiceParameters() != null) {
            myUniqueId = myDetails.getWebServiceParameters().getTVUniqueID();
            myTv = new TvType(myUniqueId);
        } else if (myDetails.getWebListeningServiceParameters() != null) {
            myUniqueId = myDetails.getWebListeningServiceParameters().getTVUniqueID();
            myTv = new TvType(myUniqueId);
        }

        if (myDetails.gettVDiscoveryParameters() != null && myTv != null) {
            myTv.setPowerStatus(myDetails.gettVDiscoveryParameters().getPowerStatus());
            myTv.setTvIPAddress(myDetails.gettVDiscoveryParameters().getTVIPAddress());
            myTv.setTvModel(myDetails.gettVDiscoveryParameters().getTVModelNumber());
            myTv.setTvRoomID(myDetails.gettVDiscoveryParameters().getTVRoomID());
            //fStatusChanged = true;
        }
        if (myDetails.getCloneToServerParameters() != null && myTv != null) {
            myTv.setCloneToServerStatus(myDetails.getCloneToServerParameters().getCloneToServerStatus());
            myTv.setCloneToServerSessionStatus(myDetails.getCloneToServerParameters().getCloneToServerSessionStatus().getSessionStatus());
            //fStatusChanged = true;
        }

        if (myDetails.getiPCloneParameters() != null && myTv != null) {
            if (myDetails.getiPCloneParameters().getCurrentUpgradeStatus() != null) {
                myTv.setUpgradeStatus(myDetails.getiPCloneParameters().getCurrentUpgradeStatus());
            } else {
                myTv.setUpgradeStatus(null);
            }
            if (myDetails.getiPCloneParameters().getCloneSessionStatus() != null) {
                myTv.setUpgradeSessionStatus(myDetails.getiPCloneParameters().getCloneSessionStatus().getSessionStatus());
            } else {
                myTv.setUpgradeSessionStatus(null);
            }
            //fStatusChanged = true;
        }

        if (myUniqueId != null) {

            if (tvList.containsKey(myUniqueId)) {
                TvType tvInMap = tvList.get(myUniqueId);
                tvInMap.update(myTv);
                tvList.put(myUniqueId, tvInMap);

            } else {
                LOGGER.debug("Add TV " + myUniqueId + "to Repository");
                tvList.put(myUniqueId, myTv);
            }
        } else {
            LOGGER.debug("UniqueID is null");
        }
    }

    public List<TvType> getTvsAsList() {
        List<TvType> myList = new ArrayList<>();
        Iterator myEntries;

        if (!tvList.isEmpty()) {
            myEntries = tvList.entrySet().iterator();
            while (myEntries.hasNext()) {
                Entry thisEntry = (Entry) myEntries.next();
                myList.add((TvType) thisEntry.getValue());
            }
        }

        return myList;
    }

    public Map<String, TvType> getTvList() {
        return tvList;
    }

    public void setTvList(Map<String, TvType> tvList) {
        this.tvList = tvList;
    }

}
