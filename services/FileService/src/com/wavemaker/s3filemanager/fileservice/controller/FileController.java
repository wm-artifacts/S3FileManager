package com.wavemaker.s3filemanager.fileservice.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wavemaker.runtime.commons.file.model.DownloadResponse;
import com.wavemaker.s3filemanager.fileservice.FileService;
import com.wavemaker.s3filemanager.fileservice.FileService.FileUploadResponse;
import com.wavemaker.s3filemanager.fileservice.FileService.WMFile;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;

/**
 * Controller object for domain model class {@link FileService}.
 * @see FileService
 */
@RestController
@Api(value = "FileController", description = "controller class for java service execution")
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @DeleteMapping(value = "/file")
    public boolean deleteFile(@RequestParam(value = "file", required = false) String file, @RequestParam(value = "relativePath", required = false) String relativePath) throws IOException {
        return fileService.deleteFile(file, relativePath);
    }

    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @GetMapping(value = "/downloadFile", produces = "application/octet-stream")
    public DownloadResponse getDownloadFile(@RequestParam(value = "file", required = false) String file, @RequestParam(value = "relativePath", required = false) String relativePath, @RequestParam(value = "returnName", required = false) String returnName) throws Exception {
        return fileService.getDownloadFile(file, relativePath, returnName);
    }

    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @GetMapping(value = "/downloadFileAsInline", produces = "application/octet-stream")
    public DownloadResponse getDownloadFileAsInline(@RequestParam(value = "file", required = false) String file, @RequestParam(value = "relativePath", required = false) String relativePath, @RequestParam(value = "returnName", required = false) String returnName) throws Exception {
        return fileService.getDownloadFileAsInline(file, relativePath, returnName);
    }

    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @GetMapping(value = "/files")
    public WMFile[] listFiles( HttpServletRequest httpServletRequest, @RequestParam(value = "relativePath", required = false) String relativePath) throws IOException {
        return fileService.listFiles(httpServletRequest, relativePath);
    }

    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @PostMapping(value = "/uploadFile", consumes = "multipart/form-data")
    public FileUploadResponse[] uploadFile(@RequestPart(value = "files", required = false) MultipartFile[] files, @RequestParam(value = "relativePath", required = false) String relativePath,  HttpServletRequest httpServletRequest) {
        return fileService.uploadFile(files, relativePath, httpServletRequest);
    }
}

