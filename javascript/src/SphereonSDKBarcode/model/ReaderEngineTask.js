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
    root.Barcode.ReaderEngineTask = factory(root.Barcode.ApiClient);
  }
}(this, function(ApiClient) {
  'use strict';




  /**
   * The ReaderEngineTask model module.
   * @module SphereonSDKBarcode/model/ReaderEngineTask
   * @version 0.1.0
   */

  /**
   * Constructs a new <code>ReaderEngineTask</code>.
   * @alias module:SphereonSDKBarcode/model/ReaderEngineTask
   * @class
   */
  var exports = function() {
    var _this = this;








  };

  /**
   * Constructs a <code>ReaderEngineTask</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:SphereonSDKBarcode/model/ReaderEngineTask} obj Optional instance to populate.
   * @return {module:SphereonSDKBarcode/model/ReaderEngineTask} The populated <code>ReaderEngineTask</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();

      if (data.hasOwnProperty('jobId')) {
        obj['jobId'] = ApiClient.convertToType(data['jobId'], 'String');
      }
      if (data.hasOwnProperty('queueId')) {
        obj['queueId'] = ApiClient.convertToType(data['queueId'], 'String');
      }
      if (data.hasOwnProperty('engine')) {
        obj['engine'] = ApiClient.convertToType(data['engine'], 'String');
      }
      if (data.hasOwnProperty('inputs')) {
        obj['inputs'] = ApiClient.convertToType(data['inputs'], ['String']);
      }
      if (data.hasOwnProperty('documentId')) {
        obj['documentId'] = ApiClient.convertToType(data['documentId'], 'String');
      }
      if (data.hasOwnProperty('url')) {
        obj['url'] = ApiClient.convertToType(data['url'], 'String');
      }
      if (data.hasOwnProperty('status')) {
        obj['status'] = ApiClient.convertToType(data['status'], 'String');
      }
    }
    return obj;
  }

  /**
   * The current job Id
   * @member {String} jobId
   */
  exports.prototype['jobId'] = undefined;
  /**
   * The queue Id provided by a backend system
   * @member {String} queueId
   */
  exports.prototype['queueId'] = undefined;
  /**
   * The Engine being used
   * @member {module:SphereonSDKBarcode/model/ReaderEngineTask.EngineEnum} engine
   */
  exports.prototype['engine'] = undefined;
  /**
   * The names of the supplied files/inputs
   * @member {Array.<String>} inputs
   */
  exports.prototype['inputs'] = undefined;
  /**
   * The document Id provided by a backend system
   * @member {String} documentId
   */
  exports.prototype['documentId'] = undefined;
  /**
   * The URL on the bucketstore for the Barcode file. Only available once the status is DONE
   * @member {String} url
   */
  exports.prototype['url'] = undefined;
  /**
   * The status of the Reader task itself
   * @member {module:SphereonSDKBarcode/model/ReaderEngineTask.StatusEnum} status
   */
  exports.prototype['status'] = undefined;


  /**
   * Allowed values for the <code>engine</code> property.
   * @enum {String}
   * @readonly
   */
  exports.EngineEnum = {
    /**
     * value: "ADVANCED"
     * @const
     */
    "ADVANCED": "ADVANCED",
    /**
     * value: "PREMIUM"
     * @const
     */
    "PREMIUM": "PREMIUM",
    /**
     * value: "BASIC"
     * @const
     */
    "BASIC": "BASIC"  };

  /**
   * Allowed values for the <code>status</code> property.
   * @enum {String}
   * @readonly
   */
  exports.StatusEnum = {
    /**
     * value: "REQUESTED"
     * @const
     */
    "REQUESTED": "REQUESTED",
    /**
     * value: "QUEUED"
     * @const
     */
    "QUEUED": "QUEUED",
    /**
     * value: "PROCESSING"
     * @const
     */
    "PROCESSING": "PROCESSING",
    /**
     * value: "DONE"
     * @const
     */
    "DONE": "DONE",
    /**
     * value: "ERROR"
     * @const
     */
    "ERROR": "ERROR"  };


  return exports;
}));


