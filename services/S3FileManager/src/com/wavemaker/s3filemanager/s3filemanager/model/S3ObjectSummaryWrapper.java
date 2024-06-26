package com.wavemaker.s3filemanager.s3filemanager.model;

import java.util.Date;
import com.wavemaker.connector.awss3connector.AWSS3ObjectSummary;
import com.wavemaker.connector.awss3connector.S3Connector;


public class S3ObjectSummaryWrapper {
    private String bucketName;
    private String key;
    private String eTag;
    private long size;
    private Date lastModified;
    private String storageClass;
    private String type;

    public S3ObjectSummaryWrapper(AWSS3ObjectSummary summary, String type) {
        this.bucketName = summary.getBucketName();
        this.key = summary.getKey();
        this.eTag = summary.getETag();
        this.size = summary.getSize();
        this.lastModified = summary.getLastModified();
        this.storageClass = summary.getStorageClass();
        this.type = type;
    }

    // Getter and setter methods
    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getETag() {
        return eTag;
    }

    public void setETag(String eTag) {
        this.eTag = eTag;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getStorageClass() {
        return storageClass;
    }

    public void setStorageClass(String storageClass) {
        this.storageClass = storageClass;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
