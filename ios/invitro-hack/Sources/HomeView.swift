//
//  HomeView.swift
//  invitro-hack
//
//  Created by Lisnic Victor on 29.09.2024.
//

import Foundation
import SwiftUI
import Spezi
import SpeziHealthKit

struct HomeView: View {
    @Environment(HealthKit.self) var module
    @Environment(HealthDataFetcher.self) var datasource

    var body: some View {
        VStack {
            Text("Welcome to you health insights")
                .foregroundStyle(Color.black)
                .font(.title)
                .padding()

            Button {
                Task {
                    try await module.askForAuthorization()
                    let data = try await datasource.fetchAndProcessHealthData()
                    print(data)
                }
            } label: {
                Text("Connect Health Data")
                    .foregroundStyle(Color.blue500)
                    .padding()
                    .frame(maxWidth: .infinity)
                    .frame(height: 100)
                    .background(
                        RoundedRectangle(cornerSize: CGSize(width: 20, height: 10))
                            .fill(Color.blue50)
                    )
            }
            .padding()
            Spacer()
        }
        .background(Color.init(hex: "#FAFAFA"))
    }
}
