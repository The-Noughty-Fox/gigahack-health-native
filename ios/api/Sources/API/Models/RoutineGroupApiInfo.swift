//
// RoutineGroupApiInfo.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation
#if canImport(AnyCodable)
import AnyCodable
#endif

public struct RoutineGroupApiInfo: Codable, JSONEncodable, Hashable {

    public var id: Int?
    public var name: String?
    public var nameLanguage1: String?
    public var nameLanguage2: String?
    public var position: Int?
    public var childGroups: [RoutineGroupApiInfo]?
    public var topLevelGroupId: Int?

    public init(id: Int? = nil, name: String? = nil, nameLanguage1: String? = nil, nameLanguage2: String? = nil, position: Int? = nil, childGroups: [RoutineGroupApiInfo]? = nil, topLevelGroupId: Int? = nil) {
        self.id = id
        self.name = name
        self.nameLanguage1 = nameLanguage1
        self.nameLanguage2 = nameLanguage2
        self.position = position
        self.childGroups = childGroups
        self.topLevelGroupId = topLevelGroupId
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case id
        case name
        case nameLanguage1
        case nameLanguage2
        case position
        case childGroups
        case topLevelGroupId
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(id, forKey: .id)
        try container.encodeIfPresent(name, forKey: .name)
        try container.encodeIfPresent(nameLanguage1, forKey: .nameLanguage1)
        try container.encodeIfPresent(nameLanguage2, forKey: .nameLanguage2)
        try container.encodeIfPresent(position, forKey: .position)
        try container.encodeIfPresent(childGroups, forKey: .childGroups)
        try container.encodeIfPresent(topLevelGroupId, forKey: .topLevelGroupId)
    }
}

