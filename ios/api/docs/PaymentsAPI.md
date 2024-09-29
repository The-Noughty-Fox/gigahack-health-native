# PaymentsAPI

All URIs are relative to *https://demo.docdream.com:8001*

Method | HTTP request | Description
------------- | ------------- | -------------
[**paymentsCreatePayment**](PaymentsAPI.md#paymentscreatepayment) | **POST** /api/payments | Create new payment


# **paymentsCreatePayment**
```swift
    open class func paymentsCreatePayment(createPaymentApiRequest: CreatePaymentApiRequest, completion: @escaping (_ data: URL?, _ error: Error?) -> Void)
```

Create new payment

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import API

let createPaymentApiRequest = CreatePaymentApiRequest(invoiceId: 123, appointmentId: 123, appointmentIds: [123], orderId: 123, orderIds: [123], amount: 123, transactionDateTime: Date(), id: "id_example", comment: "comment_example") // CreatePaymentApiRequest | 

// Create new payment
PaymentsAPI.paymentsCreatePayment(createPaymentApiRequest: createPaymentApiRequest) { (response, error) in
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
 **createPaymentApiRequest** | [**CreatePaymentApiRequest**](CreatePaymentApiRequest.md) |  | 

### Return type

**URL**

### Authorization

[Api-Key](../README.md#Api-Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/octet-stream

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

