# barcode-sdk-java8

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>com.sphereon.sdk</groupId>
    <artifactId>barcode-sdk-java8</artifactId>
    <version>1.0.0-SNAPSHOT</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "com.sphereon.sdk:barcode-sdk-java8:1.0.0-SNAPSHOT"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/barcode-sdk-java8-1.0.0-SNAPSHOT.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import com.sphereon.sdk.barcode.handler.*;
import com.sphereon.sdk.barcode.handler.auth.*;
import com.sphereon.sdk.barcode.handler.model.*;
import com.sphereon.sdk.barcode.api.BarcodeDetectorApi;

import java.io.File;
import java.util.*;

public class BarcodeDetectorApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        
        // Configure OAuth2 access token for authorization: oauth2schema
        OAuth oauth2schema = (OAuth) defaultClient.getAuthentication("oauth2schema");
        oauth2schema.setAccessToken("YOUR ACCESS TOKEN");

        BarcodeDetectorApi apiInstance = new BarcodeDetectorApi();
        String jobid = "jobid_example"; // String | jobid
        try {
            DetectorJobResponse result = apiInstance.deleteJob(jobid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling BarcodeDetectorApi#deleteJob");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://gw.api.cloud.sphereon.com/*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*BarcodeDetectorApi* | [**deleteJob**](docs/BarcodeDetectorApi.md#deleteJob) | **DELETE** /barcode/1.0.0/barcode/detector/{jobid} | Delete a job manually
*BarcodeDetectorApi* | [**getJob**](docs/BarcodeDetectorApi.md#getJob) | **GET** /barcode/1.0.0/barcode/detector/{jobid} | Job definition and state
*BarcodeDetectorApi* | [**submitJob**](docs/BarcodeDetectorApi.md#submitJob) | **PUT** /barcode/1.0.0/barcode/detector/{jobid} | Submit Detector job for processing
*BarcodeDetectorApi* | [**uploadFile**](docs/BarcodeDetectorApi.md#uploadFile) | **POST** /barcode/1.0.0/barcode/detector | Upload the file


## Documentation for Models

 - [Barcode](docs/Barcode.md)
 - [BarcodeCoordinate](docs/BarcodeCoordinate.md)
 - [DetectorJob](docs/DetectorJob.md)
 - [DetectorJobResponse](docs/DetectorJobResponse.md)
 - [DetectorJobSettings](docs/DetectorJobSettings.md)
 - [DetectorTask](docs/DetectorTask.md)
 - [Error](docs/Error.md)
 - [ErrorResponse](docs/ErrorResponse.md)
 - [Lifecycle](docs/Lifecycle.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### oauth2schema

- **Type**: OAuth
- **Flow**: application
- **Authorizatoin URL**: 
- **Scopes**: 
  - global: accessEverything


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issue.

## Author

dev@sphereon.com

