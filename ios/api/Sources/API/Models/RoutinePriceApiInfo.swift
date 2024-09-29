//
// RoutinePriceApiInfo.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation
#if canImport(AnyCodable)
import AnyCodable
#endif

public struct RoutinePriceApiInfo: Codable, JSONEncodable, Hashable {

    public var routineId: Int?
    public var isAllowed: Bool?
    public var price: Double?
    public var discount: Double?

    public init(routineId: Int? = nil, isAllowed: Bool? = nil, price: Double? = nil, discount: Double? = nil) {
        self.routineId = routineId
        self.isAllowed = isAllowed
        self.price = price
        self.discount = discount
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case routineId
        case isAllowed
        case price
        case discount
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(routineId, forKey: .routineId)
        try container.encodeIfPresent(isAllowed, forKey: .isAllowed)
        try container.encodeIfPresent(price, forKey: .price)
        try container.encodeIfPresent(discount, forKey: .discount)
    }
}

