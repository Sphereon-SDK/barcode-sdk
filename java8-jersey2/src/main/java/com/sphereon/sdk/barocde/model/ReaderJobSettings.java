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
import com.sphereon.sdk.barocde.model.Lifecycle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Barcode reader settings
 */
@ApiModel(description = "Barcode reader settings")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-06-22T18:04:26.286+02:00")
public class ReaderJobSettings {
  @JsonProperty("lifecycle")
  private Lifecycle lifecycle = null;

  @JsonProperty("outputFileName")
  private String outputFileName = null;

  /**
   * Gets or Sets engine
   */
  public enum EngineEnum {
    BASIC("BASIC"),
    
    ADVANCED("ADVANCED"),
    
    PREMIUM("PREMIUM");

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

  /**
   * Gets or Sets outputFileFormat
   */
  public enum OutputFileFormatEnum {
    JSON("JSON");

    private String value;

    OutputFileFormatEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static OutputFileFormatEnum fromValue(String text) {
      for (OutputFileFormatEnum b : OutputFileFormatEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("outputFileFormat")
  private OutputFileFormatEnum outputFileFormat = null;

  public ReaderJobSettings lifecycle(Lifecycle lifecycle) {
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

  public ReaderJobSettings outputFileName(String outputFileName) {
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

  public ReaderJobSettings engine(EngineEnum engine) {
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

  public ReaderJobSettings outputFileFormat(OutputFileFormatEnum outputFileFormat) {
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
    ReaderJobSettings readerJobSettings = (ReaderJobSettings) o;
    return Objects.equals(this.lifecycle, readerJobSettings.lifecycle) &&
        Objects.equals(this.outputFileName, readerJobSettings.outputFileName) &&
        Objects.equals(this.engine, readerJobSettings.engine) &&
        Objects.equals(this.outputFileFormat, readerJobSettings.outputFileFormat);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lifecycle, outputFileName, engine, outputFileFormat);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReaderJobSettings {\n");
    
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

