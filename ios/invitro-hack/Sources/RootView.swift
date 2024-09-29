import SwiftUI
import Spezi
import SpeziHealthKit

enum Tab {
    case home, profile, schedule, chat

    var title: String {
        switch self {
        case .home:
            return "Home"
        case .profile:
            return "Profile"
        case .schedule:
            return "Schedule"
        case .chat:
            return "Chat"
        }
    }

    var image: Image {
        switch self {
        case .home:
            return Image.house
        case .profile:
            return Image.user
        case .schedule:
            return Image.calendarDots
        case .chat:
            return Image.chatsCircle
        }
    }
}

public struct RootView: View {

    @State private var selectedTab: Tab = .home
    @Environment(HealthKit.self) var module
    @Environment(HealthDataFetcher.self) var datasource

    public var body: some View {
        TabView(selection: $selectedTab) {
            BookingFlowView()
                .tabItem {
                    VStack {
                        Tab.schedule.image
                        Text(Tab.schedule.title)
                    }
                }
                .tag(Tab.schedule)
            HomeView()
                .tabItem {
                    VStack {
                        Tab.home.image
                        Text(Tab.home.title)
                    }
                }
                .tag(Tab.home)
            InvitroChatView()
                .tabItem {
                    VStack {
                        Tab.chat.image
                        Text(Tab.chat.title)
                    }
                }
                .tag(Tab.chat)
            Color.orange
                .tabItem {
                    VStack {
                        Tab.profile.image
                        Text(Tab.profile.title)
                    }
                }
                .tag(Tab.profile)
        }.onAppear {
            fixDates()
        }
    }
}
