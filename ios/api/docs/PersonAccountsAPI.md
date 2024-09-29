# PersonAccountsAPI

All URIs are relative to *https://demo.docdream.com:8001*

Method | HTTP request | Description
------------- | ------------- | -------------
[**personAccountGetAccounts**](PersonAccountsAPI.md#personaccountgetaccounts) | **GET** /api/persons/{personId}/accounts | Get person accounts
[**personAccountGetPersonPayments**](PersonAccountsAPI.md#personaccountgetpersonpayments) | **GET** /api/personAccounts/{personId}/records | Get person payments
[**personAccountTopUpPersonAccount**](PersonAccountsAPI.md#personaccounttopuppersonaccount) | **POST** /api/personAccounts/{personAccountId}/records | Top up person account by adding Internet payment


# **personAccountGetAccounts**
```swift
    open class func personAccountGetAccounts(personId: Int, completion: @escaping (_ data: [AccountBalanceApiInfo]?, _ error: Error?) -> Void)
```

Get person accounts

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let personId = 987 // Int | 

// Get person accounts
PersonAccountsAPI.personAccountGetAccounts(personId: personId) { (response, error) in
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

[**[AccountBalanceApiInfo]**](AccountBalanceApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **personAccountGetPersonPayments**
```swift
    open class func personAccountGetPersonPayments(personId: Int, startDate: Date, endDate: Date, completion: @escaping (_ data: [PaymentApiInfo]?, _ error: Error?) -> Void)
```

Get person payments

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let personId = 987 // Int | 
let startDate = Date() // Date | 
let endDate = Date() // Date | 

// Get person payments
PersonAccountsAPI.personAccountGetPersonPayments(personId: personId, startDate: startDate, endDate: endDate) { (response, error) in
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
 **startDate** | **Date** |  | 
 **endDate** | **Date** |  | 

### Return type

[**[PaymentApiInfo]**](PaymentApiInfo.md)

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **personAccountTopUpPersonAccount**
```swift
    open class func personAccountTopUpPersonAccount(personAccountId: Int, createAccountRecordApiRequest: CreateAccountRecordApiRequest, completion: @escaping (_ data: URL?, _ error: Error?) -> Void)
```

Top up person account by adding Internet payment

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let personAccountId = 987 // Int | 
let createAccountRecordApiRequest = CreateAccountRecordApiRequest(amount: 123, transactionDateTime: Date()) // CreateAccountRecordApiRequest | 

// Top up person account by adding Internet payment
PersonAccountsAPI.personAccountTopUpPersonAccount(personAccountId: personAccountId, createAccountRecordApiRequest: createAccountRecordApiRequest) { (response, error) in
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
 **personAccountId** | **Int** |  | 
 **createAccountRecordApiRequest** | [**CreateAccountRecordApiRequest**](CreateAccountRecordApiRequest.md) |  | 

### Return type

**URL**

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/octet-stream

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

