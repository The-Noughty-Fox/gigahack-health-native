import SwiftUI

struct ServiceCategory: Identifiable {
    let id: Int
    let title: String
    let image: Image
}

struct ServiceCategoryCell: View {
    let title: String
    let image: Image

    var body: some View {
        VStack {
            Rectangle().fill(Color.clear)
                .frame(width: 32, height: 32)
                .overlay(
                    image
                    .resizable()
                    .renderingMode(.template)
                    .foregroundStyle(Color.blue500)
                    .aspectRatio(1, contentMode: .fit)
                )
            Text(title)
                .font(.system(size: 14))
        }
        .padding(.vertical, 19)
        .frame(maxWidth: .infinity)
        .background(
            RoundedRectangle(cornerRadius: 20)
                .fill(Color.white)
        )
    }
}

struct ServiceCategoryView: View {
    @StateObject var vm = BookingViewModel.shared

    @State var categories: [ServiceCategory] = []
    var onSelect: (ServiceCategory) -> Void

    var body: some View {
        VStack(alignment: .leading) {
            AskBotButton(onTap: {
                print("Ask Bot")
            })
            .padding(.horizontal, 25)
            .padding(.vertical, 20)   
            Text("Selecteaza categorie")
                .font(.system(size: 16, weight: .semibold))
                .padding(.horizontal, 25)
                .padding(.bottom, 16)   
            ScrollView {
                LazyVGrid(columns: [
                    GridItem(.flexible()),
                    GridItem(.flexible()),
                    GridItem(.flexible())
                ], spacing: 16) {
                    ForEach(categories) { category in
                        ServiceCategoryCell(title: category.title, image: category.image)
                        .onTapGesture {
                            onSelect(category)
                        }
                    }
                }
                .padding(.horizontal)
            }
        }
        .background(Color(hex: "#FAFAFA").ignoresSafeArea())
        .task {
            categories = vm.specialities.map {
                ServiceCategory.init(id: $0.id ?? 0, title: $0.name ?? "", image: Image.alergologie)
            }
        }
    }
}
