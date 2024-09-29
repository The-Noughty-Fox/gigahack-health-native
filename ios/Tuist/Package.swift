// swift-tools-version: 5.9
import PackageDescription

#if TUIST
    import ProjectDescription

    let packageSettings = PackageSettings(
        // Customize the product types for specific package product
        // Default is .staticFramework
        // productTypes: ["Alamofire": .framework,] 
        productTypes: [:]
    )
#endif

let package = Package(
    name: "invitro-hack",
    dependencies: [
        .package(path: "../api"),
        .package(
      url: "https://github.com/krzysztofzablocki/Inject.git",
      from: "1.2.4"
    ),
    .package(url: "https://github.com/Mijick/CalendarView.git", from: "1.0.0"),
    .package(url: "https://github.com/StanfordSpezi/SpeziHealthKit.git", from: "0.6.0"),
    .package(url: "git@github.com:exyte/Chat.git", exact: "2.0.5")

        // Add your own dependencies here:
        // .package(url: "https://github.com/Alamofire/Alamofire", from: "5.0.0"),
        // You can read more about dependencies here: https://docs.tuist.io/documentation/tuist/dependencies
    ]
)
