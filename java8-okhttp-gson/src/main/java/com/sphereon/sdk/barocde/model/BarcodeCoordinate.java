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
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * BarcodeCoordinate
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-06-22T18:04:36.136+02:00")
public class BarcodeCoordinate {
  /**
   * The anchor to which the positions apply
   */
  public enum AnchorEnum {
    @SerializedName("LEFT_TOP")
    LEFT_TOP("LEFT_TOP"),
    
    @SerializedName("RIGHT_TOP")
    RIGHT_TOP("RIGHT_TOP"),
    
    @SerializedName("LEFT_BOTTOM")
    LEFT_BOTTOM("LEFT_BOTTOM"),
    
    @SerializedName("RIGHT_BOTTOM")
    RIGHT_BOTTOM("RIGHT_BOTTOM"),
    
    @SerializedName("CENTER")
    CENTER("CENTER"),
    
    @SerializedName("UNKNOWN")
    UNKNOWN("UNKNOWN");

    private String value;

    AnchorEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("anchor")
  private AnchorEnum anchor = null;

  @SerializedName("x")
  private Integer x = null;

  @SerializedName("y")
  private Integer y = null;

   /**
   * The anchor to which the positions apply
   * @return anchor
  **/
  @ApiModelProperty(example = "null", value = "The anchor to which the positions apply")
  public AnchorEnum getAnchor() {
    return anchor;
  }

   /**
   * The X position
   * @return x
  **/
  @ApiModelProperty(example = "null", value = "The X position")
  public Integer getX() {
    return x;
  }

   /**
   * The Y position
   * @return y
  **/
  @ApiModelProperty(example = "null", value = "The Y position")
  public Integer getY() {
    return y;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BarcodeCoordinate barcodeCoordinate = (BarcodeCoordinate) o;
    return Objects.equals(this.anchor, barcodeCoordinate.anchor) &&
        Objects.equals(this.x, barcodeCoordinate.x) &&
        Objects.equals(this.y, barcodeCoordinate.y);
  }

  @Override
  public int hashCode() {
    return Objects.hash(anchor, x, y);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BarcodeCoordinate {\n");
    
    sb.append("    anchor: ").append(toIndentedString(anchor)).append("\n");
    sb.append("    x: ").append(toIndentedString(x)).append("\n");
    sb.append("    y: ").append(toIndentedString(y)).append("\n");
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

