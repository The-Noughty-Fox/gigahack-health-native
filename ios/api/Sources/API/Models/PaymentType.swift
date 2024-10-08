//
// PaymentType.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation
#if canImport(AnyCodable)
import AnyCodable
#endif

/**  */
public enum PaymentType: String, Codable, CaseIterable {
    case notDefined = "NotDefined"
    case cashierDesk = "CashierDesk"
    case bankTransfer = "BankTransfer"
    case internet = "Internet"
}
