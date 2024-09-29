import SwiftUI

struct Medic: Identifiable {
    let id: Int
    let executorId: Int
    let name: String
    let specializations: [Int]
    let image: Image
    let specializationName: String?
}

struct MedicListView: View {
    @StateObject var vm = BookingViewModel.shared
    @State var medics: [Medic] = []

    var onSelect: (Medic) -> Void

    var body: some View {
        VStack(alignment: .leading) {
            AskBotButton {
                print("Ask Bot")
            }
            .padding(.horizontal, 25)
            .padding(.vertical, 20)
            Text("Selecteaza doctor")
                .font(.system(size: 16, weight: .semibold))
                .padding(.horizontal, 25)
                .padding(.bottom, 20)
            ScrollView(.vertical, showsIndicators: false) {
                LazyVStack(spacing: 16) {
                    ForEach(medics) { medic in
                        MedicCell(medic: medic)
                            .onTapGesture {
                                onSelect(medic)
                            }
                    }
                }
                .padding(.horizontal, 25)
            }
        }
        .background(Color(hex: "#FAFAFA"))
        .task {
            medics = vm.employees.filter { info in
                info.specialities?.contains(where: { sp in
                    sp.id == vm.specialtyId
                }) ?? false
            }.map {
                Medic(
                    id: $0.id ?? 0,
                    executorId: $0.executorId ?? 0,
                    name: $0.fullName ?? "",
                    specializations: $0.specialities?.compactMap(\.id) ?? [],
                    image: Image("medic1"), specializationName: vm.specialities.first(where: { sp in
                        sp.id == vm.specialtyId
                    })?.name ?? ""
                )
            }
        }
    }
}

struct MedicCell: View {
    let medic: Medic

    var body: some View {
        HStack(spacing: 24) {
            RoundedRectangle(cornerRadius: 16)
                .fill(Color.clear)
                .frame(width: 60, height: 60)
                .overlay(
                    medic.image
                        .resizable()
                        .aspectRatio(1, contentMode: .fill)
                        .frame(width: 60, height: 60)
                ).clipShape(RoundedRectangle(cornerRadius: 16))
            VStack(alignment: .leading) {
                Text(medic.name)
                    .font(.system(size: 14, weight: .medium))
                Text(medic.specializationName ?? "")
                    .font(.system(size: 12, weight: .light))
            }
        }
        .frame(maxWidth: .infinity, alignment: .leading)
        .background(RoundedRectangle(cornerRadius: 20).fill(Color.white))
    }
}   
