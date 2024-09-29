//
// UnitApiInfoMedicalCareType.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation
#if canImport(AnyCodable)
import AnyCodable
#endif

public enum UnitApiInfoMedicalCareType: Codable, JSONEncodable, Hashable {
    case typeMedicalCareType(MedicalCareType)

    public func encode(to encoder: Encoder) throws {
        var container = encoder.singleValueContainer()
        switch self {
        case .typeMedicalCareType(let value):
            try container.encode(value)
        }
    }

    public init(from decoder: Decoder) throws {
        let container = try decoder.singleValueContainer()
        if let value = try? container.decode(MedicalCareType.self) {
            self = .typeMedicalCareType(value)
        } else {
            throw DecodingError.typeMismatch(Self.Type.self, .init(codingPath: decoder.codingPath, debugDescription: "Unable to decode instance of UnitApiInfoMedicalCareType"))
        }
    }
}

