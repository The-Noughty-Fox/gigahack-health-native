//
// CreatePersonRelationApiRequest.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation
#if canImport(AnyCodable)
import AnyCodable
#endif

public struct CreatePersonRelationApiRequest: Codable, JSONEncodable, Hashable {

    public var relatedPersonId: Int?
    public var relationTypeId: Int?
    public var isPartyA: Bool?
    public var shareMobilePhone: Bool?
    public var shareLandLine: Bool?
    public var shareEmail: Bool?
    public var shareDocuments: Bool?

    public init(relatedPersonId: Int? = nil, relationTypeId: Int? = nil, isPartyA: Bool? = nil, shareMobilePhone: Bool? = nil, shareLandLine: Bool? = nil, shareEmail: Bool? = nil, shareDocuments: Bool? = nil) {
        self.relatedPersonId = relatedPersonId
        self.relationTypeId = relationTypeId
        self.isPartyA = isPartyA
        self.shareMobilePhone = shareMobilePhone
        self.shareLandLine = shareLandLine
        self.shareEmail = shareEmail
        self.shareDocuments = shareDocuments
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case relatedPersonId
        case relationTypeId
        case isPartyA
        case shareMobilePhone
        case shareLandLine
        case shareEmail
        case shareDocuments
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(relatedPersonId, forKey: .relatedPersonId)
        try container.encodeIfPresent(relationTypeId, forKey: .relationTypeId)
        try container.encodeIfPresent(isPartyA, forKey: .isPartyA)
        try container.encodeIfPresent(shareMobilePhone, forKey: .shareMobilePhone)
        try container.encodeIfPresent(shareLandLine, forKey: .shareLandLine)
        try container.encodeIfPresent(shareEmail, forKey: .shareEmail)
        try container.encodeIfPresent(shareDocuments, forKey: .shareDocuments)
    }
}

