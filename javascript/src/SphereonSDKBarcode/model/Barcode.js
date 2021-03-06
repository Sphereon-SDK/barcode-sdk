/**
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

(function(root, factory) {
  if (typeof define === 'function' && define.amd) {
    // AMD. Register as an anonymous module.
    define(['SphereonSDKBarcode/ApiClient', 'SphereonSDKBarcode/model/BarcodeCoordinate'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('./BarcodeCoordinate'));
  } else {
    // Browser globals (root is window)
    if (!root.Barcode) {
      root.Barcode = {};
    }
    root.Barcode.Barcode = factory(root.Barcode.ApiClient, root.Barcode.BarcodeCoordinate);
  }
}(this, function(ApiClient, BarcodeCoordinate) {
  'use strict';




  /**
   * The Barcode model module.
   * @module SphereonSDKBarcode/model/Barcode
   * @version 0.1.0
   */

  /**
   * Constructs a new <code>Barcode</code>.
   * @alias module:SphereonSDKBarcode/model/Barcode
   * @class
   */
  var exports = function() {
    var _this = this;






  };

  /**
   * Constructs a <code>Barcode</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:SphereonSDKBarcode/model/Barcode} obj Optional instance to populate.
   * @return {module:SphereonSDKBarcode/model/Barcode} The populated <code>Barcode</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();

      if (data.hasOwnProperty('confidenceLevel')) {
        obj['confidenceLevel'] = ApiClient.convertToType(data['confidenceLevel'], 'Number');
      }
      if (data.hasOwnProperty('pageNo')) {
        obj['pageNo'] = ApiClient.convertToType(data['pageNo'], 'Integer');
      }
      if (data.hasOwnProperty('coordinates')) {
        obj['coordinates'] = ApiClient.convertToType(data['coordinates'], [BarcodeCoordinate]);
      }
      if (data.hasOwnProperty('text')) {
        obj['text'] = ApiClient.convertToType(data['text'], 'String');
      }
      if (data.hasOwnProperty('type')) {
        obj['type'] = ApiClient.convertToType(data['type'], 'String');
      }
    }
    return obj;
  }

  /**
   * The confidence level of the barcode
   * @member {Number} confidenceLevel
   */
  exports.prototype['confidenceLevel'] = undefined;
  /**
   * The number of the page the barcode is on
   * @member {Integer} pageNo
   */
  exports.prototype['pageNo'] = undefined;
  /**
   * The coordinates of the barcode. There are usually 2 coordinates, with an x and y value and an anchor.
   * @member {Array.<module:SphereonSDKBarcode/model/BarcodeCoordinate>} coordinates
   */
  exports.prototype['coordinates'] = undefined;
  /**
   * The text of the barcode
   * @member {String} text
   */
  exports.prototype['text'] = undefined;
  /**
   * The type of the barcode
   * @member {module:SphereonSDKBarcode/model/Barcode.TypeEnum} type
   */
  exports.prototype['type'] = undefined;


  /**
   * Allowed values for the <code>type</code> property.
   * @enum {String}
   * @readonly
   */
  exports.TypeEnum = {
    /**
     * value: "AZTEC"
     * @const
     */
    "AZTEC": "AZTEC",
    /**
     * value: "CODABAR"
     * @const
     */
    "CODABAR": "CODABAR",
    /**
     * value: "CODE_39"
     * @const
     */
    "CODE_39": "CODE_39",
    /**
     * value: "CODE_39_EXTENDED"
     * @const
     */
    "CODE_39_EXTENDED": "CODE_39_EXTENDED",
    /**
     * value: "CODE_93"
     * @const
     */
    "CODE_93": "CODE_93",
    /**
     * value: "CODE_128"
     * @const
     */
    "CODE_128": "CODE_128",
    /**
     * value: "DATA_MATRIX"
     * @const
     */
    "DATA_MATRIX": "DATA_MATRIX",
    /**
     * value: "EAN_8"
     * @const
     */
    "EAN_8": "EAN_8",
    /**
     * value: "EAN_13"
     * @const
     */
    "EAN_13": "EAN_13",
    /**
     * value: "ITF"
     * @const
     */
    "ITF": "ITF",
    /**
     * value: "MAXICODE"
     * @const
     */
    "MAXICODE": "MAXICODE",
    /**
     * value: "PDF_417"
     * @const
     */
    "PDF_417": "PDF_417",
    /**
     * value: "QR_CODE"
     * @const
     */
    "QR_CODE": "QR_CODE",
    /**
     * value: "RSS_14"
     * @const
     */
    "RSS_14": "RSS_14",
    /**
     * value: "RSS_EXPANDED"
     * @const
     */
    "RSS_EXPANDED": "RSS_EXPANDED",
    /**
     * value: "UPC_A"
     * @const
     */
    "UPC_A": "UPC_A",
    /**
     * value: "UPC_E"
     * @const
     */
    "UPC_E": "UPC_E",
    /**
     * value: "UPC_EAN_EXTENSION"
     * @const
     */
    "UPC_EAN_EXTENSION": "UPC_EAN_EXTENSION",
    /**
     * value: "IDENTCODE"
     * @const
     */
    "IDENTCODE": "IDENTCODE",
    /**
     * value: "INTERLEAVED25"
     * @const
     */
    "INTERLEAVED25": "INTERLEAVED25"  };


  return exports;
}));


