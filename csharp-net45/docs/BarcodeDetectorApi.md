# Sphereon.SDK.Barcode.Api.BarcodeDetectorApi

All URIs are relative to *https://gw.api.cloud.sphereon.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**DeleteJob**](BarcodeDetectorApi.md#deletejob) | **DELETE** /barcode/1.0.0/barcode/detector/{jobid} | Delete a job manually
[**GetJob**](BarcodeDetectorApi.md#getjob) | **GET** /barcode/1.0.0/barcode/detector/{jobid} | Job definition and state
[**SubmitJob**](BarcodeDetectorApi.md#submitjob) | **PUT** /barcode/1.0.0/barcode/detector/{jobid} | Submit Detector job for processing
[**UploadFile**](BarcodeDetectorApi.md#uploadfile) | **POST** /barcode/1.0.0/barcode/detector | Upload the file


<a name="deletejob"></a>
# **DeleteJob**
> DetectorJobResponse DeleteJob (string jobid)

Delete a job manually

Delete the Detector job and all related files

### Example
```csharp
using System;
using System.Diagnostics;
using Sphereon.SDK.Barcode.Api;
using Sphereon.SDK.Barcode.Client;
using Sphereon.SDK.Barcode.Model;

namespace Example
{
    public class DeleteJobExample
    {
        public void main()
        {
            
            // Configure OAuth2 access token for authorization: oauth2schema
            Configuration.Default.AccessToken = "YOUR_ACCESS_TOKEN";

            var apiInstance = new BarcodeDetectorApi();
            var jobid = jobid_example;  // string | jobid

            try
            {
                // Delete a job manually
                DetectorJobResponse result = apiInstance.DeleteJob(jobid);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling BarcodeDetectorApi.DeleteJob: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobid** | **string**| jobid | 

### Return type

[**DetectorJobResponse**](DetectorJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json;charset=UTF-8

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="getjob"></a>
# **GetJob**
> DetectorJobResponse GetJob (string jobid)

Job definition and state

Get the Detector job definition and current state. Please note that you can differentiate based on http response status

### Example
```csharp
using System;
using System.Diagnostics;
using Sphereon.SDK.Barcode.Api;
using Sphereon.SDK.Barcode.Client;
using Sphereon.SDK.Barcode.Model;

namespace Example
{
    public class GetJobExample
    {
        public void main()
        {
            
            // Configure OAuth2 access token for authorization: oauth2schema
            Configuration.Default.AccessToken = "YOUR_ACCESS_TOKEN";

            var apiInstance = new BarcodeDetectorApi();
            var jobid = jobid_example;  // string | jobid

            try
            {
                // Job definition and state
                DetectorJobResponse result = apiInstance.GetJob(jobid);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling BarcodeDetectorApi.GetJob: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobid** | **string**| jobid | 

### Return type

[**DetectorJobResponse**](DetectorJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json;charset=UTF-8

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="submitjob"></a>
# **SubmitJob**
> DetectorJobResponse SubmitJob (string jobid, DetectorJob job)

Submit Detector job for processing

Starts the barcode detection of the uploaded files, using the supplied settings associated with the job in the request body. You can only submit the job after a new Job is created with status INPUTS_UPLOADED or resubmit an existing Job with status ERROR. In all cases the job Id in the path must match the jobId in the request

### Example
```csharp
using System;
using System.Diagnostics;
using Sphereon.SDK.Barcode.Api;
using Sphereon.SDK.Barcode.Client;
using Sphereon.SDK.Barcode.Model;

namespace Example
{
    public class SubmitJobExample
    {
        public void main()
        {
            
            // Configure OAuth2 access token for authorization: oauth2schema
            Configuration.Default.AccessToken = "YOUR_ACCESS_TOKEN";

            var apiInstance = new BarcodeDetectorApi();
            var jobid = jobid_example;  // string | jobid
            var job = new DetectorJob(); // DetectorJob | jobEntity

            try
            {
                // Submit Detector job for processing
                DetectorJobResponse result = apiInstance.SubmitJob(jobid, job);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling BarcodeDetectorApi.SubmitJob: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobid** | **string**| jobid | 
 **job** | [**DetectorJob**](DetectorJob.md)| jobEntity | 

### Return type

[**DetectorJobResponse**](DetectorJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json;charset=UTF-8
 - **Accept**: application/json;charset=UTF-8

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="uploadfile"></a>
# **UploadFile**
> DetectorJobResponse UploadFile (System.IO.Stream stream)

Upload the file

Upload the  image.

### Example
```csharp
using System;
using System.Diagnostics;
using Sphereon.SDK.Barcode.Api;
using Sphereon.SDK.Barcode.Client;
using Sphereon.SDK.Barcode.Model;

namespace Example
{
    public class UploadFileExample
    {
        public void main()
        {
            
            // Configure OAuth2 access token for authorization: oauth2schema
            Configuration.Default.AccessToken = "YOUR_ACCESS_TOKEN";

            var apiInstance = new BarcodeDetectorApi();
            var stream = new System.IO.Stream(); // System.IO.Stream | The first image.

            try
            {
                // Upload the file
                DetectorJobResponse result = apiInstance.UploadFile(stream);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling BarcodeDetectorApi.UploadFile: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **stream** | **System.IO.Stream**| The first image. | 

### Return type

[**DetectorJobResponse**](DetectorJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json;charset=UTF-8

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

