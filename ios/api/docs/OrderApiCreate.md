# OrderApiCreate

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**unitId** | **Int** |  | 
**patientId** | **Int** |  | 
**dateTime** | **Date** | Date (or date and time) used for order. If not specified, current date/time is used. | [optional] 
**referrerId** | **Int** | Referrer (practitioner) which will be set for services in order. | [optional] 
**services** | [ServiceInOrderRequest] |  | [optional] 
**comment** | **String** |  | [optional] 
**diagnosisForInvoice** | **String** |  | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


