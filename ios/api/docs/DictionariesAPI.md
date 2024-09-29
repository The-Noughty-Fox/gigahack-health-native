# DictionariesAPI

All URIs are relative to *https://demo.docdream.com:8001*

Method | HTTP request | Description
------------- | ------------- | -------------
[**communicationChannelTypesGet**](DictionariesAPI.md#communicationchanneltypesget) | **GET** /api/communicationChannelTypes | 
[**containersGet**](DictionariesAPI.md#containersget) | **GET** /api/containers | 
[**personIdDocumentTypesGetPersonIdDocumentTypes**](DictionariesAPI.md#personiddocumenttypesgetpersoniddocumenttypes) | **GET** /api/personIdDocumentTypes | 
[**personRelationTypesGetPersonRelationTypes**](DictionariesAPI.md#personrelationtypesgetpersonrelationtypes) | **GET** /api/personRelationTypes | Gets person relation types to use for personRelation resource
[**specialitiesGet**](DictionariesAPI.md#specialitiesget) | **GET** /api/specialities | 
[**substancesGet**](DictionariesAPI.md#substancesget) | **GET** /api/substances | 


# **communicationChannelTypesGet**
```swift
    open class func communicationChannelTypesGet(completion: @escaping (_ data: [EntityApiInfo]?, _ error: Error?) -> Void)
```



### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API


DictionariesAPI.communicationChannelTypesGet() { (response, error) in
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
This endpoint does not need any parameter.

### Return type

[**[EntityApiInfo]**](EntityApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **containersGet**
```swift
    open class func containersGet(completion: @escaping (_ data: [EntityApiInfo]?, _ error: Error?) -> Void)
```



### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API


DictionariesAPI.containersGet() { (response, error) in
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
This endpoint does not need any parameter.

### Return type

[**[EntityApiInfo]**](EntityApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **personIdDocumentTypesGetPersonIdDocumentTypes**
```swift
    open class func personIdDocumentTypesGetPersonIdDocumentTypes(completion: @escaping (_ data: [PersonIdDocumentTypeApiInfo]?, _ error: Error?) -> Void)
```



### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API


DictionariesAPI.personIdDocumentTypesGetPersonIdDocumentTypes() { (response, error) in
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
This endpoint does not need any parameter.

### Return type

[**[PersonIdDocumentTypeApiInfo]**](PersonIdDocumentTypeApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **personRelationTypesGetPersonRelationTypes**
```swift
    open class func personRelationTypesGetPersonRelationTypes(completion: @escaping (_ data: [PersonRelationTypeApiInfo]?, _ error: Error?) -> Void)
```

Gets person relation types to use for personRelation resource

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API


// Gets person relation types to use for personRelation resource
DictionariesAPI.personRelationTypesGetPersonRelationTypes() { (response, error) in
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
This endpoint does not need any parameter.

### Return type

[**[PersonRelationTypeApiInfo]**](PersonRelationTypeApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **specialitiesGet**
```swift
    open class func specialitiesGet(completion: @escaping (_ data: [EntityApiInfo]?, _ error: Error?) -> Void)
```



### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API


DictionariesAPI.specialitiesGet() { (response, error) in
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
This endpoint does not need any parameter.

### Return type

[**[EntityApiInfo]**](EntityApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **substancesGet**
```swift
    open class func substancesGet(completion: @escaping (_ data: [EntityApiInfo]?, _ error: Error?) -> Void)
```



### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API


DictionariesAPI.substancesGet() { (response, error) in
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
This endpoint does not need any parameter.

### Return type

[**[EntityApiInfo]**](EntityApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

