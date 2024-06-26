# About S3FileManager Application

## Introduction
   S3FileManager is a web application designed to manage files and folders stored on AWS S3. It provides functionality to interact with your S3 bucket, including uploading files, creating folders, browsing existing content and display images directly within the application..

## Features

1. **File and Folder Management:**
  - View all files and folders stored in your configured S3 bucket.
  - Navigate through folders and subfolders to explore content.
  - Display images directly in the application.
  - Utilizes AWS S3 for storing uploaded content.

2. **Upload Functionality:**
  - Upload single files or bulk upload multiple files at once.
  - Ability to create new folders within the application.

3. **Image Preview:**
  - Display images directly in the application for easy viewing.
  - Ability to copy image/file source.


## Getting Started

To use the S3FileManager application, follow these steps:

## Prerequisites
Before you begin, ensure you have the following:
- AWS account with an S3 bucket configured.
- AWS access key and secret access key.
- Images or files you wish to upload.

## Configuration

1. **AWS S3 Configuration:**
   - Set up an S3 bucket in your AWS account.
   - Note down the bucket name, AWS access key, and AWS secret access key.

2. **Environment Variables:**
   - Configure the following environment variables in your application:
     ```plaintext
     connector.aws-s3-connector.default.aws.accessKey=
     connector.aws-s3-connector.default.aws.accessSecret=
     connector.aws-s3-connector.default.aws.bucketName=
     connector.aws-s3-connector.default.aws.clientRegion=
     app.environment.s3.region.domain=s3.amazonaws.com
     ```

## Installation
   - Once you get the source from MarketPlace.
   - Import into WaveMaker studio.

## Usage

1. **View Files and Folders:**
   - Upon accessing the application, you will see all images and root folders listed.

2. **Navigate and Explore:**
   - Click on folders to navigate through the directory structure.
   - View images or files within each folder.

3. **Upload Files:**
   - Upload files by clicking the upload button.
   - You can upload single files or multiple files simultaneously.

4. **Create Folders:**
   - Use the application interface to create new folders as needed(Click on create foder button).


## Example Workflow

1. **Navigate to Specific Folder:**
   - Click on a folder to view its contents.

2. **Upload Files:**
   - Choose files from your local system to upload to the selected folder.

3. **View and Manage Images:**
   - Images will be displayed directly in the application for easy viewing.

