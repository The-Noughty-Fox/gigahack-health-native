//
// AreasAPI.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation
#if canImport(AnyCodable)
import AnyCodable
#endif

open class AreasAPI {

    /**

     - parameter id: (path)  
     - returns: EntityApiInfo
     */
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open class func areasGet(id: Int) async throws -> EntityApiInfo {
        return try await areasGetWithRequestBuilder(id: id).execute().body
    }

    /**
     - GET /api/areas/{id}
     - API Key:
       - type: apiKey Api-Key (HEADER)
       - name: Api-Key
     - parameter id: (path)  
     - returns: RequestBuilder<EntityApiInfo> 
     */
    open class func areasGetWithRequestBuilder(id: Int) -> RequestBuilder<EntityApiInfo> {
        var localVariablePath = "/api/areas/{id}"
        let idPreEscape = "\(APIHelper.mapValueToPathItem(id))"
        let idPostEscape = idPreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAllowed) ?? ""
        localVariablePath = localVariablePath.replacingOccurrences(of: "{id}", with: idPostEscape, options: .literal, range: nil)
        let localVariableURLString = APIAPI.basePath + localVariablePath
        let localVariableParameters: [String: Any]? = nil

        let localVariableUrlComponents = URLComponents(string: localVariableURLString)

        let localVariableNillableHeaders: [String: Any?] = [
            :
        ]

        let localVariableHeaderParameters = APIHelper.rejectNilHeaders(localVariableNillableHeaders)

        let localVariableRequestBuilder: RequestBuilder<EntityApiInfo>.Type = APIAPI.requestBuilderFactory.getBuilder()

        return localVariableRequestBuilder.init(method: "GET", URLString: (localVariableUrlComponents?.string ?? localVariableURLString), parameters: localVariableParameters, headers: localVariableHeaderParameters, requiresAuthentication: true)
    }

    /**

     - returns: [EntityApiInfo]
     */
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open class func areasGetAll() async throws -> [EntityApiInfo] {
        return try await areasGetAllWithRequestBuilder().execute().body
    }

    /**
     - GET /api/areas
     - API Key:
       - type: apiKey Api-Key (HEADER)
       - name: Api-Key
     - returns: RequestBuilder<[EntityApiInfo]> 
     */
    open class func areasGetAllWithRequestBuilder() -> RequestBuilder<[EntityApiInfo]> {
        let localVariablePath = "/api/areas"
        let localVariableURLString = APIAPI.basePath + localVariablePath
        let localVariableParameters: [String: Any]? = nil

        let localVariableUrlComponents = URLComponents(string: localVariableURLString)

        let localVariableNillableHeaders: [String: Any?] = [
            :
        ]

        let localVariableHeaderParameters = APIHelper.rejectNilHeaders(localVariableNillableHeaders)

        let localVariableRequestBuilder: RequestBuilder<[EntityApiInfo]>.Type = APIAPI.requestBuilderFactory.getBuilder()

        return localVariableRequestBuilder.init(method: "GET", URLString: (localVariableUrlComponents?.string ?? localVariableURLString), parameters: localVariableParameters, headers: localVariableHeaderParameters, requiresAuthentication: true)
    }
}
