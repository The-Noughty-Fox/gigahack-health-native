import ExyteChat
import SwiftUI

struct InvitroChatView: View {
  @State var messages: [Message] = []

  let user = User.init(id: UUID().uuidString, name: "John Doe", avatarURL: URL(string: "https://randomuser.me/api/portraits/men/32.jpg")!, isCurrentUser: true)
  let otherUser = User.init(id: UUID().uuidString, name: "John Foe", avatarURL: URL(string: "https://randomuser.me/api/portraits/men/31.jpg")!, isCurrentUser: false)

  var body: some View {
    ChatView(messages: messages) { message in
      let newMessage = Message.init(
        id: UUID().uuidString, user: user,
        status: Message.Status.sent, createdAt: Date(), text: message.text, attachments: [],
        recording: nil, replyMessage: nil)
      messages.append(newMessage)
    }
  }
}
