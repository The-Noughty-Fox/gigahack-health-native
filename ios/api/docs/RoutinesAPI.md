# RoutinesAPI

All URIs are relative to *https://demo.docdream.com:8001*

Method | HTTP request | Description
------------- | ------------- | -------------
[**routinesGetRoutine**](RoutinesAPI.md#routinesgetroutine) | **GET** /api/routines/{routineId} | Get details for routine
[**routinesGetRoutineGroups**](RoutinesAPI.md#routinesgetroutinegroups) | **GET** /api/routineGroups | Get routine groups
[**routinesSearchRoutines**](RoutinesAPI.md#routinessearchroutines) | **GET** /api/routines | Search routines. If search is not specified, all routines are returned


# **routinesGetRoutine**
```swift
    open class func routinesGetRoutine(routineId: Int, completion: @escaping (_ data: RoutineApiInfo?, _ error: Error?) -> Void)
```

Get details for routine

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let routineId = 987 // Int | 

// Get details for routine
RoutinesAPI.routinesGetRoutine(routineId: routineId) { (response, error) in
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
 **routineId** | **Int** |  | 

### Return type

[**RoutineApiInfo**](RoutineApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **routinesGetRoutineGroups**
```swift
    open class func routinesGetRoutineGroups(completion: @escaping (_ data: [RoutineGroupApiInfo]?, _ error: Error?) -> Void)
```

Get routine groups

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API


// Get routine groups
RoutinesAPI.routinesGetRoutineGroups() { (response, error) in
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

[**[RoutineGroupApiInfo]**](RoutineGroupApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **routinesSearchRoutines**
```swift
    open class func routinesSearchRoutines(search: String? = nil, includeDeactivated: Bool? = nil, completion: @escaping (_ data: [RoutineApiSearchResult]?, _ error: Error?) -> Void)
```

Search routines. If search is not specified, all routines are returned

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let search = "search_example" // String | Part of name, group name, keyword, or code (exact match) (optional)
let includeDeactivated = true // Bool | Include inactive routines into search result (optional)

// Search routines. If search is not specified, all routines are returned
RoutinesAPI.routinesSearchRoutines(search: search, includeDeactivated: includeDeactivated) { (response, error) in
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
 **search** | **String** | Part of name, group name, keyword, or code (exact match) | [optional] 
 **includeDeactivated** | **Bool** | Include inactive routines into search result | [optional] 

### Return type

[**[RoutineApiSearchResult]**](RoutineApiSearchResult.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

