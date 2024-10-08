//
// AccountBalanceApiInfo.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation
#if canImport(AnyCodable)
import AnyCodable
#endif

public struct AccountBalanceApiInfo: Codable, JSONEncodable, Hashable {

    public var id: Int?
    public var currentBalance: Double?

    public init(id: Int? = nil, currentBalance: Double? = nil) {
        self.id = id
        self.currentBalance = currentBalance
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case id
        case currentBalance
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(id, forKey: .id)
        try container.encodeIfPresent(currentBalance, forKey: .currentBalance)
    }
}

