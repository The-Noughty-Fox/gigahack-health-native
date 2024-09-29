//
// GetMultiPlanningAppointmentDataRequest.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation
#if canImport(AnyCodable)
import AnyCodable
#endif

public struct GetMultiPlanningAppointmentDataRequest: Codable, JSONEncodable, Hashable {

    public var unitId: Int
    public var routineIds: [Int]

    public init(unitId: Int, routineIds: [Int]) {
        self.unitId = unitId
        self.routineIds = routineIds
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case unitId
        case routineIds
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(unitId, forKey: .unitId)
        try container.encode(routineIds, forKey: .routineIds)
    }
}

