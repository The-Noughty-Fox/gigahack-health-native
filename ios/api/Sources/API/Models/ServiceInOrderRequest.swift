//
// ServiceInOrderRequest.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation
#if canImport(AnyCodable)
import AnyCodable
#endif

public struct ServiceInOrderRequest: Codable, JSONEncodable, Hashable {

    /** Routine Id for service */
    public var routineId: Int
    /** Service unit price. */
    public var unitPrice: Double
    /** Service discount, as fraction. 10% discount should be passed as 0.1. */
    public var discount: Double

    public init(routineId: Int, unitPrice: Double, discount: Double) {
        self.routineId = routineId
        self.unitPrice = unitPrice
        self.discount = discount
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case routineId
        case unitPrice
        case discount
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(routineId, forKey: .routineId)
        try container.encode(unitPrice, forKey: .unitPrice)
        try container.encode(discount, forKey: .discount)
    }
}

