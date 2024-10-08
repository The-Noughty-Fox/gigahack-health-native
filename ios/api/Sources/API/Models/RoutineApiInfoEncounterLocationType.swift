//
// RoutineApiInfoEncounterLocationType.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation
#if canImport(AnyCodable)
import AnyCodable
#endif

/** Location type for routine. Most often used for remote consultations (Virtual) or home visits (Home). */
public enum RoutineApiInfoEncounterLocationType: Codable, JSONEncodable, Hashable {
    case typeEncounterLocationType(EncounterLocationType)

    public func encode(to encoder: Encoder) throws {
        var container = encoder.singleValueContainer()
        switch self {
        case .typeEncounterLocationType(let value):
            try container.encode(value)
        }
    }

    public init(from decoder: Decoder) throws {
        let container = try decoder.singleValueContainer()
        if let value = try? container.decode(EncounterLocationType.self) {
            self = .typeEncounterLocationType(value)
        } else {
            throw DecodingError.typeMismatch(Self.Type.self, .init(codingPath: decoder.codingPath, debugDescription: "Unable to decode instance of RoutineApiInfoEncounterLocationType"))
        }
    }
}

