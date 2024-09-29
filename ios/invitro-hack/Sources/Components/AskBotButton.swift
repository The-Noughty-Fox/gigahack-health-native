import SwiftUI

struct AskBotButton: View {
    var onTap: () -> Void
    var body: some View {
        Button(action: {
            // Action to be performed when the button is tapped
        }) {
            HStack {
                Rectangle().fill(Color.clear)
                    .frame(width: 22, height: 22)
                    .overlay(
                        Image.stars
                            .renderingMode(.template)
                            .resizable()
                            .foregroundColor(.blue500)
                            .frame(width: 22, height: 22)
                    )

                Text("Ask InvitroBot")
                    .font(.system(size: 16, weight: .semibold))
                    .foregroundColor(.blue500)
            }
            .contentShape(Rectangle())
        }
    }
}