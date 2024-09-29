# PricingAPI

All URIs are relative to *https://demo.docdream.com:8001*

Method | HTTP request | Description
------------- | ------------- | -------------
[**priceModelsGetPriceModels**](PricingAPI.md#pricemodelsgetpricemodels) | **GET** /api/priceModels | 
[**priceModelsGetPriceRules**](PricingAPI.md#pricemodelsgetpricerules) | **GET** /api/priceModels/{priceModelId}/priceRules | 
[**priceModelsGetRoutinePrice**](PricingAPI.md#pricemodelsgetroutineprice) | **GET** /api/priceModels/{priceModelId}/routines/{routineId} | 


# **priceModelsGetPriceModels**
```swift
    open class func priceModelsGetPriceModels(completion: @escaping (_ data: [PriceModelApiInfo]?, _ error: Error?) -> Void)
```



### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API


PricingAPI.priceModelsGetPriceModels() { (response, error) in
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

[**[PriceModelApiInfo]**](PriceModelApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **priceModelsGetPriceRules**
```swift
    open class func priceModelsGetPriceRules(priceModelId: Int, completion: @escaping (_ data: [RoutinePriceApiInfo]?, _ error: Error?) -> Void)
```



### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let priceModelId = 987 // Int | 

PricingAPI.priceModelsGetPriceRules(priceModelId: priceModelId) { (response, error) in
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
 **priceModelId** | **Int** |  | 

### Return type

[**[RoutinePriceApiInfo]**](RoutinePriceApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **priceModelsGetRoutinePrice**
```swift
    open class func priceModelsGetRoutinePrice(priceModelId: Int, routineId: Int, completion: @escaping (_ data: RoutinePriceApiInfo?, _ error: Error?) -> Void)
```



### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let priceModelId = 987 // Int | 
let routineId = 987 // Int | 

PricingAPI.priceModelsGetRoutinePrice(priceModelId: priceModelId, routineId: routineId) { (response, error) in
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
 **priceModelId** | **Int** |  | 
 **routineId** | **Int** |  | 

### Return type

[**RoutinePriceApiInfo**](RoutinePriceApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

