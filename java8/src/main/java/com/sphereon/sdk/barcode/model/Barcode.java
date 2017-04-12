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
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * Barcode
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-04-12T10:59:35.870+02:00")
public class Barcode   {
  @SerializedName("confidenceLevel")
  private Double confidenceLevel = null;

  @SerializedName("pageNo")
  private Integer pageNo = null;

  @SerializedName("coordinates")
  private List<BarcodeCoordinate> coordinates = new ArrayList<BarcodeCoordinate>();

  @SerializedName("text")
  private String text = null;

  /**
   * The type of the barcode
   */
  public enum TypeEnum {
    @SerializedName("AZTEC")
    AZTEC("AZTEC"),
    
    @SerializedName("CODABAR")
    CODABAR("CODABAR"),
    
    @SerializedName("CODE_39")
    CODE_39("CODE_39"),
    
    @SerializedName("CODE_39_EXTENDED")
    CODE_39_EXTENDED("CODE_39_EXTENDED"),
    
    @SerializedName("CODE_93")
    CODE_93("CODE_93"),
    
    @SerializedName("CODE_128")
    CODE_128("CODE_128"),
    
    @SerializedName("DATA_MATRIX")
    DATA_MATRIX("DATA_MATRIX"),
    
    @SerializedName("EAN_8")
    EAN_8("EAN_8"),
    
    @SerializedName("EAN_13")
    EAN_13("EAN_13"),
    
    @SerializedName("ITF")
    ITF("ITF"),
    
    @SerializedName("MAXICODE")
    MAXICODE("MAXICODE"),
    
    @SerializedName("PDF_417")
    PDF_417("PDF_417"),
    
    @SerializedName("QR_CODE")
    QR_CODE("QR_CODE"),
    
    @SerializedName("RSS_14")
    RSS_14("RSS_14"),
    
    @SerializedName("RSS_EXPANDED")
    RSS_EXPANDED("RSS_EXPANDED"),
    
    @SerializedName("UPC_A")
    UPC_A("UPC_A"),
    
    @SerializedName("UPC_E")
    UPC_E("UPC_E"),
    
    @SerializedName("UPC_EAN_EXTENSION")
    UPC_EAN_EXTENSION("UPC_EAN_EXTENSION"),
    
    @SerializedName("IDENTCODE")
    IDENTCODE("IDENTCODE"),
    
    @SerializedName("INTERLEAVED25")
    INTERLEAVED25("INTERLEAVED25");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("type")
  private TypeEnum type = null;

  public Barcode confidenceLevel(Double confidenceLevel) {
    this.confidenceLevel = confidenceLevel;
    return this;
  }

   /**
    * The confidence level of the barcode
   * @return confidenceLevel
  **/
   @ApiModelProperty(example = "null", value = "The confidence level of the barcode")
  public Double getConfidenceLevel() {
    return confidenceLevel;
  }

  public void setConfidenceLevel(Double confidenceLevel) {
    this.confidenceLevel = confidenceLevel;
  }

  public Barcode pageNo(Integer pageNo) {
    this.pageNo = pageNo;
    return this;
  }

   /**
    * The number of the page the barcode is on
   * @return pageNo
  **/
   @ApiModelProperty(example = "null", value = "The number of the page the barcode is on")
  public Integer getPageNo() {
    return pageNo;
  }

  public void setPageNo(Integer pageNo) {
    this.pageNo = pageNo;
  }

  public Barcode coordinates(List<BarcodeCoordinate> coordinates) {
    this.coordinates = coordinates;
    return this;
  }

  public Barcode addCoordinatesItem(BarcodeCoordinate coordinatesItem) {
    this.coordinates.add(coordinatesItem);
    return this;
  }

   /**
    * The coordinates of the barcode. There are usually 2 coordinates, with an x and y value and an anchor.
   * @return coordinates
  **/
   @ApiModelProperty(example = "null", value = "The coordinates of the barcode. There are usually 2 coordinates, with an x and y value and an anchor.")
  public List<BarcodeCoordinate> getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(List<BarcodeCoordinate> coordinates) {
    this.coordinates = coordinates;
  }

  public Barcode text(String text) {
    this.text = text;
    return this;
  }

   /**
    * The text of the barcode
   * @return text
  **/
   @ApiModelProperty(example = "null", value = "The text of the barcode")
  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Barcode type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
    * The type of the barcode
   * @return type
  **/
   @ApiModelProperty(example = "null", value = "The type of the barcode")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Barcode barcode = (Barcode) o;
    return Objects.equals(this.confidenceLevel, barcode.confidenceLevel) &&
        Objects.equals(this.pageNo, barcode.pageNo) &&
        Objects.equals(this.coordinates, barcode.coordinates) &&
        Objects.equals(this.text, barcode.text) &&
        Objects.equals(this.type, barcode.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(confidenceLevel, pageNo, coordinates, text, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Barcode {\n");
    
    sb.append("    confidenceLevel: ").append(toIndentedString(confidenceLevel)).append("\n");
    sb.append("    pageNo: ").append(toIndentedString(pageNo)).append("\n");
    sb.append("    coordinates: ").append(toIndentedString(coordinates)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

