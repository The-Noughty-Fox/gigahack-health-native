import SwiftUI

enum ServiceType {
    case consultation
    case procedure
    case test

    var title: String {
        switch self {
        case .consultation:
            return "Consultatie la medic"
        case .procedure:
            return "Investigatie medicala"
        case .test:
            return "Analiza medicala"
        }
    }

    var image: Image {
        switch self {
        case .consultation:
            return Image.pill
        case .procedure:
            return Image.pill
        case .test:
            return Image.pill
        }
    }
}

struct ServiceTypeCell: View {
    let serviceType: ServiceType

    var body: some View {
        HStack {
            RoundedRectangle(cornerRadius: 10)
                .fill(Color.blue50)
                .frame(width: 32, height: 32)
                .overlay(
                    serviceType.image
                        .renderingMode(.template)
                        .resizable()
                        .frame(width: 24, height: 24)
                        .foregroundStyle(Color.blue500)
                )
            Text(serviceType.title)
                .font(.system(size: 14))
                .foregroundStyle(Color(hex: "#42566D"))
            Spacer()
            Image(systemName: "chevron.right")
                .foregroundStyle(Color.blue500)
                .frame(height: 12)
        }
        .padding(16)
        .background(
            RoundedRectangle(cornerRadius: 16)
                .fill(Color.white)
        )
    }
}

struct ServiceTypeView: View {  
    @StateObject var vm = BookingViewModel.shared

    var onSelect: (ServiceType) -> Void
    
    var body: some View {
        VStack(spacing: 0) {
        Image.vaccineImage
            .resizable()
            .aspectRatio(contentMode: .fit)
            .padding(.horizontal)
            .padding(.bottom, -30)
        Text("Alege ce tip de programare ai nevoie.")
            .padding(.bottom, 43)
            .bold()
        VStack(spacing: 16) {
            ServiceTypeCell(serviceType: .consultation)
                .onTapGesture {
                    onSelect(.consultation)
                }
            ServiceTypeCell(serviceType: .procedure)
                .onTapGesture {
                    onSelect(.procedure)
                }
            ServiceTypeCell(serviceType: .test)
                .onTapGesture {
                    onSelect(.test)
                }
        }
        .padding(.horizontal, 35)
        Spacer()
        }
        .background {
            Color(hex: "#FAFAFA")
            .ignoresSafeArea()
        }
    }
}
