//
// PromotionRoutineApiInfo.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation
#if canImport(AnyCodable)
import AnyCodable
#endif

public struct PromotionRoutineApiInfo: Codable, JSONEncodable, Hashable {

    public var id: Int?
    public var code: String?
    public var name: String?
    public var discount: Double?

    public init(id: Int? = nil, code: String? = nil, name: String? = nil, discount: Double? = nil) {
        self.id = id
        self.code = code
        self.name = name
        self.discount = discount
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case id
        case code
        case name
        case discount
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(id, forKey: .id)
        try container.encodeIfPresent(code, forKey: .code)
        try container.encodeIfPresent(name, forKey: .name)
        try container.encodeIfPresent(discount, forKey: .discount)
    }
}

