# PersonsAPI

All URIs are relative to *https://demo.docdream.com:8001*

Method | HTTP request | Description
------------- | ------------- | -------------
[**personIdDocumentsCreatePersonIdDocument**](PersonsAPI.md#personiddocumentscreatepersoniddocument) | **POST** /api/persons/{personId}/idDocuments | 
[**personsCreatePerson**](PersonsAPI.md#personscreateperson) | **POST** /api/persons | Create new person.
[**personsCreatePersonalDataConsentForm**](PersonsAPI.md#personscreatepersonaldataconsentform) | **POST** /api/persons/{personId}/personalDataConsentForms | Register new personal data consent form for a person.
[**personsGetPerson**](PersonsAPI.md#personsgetperson) | **GET** /api/persons/{personId} | Returns details for a specific person.
[**personsGetPersonPractitionersInfos**](PersonsAPI.md#personsgetpersonpractitionersinfos) | **GET** /api/persons/{personId}/practitioners | Gets ids of practitioners, which had at least one service referred to by specified person within specified dates.
[**personsGetPersonSettlementInfos**](PersonsAPI.md#personsgetpersonsettlementinfos) | **GET** /api/persons/{personId}/settlements | Returns payments (sales) for a person, used for CRM customer profiling.
[**personsGetPersonalDataConsentForms**](PersonsAPI.md#personsgetpersonaldataconsentforms) | **GET** /api/persons/{personId}/personalDataConsentForms | Retrieves the personal data consent forms for a specified person.
[**personsIndex**](PersonsAPI.md#personsindex) | **GET** /api/persons | At least 1 parameter is required from the following: lastName, barcode, identificationNumber, channel
[**personsPatchPerson**](PersonsAPI.md#personspatchperson) | **PATCH** /api/persons/{personId} | Updates person. Handle with care! Employees can also be updated in this way.


# **personIdDocumentsCreatePersonIdDocument**
```swift
    open class func personIdDocumentsCreatePersonIdDocument(personId: Int, personIdDocumentApiCreate: PersonIdDocumentApiCreate, completion: @escaping (_ data: EntityIdApiInfo?, _ error: Error?) -> Void)
```



### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let personId = 987 // Int | 
let personIdDocumentApiCreate = PersonIdDocumentApiCreate(typeId: 123, number: "number_example", issuedBy: "issuedBy_example", issuedOn: Date(), expiresOn: Date(), firstName: "firstName_example", lastName: "lastName_example") // PersonIdDocumentApiCreate | 

PersonsAPI.personIdDocumentsCreatePersonIdDocument(personId: personId, personIdDocumentApiCreate: personIdDocumentApiCreate) { (response, error) in
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
 **personIdDocumentApiCreate** | [**PersonIdDocumentApiCreate**](PersonIdDocumentApiCreate.md) |  | 

### Return type

[**EntityIdApiInfo**](EntityIdApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **personsCreatePerson**
```swift
    open class func personsCreatePerson(personApiCreate: PersonApiCreate, completion: @escaping (_ data: EntityIdApiInfo?, _ error: Error?) -> Void)
```

Create new person.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let personApiCreate = PersonApiCreate(firstName: "firstName_example", lastName: "lastName_example", patronymicName: "patronymicName_example", dateOfBirth: Date(), gender: PersonGender(), createAccountForDefaultOwnCompany: false) // PersonApiCreate | 

// Create new person.
PersonsAPI.personsCreatePerson(personApiCreate: personApiCreate) { (response, error) in
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
 **personApiCreate** | [**PersonApiCreate**](PersonApiCreate.md) |  | 

### Return type

[**EntityIdApiInfo**](EntityIdApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **personsCreatePersonalDataConsentForm**
```swift
    open class func personsCreatePersonalDataConsentForm(personId: Int, completion: @escaping (_ data: EntityIdApiInfo?, _ error: Error?) -> Void)
```

Register new personal data consent form for a person.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let personId = 987 // Int | 

// Register new personal data consent form for a person.
PersonsAPI.personsCreatePersonalDataConsentForm(personId: personId) { (response, error) in
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

### Return type

[**EntityIdApiInfo**](EntityIdApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **personsGetPerson**
```swift
    open class func personsGetPerson(personId: Int, completion: @escaping (_ data: PersonApiInfo?, _ error: Error?) -> Void)
```

Returns details for a specific person.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let personId = 987 // Int | 

// Returns details for a specific person.
PersonsAPI.personsGetPerson(personId: personId) { (response, error) in
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

### Return type

[**PersonApiInfo**](PersonApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **personsGetPersonPractitionersInfos**
```swift
    open class func personsGetPersonPractitionersInfos(personId: Int, startDate: Date, endDate: Date, completion: @escaping (_ data: [EntityApiInfo]?, _ error: Error?) -> Void)
```

Gets ids of practitioners, which had at least one service referred to by specified person within specified dates.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let personId = 987 // Int | 
let startDate = Date() // Date | 
let endDate = Date() // Date | 

// Gets ids of practitioners, which had at least one service referred to by specified person within specified dates.
PersonsAPI.personsGetPersonPractitionersInfos(personId: personId, startDate: startDate, endDate: endDate) { (response, error) in
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
 **startDate** | **Date** |  | 
 **endDate** | **Date** |  | 

### Return type

[**[EntityApiInfo]**](EntityApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **personsGetPersonSettlementInfos**
```swift
    open class func personsGetPersonSettlementInfos(personId: Int, startDate: Date, endDate: Date, completion: @escaping (_ data: [PersonSettlementInfo]?, _ error: Error?) -> Void)
```

Returns payments (sales) for a person, used for CRM customer profiling.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let personId = 987 // Int | 
let startDate = Date() // Date | 
let endDate = Date() // Date | 

// Returns payments (sales) for a person, used for CRM customer profiling.
PersonsAPI.personsGetPersonSettlementInfos(personId: personId, startDate: startDate, endDate: endDate) { (response, error) in
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
 **startDate** | **Date** |  | 
 **endDate** | **Date** |  | 

### Return type

[**[PersonSettlementInfo]**](PersonSettlementInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **personsGetPersonalDataConsentForms**
```swift
    open class func personsGetPersonalDataConsentForms(personId: Int, completion: @escaping (_ data: [PersonalDataConsentFormApiInfo]?, _ error: Error?) -> Void)
```

Retrieves the personal data consent forms for a specified person.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let personId = 987 // Int | 

// Retrieves the personal data consent forms for a specified person.
PersonsAPI.personsGetPersonalDataConsentForms(personId: personId) { (response, error) in
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

### Return type

[**[PersonalDataConsentFormApiInfo]**](PersonalDataConsentFormApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **personsIndex**
```swift
    open class func personsIndex(lastName: String? = nil, firstName: String? = nil, patronymicName: String? = nil, channel: String? = nil, barcode: String? = nil, identificationNumber: String? = nil, dateOfBirth: Date? = nil, completion: @escaping (_ data: [PersonApiSearchResult]?, _ error: Error?) -> Void)
```

At least 1 parameter is required from the following: lastName, barcode, identificationNumber, channel

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let lastName = "lastName_example" // String |  (optional)
let firstName = "firstName_example" // String |  (optional)
let patronymicName = "patronymicName_example" // String |  (optional)
let channel = "channel_example" // String |  (optional)
let barcode = "barcode_example" // String |  (optional)
let identificationNumber = "identificationNumber_example" // String |  (optional)
let dateOfBirth = Date() // Date |  (optional)

// At least 1 parameter is required from the following: lastName, barcode, identificationNumber, channel
PersonsAPI.personsIndex(lastName: lastName, firstName: firstName, patronymicName: patronymicName, channel: channel, barcode: barcode, identificationNumber: identificationNumber, dateOfBirth: dateOfBirth) { (response, error) in
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
 **lastName** | **String** |  | [optional] 
 **firstName** | **String** |  | [optional] 
 **patronymicName** | **String** |  | [optional] 
 **channel** | **String** |  | [optional] 
 **barcode** | **String** |  | [optional] 
 **identificationNumber** | **String** |  | [optional] 
 **dateOfBirth** | **Date** |  | [optional] 

### Return type

[**[PersonApiSearchResult]**](PersonApiSearchResult.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **personsPatchPerson**
```swift
    open class func personsPatchPerson(personId: Int, personApiPatch: PersonApiPatch, completion: @escaping (_ data: URL?, _ error: Error?) -> Void)
```

Updates person. Handle with care! Employees can also be updated in this way.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let personId = 987 // Int | 
let personApiPatch = PersonApiPatch(firstName: PersonChannelApiPatch_value(value: "value_example"), lastName: nil, patronymicName: nil, dateOfBirth: PersonApiPatch_dateOfBirth(value: Date()), gender: PersonApiPatch_gender(value: PersonGender())) // PersonApiPatch | 

// Updates person. Handle with care! Employees can also be updated in this way.
PersonsAPI.personsPatchPerson(personId: personId, personApiPatch: personApiPatch) { (response, error) in
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
 **personApiPatch** | [**PersonApiPatch**](PersonApiPatch.md) |  | 

### Return type

**URL**

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/octet-stream

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

