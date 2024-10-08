//
// RegularRoutineType.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation
#if canImport(AnyCodable)
import AnyCodable
#endif

/**  */
public enum RegularRoutineType: String, Codable, CaseIterable {
    case notDefined = "NotDefined"
    case consultation = "Consultation"
    case examination = "Examination"
    case treatment = "Treatment"
    case intake = "Intake"
    case intervention = "Intervention"
    case drug = "Drug"
    case vaccine = "Vaccine"
    case procedure = "Procedure"
    case other = "Other"
    case hospitalStay = "HospitalStay"
    case anaesthesia = "Anaesthesia"
}
