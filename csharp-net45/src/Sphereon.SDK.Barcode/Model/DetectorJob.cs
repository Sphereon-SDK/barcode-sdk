/* 
 * Barcode 
 *
 * <b>The Barcode Detection API '/detector' converts barcodes from image files to JSON files.</b>    The flow is generally as follows:  1. First upload an image using the /detector POST endpoint. You will get back a job response that contains a job with its associated settings.  2. Start the job from a PUT request to the /detector/{jobid} endpoint, with the Job and Settings JSON as request body. The barcode detection will now start.  3. Check the job status from the /detector/{jobid} GET endpoint until the status has changed to DONE or ERROR. Messaging using a websocket will be available as an alternative in a future version  4. Retrieve the JSON file using the /detector/{jobid}/stream GET endpoint. This will return the JSON file only when the status is DONE. In other cases it will return the Job Response JSON (with http code 202 instead of 200)      <b>Interactive testing: </b>A web based test console is available in the <a href=\"https://store.sphereon.com\">Sphereon API Store</a>
 *
 * OpenAPI spec version: 1.0.0
 * Contact: dev@sphereon.com
 * Generated by: https://github.com/swagger-api/swagger-codegen.git
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

using System;
using System.Linq;
using System.IO;
using System.Text;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Runtime.Serialization;
using Newtonsoft.Json;
using Newtonsoft.Json.Converters;

namespace Sphereon.SDK.Barcode.Model
{
    /// <summary>
    /// The Detector job. Has access to the job settings.
    /// </summary>
    [DataContract]
    public partial class DetectorJob :  IEquatable<DetectorJob>
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="DetectorJob" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected DetectorJob() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="DetectorJob" /> class.
        /// </summary>
        /// <param name="JobId">The server generated job jobId. This jobId is checked against the jobId in the request path on every invocation (required).</param>
        /// <param name="Settings">Settings.</param>
        public DetectorJob(string JobId = null, DetectorJobSettings Settings = null)
        {
            // to ensure "JobId" is required (not null)
            if (JobId == null)
            {
                throw new InvalidDataException("JobId is a required property for DetectorJob and cannot be null");
            }
            else
            {
                this.JobId = JobId;
            }
            this.Settings = Settings;
        }
        
        /// <summary>
        /// The server generated job jobId. This jobId is checked against the jobId in the request path on every invocation
        /// </summary>
        /// <value>The server generated job jobId. This jobId is checked against the jobId in the request path on every invocation</value>
        [DataMember(Name="jobId", EmitDefaultValue=false)]
        public string JobId { get; set; }
        /// <summary>
        /// Gets or Sets Settings
        /// </summary>
        [DataMember(Name="settings", EmitDefaultValue=false)]
        public DetectorJobSettings Settings { get; set; }
        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class DetectorJob {\n");
            sb.Append("  JobId: ").Append(JobId).Append("\n");
            sb.Append("  Settings: ").Append(Settings).Append("\n");
            sb.Append("}\n");
            return sb.ToString();
        }
  
        /// <summary>
        /// Returns the JSON string presentation of the object
        /// </summary>
        /// <returns>JSON string presentation of the object</returns>
        public string ToJson()
        {
            return JsonConvert.SerializeObject(this, Formatting.Indented);
        }

        /// <summary>
        /// Returns true if objects are equal
        /// </summary>
        /// <param name="obj">Object to be compared</param>
        /// <returns>Boolean</returns>
        public override bool Equals(object obj)
        {
            // credit: http://stackoverflow.com/a/10454552/677735
            return this.Equals(obj as DetectorJob);
        }

        /// <summary>
        /// Returns true if DetectorJob instances are equal
        /// </summary>
        /// <param name="other">Instance of DetectorJob to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(DetectorJob other)
        {
            // credit: http://stackoverflow.com/a/10454552/677735
            if (other == null)
                return false;

            return 
                (
                    this.JobId == other.JobId ||
                    this.JobId != null &&
                    this.JobId.Equals(other.JobId)
                ) && 
                (
                    this.Settings == other.Settings ||
                    this.Settings != null &&
                    this.Settings.Equals(other.Settings)
                );
        }

        /// <summary>
        /// Gets the hash code
        /// </summary>
        /// <returns>Hash code</returns>
        public override int GetHashCode()
        {
            // credit: http://stackoverflow.com/a/263416/677735
            unchecked // Overflow is fine, just wrap
            {
                int hash = 41;
                // Suitable nullity checks etc, of course :)
                if (this.JobId != null)
                    hash = hash * 59 + this.JobId.GetHashCode();
                if (this.Settings != null)
                    hash = hash * 59 + this.Settings.GetHashCode();
                return hash;
            }
        }
    }

}
