//
// PersonAccountsAPI.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation
#if canImport(AnyCodable)
import AnyCodable
#endif

open class PersonAccountsAPI {

    /**
     Get person accounts
     
     - parameter personId: (path)  
     - returns: [AccountBalanceApiInfo]
     */
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open class func personAccountGetAccounts(personId: Int) async throws -> [AccountBalanceApiInfo] {
        return try await personAccountGetAccountsWithRequestBuilder(personId: personId).execute().body
    }

    /**
     Get person accounts
     - GET /api/persons/{personId}/accounts
     - API Key:
       - type: apiKey Api-Key (HEADER)
       - name: Api-Key
     - parameter personId: (path)  
     - returns: RequestBuilder<[AccountBalanceApiInfo]> 
     */
    open class func personAccountGetAccountsWithRequestBuilder(personId: Int) -> RequestBuilder<[AccountBalanceApiInfo]> {
        var localVariablePath = "/api/persons/{personId}/accounts"
        let personIdPreEscape = "\(APIHelper.mapValueToPathItem(personId))"
        let personIdPostEscape = personIdPreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAllowed) ?? ""
        localVariablePath = localVariablePath.replacingOccurrences(of: "{personId}", with: personIdPostEscape, options: .literal, range: nil)
        let localVariableURLString = APIAPI.basePath + localVariablePath
        let localVariableParameters: [String: Any]? = nil

        let localVariableUrlComponents = URLComponents(string: localVariableURLString)

        let localVariableNillableHeaders: [String: Any?] = [
            :
        ]

        let localVariableHeaderParameters = APIHelper.rejectNilHeaders(localVariableNillableHeaders)

        let localVariableRequestBuilder: RequestBuilder<[AccountBalanceApiInfo]>.Type = APIAPI.requestBuilderFactory.getBuilder()

        return localVariableRequestBuilder.init(method: "GET", URLString: (localVariableUrlComponents?.string ?? localVariableURLString), parameters: localVariableParameters, headers: localVariableHeaderParameters, requiresAuthentication: true)
    }

    /**
     Get person payments
     
     - parameter personId: (path)  
     - parameter startDate: (query)  
     - parameter endDate: (query)  
     - returns: [PaymentApiInfo]
     */
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open class func personAccountGetPersonPayments(personId: Int, startDate: Date, endDate: Date) async throws -> [PaymentApiInfo] {
        return try await personAccountGetPersonPaymentsWithRequestBuilder(personId: personId, startDate: startDate, endDate: endDate).execute().body
    }

    /**
     Get person payments
     - GET /api/personAccounts/{personId}/records
     - API Key:
       - type: apiKey Api-Key (HEADER)
       - name: Api-Key
     - parameter personId: (path)  
     - parameter startDate: (query)  
     - parameter endDate: (query)  
     - returns: RequestBuilder<[PaymentApiInfo]> 
     */
    open class func personAccountGetPersonPaymentsWithRequestBuilder(personId: Int, startDate: Date, endDate: Date) -> RequestBuilder<[PaymentApiInfo]> {
        var localVariablePath = "/api/personAccounts/{personId}/records"
        let personIdPreEscape = "\(APIHelper.mapValueToPathItem(personId))"
        let personIdPostEscape = personIdPreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAllowed) ?? ""
        localVariablePath = localVariablePath.replacingOccurrences(of: "{personId}", with: personIdPostEscape, options: .literal, range: nil)
        let localVariableURLString = APIAPI.basePath + localVariablePath
        let localVariableParameters: [String: Any]? = nil

        var localVariableUrlComponents = URLComponents(string: localVariableURLString)
        localVariableUrlComponents?.queryItems = APIHelper.mapValuesToQueryItems([
            "startDate": (wrappedValue: startDate.encodeToJSON(), isExplode: true),
            "endDate": (wrappedValue: endDate.encodeToJSON(), isExplode: true),
        ])

        let localVariableNillableHeaders: [String: Any?] = [
            :
        ]

        let localVariableHeaderParameters = APIHelper.rejectNilHeaders(localVariableNillableHeaders)

        let localVariableRequestBuilder: RequestBuilder<[PaymentApiInfo]>.Type = APIAPI.requestBuilderFactory.getBuilder()

        return localVariableRequestBuilder.init(method: "GET", URLString: (localVariableUrlComponents?.string ?? localVariableURLString), parameters: localVariableParameters, headers: localVariableHeaderParameters, requiresAuthentication: true)
    }

    /**
     Top up person account by adding Internet payment
     
     - parameter personAccountId: (path)  
     - parameter createAccountRecordApiRequest: (body)  
     - returns: URL
     */
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open class func personAccountTopUpPersonAccount(personAccountId: Int, createAccountRecordApiRequest: CreateAccountRecordApiRequest) async throws -> URL {
        return try await personAccountTopUpPersonAccountWithRequestBuilder(personAccountId: personAccountId, createAccountRecordApiRequest: createAccountRecordApiRequest).execute().body
    }

    /**
     Top up person account by adding Internet payment
     - POST /api/personAccounts/{personAccountId}/records
     - API Key:
       - type: apiKey Api-Key (HEADER)
       - name: Api-Key
     - parameter personAccountId: (path)  
     - parameter createAccountRecordApiRequest: (body)  
     - returns: RequestBuilder<URL> 
     */
    open class func personAccountTopUpPersonAccountWithRequestBuilder(personAccountId: Int, createAccountRecordApiRequest: CreateAccountRecordApiRequest) -> RequestBuilder<URL> {
        var localVariablePath = "/api/personAccounts/{personAccountId}/records"
        let personAccountIdPreEscape = "\(APIHelper.mapValueToPathItem(personAccountId))"
        let personAccountIdPostEscape = personAccountIdPreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAllowed) ?? ""
        localVariablePath = localVariablePath.replacingOccurrences(of: "{personAccountId}", with: personAccountIdPostEscape, options: .literal, range: nil)
        let localVariableURLString = APIAPI.basePath + localVariablePath
        let localVariableParameters = JSONEncodingHelper.encodingParameters(forEncodableObject: createAccountRecordApiRequest)

        let localVariableUrlComponents = URLComponents(string: localVariableURLString)

        let localVariableNillableHeaders: [String: Any?] = [
            "Content-Type": "application/json",
        ]

        let localVariableHeaderParameters = APIHelper.rejectNilHeaders(localVariableNillableHeaders)

        let localVariableRequestBuilder: RequestBuilder<URL>.Type = APIAPI.requestBuilderFactory.getBuilder()

        return localVariableRequestBuilder.init(method: "POST", URLString: (localVariableUrlComponents?.string ?? localVariableURLString), parameters: localVariableParameters, headers: localVariableHeaderParameters, requiresAuthentication: true)
    }
}
