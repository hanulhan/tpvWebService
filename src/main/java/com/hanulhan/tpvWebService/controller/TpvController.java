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
import java.io.IOException;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    private static final Logger LOGGER_TV = LogManager.getLogger("TV");

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
    public void register(@RequestBody TpvCommand aCommand) {
        String myUniqueId = null;
        LOGGER_TV.debug(aCommand);
        tvList.update(aCommand);
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

    @RequestMapping(value = "/download/{fileName:.+}", method = RequestMethod.GET)
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {

        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            LOGGER.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
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
