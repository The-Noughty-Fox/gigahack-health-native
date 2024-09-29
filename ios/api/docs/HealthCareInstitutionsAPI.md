# HealthCareInstitutionsAPI

All URIs are relative to *https://demo.docdream.com:8001*

Method | HTTP request | Description
------------- | ------------- | -------------
[**healthCareInstitutionsGet**](HealthCareInstitutionsAPI.md#healthcareinstitutionsget) | **GET** /api/healthCareInstitutions/{id} | 
[**healthCareInstitutionsGetAll**](HealthCareInstitutionsAPI.md#healthcareinstitutionsgetall) | **GET** /api/healthCareInstitutions | 


# **healthCareInstitutionsGet**
```swift
    open class func healthCareInstitutionsGet(id: Int, completion: @escaping (_ data: EntityApiInfo?, _ error: Error?) -> Void)
```



### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let id = 987 // Int | 

HealthCareInstitutionsAPI.healthCareInstitutionsGet(id: id) { (response, error) in
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
 **id** | **Int** |  | 

### Return type

[**EntityApiInfo**](EntityApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **healthCareInstitutionsGetAll**
```swift
    open class func healthCareInstitutionsGetAll(completion: @escaping (_ data: [EntityApiInfo]?, _ error: Error?) -> Void)
```



### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API


HealthCareInstitutionsAPI.healthCareInstitutionsGetAll() { (response, error) in
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

