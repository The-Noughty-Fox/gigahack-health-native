# PromotionsAPI

All URIs are relative to *https://demo.docdream.com:8001*

Method | HTTP request | Description
------------- | ------------- | -------------
[**promotionGetAll**](PromotionsAPI.md#promotiongetall) | **GET** /api/promotions | Get all active promotions
[**promotionGetPromotion**](PromotionsAPI.md#promotiongetpromotion) | **GET** /api/promotions/{promotionId} | Get promotion details
[**promotionGetRoutinePromotions**](PromotionsAPI.md#promotiongetroutinepromotions) | **GET** /api/routines/{routineId}/promotions | Get possible promotions for routine


# **promotionGetAll**
```swift
    open class func promotionGetAll(completion: @escaping (_ data: [EntityApiInfo]?, _ error: Error?) -> Void)
```

Get all active promotions

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API


// Get all active promotions
PromotionsAPI.promotionGetAll() { (response, error) in
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

# **promotionGetPromotion**
```swift
    open class func promotionGetPromotion(promotionId: Int, completion: @escaping (_ data: PromotionApiInfo?, _ error: Error?) -> Void)
```

Get promotion details

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let promotionId = 987 // Int | 

// Get promotion details
PromotionsAPI.promotionGetPromotion(promotionId: promotionId) { (response, error) in
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
 **promotionId** | **Int** |  | 

### Return type

[**PromotionApiInfo**](PromotionApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **promotionGetRoutinePromotions**
```swift
    open class func promotionGetRoutinePromotions(routineId: Int, completion: @escaping (_ data: [RoutinePromotionApiInfo]?, _ error: Error?) -> Void)
```

Get possible promotions for routine

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let routineId = 987 // Int | 

// Get possible promotions for routine
PromotionsAPI.promotionGetRoutinePromotions(routineId: routineId) { (response, error) in
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

[**[RoutinePromotionApiInfo]**](RoutinePromotionApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

