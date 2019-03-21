/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hanulhan.tpvWebService.Controller;

import com.hanulhan.tpvWebService.Command.TpvCommand;
import com.hanulhan.tpvWebService.payload.UploadFileResponse;
import com.hanulhan.tpvWebService.service.FileStorageService;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author UHansen
 */
@RestController()
public class TpvController {

    @Autowired
    FileStorageService fileStorageService;

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
    public void register(@RequestBody TpvCommand aCommand) {
        System.out.println(aCommand);
    }

    @RequestMapping(value = "/register",
            consumes = {"multipart/form-data"},
            produces = {"application/json"},
            method = RequestMethod.POST)

    public UploadFileResponse uploadTvSettings( @RequestPart("TVSettings") MultipartFile aFile,
                                                @RequestPart("RoomSpecificSettings") MultipartFile aFile2) {

        String fileName = fileStorageService.storeFile(aFile);
        System.out.println("Upload File: " + fileName);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        UploadFileResponse myResponse = new UploadFileResponse(fileName, fileDownloadUri,
                aFile.getContentType(), aFile.getSize());

        return myResponse;

    }

    public UploadFileResponse uploadRoomSpecificSettings(@RequestPart("RoomSpecificSettings") MultipartFile aFile) {

        String fileName = fileStorageService.storeFile(aFile);
        System.out.println("Upload File: " + fileName);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        UploadFileResponse myResponse = new UploadFileResponse(fileName, fileDownloadUri,
                aFile.getContentType(), aFile.getSize());

        return myResponse;
    }

    public UploadFileResponse uploadLocalCustomDashboard(@RequestPart("CustomDashboardFallback") MultipartFile aFile) {

        String fileName = fileStorageService.storeFile(aFile);
        System.out.println("Upload File: " + fileName);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        UploadFileResponse myResponse = new UploadFileResponse(fileName, fileDownloadUri,
                aFile.getContentType(), aFile.getSize());

        return myResponse;

    }

//    public ResponseEntity<String> uploadfile(@RequestPart("TVSettings") MultipartFile aFilename) {
//        System.out.println("Obtained a upload request for the name: ");
//
//        return new ResponseEntity<>("file upload has been accepted.", HttpStatus.ACCEPTED);
//    }
    @RequestMapping(value = "/register", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getCommand() {
        System.out.println("Http Get");
        return "Received HTTP-GET";
    }

    @RequestMapping(value = "/register", method = RequestMethod.DELETE)
    public String deleteCommand(@PathVariable("regdNum") String regdNum) {
        System.out.println("Http Delete");
        return "Received HTTP-GET\n";
    }

    @RequestMapping(value = "/register", method = RequestMethod.PUT)
    public String updateCommand(@RequestBody TpvCommand aCommand) {
        System.out.println("Http put");
        return "Received HTTP-PUT";
    }
}
