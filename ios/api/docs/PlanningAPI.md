# PlanningAPI

All URIs are relative to *https://demo.docdream.com:8001*

Method | HTTP request | Description
------------- | ------------- | -------------
[**planningApiGetMultiPlanningAppointmentData**](PlanningAPI.md#planningapigetmultiplanningappointmentdata) | **POST** /api/planning/multi | Get multiple planning appointment data
[**planningApiGetPlanning**](PlanningAPI.md#planningapigetplanning) | **GET** /api/planning | Get available intervals according to search parameters.


# **planningApiGetMultiPlanningAppointmentData**
```swift
    open class func planningApiGetMultiPlanningAppointmentData(getMultiPlanningAppointmentDataRequest: GetMultiPlanningAppointmentDataRequest, completion: @escaping (_ data: [AppointmentPlanningDataApiInfo]?, _ error: Error?) -> Void)
```

Get multiple planning appointment data

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let getMultiPlanningAppointmentDataRequest = GetMultiPlanningAppointmentDataRequest(unitId: 123, routineIds: [123]) // GetMultiPlanningAppointmentDataRequest | 

// Get multiple planning appointment data
PlanningAPI.planningApiGetMultiPlanningAppointmentData(getMultiPlanningAppointmentDataRequest: getMultiPlanningAppointmentDataRequest) { (response, error) in
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
 **getMultiPlanningAppointmentDataRequest** | [**GetMultiPlanningAppointmentDataRequest**](GetMultiPlanningAppointmentDataRequest.md) |  | 

### Return type

[**[AppointmentPlanningDataApiInfo]**](AppointmentPlanningDataApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **planningApiGetPlanning**
```swift
    open class func planningApiGetPlanning(startDate: Date, endDate: Date, unitId: Int? = nil, executorId: Int? = nil, specialityId: Int? = nil, routineId: Int? = nil, completion: @escaping (_ data: [PlanningResultApiInfo]?, _ error: Error?) -> Void)
```

Get available intervals according to search parameters.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let startDate = Date() // Date | 
let endDate = Date() // Date | 
let unitId = 987 // Int |  (optional)
let executorId = 987 // Int |  (optional)
let specialityId = 987 // Int |  (optional)
let routineId = 987 // Int |  (optional)

// Get available intervals according to search parameters.
PlanningAPI.planningApiGetPlanning(startDate: startDate, endDate: endDate, unitId: unitId, executorId: executorId, specialityId: specialityId, routineId: routineId) { (response, error) in
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
 **startDate** | **Date** |  | 
 **endDate** | **Date** |  | 
 **unitId** | **Int** |  | [optional] 
 **executorId** | **Int** |  | [optional] 
 **specialityId** | **Int** |  | [optional] 
 **routineId** | **Int** |  | [optional] 

### Return type

[**[PlanningResultApiInfo]**](PlanningResultApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

