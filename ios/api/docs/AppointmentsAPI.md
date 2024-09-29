# AppointmentsAPI

All URIs are relative to *https://demo.docdream.com:8001*

Method | HTTP request | Description
------------- | ------------- | -------------
[**appointmentGetAppointmentInfo**](AppointmentsAPI.md#appointmentgetappointmentinfo) | **GET** /api/appointments/{appointmentId} | Get appointment by id
[**appointmentGetAppointments**](AppointmentsAPI.md#appointmentgetappointments) | **GET** /api/appointments | Get list of appointments. Either date range or patient Id is required
[**appointmentPatchAppointment**](AppointmentsAPI.md#appointmentpatchappointment) | **PATCH** /api/appointments/{appointmentId} | Update appointment by id
[**appointmentPlanAppointment**](AppointmentsAPI.md#appointmentplanappointment) | **POST** /api/appointments | Create appointment. Appointment is created in confirmed (Planned) state. Venue is automatic.


# **appointmentGetAppointmentInfo**
```swift
    open class func appointmentGetAppointmentInfo(appointmentId: Int, completion: @escaping (_ data: AppointmentOrderApiInfo?, _ error: Error?) -> Void)
```

Get appointment by id

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let appointmentId = 987 // Int | 

// Get appointment by id
AppointmentsAPI.appointmentGetAppointmentInfo(appointmentId: appointmentId) { (response, error) in
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
 **appointmentId** | **Int** |  | 

### Return type

[**AppointmentOrderApiInfo**](AppointmentOrderApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **appointmentGetAppointments**
```swift
    open class func appointmentGetAppointments(startDate: Date? = nil, endDate: Date? = nil, patientId: Int? = nil, executorId: Int? = nil, referrerId: Int? = nil, unitId: Int? = nil, completion: @escaping (_ data: [AppointmentApiInfo]?, _ error: Error?) -> Void)
```

Get list of appointments. Either date range or patient Id is required

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let startDate = Date() // Date | Date filter (optional)
let endDate = Date() // Date | Date filter (optional)
let patientId = 987 // Int | Patient filter (optional)
let executorId = 987 // Int | Executor filter (optional)
let referrerId = 987 // Int | Referrer filter (optional)
let unitId = 987 // Int | Unit filter (optional)

// Get list of appointments. Either date range or patient Id is required
AppointmentsAPI.appointmentGetAppointments(startDate: startDate, endDate: endDate, patientId: patientId, executorId: executorId, referrerId: referrerId, unitId: unitId) { (response, error) in
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
 **startDate** | **Date** | Date filter | [optional] 
 **endDate** | **Date** | Date filter | [optional] 
 **patientId** | **Int** | Patient filter | [optional] 
 **executorId** | **Int** | Executor filter | [optional] 
 **referrerId** | **Int** | Referrer filter | [optional] 
 **unitId** | **Int** | Unit filter | [optional] 

### Return type

[**[AppointmentApiInfo]**](AppointmentApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **appointmentPatchAppointment**
```swift
    open class func appointmentPatchAppointment(appointmentId: Int, appointmentApiPatch: AppointmentApiPatch, completion: @escaping (_ data: URL?, _ error: Error?) -> Void)
```

Update appointment by id

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let appointmentId = 987 // Int | 
let appointmentApiPatch = AppointmentApiPatch(state: AppointmentApiPatch_state(value: AppointmentState())) // AppointmentApiPatch | 

// Update appointment by id
AppointmentsAPI.appointmentPatchAppointment(appointmentId: appointmentId, appointmentApiPatch: appointmentApiPatch) { (response, error) in
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
 **appointmentId** | **Int** |  | 
 **appointmentApiPatch** | [**AppointmentApiPatch**](AppointmentApiPatch.md) |  | 

### Return type

**URL**

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/octet-stream

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **appointmentPlanAppointment**
```swift
    open class func appointmentPlanAppointment(appointmentPlanningRequest: AppointmentPlanningRequest, completion: @escaping (_ data: AppointmentApiInfo?, _ error: Error?) -> Void)
```

Create appointment. Appointment is created in confirmed (Planned) state. Venue is automatic.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let appointmentPlanningRequest = AppointmentPlanningRequest(personId: 123, mainExecutorId: 123, unitId: 123, start: Date(), duration: 123, state: AppointmentPlanningRequest_state(), reserveExpiration: Date(), referrerId: 123, services: [ServiceInAppointmentRequest(routineId: 123, unitPrice: 123, discount: 123)]) // AppointmentPlanningRequest | 

// Create appointment. Appointment is created in confirmed (Planned) state. Venue is automatic.
AppointmentsAPI.appointmentPlanAppointment(appointmentPlanningRequest: appointmentPlanningRequest) { (response, error) in
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
 **appointmentPlanningRequest** | [**AppointmentPlanningRequest**](AppointmentPlanningRequest.md) |  | 

### Return type

[**AppointmentApiInfo**](AppointmentApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

