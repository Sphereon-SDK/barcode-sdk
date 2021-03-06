# barcode

Barcode - JavaScript client for barcode
<b>The Barcode Reader API '/reader' reads barcodes from image files and returns the barcode data as JSON files.</b>    The flow is generally as follows:  1. First upload an image using the /reader POST endpoint. You will get back a job response that contains a job with its associated settings.  2. Start the job from a PUT request to the /reader/{jobid} endpoint, with the Job and Settings JSON as request body. The barcode detection will now start.  3. Check the job status from the /reader/{jobid} GET endpoint until the status has changed to DONE or ERROR. Messaging using a websocket will be available as an alternative in a future version  4. Retrieve the JSON file using the /reader/{jobid}/stream GET endpoint. This will return the JSON file only when the status is DONE. In other cases it will return the Job Response JSON (with http code 202 instead of 200)      <b>Interactive testing: </b>A web based test console is available in the <a href=\"https://store.sphereon.com\">Sphereon API Store</a>
This SDK is automatically generated by the [Swagger Codegen](https://github.com/swagger-api/swagger-codegen) project:

- API version: 0.1.0
- Package version: 0.1.0
- Build date: 2017-06-22T18:03:48.863+02:00
- Build package: class io.swagger.codegen.languages.JavascriptClientCodegen
For more information, please visit [https://sphereon.com](https://sphereon.com)

## Installation

### For [Node.js](https://nodejs.org/)

#### npm

To publish the library as a [npm](https://www.npmjs.com/),
please follow the procedure in ["Publishing npm packages"](https://docs.npmjs.com/getting-started/publishing-npm-packages).

Then install it via:

```shell
npm install barcode --save
```

#### git
#
If the library is hosted at a git repository, e.g.
https://github.com/GIT_USER_ID/GIT_REPO_ID
then install it via:

```shell
    npm install GIT_USER_ID/GIT_REPO_ID --save
```

### For browser

The library also works in the browser environment via npm and [browserify](http://browserify.org/). After following
the above steps with Node.js and installing browserify with `npm install -g browserify`,
perform the following (assuming *main.js* is your entry file):

```shell
browserify main.js > bundle.js
```

Then include *bundle.js* in the HTML pages.

## Getting Started

Please follow the [installation](#installation) instruction and execute the following JS code:

```javascript
var Barcode = require('barcode');

var defaultClient = Barcode.ApiClient.instance;

// Configure OAuth2 access token for authorization: oauth2schema
var oauth2schema = defaultClient.authentications['oauth2schema'];
oauth2schema.accessToken = "YOUR ACCESS TOKEN"

var api = new Barcode.BarcodeReaderApi()

var jobid = "jobid_example"; // {String} jobid


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
api.deleteJob(jobid, callback);

```

## Documentation for API Endpoints

All URIs are relative to *https://gw.api.cloud.sphereon.com/*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*Barcode.BarcodeReaderApi* | [**deleteJob**](docs/BarcodeReaderApi.md#deleteJob) | **DELETE** /barcode/0.1.0/reader/{jobid} | Delete a job manually
*Barcode.BarcodeReaderApi* | [**getJob**](docs/BarcodeReaderApi.md#getJob) | **GET** /barcode/0.1.0/reader/{jobid} | Job definition and state
*Barcode.BarcodeReaderApi* | [**submitJob**](docs/BarcodeReaderApi.md#submitJob) | **PUT** /barcode/0.1.0/reader/{jobid} | Submit job for reading
*Barcode.BarcodeReaderApi* | [**uploadFile**](docs/BarcodeReaderApi.md#uploadFile) | **POST** /barcode/0.1.0/reader | Upload the file


## Documentation for Models

 - [Barcode.Barcode](docs/Barcode.md)
 - [Barcode.BarcodeCoordinate](docs/BarcodeCoordinate.md)
 - [Barcode.Error](docs/Error.md)
 - [Barcode.ErrorResponse](docs/ErrorResponse.md)
 - [Barcode.Lifecycle](docs/Lifecycle.md)
 - [Barcode.ReaderEngineTask](docs/ReaderEngineTask.md)
 - [Barcode.ReaderJob](docs/ReaderJob.md)
 - [Barcode.ReaderJobResponse](docs/ReaderJobResponse.md)
 - [Barcode.ReaderJobSettings](docs/ReaderJobSettings.md)
 - [Barcode.ReaderResultJobResponse](docs/ReaderResultJobResponse.md)


## Documentation for Authorization


### oauth2schema

- **Type**: OAuth
- **Flow**: application
- **Authorization URL**: 
- **Scopes**: 
  - global: accessEverything

