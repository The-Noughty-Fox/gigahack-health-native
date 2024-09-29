# DocumentsAPI

All URIs are relative to *https://demo.docdream.com:8001*

Method | HTTP request | Description
------------- | ------------- | -------------
[**documentsAttachDocument**](DocumentsAPI.md#documentsattachdocument) | **POST** /api/persons/{personId}/documents | Attach file to patient&#39;s medical card
[**documentsDownloadAttachment**](DocumentsAPI.md#documentsdownloadattachment) | **GET** /api/documents/{documentId}/download | Download attachment
[**documentsDownloadDocumentFromAccessCode**](DocumentsAPI.md#documentsdownloaddocumentfromaccesscode) | **GET** /api/documents/onlineaccesscode/{onlineAccessCode}/download | Download document from online access code
[**documentsGetDocumentRecords**](DocumentsAPI.md#documentsgetdocumentrecords) | **GET** /api/documents/{documentId}/records | 
[**documentsGetHl7**](DocumentsAPI.md#documentsgethl7) | **GET** /api/documents/{documentId}/hl7 | Get document as HL7 v2 message
[**documentsGetPersonDocuments**](DocumentsAPI.md#documentsgetpersondocuments) | **GET** /api/persons/{personId}/documents | List documents for a person. Documents must be finalized (protected) to appear here.
[**documentsRenderPdf**](DocumentsAPI.md#documentsrenderpdf) | **GET** /api/documents/{documentId}/render | Render document as PDF


# **documentsAttachDocument**
```swift
    open class func documentsAttachDocument(personId: Int, personDocumentApiAttach: PersonDocumentApiAttach, completion: @escaping (_ data: URL?, _ error: Error?) -> Void)
```

Attach file to patient's medical card

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let personId = 987 // Int | 
let personDocumentApiAttach = PersonDocumentApiAttach(documentName: "documentName_example", documentDate: Date(), documentType: PersonDocumentApiAttach_documentType(), contentType: PersonDocumentApiAttach_contentType(), content: 123) // PersonDocumentApiAttach | contentType: PdfDocument | Jpeg | Png | Gif | HtmlDocument | DicomFile  documentType: TitlePage | Consultation | Diary | ExaminationReport | LaboratoryResult | InterventionRecord | PrescriptionSheet | Epicrisis | Certificate | Referral | Consent | Contract | Financial | OtherNonMedical | OtherMedical

// Attach file to patient's medical card
DocumentsAPI.documentsAttachDocument(personId: personId, personDocumentApiAttach: personDocumentApiAttach) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **personId** | **Int** |  | 
 **personDocumentApiAttach** | [**PersonDocumentApiAttach**](PersonDocumentApiAttach.md) | contentType: PdfDocument | Jpeg | Png | Gif | HtmlDocument | DicomFile  documentType: TitlePage | Consultation | Diary | ExaminationReport | LaboratoryResult | InterventionRecord | PrescriptionSheet | Epicrisis | Certificate | Referral | Consent | Contract | Financial | OtherNonMedical | OtherMedical | 

### Return type

**URL**

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/octet-stream

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **documentsDownloadAttachment**
```swift
    open class func documentsDownloadAttachment(documentId: Int, completion: @escaping (_ data: URL?, _ error: Error?) -> Void)
```

Download attachment

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let documentId = 987 // Int | 

// Download attachment
DocumentsAPI.documentsDownloadAttachment(documentId: documentId) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **documentId** | **Int** |  | 

### Return type

**URL**

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/octet-stream

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **documentsDownloadDocumentFromAccessCode**
```swift
    open class func documentsDownloadDocumentFromAccessCode(onlineAccessCode: String, completion: @escaping (_ data: URL?, _ error: Error?) -> Void)
```

Download document from online access code

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let onlineAccessCode = "onlineAccessCode_example" // String | 

// Download document from online access code
DocumentsAPI.documentsDownloadDocumentFromAccessCode(onlineAccessCode: onlineAccessCode) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **onlineAccessCode** | **String** |  | 

### Return type

**URL**

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/octet-stream

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **documentsGetDocumentRecords**
```swift
    open class func documentsGetDocumentRecords(documentId: Int, completion: @escaping (_ data: [DocumentRecordApiInfo]?, _ error: Error?) -> Void)
```



### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let documentId = 987 // Int | 

DocumentsAPI.documentsGetDocumentRecords(documentId: documentId) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **documentId** | **Int** |  | 

### Return type

[**[DocumentRecordApiInfo]**](DocumentRecordApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **documentsGetHl7**
```swift
    open class func documentsGetHl7(documentId: Int, completion: @escaping (_ data: URL?, _ error: Error?) -> Void)
```

Get document as HL7 v2 message

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let documentId = 987 // Int | 

// Get document as HL7 v2 message
DocumentsAPI.documentsGetHl7(documentId: documentId) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **documentId** | **Int** |  | 

### Return type

**URL**

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/octet-stream

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **documentsGetPersonDocuments**
```swift
    open class func documentsGetPersonDocuments(personId: Int, startDate: Date? = nil, endDate: Date? = nil, completion: @escaping (_ data: [DocumentApiInfo]?, _ error: Error?) -> Void)
```

List documents for a person. Documents must be finalized (protected) to appear here.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let personId = 987 // Int | 
let startDate = Date() // Date | Date filter (optional)
let endDate = Date() // Date | Date filter (optional)

// List documents for a person. Documents must be finalized (protected) to appear here.
DocumentsAPI.documentsGetPersonDocuments(personId: personId, startDate: startDate, endDate: endDate) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **personId** | **Int** |  | 
 **startDate** | **Date** | Date filter | [optional] 
 **endDate** | **Date** | Date filter | [optional] 

### Return type

[**[DocumentApiInfo]**](DocumentApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **documentsRenderPdf**
```swift
    open class func documentsRenderPdf(documentId: Int, completion: @escaping (_ data: URL?, _ error: Error?) -> Void)
```

Render document as PDF

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let documentId = 987 // Int | 

// Render document as PDF
DocumentsAPI.documentsRenderPdf(documentId: documentId) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **documentId** | **Int** |  | 

### Return type

**URL**

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/octet-stream

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

