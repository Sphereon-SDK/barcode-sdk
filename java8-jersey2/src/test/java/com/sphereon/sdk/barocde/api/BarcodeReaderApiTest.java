/*
 * Barcode
 * <b>The Barcode Reader API '/reader' reads barcodes from image files and returns the barcode data as JSON files.</b>    The flow is generally as follows:  1. First upload an image using the /reader POST endpoint. You will get back a job response that contains a job with its associated settings.  2. Start the job from a PUT request to the /reader/{jobid} endpoint, with the Job and Settings JSON as request body. The barcode detection will now start.  3. Check the job status from the /reader/{jobid} GET endpoint until the status has changed to DONE or ERROR. Messaging using a websocket will be available as an alternative in a future version  4. Retrieve the JSON file using the /reader/{jobid}/stream GET endpoint. This will return the JSON file only when the status is DONE. In other cases it will return the Job Response JSON (with http code 202 instead of 200)      <b>Interactive testing: </b>A web based test console is available in the <a href=\"https://store.sphereon.com\">Sphereon API Store</a>
 *
 * OpenAPI spec version: 0.1.0
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


package com.sphereon.sdk.barocde.api;

import com.sphereon.sdk.barocde.handler.ApiException;
import com.sphereon.sdk.barocde.model.*;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.annotation.PostConstruct;
import java.io.File;
import java.net.URL;

/**
 * API tests for BarcodeReaderApi
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BarcodeReaderApiTest {
    private static final URL BARCODE_URL = BarcodeReaderApiTest.class.getResource("/barcodes.tif");
    private static final String ACCESS_TOKEN = "0dbd17f1-c108-350e-807e-42d13e543b32";

    private static final BarcodeReaderApi api = new BarcodeReaderApi();

    private static String jobId;
    private static ReaderJob job;

    @PostConstruct
    protected void init() {

    }


    /**
     * Upload the file
     * <p>
     * Upload the  image.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void _01_uploadFileTest() throws ApiException {
        api.getApiClient().setAccessToken(ACCESS_TOKEN);

        File stream = new File(BARCODE_URL.getFile());
        ReaderJobResponse response = api.uploadFile(stream);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getJobId());
        Assert.assertEquals(ReaderJobResponse.StatusEnum.INPUTS_UPLOADED, response.getStatus());
        BarcodeReaderApiTest.jobId = response.getJobId();
        BarcodeReaderApiTest.job = response.getJob();
    }


    /**
     * Job definition and state
     * <p>
     * Get the Detector job definition and current state. Please note that you can differentiate based on http response status
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void _02_getJobTestBeforeSubmit() throws ApiException {
        ReaderResultJobResponse response = api.getJob(jobId);
        Assert.assertNotNull(response);
        Assert.assertEquals(jobId, response.getJobId());
        Assert.assertEquals(ReaderResultJobResponse.StatusEnum.INPUTS_UPLOADED, response.getStatus());
    }

    /**
     * Submit Detector job for processing
     * <p>
     * Starts the barcode detection of the uploaded files, using the supplied settings associated with the job in the request body. You can only submit the job after a new Job is created with status INPUTS_UPLOADED or resubmit an existing Job with status ERROR. In all cases the jobId in the path must match the jobId in the request
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void _03_submitJobTest() throws ApiException {
        ReaderJobResponse response = api.submitJob(jobId, job);
        Assert.assertNotNull(response);
        Assert.assertEquals(ReaderJobResponse.StatusEnum.PROCESSING, response.getStatus());
    }

    /**
     * Job definition and state
     * <p>
     * Get the Detector job definition and current state. Please note that you can differentiate based on http response status
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void _04_getJobTestAfterSubmit() throws ApiException {
        ReaderResultJobResponse response = api.getJob(jobId);
        Assert.assertNotNull(response);

        final int maxCount = 100;
        int currentCount = 0;

        while (currentCount++ < maxCount && ReaderResultJobResponse.StatusEnum.PROCESSING == response.getStatus()) {
            response = api.getJob(jobId);
            Assert.assertTrue(ReaderResultJobResponse.StatusEnum.PROCESSING == response.getStatus() || ReaderResultJobResponse.StatusEnum.DONE == response.getStatus());
        }
        Assert.assertEquals(ReaderResultJobResponse.StatusEnum.DONE, response.getStatus());
        Assert.assertEquals(3, response.getBarcodes().size());
        Assert.assertEquals(Barcode.TypeEnum.CODE_39, response.getBarcodes().get(0).getType());
        Assert.assertEquals("++SCANUSER+NIELS", response.getBarcodes().get(0).getText());
    }


    /**
     * Delete a job manually
     * <p>
     * Delete the Detector Job and all related files
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void _05_deleteJobTest() throws ApiException {
        ReaderJobResponse response = api.deleteJob(jobId);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getJobId());
        Assert.assertEquals(ReaderJobResponse.StatusEnum.DELETED, response.getStatus());

        try {
            api.getJob(jobId);
            Assert.fail("After job deletion we should not get here");
        } catch (ApiException e) {
            // Normal flow after job deletion and retrieval of already deleted job
            System.err.println(e.getMessage());

        }


    }


}
