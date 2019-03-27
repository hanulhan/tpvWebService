/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hanulhan.tpvWebService.controller;

import com.hanulhan.tpvWebService.command.CommandDetails;
import com.hanulhan.tpvWebService.command.TpvCommand;
import com.hanulhan.tpvWebService.model.TvList;
import com.hanulhan.tpvWebService.model.TvType;
import com.hanulhan.tpvWebService.response.MultipartResponse;
import com.hanulhan.tpvWebService.response.MultipartResponseList;
import com.hanulhan.tpvWebService.service.FileStorageService;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author UHansen
 */
@RestController()
public class TpvController {

    @Autowired
    FileStorageService fileStorageService;

    @Autowired
    TvList tvList;

    private static final Logger LOGGER = LogManager.getLogger(TpvController.class);

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
    public void register(@RequestBody TpvCommand aCommand) {
        String myUniqueId = null;
        LOGGER.debug(aCommand);
        CommandDetails myDetails = aCommand.getCommandDetails();
        TvType myTv = null;
        Boolean fStatusChanged = false;

        if (myDetails.getWebServiceParameters() != null) {
            myUniqueId = myDetails.getWebServiceParameters().getTVUniqueID();
            myTv = new TvType(myUniqueId);
        }

        if (myDetails.gettVDiscoveryParameters() != null && myTv != null) {
            myTv.setPowerStatus(myDetails.gettVDiscoveryParameters().getPowerStatus());
            myTv.setTvIPAddress(myDetails.gettVDiscoveryParameters().getTVIPAddress());
            myTv.setTvModel(myDetails.gettVDiscoveryParameters().getTVModelNumber());
            myTv.setTvRoomID(myDetails.gettVDiscoveryParameters().getTVRoomID());
            fStatusChanged = true;
        }
        if (myDetails.getCloneToServerParameters() != null && myTv != null) {
            myTv.setCloneToServerStatus(myDetails.getCloneToServerParameters().getCloneToServerStatus());
            myTv.setCloneToServerSessionStatus(myDetails.getCloneToServerParameters().getCloneToServerSessionStatus().getSessionStatus());
            fStatusChanged = true;
        }

        if (myDetails.getiPCloneParameters() != null && myTv != null) {
            myTv.setUpgradeStatus(myDetails.getiPCloneParameters().getCurrentUpgradeStatus());
            myTv.setUpgradeStatus(myDetails.getiPCloneParameters().getCloneSessionStatus().getSessionStatus());
            fStatusChanged = true;
        }

        if (myUniqueId != null && fStatusChanged) {

            if (!tvList.getTvList().containsKey(myUniqueId)) {
                LOGGER.debug("Add TV " + myUniqueId + "to Repository");
                tvList.getTvList().put(myUniqueId, myTv);
            } else {
                TvType tvInMap= tvList.getTvList().get(myUniqueId);
                tvInMap.setCloneToServerStatus(myTv.getCloneToServerStatus());
                tvInMap.setCloneToServerSessionStatus(myTv.getCloneToServerSessionStatus());
                tvInMap.setUpgradeStatus(myTv.getUpgradeStatus());
                tvInMap.setUpgradeSessionStatus(myTv.getUpgradeSessionStatus());
                
                tvList.getTvList().put(myUniqueId, tvInMap);
            }
        } else {
            LOGGER.debug("UniqueID is null");
        }

        //System.out.println(aCommand);
    }

    @RequestMapping(value = "/register",
            consumes = {"multipart/form-data"},
            produces = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<MultipartResponseList> uploadRoomSpecificSettings(@RequestPart(value = "RoomSpecificSettings", required = false) MultipartFile roomSpecificSettings,
            @RequestPart(value = "TVSettings", required = false) MultipartFile tvSettings) {

        String myFile;
        MultipartResponseList responseList = new MultipartResponseList();
        MultipartResponse response;

        if (roomSpecificSettings != null) {
            myFile = fileStorageService.storeFile(roomSpecificSettings);
            //System.out.println("Upload File: " + myFile);
            LOGGER.debug("Upload File: " + myFile);
            response = new MultipartResponse("SAVED", myFile, new Date());
            responseList.getResponseList().add(response);
        }

        if (tvSettings != null) {
            myFile = fileStorageService.storeFile(tvSettings);
            //System.out.println("Upload File: " + myFile);
            LOGGER.debug("Upload File: " + myFile);
            response = new MultipartResponse("SAVED", myFile, new Date());
            responseList.getResponseList().add(response);
        }
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getCommand() {

        LOGGER.debug("Http Get");
        return "Received HTTP-GET";
    }

    @RequestMapping(value = "/register", method = RequestMethod.DELETE)
    public String deleteCommand(@PathVariable("regdNum") String regdNum) {
        LOGGER.debug("Http Delete");
        return "Received HTTP-GET\n";
    }

    @RequestMapping(value = "/register", method = RequestMethod.PUT)
    public String updateCommand(@RequestBody TpvCommand aCommand) {
        LOGGER.debug("Http put");
        return "Received HTTP-PUT";
    }
}
