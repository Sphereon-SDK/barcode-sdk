# BarcodeDetectorApi

All URIs are relative to *https://gw.api.cloud.sphereon.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteJob**](BarcodeDetectorApi.md#deleteJob) | **DELETE** /barcode/1.0.0/barcode/detector/{jobid} | Delete a job manually
[**getJob**](BarcodeDetectorApi.md#getJob) | **GET** /barcode/1.0.0/barcode/detector/{jobid} | Job definition and state
[**submitJob**](BarcodeDetectorApi.md#submitJob) | **PUT** /barcode/1.0.0/barcode/detector/{jobid} | Submit Detector job for processing
[**uploadFile**](BarcodeDetectorApi.md#uploadFile) | **POST** /barcode/1.0.0/barcode/detector | Upload the file


<a name="deleteJob"></a>
# **deleteJob**
> DetectorJobResponse deleteJob(jobid)

Delete a job manually

Delete the Detector Job and all related files

### Example
```java
// Import classes:
//import com.sphereon.sdk.barcode.handler.ApiClient;
//import com.sphereon.sdk.barcode.handler.ApiException;
//import com.sphereon.sdk.barcode.handler.Configuration;
//import com.sphereon.sdk.barcode.handler.auth.*;
//import com.sphereon.sdk.barcode.api.BarcodeDetectorApi;

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
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobid** | **String**| jobid |

### Return type

[**DetectorJobResponse**](DetectorJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json;charset=UTF-8

<a name="getJob"></a>
# **getJob**
> DetectorJobResponse getJob(jobid)

Job definition and state

Get the Detector job definition and current state. Please note that you can differentiate based on http response status

### Example
```java
// Import classes:
//import com.sphereon.sdk.barcode.handler.ApiClient;
//import com.sphereon.sdk.barcode.handler.ApiException;
//import com.sphereon.sdk.barcode.handler.Configuration;
//import com.sphereon.sdk.barcode.handler.auth.*;
//import com.sphereon.sdk.barcode.api.BarcodeDetectorApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2schema
OAuth oauth2schema = (OAuth) defaultClient.getAuthentication("oauth2schema");
oauth2schema.setAccessToken("YOUR ACCESS TOKEN");

BarcodeDetectorApi apiInstance = new BarcodeDetectorApi();
String jobid = "jobid_example"; // String | jobid
try {
    DetectorJobResponse result = apiInstance.getJob(jobid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BarcodeDetectorApi#getJob");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobid** | **String**| jobid |

### Return type

[**DetectorJobResponse**](DetectorJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json;charset=UTF-8

<a name="submitJob"></a>
# **submitJob**
> DetectorJobResponse submitJob(jobid, job)

Submit Detector job for processing

Starts the barcode detection of the uploaded files, using the supplied settings associated with the job in the request body. You can only submit the job after a new Job is created with status INPUTS_UPLOADED or resubmit an existing Job with status ERROR. In all cases the jobId in the path must match the jobId in the request

### Example
```java
// Import classes:
//import com.sphereon.sdk.barcode.handler.ApiClient;
//import com.sphereon.sdk.barcode.handler.ApiException;
//import com.sphereon.sdk.barcode.handler.Configuration;
//import com.sphereon.sdk.barcode.handler.auth.*;
//import com.sphereon.sdk.barcode.api.BarcodeDetectorApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2schema
OAuth oauth2schema = (OAuth) defaultClient.getAuthentication("oauth2schema");
oauth2schema.setAccessToken("YOUR ACCESS TOKEN");

BarcodeDetectorApi apiInstance = new BarcodeDetectorApi();
String jobid = "jobid_example"; // String | jobid
DetectorJob job = new DetectorJob(); // DetectorJob | jobEntity
try {
    DetectorJobResponse result = apiInstance.submitJob(jobid, job);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BarcodeDetectorApi#submitJob");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobid** | **String**| jobid |
 **job** | [**DetectorJob**](DetectorJob.md)| jobEntity |

### Return type

[**DetectorJobResponse**](DetectorJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json;charset=UTF-8
 - **Accept**: application/json;charset=UTF-8

<a name="uploadFile"></a>
# **uploadFile**
> DetectorJobResponse uploadFile(stream)

Upload the file

Upload the  image.

### Example
```java
// Import classes:
//import com.sphereon.sdk.barcode.handler.ApiClient;
//import com.sphereon.sdk.barcode.handler.ApiException;
//import com.sphereon.sdk.barcode.handler.Configuration;
//import com.sphereon.sdk.barcode.handler.auth.*;
//import com.sphereon.sdk.barcode.api.BarcodeDetectorApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2schema
OAuth oauth2schema = (OAuth) defaultClient.getAuthentication("oauth2schema");
oauth2schema.setAccessToken("YOUR ACCESS TOKEN");

BarcodeDetectorApi apiInstance = new BarcodeDetectorApi();
File stream = new File("/path/to/file.txt"); // File | The first image.
try {
    DetectorJobResponse result = apiInstance.uploadFile(stream);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BarcodeDetectorApi#uploadFile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **stream** | **File**| The first image. |

### Return type

[**DetectorJobResponse**](DetectorJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json;charset=UTF-8

