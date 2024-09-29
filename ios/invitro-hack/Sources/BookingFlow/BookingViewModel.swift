//
//  BookingViewModel.swift
//  invitro-hack
//
//  Created by Lisnic Victor on 29.09.2024.
//

import Foundation
import API

import Combine

@propertyWrapper
struct Defaults<T: Codable> where T: Equatable {
    let defaultValue: T
    let key: String

    init(wrappedValue defaultValue: T, _ key: String) {
        self.key = key
        self.defaultValue = defaultValue
    }

    var wrappedValue: T {
        get {
            guard let data = UserDefaults.standard.data(forKey: key) else { return defaultValue }
            do {
                let item = try JSONDecoder().decode(T.self, from: data)
                return item
            } catch {
                return defaultValue
            }
        }
        set {
            let data = try! JSONEncoder().encode(newValue)
            UserDefaults.standard.set(data, forKey: key)
        }
    }

    var projectedValue: AnyPublisher<T, Never> {
        NotificationCenter.default.publisher(for: UserDefaults.didChangeNotification)
            .map { _ in UserDefaults.standard.data(forKey: key) }
            .compactMap { $0 }
            .compactMap { try? JSONDecoder().decode(T.self, from: $0) }
            .removeDuplicates()
            .prepend(wrappedValue)
            .eraseToAnyPublisher()
    }
}


final class BookingViewModel: ObservableObject {
    static let shared = BookingViewModel()
    @Defaults("routines")
    var routines: [RoutineApiSearchResult] = []

    @Defaults("units")
    var units: [UnitApiInfo] = []

    @Defaults("specialities")
    var specialities: [EntityApiInfo] = []

    @Defaults("employees")
    var employees: [EmployeeApiInfo] = []

    @Published var specialtyId: Int?
    @Published var medic: Medic? = nil
    @Published var routine: Service?

    func fetch() async throws {
        async let routines = try await RoutinesAPI.routinesSearchRoutines()
        async let units = try await ResourcesAPI.unitsGet()
        async let specialities = try await DictionariesAPI.specialitiesGet()
        async let employees = try await ResourcesAPI.employeesGetEmployees(includeNonActive: false)

        self.routines = try await routines
        self.units = try await units
        self.specialities = try await specialities
        self.employees = try await employees
    }
}
