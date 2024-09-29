# AppointmentPlanningRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**personId** | **Int** | Person to plan appointment for | 
**mainExecutorId** | **Int** | Id of main executor resource (employee or role). Use id of executor which is returned by api/planning | 
**unitId** | **Int** | Id of Unit to plan appointment | 
**start** | **Date** | Date and time of appointment start | 
**duration** | **Int** | Appointment duration in minutes | 
**state** | [**AppointmentPlanningRequestState**](AppointmentPlanningRequestState.md) |  | [optional] 
**reserveExpiration** | **Date** | Date and time of reserve expiration. Used only for Reserved state. If empty, 10 minutes is assumed | [optional] 
**referrerId** | **Int** | Id of referring doctor (practitioner resource). | [optional] 
**services** | [ServiceInAppointmentRequest] | List of services to plan. May be null/empty, empty appointments are permitted. | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


