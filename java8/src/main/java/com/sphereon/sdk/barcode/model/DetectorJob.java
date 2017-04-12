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


package com.sphereon.sdk.barcode.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;


/**
 * The Detector job. Has access to the job settings.
 */
@ApiModel(description = "The Detector job. Has access to the job settings.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-04-12T10:59:35.870+02:00")
public class DetectorJob   {
  @SerializedName("jobId")
  private String jobId = null;

  @SerializedName("settings")
  private DetectorJobSettings settings = null;

  public DetectorJob jobId(String jobId) {
    this.jobId = jobId;
    return this;
  }

   /**
   * The server generated job jobId. This jobId is checked against the jobId in the request path on every invocation
   * @return jobId
  **/
  @ApiModelProperty(example = "null", required = true, value = "The server generated job jobId. This jobId is checked against the jobId in the request path on every invocation")
  public String getJobId() {
    return jobId;
  }

  public void setJobId(String jobId) {
    this.jobId = jobId;
  }

  public DetectorJob settings(DetectorJobSettings settings) {
    this.settings = settings;
    return this;
  }

   /**
   * Get settings
   * @return settings
  **/
  @ApiModelProperty(example = "null", value = "")
  public DetectorJobSettings getSettings() {
    return settings;
  }

  public void setSettings(DetectorJobSettings settings) {
    this.settings = settings;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DetectorJob detectorJob = (DetectorJob) o;
    return Objects.equals(this.jobId, detectorJob.jobId) &&
        Objects.equals(this.settings, detectorJob.settings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jobId, settings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DetectorJob {\n");
    
    sb.append("    jobId: ").append(toIndentedString(jobId)).append("\n");
    sb.append("    settings: ").append(toIndentedString(settings)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

