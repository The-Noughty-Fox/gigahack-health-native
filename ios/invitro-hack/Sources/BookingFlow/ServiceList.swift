import SwiftUI

struct Service: Identifiable {
    let id = UUID()
    let name: String
    let price: Double
    let duration: Int // in minutes
}

struct ServiceRow: View {
    let service: Service
    
    var body: some View {
        VStack(alignment: .leading, spacing: 4) {
            Text(service.name)
                .font(.system(size: 16, weight: .medium))
            Text(String(format: "%.2f MDL", service.price))
                .font(.system(size: 16, weight: .light))
        }
        .frame(maxWidth: .infinity, alignment: .leading)
        .padding(.horizontal, 16)
        .padding(.vertical, 22)
        .background(RoundedRectangle(cornerRadius: 20).fill(Color.white))
    }
}

struct ServiceList: View {
    @State private var services: [Service] = [
        Service(name: "Consultație cardiolog", price: 350.00, duration: 30),
        Service(name: "ECG", price: 150.00, duration: 15),
        Service(name: "Ecocardiografie", price: 500.00, duration: 45),
        Service(name: "Test de efort", price: 400.00, duration: 60)
    ]

    var onSelect: (Service) -> Void
    
    var body: some View {
        VStack(alignment: .leading) {
            AskBotButton(onTap: {
                print("Ask Bot")
            })
            .padding(.horizontal, 25)
            ScrollView {
                LazyVStack(spacing: 16) {
                    ForEach(services) { service in
                        ServiceRow(service: service)
                            .onTapGesture {
                                onSelect(service)
                            }
                }
                }
                .padding()
            }
        }
        .background(Color(hex: "#FAFAFA").ignoresSafeArea())
    }
}