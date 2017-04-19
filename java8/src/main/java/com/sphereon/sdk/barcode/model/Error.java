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
 * An error
 */
@ApiModel(description = "An error")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-04-18T14:00:19.660+02:00")
public class Error   {
  @SerializedName("code")
  private String code = null;

  /**
   * Gets or Sets level
   */
  public enum LevelEnum {
    @SerializedName("INFO")
    INFO("INFO"),
    
    @SerializedName("WARNING")
    WARNING("WARNING"),
    
    @SerializedName("FATAL")
    FATAL("FATAL");

    private String value;

    LevelEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("level")
  private LevelEnum level = null;

  @SerializedName("cause")
  private Error cause = null;

  @SerializedName("message")
  private String message = null;

  public Error code(String code) {
    this.code = code;
    return this;
  }

   /**
   * Get code
   * @return code
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Error level(LevelEnum level) {
    this.level = level;
    return this;
  }

   /**
   * Get level
   * @return level
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public LevelEnum getLevel() {
    return level;
  }

  public void setLevel(LevelEnum level) {
    this.level = level;
  }

  public Error cause(Error cause) {
    this.cause = cause;
    return this;
  }

   /**
   * Get cause
   * @return cause
  **/
  @ApiModelProperty(example = "null", value = "")
  public Error getCause() {
    return cause;
  }

  public void setCause(Error cause) {
    this.cause = cause;
  }

  public Error message(String message) {
    this.message = message;
    return this;
  }

   /**
   * Get message
   * @return message
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.code, error.code) &&
        Objects.equals(this.level, error.level) &&
        Objects.equals(this.cause, error.cause) &&
        Objects.equals(this.message, error.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, level, cause, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    level: ").append(toIndentedString(level)).append("\n");
    sb.append("    cause: ").append(toIndentedString(cause)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

