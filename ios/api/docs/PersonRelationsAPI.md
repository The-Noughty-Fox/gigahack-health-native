# PersonRelationsAPI

All URIs are relative to *https://demo.docdream.com:8001*

Method | HTTP request | Description
------------- | ------------- | -------------
[**personRelationCreatePersonRelation**](PersonRelationsAPI.md#personrelationcreatepersonrelation) | **POST** /api/persons/{personId}/relations | Create a new person relation
[**personRelationGetPersonRelations**](PersonRelationsAPI.md#personrelationgetpersonrelations) | **GET** /api/persons/{personId}/relations | Get person relations


# **personRelationCreatePersonRelation**
```swift
    open class func personRelationCreatePersonRelation(personId: Int, createPersonRelationApiRequest: CreatePersonRelationApiRequest, completion: @escaping (_ data: EntityIdApiInfo?, _ error: Error?) -> Void)
```

Create a new person relation

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let personId = 987 // Int | 
let createPersonRelationApiRequest = CreatePersonRelationApiRequest(relatedPersonId: 123, relationTypeId: 123, isPartyA: false, shareMobilePhone: false, shareLandLine: false, shareEmail: false, shareDocuments: false) // CreatePersonRelationApiRequest | 

// Create a new person relation
PersonRelationsAPI.personRelationCreatePersonRelation(personId: personId, createPersonRelationApiRequest: createPersonRelationApiRequest) { (response, error) in
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
 **createPersonRelationApiRequest** | [**CreatePersonRelationApiRequest**](CreatePersonRelationApiRequest.md) |  | 

### Return type

[**EntityIdApiInfo**](EntityIdApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **personRelationGetPersonRelations**
```swift
    open class func personRelationGetPersonRelations(personId: Int, completion: @escaping (_ data: URL?, _ error: Error?) -> Void)
```

Get person relations

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let personId = 987 // Int | 

// Get person relations
PersonRelationsAPI.personRelationGetPersonRelations(personId: personId) { (response, error) in
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

**URL**

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/octet-stream

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

