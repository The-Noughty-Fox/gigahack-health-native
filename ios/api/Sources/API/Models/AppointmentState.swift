//
// AppointmentState.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation
#if canImport(AnyCodable)
import AnyCodable
#endif

/**  */
public enum AppointmentState: String, Codable, CaseIterable {
    case notDefined = "NotDefined"
    case reserved = "Reserved"
    case planned = "Planned"
    case patientWaiting = "PatientWaiting"
    case inProgress = "InProgress"
    case suspended = "Suspended"
    case completed = "Completed"
    case cancelled = "Cancelled"
    case noShow = "NoShow"
    case toPlan = "ToPlan"
}
