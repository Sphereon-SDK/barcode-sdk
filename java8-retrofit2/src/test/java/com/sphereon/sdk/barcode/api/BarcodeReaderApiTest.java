package com.sphereon.sdk.barcode.api;

import com.sphereon.sdk.barcode.handler.ApiClient;
import com.sphereon.sdk.barcode.model.ErrorResponse;
import java.io.File;
import com.sphereon.sdk.barcode.model.ReaderJob;
import com.sphereon.sdk.barcode.model.ReaderJobResponse;
import com.sphereon.sdk.barcode.model.ReaderResultJobResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for BarcodeReaderApi
 */
public class BarcodeReaderApiTest {

    private BarcodeReaderApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(BarcodeReaderApi.class);
    }

    
    /**
     * Delete a job manually
     *
     * Delete the Job and all related files
     */
    @Test
    public void deleteJobTest() {
        String jobid = null;
        // ReaderJobResponse response = api.deleteJob(jobid);

        // TODO: test validations
    }
    
    /**
     * Job definition and state
     *
     * Get the ReadResult response , job definition and current state. Please note that you can differentiate completion based on http response status
     */
    @Test
    public void getJobTest() {
        String jobid = null;
        // ReaderResultJobResponse response = api.getJob(jobid);

        // TODO: test validations
    }
    
    /**
     * Submit job for reading
     *
     * Starts the barcode detection of the uploaded files, using the supplied settings associated with the job in the request body. You can only submit the job after a new Job is created with status INPUTS_UPLOADED or resubmit an existing Job with status ERROR. In all cases the jobId in the path must match the jobId in the request
     */
    @Test
    public void submitJobTest() {
        String jobid = null;
        ReaderJob job = null;
        // ReaderJobResponse response = api.submitJob(jobid, job);

        // TODO: test validations
    }
    
    /**
     * Upload the file
     *
     * Upload the  image.
     */
    @Test
    public void uploadFileTest() {
        File stream = null;
        // ReaderJobResponse response = api.uploadFile(stream);

        // TODO: test validations
    }
    
}
