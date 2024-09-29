# RoutineApiInfo

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **String** |  | [optional] 
**shortName** | **String** |  | [optional] 
**code** | **String** |  | [optional] 
**isActive** | **Bool** |  | [optional] 
**nameLanguage1** | **String** |  | [optional] 
**nameLanguage2** | **String** |  | [optional] 
**isAvailableOnline** | **Bool** | Marked as available online in DocDream | [optional] 
**type** | [**RoutineApiInfoType**](RoutineApiInfoType.md) |  | [optional] 
**description** | **String** |  | [optional] 
**descriptionLanguage1** | **String** |  | [optional] 
**descriptionLanguage2** | **String** |  | [optional] 
**routineGroupId** | **Int** | Routine group | [optional] 
**preparationDescription** | **String** |  | [optional] 
**preparationDescriptionLanguage1** | **String** |  | [optional] 
**preparationDescriptionLanguage2** | **String** |  | [optional] 
**printInPriceList** | **Bool** | Print in price list in DocDream | [optional] 
**disableAddingAsStandaloneService** | **Bool** | Cannot be added to order separately, only can be used within package service | [optional] 
**defaultSpecialityId** | **Int** | Default speciality routine is associated with. Most useful for consultations. | [optional] 
**regularRoutineType** | [**RoutineApiInfoRegularRoutineType**](RoutineApiInfoRegularRoutineType.md) |  | [optional] 
**encounterLocationType** | [**RoutineApiInfoEncounterLocationType**](RoutineApiInfoEncounterLocationType.md) |  | [optional] 
**durationSingle** | **Int** | Duration of appointment if routine is the only one | [optional] 
**durationCombined** | **Int** | If appointment has several routines, it&#39;s duration is Max(Sum(DurationCombined),Max(DurationSingle)) | [optional] 
**isProfile** | **Bool** | Is profile (composite laboratory test) | [optional] 
**substanceId** | **Int** | Substance for laboratory test. null for profiles - determine via components | [optional] 
**containerId** | **Int** | Container for laboratory test. null for profiles - determine via components | [optional] 
**turnAroundTimeHours** | **Int** | Turn around time (hours) - from sampling to result delivery, as promised to customer | [optional] 
**intakeRoutineIds** | **[Int]** | Intake routine ids. For profiles, intakes for all component tests are returned. | [optional] 
**labProfileComponents** | **[Int]** | List of profile components | [optional] 
**packageComponents** | [ComponentApiInfo] | List of package components | [optional] 
**createdOn** | **Date** |  | [optional] 
**updatedOn** | **Date** |  | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


