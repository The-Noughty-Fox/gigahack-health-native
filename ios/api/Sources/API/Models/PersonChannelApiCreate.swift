//
// PersonChannelApiCreate.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation
#if canImport(AnyCodable)
import AnyCodable
#endif

public struct PersonChannelApiCreate: Codable, JSONEncodable, Hashable {

    static let valueRule = StringRule(minLength: 1, maxLength: nil, pattern: nil)
    public var typeId: Int
    public var value: String
    public var comment: String?
    public var allowDocumentDelivery: Bool
    public var allowNotifications: Bool
    public var allowPromotions: Bool

    public init(typeId: Int, value: String, comment: String? = nil, allowDocumentDelivery: Bool, allowNotifications: Bool, allowPromotions: Bool) {
        self.typeId = typeId
        self.value = value
        self.comment = comment
        self.allowDocumentDelivery = allowDocumentDelivery
        self.allowNotifications = allowNotifications
        self.allowPromotions = allowPromotions
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case typeId
        case value
        case comment
        case allowDocumentDelivery
        case allowNotifications
        case allowPromotions
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(typeId, forKey: .typeId)
        try container.encode(value, forKey: .value)
        try container.encodeIfPresent(comment, forKey: .comment)
        try container.encode(allowDocumentDelivery, forKey: .allowDocumentDelivery)
        try container.encode(allowNotifications, forKey: .allowNotifications)
        try container.encode(allowPromotions, forKey: .allowPromotions)
    }
}

