//
// AppointmentOrderApiInfo.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation
#if canImport(AnyCodable)
import AnyCodable
#endif

public struct AppointmentOrderApiInfo: Codable, JSONEncodable, Hashable {

    public var personId: Int?
    public var unitId: Int?
    public var venueId: Int?
    public var mainExecutorId: Int?
    public var referrerId: Int?
    public var state: AppointmentState?
    public var visitConfirmationState: VisitConfirmationState?
    public var plannedStartTime: Date?
    public var comment: String?
    public var customerInformationSourceDescription: String?
    public var services: [OrderServiceApiInfo]?
    public var hasLabRequest: Bool?
    public var diagnosisCodes: [String]?
    public var availableStates: [AppointmentState]?

    public init(personId: Int? = nil, unitId: Int? = nil, venueId: Int? = nil, mainExecutorId: Int? = nil, referrerId: Int? = nil, state: AppointmentState? = nil, visitConfirmationState: VisitConfirmationState? = nil, plannedStartTime: Date? = nil, comment: String? = nil, customerInformationSourceDescription: String? = nil, services: [OrderServiceApiInfo]? = nil, hasLabRequest: Bool? = nil, diagnosisCodes: [String]? = nil, availableStates: [AppointmentState]? = nil) {
        self.personId = personId
        self.unitId = unitId
        self.venueId = venueId
        self.mainExecutorId = mainExecutorId
        self.referrerId = referrerId
        self.state = state
        self.visitConfirmationState = visitConfirmationState
        self.plannedStartTime = plannedStartTime
        self.comment = comment
        self.customerInformationSourceDescription = customerInformationSourceDescription
        self.services = services
        self.hasLabRequest = hasLabRequest
        self.diagnosisCodes = diagnosisCodes
        self.availableStates = availableStates
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case personId
        case unitId
        case venueId
        case mainExecutorId
        case referrerId
        case state
        case visitConfirmationState
        case plannedStartTime
        case comment
        case customerInformationSourceDescription
        case services
        case hasLabRequest
        case diagnosisCodes
        case availableStates
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(personId, forKey: .personId)
        try container.encodeIfPresent(unitId, forKey: .unitId)
        try container.encodeIfPresent(venueId, forKey: .venueId)
        try container.encodeIfPresent(mainExecutorId, forKey: .mainExecutorId)
        try container.encodeIfPresent(referrerId, forKey: .referrerId)
        try container.encodeIfPresent(state, forKey: .state)
        try container.encodeIfPresent(visitConfirmationState, forKey: .visitConfirmationState)
        try container.encodeIfPresent(plannedStartTime, forKey: .plannedStartTime)
        try container.encodeIfPresent(comment, forKey: .comment)
        try container.encodeIfPresent(customerInformationSourceDescription, forKey: .customerInformationSourceDescription)
        try container.encodeIfPresent(services, forKey: .services)
        try container.encodeIfPresent(hasLabRequest, forKey: .hasLabRequest)
        try container.encodeIfPresent(diagnosisCodes, forKey: .diagnosisCodes)
        try container.encodeIfPresent(availableStates, forKey: .availableStates)
    }
}

