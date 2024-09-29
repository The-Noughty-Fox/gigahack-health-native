# ReferringDoctorsAPI

All URIs are relative to *https://demo.docdream.com:8001*

Method | HTTP request | Description
------------- | ------------- | -------------
[**practitionerCreatePractitioner**](ReferringDoctorsAPI.md#practitionercreatepractitioner) | **POST** /api/practitioners | Create practitioner (referring doctor). Id of existing person should be provided. Id of practitioner resource is equal to person.id
[**practitionerGetCommissions**](ReferringDoctorsAPI.md#practitionergetcommissions) | **GET** /api/practitioners/{practitionerId}/commissions | Gets practitioner commissions for the period
[**practitionerGetCustomers**](ReferringDoctorsAPI.md#practitionergetcustomers) | **GET** /api/practitioners/{practitionerId}/persons | Gets ids of patient (persons), which had at least one service referred to by specified practitioner within specified dates.
[**practitionerGetPractitioners**](ReferringDoctorsAPI.md#practitionergetpractitioners) | **GET** /api/practitioners | Get referring doctors


# **practitionerCreatePractitioner**
```swift
    open class func practitionerCreatePractitioner(createPractitionerApiRequest: CreatePractitionerApiRequest, completion: @escaping (_ data: EntityIdApiInfo?, _ error: Error?) -> Void)
```

Create practitioner (referring doctor). Id of existing person should be provided. Id of practitioner resource is equal to person.id

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let createPractitionerApiRequest = CreatePractitionerApiRequest(personId: 123, principalSpecialityId: 123) // CreatePractitionerApiRequest | 

// Create practitioner (referring doctor). Id of existing person should be provided. Id of practitioner resource is equal to person.id
ReferringDoctorsAPI.practitionerCreatePractitioner(createPractitionerApiRequest: createPractitionerApiRequest) { (response, error) in
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
 **createPractitionerApiRequest** | [**CreatePractitionerApiRequest**](CreatePractitionerApiRequest.md) |  | 

### Return type

[**EntityIdApiInfo**](EntityIdApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **practitionerGetCommissions**
```swift
    open class func practitionerGetCommissions(practitionerId: Int, startDate: Date, endDate: Date, completion: @escaping (_ data: [CommissionInfo]?, _ error: Error?) -> Void)
```

Gets practitioner commissions for the period

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let practitionerId = 987 // Int | 
let startDate = Date() // Date | 
let endDate = Date() // Date | 

// Gets practitioner commissions for the period
ReferringDoctorsAPI.practitionerGetCommissions(practitionerId: practitionerId, startDate: startDate, endDate: endDate) { (response, error) in
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
 **practitionerId** | **Int** |  | 
 **startDate** | **Date** |  | 
 **endDate** | **Date** |  | 

### Return type

[**[CommissionInfo]**](CommissionInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **practitionerGetCustomers**
```swift
    open class func practitionerGetCustomers(practitionerId: Int, startDate: Date, endDate: Date, completion: @escaping (_ data: [Int]?, _ error: Error?) -> Void)
```

Gets ids of patient (persons), which had at least one service referred to by specified practitioner within specified dates.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let practitionerId = 987 // Int | 
let startDate = Date() // Date | 
let endDate = Date() // Date | 

// Gets ids of patient (persons), which had at least one service referred to by specified practitioner within specified dates.
ReferringDoctorsAPI.practitionerGetCustomers(practitionerId: practitionerId, startDate: startDate, endDate: endDate) { (response, error) in
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
 **practitionerId** | **Int** |  | 
 **startDate** | **Date** |  | 
 **endDate** | **Date** |  | 

### Return type

**[Int]**

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **practitionerGetPractitioners**
```swift
    open class func practitionerGetPractitioners(code: String? = nil, page: Int? = nil, pageSize: Int? = nil, completion: @escaping (_ data: [PractitionerApiInfo]?, _ error: Error?) -> Void)
```

Get referring doctors

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let code = "code_example" // String | Code (optional)
let page = 987 // Int | Page (optional) (default to 1)
let pageSize = 987 // Int | Page size (max 200) (optional) (default to 50)

// Get referring doctors
ReferringDoctorsAPI.practitionerGetPractitioners(code: code, page: page, pageSize: pageSize) { (response, error) in
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
 **code** | **String** | Code | [optional] 
 **page** | **Int** | Page | [optional] [default to 1]
 **pageSize** | **Int** | Page size (max 200) | [optional] [default to 50]

### Return type

[**[PractitionerApiInfo]**](PractitionerApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

