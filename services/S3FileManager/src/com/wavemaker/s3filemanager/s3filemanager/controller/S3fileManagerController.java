package com.wavemaker.s3filemanager.s3filemanager.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wavemaker.connector.awss3connector.AWSS3ObjectSummary;
import com.wavemaker.runtime.commons.file.model.DownloadResponse;
import com.wavemaker.s3filemanager.s3filemanager.S3FileManager;
import com.wavemaker.s3filemanager.s3filemanager.model.S3ObjectSummaryWrapper;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;

/**
 * Controller object for domain model class {@link S3FileManager}.
 * @see S3FileManager
 */
@RestController
@Api(value = "S3fileManagerController", description = "controller class for java service execution")
@RequestMapping("/s3FileManager")
public class S3fileManagerController {

    @Autowired
    private S3FileManager s3FileManager;

    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @PostMapping(value = "/folderInS3")
    public String createFolderInS3(@RequestParam(value = "folderName", required = false) String folderName) {
        return s3FileManager.createFolderInS3(folderName);
    }

    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @DeleteMapping(value = "/file")
    public void deleteFile(@RequestParam(value = "s3KeyName", required = false) String s3KeyName) {
        s3FileManager.deleteFile(s3KeyName);
    }

    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @DeleteMapping(value = "/folder")
    public void deleteFolder(@RequestParam(value = "folderName", required = false) String folderName) {
        s3FileManager.deleteFolder(folderName);
    }

    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @GetMapping(value = "/downloadFile", produces = "application/octet-stream")
    public DownloadResponse downloadFile(@RequestParam(value = "s3KeyName", required = false) String s3KeyName) {
        return s3FileManager.downloadFile(s3KeyName);
    }

    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @GetMapping(value = "/filterObjectsByFolders")
    public List<S3ObjectSummaryWrapper> filterObjectsByFolders(@RequestParam(value = "folderPath", required = false) String folderPath) {
        return s3FileManager.filterObjectsByFolders(folderPath);
    }

    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @GetMapping(value = "/allFoldersWithObjects")
    public List listAllFoldersWithObjects() {
        return s3FileManager.listAllFoldersWithObjects();
    }

    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @GetMapping(value = "/objects")
    public List<AWSS3ObjectSummary> listObjects() {
        return s3FileManager.listObjects();
    }

    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @GetMapping(value = "/rootLevelFoldersObjects")
    public List<S3ObjectSummaryWrapper> listRootLevelFoldersObjects() {
        return s3FileManager.listRootLevelFoldersObjects();
    }

    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @PostMapping(value = "/uploadFilesFromCsvToS3", consumes = "multipart/form-data")
    public String uploadFilesFromCsvToS3(@RequestParam(value = "folderName", required = false) String folderName, @RequestPart(value = "csvFile", required = false) MultipartFile csvFile) {
        return s3FileManager.uploadFilesFromCsvToS3(folderName, csvFile);
    }

    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @PostMapping(value = "/uploadFilesToS3", consumes = "multipart/form-data")
    public String uploadFilesToS3(@RequestParam(value = "folderPath", required = false) String folderPath, @RequestPart(value = "files", required = false) MultipartFile[] files) {
        return s3FileManager.uploadFilesToS3(folderPath, files);
    }

    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @PostMapping(value = "/uploadFileToIcons", consumes = "multipart/form-data")
    public String uploadFileToIcons(@RequestPart(value = "file", required = false) MultipartFile file) {
        return s3FileManager.uploadFileToIcons(file);
    }

    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @PostMapping(value = "/uploadFileToPhotos", consumes = "multipart/form-data")
    public String uploadFileToPhotos(@RequestPart(value = "file", required = false) MultipartFile file) {
        return s3FileManager.uploadFileToPhotos(file);
    }

    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @PostMapping(value = "/uploadFileToSpecifiedDirectory", consumes = "multipart/form-data")
    public String uploadFileToSpecifiedDirectory(@RequestPart(value = "file", required = false) MultipartFile file, @RequestParam(value = "directory", required = false) String directory) {
        return s3FileManager.uploadFileToSpecifiedDirectory(file, directory);
    }
}

