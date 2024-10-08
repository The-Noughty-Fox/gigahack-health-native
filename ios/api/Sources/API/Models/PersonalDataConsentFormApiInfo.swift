//
// PersonalDataConsentFormApiInfo.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation
#if canImport(AnyCodable)
import AnyCodable
#endif

public struct PersonalDataConsentFormApiInfo: Codable, JSONEncodable, Hashable {

    public var id: Int?
    public var signedOn: Date?
    public var createdById: Int?

    public init(id: Int? = nil, signedOn: Date? = nil, createdById: Int? = nil) {
        self.id = id
        self.signedOn = signedOn
        self.createdById = createdById
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case id
        case signedOn
        case createdById
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(id, forKey: .id)
        try container.encodeIfPresent(signedOn, forKey: .signedOn)
        try container.encodeIfPresent(createdById, forKey: .createdById)
    }
}

