import SwiftUI
import Spezi

@main
struct InvitroHackApp: App {
    @ApplicationDelegateAdaptor(ExampleAppDelegate.self) var appDelegate

    var body: some Scene {
        WindowGroup {
            ContentView()
             .spezi(appDelegate)
        }
    }
}
