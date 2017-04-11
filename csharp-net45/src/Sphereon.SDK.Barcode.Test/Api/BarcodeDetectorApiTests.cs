/* 
 * Barcode 
 *
 * <b>The Barcode Detection API 'barcode/detector' converts barcodes from image files to JSON files.</b>    The flow is generally as follows:  1. First upload an image using the /barcode/detector POST endpoint. You will get back a job response that contains a job with its associated settings.  2. Start the job from a PUT request to the /barcode/detector/{jobid} endpoint, with the Job and Settings JSON as request body. The barcode detection will now start.  3. Check the job status from the /barcode/detector/{jobid} GET endpoint until the status has changed to DONE or ERROR. Messaging using a websocket will be available as an alternative in a future version  4. Retrieve the JSON file using the /barcode/detector/{jobid}/stream GET endpoint. This will return the JSON file only when the status is DONE. In other cases it will return the Job Response JSON (with http code 202 instead of 200)      <b>Interactive testing: </b>A web based test console is available in the <a href=\"https://store.sphereon.com\">Sphereon API Store</a>
 *
 * OpenAPI spec version: 1.0.0
 * Contact: dev@sphereon.com
 * Generated by: https://github.com/swagger-api/swagger-codegen.git
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

using System;
using System.IO;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Reflection;
using RestSharp;
using NUnit.Framework;

using Sphereon.SDK.Barcode.Client;
using Sphereon.SDK.Barcode.Api;
using Sphereon.SDK.Barcode.Model;

namespace Sphereon.SDK.Barcode.Test
{
    /// <summary>
    ///  Class for testing BarcodeDetectorApi
    /// </summary>
    /// <remarks>
    /// This file is automatically generated by Swagger Codegen.
    /// Please update the test case below to test the API endpoint.
    /// </remarks>
    [TestFixture]
    public class BarcodeDetectorApiTests
    {
        private BarcodeDetectorApi instance;

        /// <summary>
        /// Setup before each unit test
        /// </summary>
        [SetUp]
        public void Init()
        {
            instance = new BarcodeDetectorApi();
        }

        /// <summary>
        /// Clean up after each unit test
        /// </summary>
        [TearDown]
        public void Cleanup()
        {

        }

        /// <summary>
        /// Test an instance of BarcodeDetectorApi
        /// </summary>
        [Test]
        public void InstanceTest()
        {
            // TODO uncomment below to test 'IsInstanceOfType' BarcodeDetectorApi
            //Assert.IsInstanceOfType(typeof(BarcodeDetectorApi), instance, "instance is a BarcodeDetectorApi");
        }

        
        /// <summary>
        /// Test DeleteJob
        /// </summary>
        [Test]
        public void DeleteJobTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string jobid = null;
            //var response = instance.DeleteJob(jobid);
            //Assert.IsInstanceOf<DetectorJobResponse> (response, "response is DetectorJobResponse");
        }
        
        /// <summary>
        /// Test GetJob
        /// </summary>
        [Test]
        public void GetJobTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string jobid = null;
            //var response = instance.GetJob(jobid);
            //Assert.IsInstanceOf<DetectorJobResponse> (response, "response is DetectorJobResponse");
        }
        
        /// <summary>
        /// Test SubmitJob
        /// </summary>
        [Test]
        public void SubmitJobTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string jobid = null;
            //DetectorJob job = null;
            //var response = instance.SubmitJob(jobid, job);
            //Assert.IsInstanceOf<DetectorJobResponse> (response, "response is DetectorJobResponse");
        }
        
        /// <summary>
        /// Test UploadFile
        /// </summary>
        [Test]
        public void UploadFileTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //System.IO.Stream stream = null;
            //var response = instance.UploadFile(stream);
            //Assert.IsInstanceOf<DetectorJobResponse> (response, "response is DetectorJobResponse");
        }
        
    }

}
