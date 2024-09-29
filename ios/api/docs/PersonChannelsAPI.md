# PersonChannelsAPI

All URIs are relative to *https://demo.docdream.com:8001*

Method | HTTP request | Description
------------- | ------------- | -------------
[**personChannelsCreatePersonChannel**](PersonChannelsAPI.md#personchannelscreatepersonchannel) | **POST** /api/persons/{personId}/channels | 
[**personChannelsDeletePersonChannel**](PersonChannelsAPI.md#personchannelsdeletepersonchannel) | **DELETE** /api/personChannels/{channelId} | 
[**personChannelsGetPersonChannels**](PersonChannelsAPI.md#personchannelsgetpersonchannels) | **GET** /api/persons/{personId}/channels | 
[**personChannelsPersonChannelPatch**](PersonChannelsAPI.md#personchannelspersonchannelpatch) | **PATCH** /api/personChannels/{channelId} | 


# **personChannelsCreatePersonChannel**
```swift
    open class func personChannelsCreatePersonChannel(personId: Int, personChannelApiCreate: PersonChannelApiCreate, completion: @escaping (_ data: EntityIdApiInfo?, _ error: Error?) -> Void)
```



### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let personId = 987 // Int | 
let personChannelApiCreate = PersonChannelApiCreate(typeId: 123, value: "value_example", comment: "comment_example", allowDocumentDelivery: false, allowNotifications: false, allowPromotions: false) // PersonChannelApiCreate | 

PersonChannelsAPI.personChannelsCreatePersonChannel(personId: personId, personChannelApiCreate: personChannelApiCreate) { (response, error) in
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
 **personId** | **Int** |  | 
 **personChannelApiCreate** | [**PersonChannelApiCreate**](PersonChannelApiCreate.md) |  | 

### Return type

[**EntityIdApiInfo**](EntityIdApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **personChannelsDeletePersonChannel**
```swift
    open class func personChannelsDeletePersonChannel(channelId: Int, completion: @escaping (_ data: URL?, _ error: Error?) -> Void)
```



### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let channelId = 987 // Int | 

PersonChannelsAPI.personChannelsDeletePersonChannel(channelId: channelId) { (response, error) in
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
 **channelId** | **Int** |  | 

### Return type

**URL**

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/octet-stream

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **personChannelsGetPersonChannels**
```swift
    open class func personChannelsGetPersonChannels(personId: Int, completion: @escaping (_ data: [PersonChannelApiInfo]?, _ error: Error?) -> Void)
```



### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let personId = 987 // Int | 

PersonChannelsAPI.personChannelsGetPersonChannels(personId: personId) { (response, error) in
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
 **personId** | **Int** |  | 

### Return type

[**[PersonChannelApiInfo]**](PersonChannelApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **personChannelsPersonChannelPatch**
```swift
    open class func personChannelsPersonChannelPatch(channelId: Int, personChannelApiPatch: PersonChannelApiPatch, completion: @escaping (_ data: URL?, _ error: Error?) -> Void)
```



### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let channelId = 987 // Int | 
let personChannelApiPatch = PersonChannelApiPatch(typeId: PersonChannelApiPatch_typeId(value: 123), value: PersonChannelApiPatch_value(value: "value_example"), comment: nil, allowDocumentDelivery: PersonChannelApiPatch_allowDocumentDelivery(value: false), allowNotifications: nil, allowPromotions: nil) // PersonChannelApiPatch | 

PersonChannelsAPI.personChannelsPersonChannelPatch(channelId: channelId, personChannelApiPatch: personChannelApiPatch) { (response, error) in
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
 **channelId** | **Int** |  | 
 **personChannelApiPatch** | [**PersonChannelApiPatch**](PersonChannelApiPatch.md) |  | 

### Return type

**URL**

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/octet-stream

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

