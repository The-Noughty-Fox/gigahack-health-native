import SwiftUI

struct BookingFlowView: View {
    @StateObject var vm = BookingViewModel.shared

    enum Screen: Hashable {
        case serviceCategory
        case serviceList
        case medicList
        case dateTimeLocation
        case bookingInfo
    }

    @State private var currentScreen: [Screen] = []

    var body: some View {
        NavigationStack(path: $currentScreen) {
            ServiceTypeView() { serviceType in
                let screen: Screen = switch serviceType {
                case .consultation:
                    .serviceCategory
                case .test:
                    .serviceCategory
                case .procedure:
                    .serviceCategory
                }

                currentScreen.append(screen)
            }.task {
                do {
                    try await vm.fetch()
                } catch {
                    print(error)
                }
            }
            .navigationDestination(for: Screen.self, destination: { screen in
                switch screen {
                case .serviceCategory:
                    ServiceCategoryView() { _ in
                        currentScreen.append(.serviceList)
                    }
                case .serviceList:
                    ServiceList() { service in
                        currentScreen.append(.medicList)
                    }
                case .medicList:
                    MedicListView() { medic in
                        currentScreen.append(.dateTimeLocation)
                    }
                case .dateTimeLocation:
                    DateTimeLocation(procedureName: "Procedura") { bookingInfo in
                        currentScreen.append(.bookingInfo)
                    }
                case .bookingInfo:
                    BookingInfoView(bookingInfo: BookingInfo(procedureName: "Procedura", location: "str. Testimetianu 18/3", date: Date(), time: "Ora", price: 500, notes: "Note"))
                }
            }) 
        }
    }
}
