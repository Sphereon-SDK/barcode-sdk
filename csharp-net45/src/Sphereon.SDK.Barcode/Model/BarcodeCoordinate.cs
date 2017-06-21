/* 
 * Barcode
 *
 * <b>The Barcode Reader API '/reader' reads barcodes from image files and returns the barcode data as JSON files.</b>    The flow is generally as follows:  1. First upload an image using the /reader POST endpoint. You will get back a job response that contains a job with its associated settings.  2. Start the job from a PUT request to the /reader/{jobid} endpoint, with the Job and Settings JSON as request body. The barcode detection will now start.  3. Check the job status from the /reader/{jobid} GET endpoint until the status has changed to DONE or ERROR. Messaging using a websocket will be available as an alternative in a future version  4. Retrieve the JSON file using the /reader/{jobid}/stream GET endpoint. This will return the JSON file only when the status is DONE. In other cases it will return the Job Response JSON (with http code 202 instead of 200)      <b>Interactive testing: </b>A web based test console is available in the <a href=\"https://store.sphereon.com\">Sphereon API Store</a>
 *
 * OpenAPI spec version: 0.1.0
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
    /// BarcodeCoordinate
    /// </summary>
    [DataContract]
    public partial class BarcodeCoordinate :  IEquatable<BarcodeCoordinate>
    {
        /// <summary>
        /// Gets or Sets Anchor
        /// </summary>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum AnchorEnum
        {
            
            /// <summary>
            /// Enum LEFTTOP for "LEFT_TOP"
            /// </summary>
            [EnumMember(Value = "LEFT_TOP")]
            LEFTTOP,
            
            /// <summary>
            /// Enum RIGHTTOP for "RIGHT_TOP"
            /// </summary>
            [EnumMember(Value = "RIGHT_TOP")]
            RIGHTTOP,
            
            /// <summary>
            /// Enum LEFTBOTTOM for "LEFT_BOTTOM"
            /// </summary>
            [EnumMember(Value = "LEFT_BOTTOM")]
            LEFTBOTTOM,
            
            /// <summary>
            /// Enum RIGHTBOTTOM for "RIGHT_BOTTOM"
            /// </summary>
            [EnumMember(Value = "RIGHT_BOTTOM")]
            RIGHTBOTTOM,
            
            /// <summary>
            /// Enum CENTER for "CENTER"
            /// </summary>
            [EnumMember(Value = "CENTER")]
            CENTER,
            
            /// <summary>
            /// Enum UNKNOWN for "UNKNOWN"
            /// </summary>
            [EnumMember(Value = "UNKNOWN")]
            UNKNOWN
        }

        /// <summary>
        /// Gets or Sets Anchor
        /// </summary>
        [DataMember(Name="anchor", EmitDefaultValue=false)]
        public AnchorEnum? Anchor { get; set; }
        /// <summary>
        /// Initializes a new instance of the <see cref="BarcodeCoordinate" /> class.
        /// </summary>
        /// <param name="Anchor">Anchor.</param>
        /// <param name="X">X.</param>
        /// <param name="Y">Y.</param>
        public BarcodeCoordinate(AnchorEnum? Anchor = null, int? X = null, int? Y = null)
        {
            this.Anchor = Anchor;
            this.X = X;
            this.Y = Y;
        }
        
        /// <summary>
        /// Gets or Sets X
        /// </summary>
        [DataMember(Name="x", EmitDefaultValue=false)]
        public int? X { get; set; }
        /// <summary>
        /// Gets or Sets Y
        /// </summary>
        [DataMember(Name="y", EmitDefaultValue=false)]
        public int? Y { get; set; }
        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class BarcodeCoordinate {\n");
            sb.Append("  Anchor: ").Append(Anchor).Append("\n");
            sb.Append("  X: ").Append(X).Append("\n");
            sb.Append("  Y: ").Append(Y).Append("\n");
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
            return this.Equals(obj as BarcodeCoordinate);
        }

        /// <summary>
        /// Returns true if BarcodeCoordinate instances are equal
        /// </summary>
        /// <param name="other">Instance of BarcodeCoordinate to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(BarcodeCoordinate other)
        {
            // credit: http://stackoverflow.com/a/10454552/677735
            if (other == null)
                return false;

            return 
                (
                    this.Anchor == other.Anchor ||
                    this.Anchor != null &&
                    this.Anchor.Equals(other.Anchor)
                ) && 
                (
                    this.X == other.X ||
                    this.X != null &&
                    this.X.Equals(other.X)
                ) && 
                (
                    this.Y == other.Y ||
                    this.Y != null &&
                    this.Y.Equals(other.Y)
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
                if (this.Anchor != null)
                    hash = hash * 59 + this.Anchor.GetHashCode();
                if (this.X != null)
                    hash = hash * 59 + this.X.GetHashCode();
                if (this.Y != null)
                    hash = hash * 59 + this.Y.GetHashCode();
                return hash;
            }
        }
    }

}
