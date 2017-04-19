/**
 * Barcode 
 * <b>The Barcode Detection API '/detector' converts barcodes from image files to JSON files.</b>    The flow is generally as follows:  1. First upload an image using the /detector POST endpoint. You will get back a job response that contains a job with its associated settings.  2. Start the job from a PUT request to the /detector/{jobid} endpoint, with the Job and Settings JSON as request body. The barcode detection will now start.  3. Check the job status from the /detector/{jobid} GET endpoint until the status has changed to DONE or ERROR. Messaging using a websocket will be available as an alternative in a future version  4. Retrieve the JSON file using the /detector/{jobid}/stream GET endpoint. This will return the JSON file only when the status is DONE. In other cases it will return the Job Response JSON (with http code 202 instead of 200)      <b>Interactive testing: </b>A web based test console is available in the <a href=\"https://store.sphereon.com\">Sphereon API Store</a>
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
 * Barcode detection settings
 */
@ApiModel(description = "Barcode detection settings")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-04-18T14:00:19.660+02:00")
public class DetectorJobSettings   {
  @SerializedName("lifecycle")
  private Lifecycle lifecycle = null;

  @SerializedName("outputFileName")
  private String outputFileName = null;

  /**
   * Gets or Sets engine
   */
  public enum EngineEnum {
    @SerializedName("BASIC")
    BASIC("BASIC"),
    
    @SerializedName("ADVANCED")
    ADVANCED("ADVANCED"),
    
    @SerializedName("PREMIUM")
    PREMIUM("PREMIUM");

    private String value;

    EngineEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("engine")
  private EngineEnum engine = null;

  /**
   * Gets or Sets outputFileFormat
   */
  public enum OutputFileFormatEnum {
    @SerializedName("JSON")
    JSON("JSON");

    private String value;

    OutputFileFormatEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("outputFileFormat")
  private OutputFileFormatEnum outputFileFormat = null;

  public DetectorJobSettings lifecycle(Lifecycle lifecycle) {
    this.lifecycle = lifecycle;
    return this;
  }

   /**
   * Get lifecycle
   * @return lifecycle
  **/
  @ApiModelProperty(example = "null", value = "")
  public Lifecycle getLifecycle() {
    return lifecycle;
  }

  public void setLifecycle(Lifecycle lifecycle) {
    this.lifecycle = lifecycle;
  }

  public DetectorJobSettings outputFileName(String outputFileName) {
    this.outputFileName = outputFileName;
    return this;
  }

   /**
   * Get outputFileName
   * @return outputFileName
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getOutputFileName() {
    return outputFileName;
  }

  public void setOutputFileName(String outputFileName) {
    this.outputFileName = outputFileName;
  }

  public DetectorJobSettings engine(EngineEnum engine) {
    this.engine = engine;
    return this;
  }

   /**
   * Get engine
   * @return engine
  **/
  @ApiModelProperty(example = "null", value = "")
  public EngineEnum getEngine() {
    return engine;
  }

  public void setEngine(EngineEnum engine) {
    this.engine = engine;
  }

  public DetectorJobSettings outputFileFormat(OutputFileFormatEnum outputFileFormat) {
    this.outputFileFormat = outputFileFormat;
    return this;
  }

   /**
   * Get outputFileFormat
   * @return outputFileFormat
  **/
  @ApiModelProperty(example = "null", value = "")
  public OutputFileFormatEnum getOutputFileFormat() {
    return outputFileFormat;
  }

  public void setOutputFileFormat(OutputFileFormatEnum outputFileFormat) {
    this.outputFileFormat = outputFileFormat;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DetectorJobSettings detectorJobSettings = (DetectorJobSettings) o;
    return Objects.equals(this.lifecycle, detectorJobSettings.lifecycle) &&
        Objects.equals(this.outputFileName, detectorJobSettings.outputFileName) &&
        Objects.equals(this.engine, detectorJobSettings.engine) &&
        Objects.equals(this.outputFileFormat, detectorJobSettings.outputFileFormat);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lifecycle, outputFileName, engine, outputFileFormat);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DetectorJobSettings {\n");
    
    sb.append("    lifecycle: ").append(toIndentedString(lifecycle)).append("\n");
    sb.append("    outputFileName: ").append(toIndentedString(outputFileName)).append("\n");
    sb.append("    engine: ").append(toIndentedString(engine)).append("\n");
    sb.append("    outputFileFormat: ").append(toIndentedString(outputFileFormat)).append("\n");
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

