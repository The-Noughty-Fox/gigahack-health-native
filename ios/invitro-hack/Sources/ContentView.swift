import SwiftUI
import API
import Inject

final class TestViewModel: ObservableObject {
    func foo() {
    }
}

public struct ContentView: View {
    public init() {}

    public var body: some View {
        RootView()
        // .enableInjection()
    }

    #if DEBUG
    @ObserveInjection var forceRedraw
    #endif
}


struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
