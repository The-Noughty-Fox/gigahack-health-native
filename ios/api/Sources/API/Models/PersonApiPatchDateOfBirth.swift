//
// PersonApiPatchDateOfBirth.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation
#if canImport(AnyCodable)
import AnyCodable
#endif

public enum PersonApiPatchDateOfBirth: Codable, JSONEncodable, Hashable {
    case typePropertyPatchOfNullableDateTime(PropertyPatchOfNullableDateTime)

    public func encode(to encoder: Encoder) throws {
        var container = encoder.singleValueContainer()
        switch self {
        case .typePropertyPatchOfNullableDateTime(let value):
            try container.encode(value)
        }
    }

    public init(from decoder: Decoder) throws {
        let container = try decoder.singleValueContainer()
        if let value = try? container.decode(PropertyPatchOfNullableDateTime.self) {
            self = .typePropertyPatchOfNullableDateTime(value)
        } else {
            throw DecodingError.typeMismatch(Self.Type.self, .init(codingPath: decoder.codingPath, debugDescription: "Unable to decode instance of PersonApiPatchDateOfBirth"))
        }
    }
}

