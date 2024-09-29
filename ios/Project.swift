import ProjectDescription

let project = Project(
    name: "invitro-hack",
    targets: [
        .target(
            name: "invitro-hack",
            destinations: .iOS,
            product: .app,
            bundleId: "com.tnf.invitro-hack",
            infoPlist: .extendingDefault(
                with: [
                    "UILaunchScreen": [
                        "UIColorName": "",
                        "UIImageName": "",
                    ],
                    "NSPhotoLibraryUsageDescription": "Grant access to photo library to be able to select photos",
                    "NSCameraUsageDescription": "Grant access to camera to be able to take photos and videos",
                    "NSMicrophoneUsageDescription": "Grant access to microphone to be able to take videos",
                ]
            ),
            sources: ["invitro-hack/Sources/**"],
            resources: ["invitro-hack/Resources/**"],
            dependencies: [
                .external(name: "API"),
                .external(name: "Inject"),
                .external(name: "MijickCalendarView"),
                .external(name: "SpeziHealthKit"),
                .external(name: "ExyteChat"),
                // .external(name: "Spezi")
            ]
            // ,
            // settings: .settings(
            //     base: [
            //         "OTHER_LDFLAGS": "$(inherited) -Xlinker -interposable",
            //     ]
            // )
        ),
        .target(
            name: "invitro-hackTests",
            destinations: .iOS,
            product: .unitTests,
            bundleId: "com.tnf.invitro-hackTests",
            infoPlist: .default,
            sources: ["invitro-hack/Tests/**"],
            resources: [],
            dependencies: [.target(name: "invitro-hack")]
        ),
    ]
)
