//
// AppointmentPlanningDataApiInfo.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation
#if canImport(AnyCodable)
import AnyCodable
#endif

public struct AppointmentPlanningDataApiInfo: Codable, JSONEncodable, Hashable {

    public var unitId: Int?
    public var routines: [RoutineAssociationPlanningDataApiInfo]?
    public var executors: [EntityApiInfo]?

    public init(unitId: Int? = nil, routines: [RoutineAssociationPlanningDataApiInfo]? = nil, executors: [EntityApiInfo]? = nil) {
        self.unitId = unitId
        self.routines = routines
        self.executors = executors
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case unitId
        case routines
        case executors
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(unitId, forKey: .unitId)
        try container.encodeIfPresent(routines, forKey: .routines)
        try container.encodeIfPresent(executors, forKey: .executors)
    }
}

