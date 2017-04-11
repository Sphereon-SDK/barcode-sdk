/**
 * Barcode 
 * <b>The Barcode Detection API 'barcode/detector' converts barcodes from image files to JSON files.</b>    The flow is generally as follows:  1. First upload an image using the /barcode/detector POST endpoint. You will get back a job response that contains a job with its associated settings.  2. Start the job from a PUT request to the /barcode/detector/{jobid} endpoint, with the Job and Settings JSON as request body. The barcode detection will now start.  3. Check the job status from the /barcode/detector/{jobid} GET endpoint until the status has changed to DONE or ERROR. Messaging using a websocket will be available as an alternative in a future version  4. Retrieve the JSON file using the /barcode/detector/{jobid}/stream GET endpoint. This will return the JSON file only when the status is DONE. In other cases it will return the Job Response JSON (with http code 202 instead of 200)      <b>Interactive testing: </b>A web based test console is available in the <a href=\"https://store.sphereon.com\">Sphereon API Store</a>
 *
 * OpenAPI spec version: 1.0.0
 * Contact: dev@sphereon.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.sphereon.sdk.barcode.api;

import com.sphereon.sdk.barcode.handler.ApiCallback;
import com.sphereon.sdk.barcode.handler.ApiClient;
import com.sphereon.sdk.barcode.handler.ApiException;
import com.sphereon.sdk.barcode.handler.ApiResponse;
import com.sphereon.sdk.barcode.handler.Configuration;
import com.sphereon.sdk.barcode.handler.Pair;
import com.sphereon.sdk.barcode.handler.ProgressRequestBody;
import com.sphereon.sdk.barcode.handler.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import com.sphereon.sdk.barcode.model.DetectorJobResponse;
import com.sphereon.sdk.barcode.model.ErrorResponse;
import com.sphereon.sdk.barcode.model.DetectorJob;
import java.io.File;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BarcodeDetectorApi {
    private ApiClient apiClient;

    public BarcodeDetectorApi() {
        this(Configuration.getDefaultApiClient());
    }

    public BarcodeDetectorApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    String PREFIX = "";
    //String PREFIX = "/barcode/1.0.0";

    /* Build call for deleteJob */
    private com.squareup.okhttp.Call deleteJobCall(String jobid, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'jobid' is set
        if (jobid == null) {
            throw new ApiException("Missing the required parameter 'jobid' when calling deleteJob(Async)");
        }
        

        // create path and map variables

        String localVarPath = (PREFIX + "/barcode/detector/{jobid}").replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "jobid" + "\\}", apiClient.escapeString(jobid.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json;charset=UTF-8"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "oauth2schema" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Delete a job manually
     * Delete the Detector job and all related files
     * @param jobid jobid (required)
     * @return DetectorJobResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DetectorJobResponse deleteJob(String jobid) throws ApiException {
        ApiResponse<DetectorJobResponse> resp = deleteJobWithHttpInfo(jobid);
        return resp.getData();
    }

    /**
     * Delete a job manually
     * Delete the Detector job and all related files
     * @param jobid jobid (required)
     * @return ApiResponse&lt;DetectorJobResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DetectorJobResponse> deleteJobWithHttpInfo(String jobid) throws ApiException {
        com.squareup.okhttp.Call call = deleteJobCall(jobid, null, null);
        Type localVarReturnType = new TypeToken<DetectorJobResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Delete a job manually (asynchronously)
     * Delete the Detector job and all related files
     * @param jobid jobid (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteJobAsync(String jobid, final ApiCallback<DetectorJobResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteJobCall(jobid, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DetectorJobResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for getJob */
    private com.squareup.okhttp.Call getJobCall(String jobid, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'jobid' is set
        if (jobid == null) {
            throw new ApiException("Missing the required parameter 'jobid' when calling getJob(Async)");
        }
        

        // create path and map variables
        String localVarPath = PREFIX + "/barcode/detector/{jobid}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "jobid" + "\\}", apiClient.escapeString(jobid.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json;charset=UTF-8"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "oauth2schema" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Job definition and state
     * Get the Detector job definition and current state. Please note that you can differentiate based on http response status
     * @param jobid jobid (required)
     * @return DetectorJobResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DetectorJobResponse getJob(String jobid) throws ApiException {
        ApiResponse<DetectorJobResponse> resp = getJobWithHttpInfo(jobid);
        return resp.getData();
    }

    /**
     * Job definition and state
     * Get the Detector job definition and current state. Please note that you can differentiate based on http response status
     * @param jobid jobid (required)
     * @return ApiResponse&lt;DetectorJobResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DetectorJobResponse> getJobWithHttpInfo(String jobid) throws ApiException {
        com.squareup.okhttp.Call call = getJobCall(jobid, null, null);
        Type localVarReturnType = new TypeToken<DetectorJobResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Job definition and state (asynchronously)
     * Get the Detector job definition and current state. Please note that you can differentiate based on http response status
     * @param jobid jobid (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getJobAsync(String jobid, final ApiCallback<DetectorJobResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getJobCall(jobid, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DetectorJobResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for submitJob */
    private com.squareup.okhttp.Call submitJobCall(String jobid, DetectorJob job, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = job;
        
        // verify the required parameter 'jobid' is set
        if (jobid == null) {
            throw new ApiException("Missing the required parameter 'jobid' when calling submitJob(Async)");
        }
        
        // verify the required parameter 'job' is set
        if (job == null) {
            throw new ApiException("Missing the required parameter 'job' when calling submitJob(Async)");
        }
        

        // create path and map variables
        String localVarPath = PREFIX + "/barcode/detector/{jobid}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "jobid" + "\\}", apiClient.escapeString(jobid.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json;charset=UTF-8"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json;charset=UTF-8"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "oauth2schema" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Submit Detector job for processing
     * Starts the barcode detection of the uploaded files, using the supplied settings associated with the job in the request body. You can only submit the job after a new Job is created with status INPUTS_UPLOADED or resubmit an existing Job with status ERROR. In all cases the job Id in the path must match the jobId in the request
     * @param jobid jobid (required)
     * @param job jobEntity (required)
     * @return DetectorJobResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DetectorJobResponse submitJob(String jobid, DetectorJob job) throws ApiException {
        ApiResponse<DetectorJobResponse> resp = submitJobWithHttpInfo(jobid, job);
        return resp.getData();
    }

    /**
     * Submit Detector job for processing
     * Starts the barcode detection of the uploaded files, using the supplied settings associated with the job in the request body. You can only submit the job after a new Job is created with status INPUTS_UPLOADED or resubmit an existing Job with status ERROR. In all cases the job Id in the path must match the jobId in the request
     * @param jobid jobid (required)
     * @param job jobEntity (required)
     * @return ApiResponse&lt;DetectorJobResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DetectorJobResponse> submitJobWithHttpInfo(String jobid, DetectorJob job) throws ApiException {
        com.squareup.okhttp.Call call = submitJobCall(jobid, job, null, null);
        Type localVarReturnType = new TypeToken<DetectorJobResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Submit Detector job for processing (asynchronously)
     * Starts the barcode detection of the uploaded files, using the supplied settings associated with the job in the request body. You can only submit the job after a new Job is created with status INPUTS_UPLOADED or resubmit an existing Job with status ERROR. In all cases the job Id in the path must match the jobId in the request
     * @param jobid jobid (required)
     * @param job jobEntity (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call submitJobAsync(String jobid, DetectorJob job, final ApiCallback<DetectorJobResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = submitJobCall(jobid, job, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DetectorJobResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for uploadFile */
    private com.squareup.okhttp.Call uploadFileCall(File stream, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'stream' is set
        if (stream == null) {
            throw new ApiException("Missing the required parameter 'stream' when calling uploadFile(Async)");
        }
        

        // create path and map variables
        String localVarPath = PREFIX + "/barcode/detector".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        if (stream != null)
        localVarFormParams.put("stream", stream);

        final String[] localVarAccepts = {
            "application/json;charset=UTF-8"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "multipart/form-data"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "oauth2schema" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Upload the file
     * Upload the  image.
     * @param stream The first image. (required)
     * @return DetectorJobResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DetectorJobResponse uploadFile(File stream) throws ApiException {
        ApiResponse<DetectorJobResponse> resp = uploadFileWithHttpInfo(stream);
        return resp.getData();
    }

    /**
     * Upload the file
     * Upload the  image.
     * @param stream The first image. (required)
     * @return ApiResponse&lt;DetectorJobResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DetectorJobResponse> uploadFileWithHttpInfo(File stream) throws ApiException {
        com.squareup.okhttp.Call call = uploadFileCall(stream, null, null);
        Type localVarReturnType = new TypeToken<DetectorJobResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Upload the file (asynchronously)
     * Upload the  image.
     * @param stream The first image. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call uploadFileAsync(File stream, final ApiCallback<DetectorJobResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = uploadFileCall(stream, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DetectorJobResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
