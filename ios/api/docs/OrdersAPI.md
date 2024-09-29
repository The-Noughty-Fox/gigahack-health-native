# OrdersAPI

All URIs are relative to *https://demo.docdream.com:8001*

Method | HTTP request | Description
------------- | ------------- | -------------
[**orderCreateNewOrder**](OrdersAPI.md#ordercreateneworder) | **POST** /api/orders | Create new order
[**orderGetOrder**](OrdersAPI.md#ordergetorder) | **GET** /api/orders/{orderId} | Get order by id
[**orderGetOrders**](OrdersAPI.md#ordergetorders) | **GET** /api/person/{patientId}/orders | Get list of orders


# **orderCreateNewOrder**
```swift
    open class func orderCreateNewOrder(orderApiCreate: OrderApiCreate, completion: @escaping (_ data: EntityIdApiInfo?, _ error: Error?) -> Void)
```

Create new order

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let orderApiCreate = OrderApiCreate(unitId: 123, patientId: 123, dateTime: Date(), referrerId: 123, services: [ServiceInOrderRequest(routineId: 123, unitPrice: 123, discount: 123)], comment: "comment_example", diagnosisForInvoice: "diagnosisForInvoice_example") // OrderApiCreate | 

// Create new order
OrdersAPI.orderCreateNewOrder(orderApiCreate: orderApiCreate) { (response, error) in
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
 **orderApiCreate** | [**OrderApiCreate**](OrderApiCreate.md) |  | 

### Return type

[**EntityIdApiInfo**](EntityIdApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **orderGetOrder**
```swift
    open class func orderGetOrder(orderId: Int, completion: @escaping (_ data: OrderApiInfo?, _ error: Error?) -> Void)
```

Get order by id

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let orderId = 987 // Int | 

// Get order by id
OrdersAPI.orderGetOrder(orderId: orderId) { (response, error) in
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
 **orderId** | **Int** |  | 

### Return type

[**OrderApiInfo**](OrderApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **orderGetOrders**
```swift
    open class func orderGetOrders(patientId: Int, startDate: Date? = nil, endDate: Date? = nil, unitId: Int? = nil, completion: @escaping (_ data: [OrderShortApiInfo]?, _ error: Error?) -> Void)
```

Get list of orders

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let patientId = 987 // Int | Patient filter
let startDate = Date() // Date | Date filter (optional)
let endDate = Date() // Date | Date filter (optional)
let unitId = 987 // Int | Unit filter (optional)

// Get list of orders
OrdersAPI.orderGetOrders(patientId: patientId, startDate: startDate, endDate: endDate, unitId: unitId) { (response, error) in
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
 **patientId** | **Int** | Patient filter | 
 **startDate** | **Date** | Date filter | [optional] 
 **endDate** | **Date** | Date filter | [optional] 
 **unitId** | **Int** | Unit filter | [optional] 

### Return type

[**[OrderShortApiInfo]**](OrderShortApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

