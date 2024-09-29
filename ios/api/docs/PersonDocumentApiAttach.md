# PersonDocumentApiAttach

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**documentName** | **String** | Original file name. If has extension, will be used to determine content type if ContentType is not specified. File name without extension becomes document name. | 
**documentDate** | **Date** | Document date / time. If not specified, current date is used | [optional] 
**documentType** | [**PersonDocumentApiAttachDocumentType**](PersonDocumentApiAttachDocumentType.md) |  | [optional] 
**contentType** | [**PersonDocumentApiAttachContentType**](PersonDocumentApiAttachContentType.md) |  | [optional] 
**content** | **Data** | Base64 encoded file content | 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


