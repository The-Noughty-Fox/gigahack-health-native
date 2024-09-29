# ResourcesAPI

All URIs are relative to *https://demo.docdream.com:8001*

Method | HTTP request | Description
------------- | ------------- | -------------
[**employeesGetCommissions**](ResourcesAPI.md#employeesgetcommissions) | **GET** /api/employees/{employeeId}/commissions | Gets executor commissions for the period
[**employeesGetEmployees**](ResourcesAPI.md#employeesgetemployees) | **GET** /api/employees | Get list of employees
[**executorsGetAbilities**](ResourcesAPI.md#executorsgetabilities) | **GET** /api/executors/{executorId}/abilities | Get list of routines executor is capable of
[**executorsGetCustomers**](ResourcesAPI.md#executorsgetcustomers) | **GET** /api/executors/{executorId}/persons | Gets ids of patient (persons), which had at least one service performed to by specified executor within specified dates.
[**executorsGetEmployees**](ResourcesAPI.md#executorsgetemployees) | **GET** /api/executors | Get list of executors
[**resourceTimeslotGetTimeSlots**](ResourcesAPI.md#resourcetimeslotgettimeslots) | **GET** /api/employees/{employeeId}/timeslots | Gets employee timeslots for the specified dates, grouped by unit
[**unitsGet**](ResourcesAPI.md#unitsget) | **GET** /api/units | Get list of units - clinic and blood drawing points. Units are used when planning and creating orders.


# **employeesGetCommissions**
```swift
    open class func employeesGetCommissions(employeeId: Int, startDate: Date, endDate: Date, completion: @escaping (_ data: [CommissionInfo]?, _ error: Error?) -> Void)
```

Gets executor commissions for the period

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let employeeId = 987 // Int | 
let startDate = Date() // Date | 
let endDate = Date() // Date | 

// Gets executor commissions for the period
ResourcesAPI.employeesGetCommissions(employeeId: employeeId, startDate: startDate, endDate: endDate) { (response, error) in
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
 **employeeId** | **Int** |  | 
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

# **employeesGetEmployees**
```swift
    open class func employeesGetEmployees(specialityId: Int? = nil, unitId: Int? = nil, includeNonActive: Bool? = nil, completion: @escaping (_ data: [EmployeeApiInfo]?, _ error: Error?) -> Void)
```

Get list of employees

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let specialityId = 987 // Int | Optional speciality filter (optional)
let unitId = 987 // Int | Optional unit filter (optional)
let includeNonActive = true // Bool | Include non active employees (optional) (default to false)

// Get list of employees
ResourcesAPI.employeesGetEmployees(specialityId: specialityId, unitId: unitId, includeNonActive: includeNonActive) { (response, error) in
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
 **specialityId** | **Int** | Optional speciality filter | [optional] 
 **unitId** | **Int** | Optional unit filter | [optional] 
 **includeNonActive** | **Bool** | Include non active employees | [optional] [default to false]

### Return type

[**[EmployeeApiInfo]**](EmployeeApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **executorsGetAbilities**
```swift
    open class func executorsGetAbilities(executorId: Int, completion: @escaping (_ data: [AbilityApiInfo]?, _ error: Error?) -> Void)
```

Get list of routines executor is capable of

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let executorId = 987 // Int | Id of executor (not same as employeeId!)

// Get list of routines executor is capable of
ResourcesAPI.executorsGetAbilities(executorId: executorId) { (response, error) in
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
 **executorId** | **Int** | Id of executor (not same as employeeId!) | 

### Return type

[**[AbilityApiInfo]**](AbilityApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **executorsGetCustomers**
```swift
    open class func executorsGetCustomers(executorId: Int, startDate: Date, endDate: Date, completion: @escaping (_ data: [Int]?, _ error: Error?) -> Void)
```

Gets ids of patient (persons), which had at least one service performed to by specified executor within specified dates.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let executorId = 987 // Int | 
let startDate = Date() // Date | 
let endDate = Date() // Date | 

// Gets ids of patient (persons), which had at least one service performed to by specified executor within specified dates.
ResourcesAPI.executorsGetCustomers(executorId: executorId, startDate: startDate, endDate: endDate) { (response, error) in
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
 **executorId** | **Int** |  | 
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

# **executorsGetEmployees**
```swift
    open class func executorsGetEmployees(specialityId: Int? = nil, unitId: Int? = nil, includeNonActive: Bool? = nil, completion: @escaping (_ data: [ExecutorApiInfo]?, _ error: Error?) -> Void)
```

Get list of executors

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let specialityId = 987 // Int | Optional speciality filter (optional)
let unitId = 987 // Int | Optional unit filter (optional)
let includeNonActive = true // Bool | Include non active executors (optional) (default to false)

// Get list of executors
ResourcesAPI.executorsGetEmployees(specialityId: specialityId, unitId: unitId, includeNonActive: includeNonActive) { (response, error) in
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
 **specialityId** | **Int** | Optional speciality filter | [optional] 
 **unitId** | **Int** | Optional unit filter | [optional] 
 **includeNonActive** | **Bool** | Include non active executors | [optional] [default to false]

### Return type

[**[ExecutorApiInfo]**](ExecutorApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **resourceTimeslotGetTimeSlots**
```swift
    open class func resourceTimeslotGetTimeSlots(employeeId: Int, startDate: Date, endDate: Date, unitId: Int? = nil, completion: @escaping (_ data: [ExecutorUnitTimeslots]?, _ error: Error?) -> Void)
```

Gets employee timeslots for the specified dates, grouped by unit

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let employeeId = 987 // Int | 
let startDate = Date() // Date | 
let endDate = Date() // Date | 
let unitId = 987 // Int |  (optional)

// Gets employee timeslots for the specified dates, grouped by unit
ResourcesAPI.resourceTimeslotGetTimeSlots(employeeId: employeeId, startDate: startDate, endDate: endDate, unitId: unitId) { (response, error) in
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
 **employeeId** | **Int** |  | 
 **startDate** | **Date** |  | 
 **endDate** | **Date** |  | 
 **unitId** | **Int** |  | [optional] 

### Return type

[**[ExecutorUnitTimeslots]**](ExecutorUnitTimeslots.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **unitsGet**
```swift
    open class func unitsGet(completion: @escaping (_ data: [UnitApiInfo]?, _ error: Error?) -> Void)
```

Get list of units - clinic and blood drawing points. Units are used when planning and creating orders.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API


// Get list of units - clinic and blood drawing points. Units are used when planning and creating orders.
ResourcesAPI.unitsGet() { (response, error) in
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

[**[UnitApiInfo]**](UnitApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

