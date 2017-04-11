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

import com.sphereon.sdk.barcode.handler.ApiException;
import com.sphereon.sdk.barcode.model.DetectorJobResponse;
import com.sphereon.sdk.barcode.model.ErrorResponse;
import com.sphereon.sdk.barcode.model.DetectorJob;
import java.io.File;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for BarcodeDetectorApi
 */
public class BarcodeDetectorApiTest {

    private final BarcodeDetectorApi api = new BarcodeDetectorApi();

    
    /**
     * Delete a job manually
     *
     * Delete the Detector job and all related files
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteJobTest() throws ApiException {
        String jobid = null;
        // DetectorJobResponse response = api.deleteJob(jobid);

        // TODO: test validations
    }
    
    /**
     * Job definition and state
     *
     * Get the Detector job definition and current state. Please note that you can differentiate based on http response status
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getJobTest() throws ApiException {
        String jobid = null;
        // DetectorJobResponse response = api.getJob(jobid);

        // TODO: test validations
    }
    
    /**
     * Submit Detector job for processing
     *
     * Starts the barcode detection of the uploaded files, using the supplied settings associated with the job in the request body. You can only submit the job after a new Job is created with status INPUTS_UPLOADED or resubmit an existing Job with status ERROR. In all cases the job Id in the path must match the jobId in the request
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void submitJobTest() throws ApiException {
        String jobid = null;
        DetectorJob job = null;
        // DetectorJobResponse response = api.submitJob(jobid, job);

        // TODO: test validations
    }
    
    /**
     * Upload the file
     *
     * Upload the  image.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void uploadFileTest() throws ApiException {
        File stream = null;
        // DetectorJobResponse response = api.uploadFile(stream);

        // TODO: test validations
    }
    
}
