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
    define(['SphereonSDKBarcode/ApiClient'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'));
  } else {
    // Browser globals (root is window)
    if (!root.Barcode) {
      root.Barcode = {};
    }
    root.Barcode.Lifecycle = factory(root.Barcode.ApiClient);
  }
}(this, function(ApiClient) {
  'use strict';




  /**
   * The Lifecycle model module.
   * @module SphereonSDKBarcode/model/Lifecycle
   * @version 0.1.0
   */

  /**
   * Constructs a new <code>Lifecycle</code>.
   * Lifecycle settings. When no lifecycle settings are supplied, the job and files will be deleted directly after retrieval of the file
   * @alias module:SphereonSDKBarcode/model/Lifecycle
   * @class
   */
  var exports = function() {
    var _this = this;




  };

  /**
   * Constructs a <code>Lifecycle</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:SphereonSDKBarcode/model/Lifecycle} obj Optional instance to populate.
   * @return {module:SphereonSDKBarcode/model/Lifecycle} The populated <code>Lifecycle</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();

      if (data.hasOwnProperty('actionTime')) {
        obj['actionTime'] = ApiClient.convertToType(data['actionTime'], 'Date');
      }
      if (data.hasOwnProperty('action')) {
        obj['action'] = ApiClient.convertToType(data['action'], 'String');
      }
      if (data.hasOwnProperty('type')) {
        obj['type'] = ApiClient.convertToType(data['type'], 'String');
      }
    }
    return obj;
  }

  /**
   * The time at which the job and files will be deleted, regardless of whether it has been retrieved or not. Maximal time is 1 day from job creation
   * @member {Date} actionTime
   */
  exports.prototype['actionTime'] = undefined;
  /**
   * @member {module:SphereonSDKBarcode/model/Lifecycle.ActionEnum} action
   */
  exports.prototype['action'] = undefined;
  /**
   * @member {module:SphereonSDKBarcode/model/Lifecycle.TypeEnum} type
   */
  exports.prototype['type'] = undefined;


  /**
   * Allowed values for the <code>action</code> property.
   * @enum {String}
   * @readonly
   */
  exports.ActionEnum = {
    /**
     * value: "DELETE"
     * @const
     */
    "DELETE": "DELETE"  };

  /**
   * Allowed values for the <code>type</code> property.
   * @enum {String}
   * @readonly
   */
  exports.TypeEnum = {
    /**
     * value: "RETRIEVAL"
     * @const
     */
    "RETRIEVAL": "RETRIEVAL",
    /**
     * value: "TIME"
     * @const
     */
    "TIME": "TIME"  };


  return exports;
}));


