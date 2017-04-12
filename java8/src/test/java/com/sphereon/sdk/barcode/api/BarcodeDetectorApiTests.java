package com.sphereon.sdk.barcode.api;

import com.sphereon.sdk.barcode.handler.ApiException;
import com.sphereon.sdk.barcode.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by Gebruiker on 7-4-2017.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BarcodeDetectorApiTests {

    private final BarcodeDetectorApi api = new BarcodeDetectorApi();
    private static DetectorJob detectorJob;
    private static final String IMAGE_NAME = "barcodes.tif";

    private final URL IMAGE_URL = getClass().getClassLoader().getResource(IMAGE_NAME);

    private static final String ACCESS_TOKEN = "0dbd17f1-c108-350e-807e-42d13e543b32";

    /**
     * Temporarily use local microservice
     * FIXME remove before deployment
     */
    @Before
    public void setToLocalMicroservice() {
        api.getApiClient().setBasePath(getServiceUrl());
    }

    /**
     * Upload the file
     * <p>
     * Upload the  image.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void _01uploadFileTest() throws ApiException, URISyntaxException {
        //api.getApiClient().setAccessToken(ACCESS_TOKEN);
        File stream = new File(IMAGE_URL.toURI());

        DetectorJobResponse response = api.uploadFile(stream);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getJobId());
        Assert.assertNotNull(response.getJob());
        Assert.assertEquals(DetectorJobResponse.StatusEnum.INPUTS_UPLOADED, response.getStatus());
        detectorJob = response.getJob();

    }

    /**
     * Submit Detector job for processing
     * <p>
     * Starts the barcode detection of the uploaded files, using the supplied settings associated with the job in the request body. You can only submit the job after a new Job is created with status INPUTS_UPLOADED or resubmit an existing Job with status ERROR. In all cases the job Id in the path must match the jobId in the request
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void _02submitJobTest() {
        detectorJob.getSettings().getLifecycle().setType(Lifecycle.TypeEnum.TIME);
        detectorJob.getSettings().engine(DetectorJobSettings.EngineEnum.PREMIUM);
        DetectorJobResponse response = null;
        try {
            response = api.submitJob(detectorJob.getJobId(), detectorJob);
        } catch (ApiException e) {
            Assert.fail("Failed to submit Job to API");
        }
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getJob());
        Assert.assertEquals(DetectorJobResponse.StatusEnum.PROCESSING, response.getStatus());

        //Test error handling
        try {
            DetectorJobResponse errorResponse = api.submitJob(detectorJob.getJobId(), detectorJob);
        } catch (ApiException e) {
            Assert.assertEquals(e.getCode(), 400);
        }

        try {
            DetectorJobResponse errorResponse = api.submitJob("thisisnotavalidjobid", detectorJob);
        } catch (ApiException e) {
            Assert.assertEquals(e.getCode(), 404);
        }

    }

    /**
     * Job definition and state
     * <p>
     * Get the Detector job definition and current state. Please note that you can differentiate based on http response status
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void _03getJobTest() {
        DetectorJobResponse response = null;
        try {
            response = api.getJob(detectorJob.getJobId());
        } catch (ApiException e) {
            Assert.fail("Failed to submit get job from API");
        }
        Assert.assertNotNull(response);

        Assert.assertTrue(response.getStatus() == DetectorJobResponse.StatusEnum.PROCESSING || response.getStatus() == DetectorJobResponse.StatusEnum.DONE);

        int sleepTime = 100;
        int maxCount = 90 * 1000 / sleepTime; // Wait at most 90 seconds
        int count = 0;

        Assert.assertEquals(1, response.getDetectorTasks().size());
        DetectorTask task = response.getDetectorTasks().get(0);

        while (task.getStatus() == DetectorTask.StatusEnum.REQUESTED && count <= maxCount) {
            count++;
            System.out.print("Job " + response.getJobId() + " is processing. Count: " + count);
            System.out.println(String.format("  -> Engine  task status: %s", task.getStatus().name()));
            try {
                response = api.getJob(detectorJob.getJobId());
            } catch (ApiException e) {
                Assert.fail("Failed to get Job from API");
            }
            task = response.getDetectorTasks().get(0);
        }

        while (task.getStatus() == DetectorTask.StatusEnum.PROCESSING && count <= maxCount) {
            count++;
            System.out.print("Job " + response.getJobId() + " is processing. Count: " + count);
            System.out.println(String.format("  -> Engine  task status: %s", task.getStatus().name()));
            try {
                response = api.getJob(detectorJob.getJobId());
            } catch (ApiException e) {
                Assert.fail("Failed to get Job from the API");

            }
            task = response.getDetectorTasks().get(0);
        }

        if (response.getStatus() == DetectorJobResponse.StatusEnum.DONE) {
            Assert.assertNotNull(response.getBarcodeResults());
        }

        //Test error handling
        try {
            DetectorJobResponse errorResponse = api.getJob("thisisnotavalidjobid");
        } catch (ApiException e) {
            Assert.assertEquals(e.getCode(), 404);
        }

    }


    /**
     * Delete a job manually
     * <p>
     * Delete the Detector job and all related files
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void _04deleteJobTest() {
        DetectorJobResponse response = null;
        try {
            response = api.deleteJob(detectorJob.getJobId());
        } catch (ApiException e) {
            Assert.fail("Failed to delete Job from API");
        }
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getJob());
        Assert.assertEquals(DetectorJobResponse.StatusEnum.DELETED, response.getStatus());

        try {
            DetectorJobResponse errorresponse = api.deleteJob(detectorJob.getJobId());
        } catch (ApiException e) {
            Assert.assertEquals(e.getCode(), 404);
        }
    }


    private String getServiceUrl() {
        return "http://localhost:18197";
    }
}
