# Sphereon.SDK.Barcode.Model.ReaderJobResponse
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**DetectorTasks** | [**List&lt;ReaderEngineTask&gt;**](ReaderEngineTask.md) |  | [optional] 
**CompletionTime** | **DateTime?** | The completion date/time of this job in ISO 8601 format | [optional] 
**JobId** | **string** |  | [optional] 
**CreationTime** | **DateTime?** | The creation date/time of this job in ISO 8601 format | [optional] 
**Inputs** | **List&lt;string&gt;** | The original input files. Currently supported inputs are: tif files | 
**UpdateTime** | **DateTime?** | The last update date/time of this job in ISO 8601 format | [optional] 
**Barcodes** | [**List&lt;Barcode&gt;**](Barcode.md) | The returned barcodes | [optional] 
**Job** | [**ReaderJob**](ReaderJob.md) |  | [optional] 
**StatusMessage** | **string** | A status message, which can be informational, warning or error. A message here does not indicate an error perse | [optional] 
**QueueTime** | **DateTime?** | The reader queue date/time of this job in ISO 8601 format | [optional] 
**Status** | **string** | The status of the job | 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

