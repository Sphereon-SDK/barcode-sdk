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


package com.sphereon.sdk.barocde.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * ReaderEngineTask
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-06-22T18:04:26.286+02:00")
public class ReaderEngineTask {
  @JsonProperty("jobId")
  private String jobId = null;

  @JsonProperty("queueId")
  private String queueId = null;

  /**
   * The Engine being used
   */
  public enum EngineEnum {
    ADVANCED("ADVANCED"),
    
    PREMIUM("PREMIUM"),
    
    BASIC("BASIC");

    private String value;

    EngineEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static EngineEnum fromValue(String text) {
      for (EngineEnum b : EngineEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("engine")
  private EngineEnum engine = null;

  @JsonProperty("inputs")
  private List<String> inputs = new ArrayList<String>();

  @JsonProperty("documentId")
  private String documentId = null;

  @JsonProperty("url")
  private String url = null;

  /**
   * The status of the Reader task itself
   */
  public enum StatusEnum {
    REQUESTED("REQUESTED"),
    
    QUEUED("QUEUED"),
    
    PROCESSING("PROCESSING"),
    
    DONE("DONE"),
    
    ERROR("ERROR");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("status")
  private StatusEnum status = null;

   /**
   * The current job Id
   * @return jobId
  **/
  @ApiModelProperty(example = "null", value = "The current job Id")
  public String getJobId() {
    return jobId;
  }

   /**
   * The queue Id provided by a backend system
   * @return queueId
  **/
  @ApiModelProperty(example = "null", value = "The queue Id provided by a backend system")
  public String getQueueId() {
    return queueId;
  }

   /**
   * The Engine being used
   * @return engine
  **/
  @ApiModelProperty(example = "null", value = "The Engine being used")
  public EngineEnum getEngine() {
    return engine;
  }

  public ReaderEngineTask inputs(List<String> inputs) {
    this.inputs = inputs;
    return this;
  }

  public ReaderEngineTask addInputsItem(String inputsItem) {
    this.inputs.add(inputsItem);
    return this;
  }

   /**
   * The names of the supplied files/inputs
   * @return inputs
  **/
  @ApiModelProperty(example = "null", value = "The names of the supplied files/inputs")
  public List<String> getInputs() {
    return inputs;
  }

  public void setInputs(List<String> inputs) {
    this.inputs = inputs;
  }

   /**
   * The document Id provided by a backend system
   * @return documentId
  **/
  @ApiModelProperty(example = "null", value = "The document Id provided by a backend system")
  public String getDocumentId() {
    return documentId;
  }

   /**
   * The URL on the bucketstore for the Barcode file. Only available once the status is DONE
   * @return url
  **/
  @ApiModelProperty(example = "null", value = "The URL on the bucketstore for the Barcode file. Only available once the status is DONE")
  public String getUrl() {
    return url;
  }

   /**
   * The status of the Reader task itself
   * @return status
  **/
  @ApiModelProperty(example = "null", value = "The status of the Reader task itself")
  public StatusEnum getStatus() {
    return status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReaderEngineTask readerEngineTask = (ReaderEngineTask) o;
    return Objects.equals(this.jobId, readerEngineTask.jobId) &&
        Objects.equals(this.queueId, readerEngineTask.queueId) &&
        Objects.equals(this.engine, readerEngineTask.engine) &&
        Objects.equals(this.inputs, readerEngineTask.inputs) &&
        Objects.equals(this.documentId, readerEngineTask.documentId) &&
        Objects.equals(this.url, readerEngineTask.url) &&
        Objects.equals(this.status, readerEngineTask.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jobId, queueId, engine, inputs, documentId, url, status);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReaderEngineTask {\n");
    
    sb.append("    jobId: ").append(toIndentedString(jobId)).append("\n");
    sb.append("    queueId: ").append(toIndentedString(queueId)).append("\n");
    sb.append("    engine: ").append(toIndentedString(engine)).append("\n");
    sb.append("    inputs: ").append(toIndentedString(inputs)).append("\n");
    sb.append("    documentId: ").append(toIndentedString(documentId)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

