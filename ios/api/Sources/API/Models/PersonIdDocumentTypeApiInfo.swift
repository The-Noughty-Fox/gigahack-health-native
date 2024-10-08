//
// PersonIdDocumentTypeApiInfo.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation
#if canImport(AnyCodable)
import AnyCodable
#endif

public struct PersonIdDocumentTypeApiInfo: Codable, JSONEncodable, Hashable {

    public var id: Int?
    public var name: String?
    public var canSpecifyName: Bool?
    public var hasExpirationDate: Bool?

    public init(id: Int? = nil, name: String? = nil, canSpecifyName: Bool? = nil, hasExpirationDate: Bool? = nil) {
        self.id = id
        self.name = name
        self.canSpecifyName = canSpecifyName
        self.hasExpirationDate = hasExpirationDate
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case id
        case name
        case canSpecifyName
        case hasExpirationDate
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(id, forKey: .id)
        try container.encodeIfPresent(name, forKey: .name)
        try container.encodeIfPresent(canSpecifyName, forKey: .canSpecifyName)
        try container.encodeIfPresent(hasExpirationDate, forKey: .hasExpirationDate)
    }
}

