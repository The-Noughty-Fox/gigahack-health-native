import SwiftUI

extension Color {
    init(hex: String) {
            let hex = hex.trimmingCharacters(in: CharacterSet.alphanumerics.inverted)
            var int: UInt64 = 0
            Scanner(string: hex).scanHexInt64(&int)
            let a, r, g, b: UInt64
            switch hex.count {
            case 3: // RGB (12-bit)
                (a, r, g, b) = (255, (int >> 8) * 17, (int >> 4 & 0xF) * 17, (int & 0xF) * 17)
            case 6: // RGB (24-bit)
                (a, r, g, b) = (255, int >> 16, int >> 8 & 0xFF, int & 0xFF)
            case 8: // ARGB (32-bit)
                (a, r, g, b) = (int >> 24, int >> 16 & 0xFF, int >> 8 & 0xFF, int & 0xFF)
            default:
                (a, r, g, b) = (1, 1, 1, 0)
            }

            self.init(
                .sRGB,
                red: Double(r) / 255,
                green: Double(g) / 255,
                blue:  Double(b) / 255,
                opacity: Double(a) / 255
            )
        }

    static let primary = Color(hex: "#069EF1")
}

extension Color {
        public static var gray50 = Color(hex: "#f9fafb")
        public static var gray100 = SwiftUI.Color(hex: "#f4f5f7")
        public static var gray200 = SwiftUI.Color(hex: "#e5e7eb")
        public static var gray300 = SwiftUI.Color(hex: "#d2d6dc")
        public static var gray400 = SwiftUI.Color(hex: "#9fa6b2")
        public static var gray500 = SwiftUI.Color(hex: "#6b7280")
        public static var gray600 = SwiftUI.Color(hex: "#4b5563")
        public static var gray700 = SwiftUI.Color(hex: "#374151")
        public static var gray800 = SwiftUI.Color(hex: "#252f3f")
        public static var gray900 = SwiftUI.Color(hex: "#161e2e")

        public static var red50 = SwiftUI.Color(hex: "#fdf2f2")
        public static var red100 = SwiftUI.Color(hex: "#fde8e8")
        public static var red200 = SwiftUI.Color(hex: "#fbd5d5")
        public static var red300 = SwiftUI.Color(hex: "#f8b4b4")
        public static var red400 = SwiftUI.Color(hex: "#f98080")
        public static var red500 = SwiftUI.Color(hex: "#f05252")
        public static var red600 = SwiftUI.Color(hex: "#e02424")
        public static var red700 = SwiftUI.Color(hex: "#c81e1e")
        public static var red800 = SwiftUI.Color(hex: "#9b1c1c")
        public static var red900 = SwiftUI.Color(hex: "#771d1d")

        public static var orange50 = SwiftUI.Color(hex: "#fff8f1")
        public static var orange100 = SwiftUI.Color(hex: "#feecdc")
        public static var orange200 = SwiftUI.Color(hex: "#fcd9bd")
        public static var orange300 = SwiftUI.Color(hex: "#fdba8c")
        public static var orange400 = SwiftUI.Color(hex: "#ff8a4c")
        public static var orange500 = SwiftUI.Color(hex: "#ff5a1f")
        public static var orange600 = SwiftUI.Color(hex: "#d03801")
        public static var orange700 = SwiftUI.Color(hex: "#b43403")
        public static var orange800 = SwiftUI.Color(hex: "#8a2c0d")
        public static var orange900 = SwiftUI.Color(hex: "#73230d")

        public static var yellow50 = SwiftUI.Color(hex: "#fdfdea")
        public static var yellow100 = SwiftUI.Color(hex: "#fdf6b2")
        public static var yellow200 = SwiftUI.Color(hex: "#fce96a")
        public static var yellow300 = SwiftUI.Color(hex: "#faca15")
        public static var yellow400 = SwiftUI.Color(hex: "#e3a008")
        public static var yellow500 = SwiftUI.Color(hex: "#c27803")
        public static var yellow600 = SwiftUI.Color(hex: "#9f580a")
        public static var yellow700 = SwiftUI.Color(hex: "#8e4b10")
        public static var yellow800 = SwiftUI.Color(hex: "#723b13")
        public static var yellow900 = SwiftUI.Color(hex: "#633112")

        public static var green50 = SwiftUI.Color(hex: "#f3faf7")
        public static var green100 = SwiftUI.Color(hex: "#def7ec")
        public static var green200 = SwiftUI.Color(hex: "#bcf0da")
        public static var green300 = SwiftUI.Color(hex: "#84e1bc")
        public static var green400 = SwiftUI.Color(hex: "#31c48d")
        public static var green500 = SwiftUI.Color(hex: "#0e9f6e")
        public static var green600 = SwiftUI.Color(hex: "#057a55")
        public static var green700 = SwiftUI.Color(hex: "#046c4e")
        public static var green800 = SwiftUI.Color(hex: "#03543f")
        public static var green900 = SwiftUI.Color(hex: "#014737")

        public static var teal50 = SwiftUI.Color(hex: "#edfafa")
        public static var teal100 = SwiftUI.Color(hex: "#d5f5f6")
        public static var teal200 = SwiftUI.Color(hex: "#afecef")
        public static var teal300 = SwiftUI.Color(hex: "#7edce2")
        public static var teal400 = SwiftUI.Color(hex: "#16bdca")
        public static var teal500 = SwiftUI.Color(hex: "#0694a2")
        public static var teal600 = SwiftUI.Color(hex: "#047481")
        public static var teal700 = SwiftUI.Color(hex: "#036672")
        public static var teal800 = SwiftUI.Color(hex: "#05505c")
        public static var teal900 = SwiftUI.Color(hex: "#014451")

        public static var blue50 = SwiftUI.Color(hex: "#ebf5ff")
        public static var blue100 = SwiftUI.Color(hex: "#e1effe")
        public static var blue200 = SwiftUI.Color(hex: "#c3ddfd")
        public static var blue300 = SwiftUI.Color(hex: "#a4cafe")
        public static var blue400 = SwiftUI.Color(hex: "#76a9fa")
        public static var blue500 = SwiftUI.Color(hex: "#3f83f8")
        public static var blue600 = SwiftUI.Color(hex: "#1c64f2")
        public static var blue700 = SwiftUI.Color(hex: "#1a56db")
        public static var blue800 = SwiftUI.Color(hex: "#1e429f")
        public static var blue900 = SwiftUI.Color(hex: "#233876")

        public static var indigo50 = SwiftUI.Color(hex: "#f0f5ff")
        public static var indigo100 = SwiftUI.Color(hex: "#e5edff")
        public static var indigo200 = SwiftUI.Color(hex: "#cddbfe")
        public static var indigo300 = SwiftUI.Color(hex: "#b4c6fc")
        public static var indigo400 = SwiftUI.Color(hex: "#8da2fb")
        public static var indigo500 = SwiftUI.Color(hex: "#6875f5")
        public static var indigo600 = SwiftUI.Color(hex: "#5850ec")
        public static var indigo700 = SwiftUI.Color(hex: "#5145cd")
        public static var indigo800 = SwiftUI.Color(hex: "#42389d")
        public static var indigo900 = SwiftUI.Color(hex: "#362f78")

        public static var purple50 = SwiftUI.Color(hex: "#f6f5ff")
        public static var purple100 = SwiftUI.Color(hex: "#edebfe")
        public static var purple200 = SwiftUI.Color(hex: "#dcd7fe")
        public static var purple300 = SwiftUI.Color(hex: "#cabffd")
        public static var purple400 = SwiftUI.Color(hex: "#ac94fa")
        public static var purple500 = SwiftUI.Color(hex: "#9061f9")
        public static var purple600 = SwiftUI.Color(hex: "#7e3af2")
        public static var purple700 = SwiftUI.Color(hex: "#6c2bd9")
        public static var purple800 = SwiftUI.Color(hex: "#5521b5")
        public static var purple900 = SwiftUI.Color(hex: "#4a1d96")

        public static var pink50 = SwiftUI.Color(hex: "#fdf2f8")
        public static var pink100 = SwiftUI.Color(hex: "#fce8f3")
        public static var pink200 = SwiftUI.Color(hex: "#fad1e8")
        public static var pink300 = SwiftUI.Color(hex: "#f8b4d9")
        public static var pink400 = SwiftUI.Color(hex: "#f17eb8")
        public static var pink500 = SwiftUI.Color(hex: "#e74694")
        public static var pink600 = SwiftUI.Color(hex: "#d61f69")
        public static var pink700 = SwiftUI.Color(hex: "#bf125d")
        public static var pink800 = SwiftUI.Color(hex: "#99154b")
        public static var pink900 = SwiftUI.Color(hex: "#751a3d")
    }

