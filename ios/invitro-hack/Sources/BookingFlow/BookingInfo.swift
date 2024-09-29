import SwiftUI
import API

struct BookingInfo {
  let procedureName: String
  let location: String
  let date: Date
  let time: String
  let price: Double
  let notes: String?
}

func fixDates() {
    let dateFormatter = DateFormatter()
    dateFormatter.dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSS"
    CodableHelper.dateFormatter = dateFormatter
}

struct BookingInfoView: View {
    let bookingInfo: BookingInfo
    @StateObject var vm = BookingViewModel.shared

    var body: some View {
        VStack(alignment: .leading, spacing: 16) {
            Text(bookingInfo.procedureName)
                .font(.title)
                .fontWeight(.bold)

            ScrollView(showsIndicators: false) {
                VStack(alignment: .leading, spacing: 4) {
                    Text("Data si Ora")
                        .font(.subheadline)
                        .foregroundColor(.gray)
                    Text(bookingInfo.date, format: .dateTime.day().month(.wide).hour().minute())
                        .font(.headline)
                        .fontWeight(.semibold)
                        .frame(maxWidth: .infinity, alignment: .leading)
                        .padding()
                        .background(RoundedRectangle(cornerRadius: 10).fill(Color.white))

                }
                if let medic = vm.medic {
                    VStack(alignment: .leading, spacing: 4) {
                        Text("Medic")
                            .font(.subheadline)
                            .foregroundColor(.gray)
                        MedicCell(
                            medic: medic
                        )
                    }

                    VStack(alignment: .leading, spacing: 4) {
                        Text("Locația")
                            .font(.subheadline)
                            .foregroundColor(.gray)
                        VStack(alignment: .leading) {
                            RoundedRectangle(cornerRadius: 10).fill(Color.white)
                                .frame(height: 200)
                                .overlay(
                                    Image("map")
                                        .resizable()
                                        .aspectRatio(contentMode: .fill)
                                )
                                .clipShape(RoundedRectangle(cornerRadius: 10))

                            Text(bookingInfo.location)
                                .font(.headline)
                                .fontWeight(.semibold)
                                .padding()
                        }
                        .frame(maxWidth: .infinity, alignment: .leading)
                        .background(RoundedRectangle(cornerRadius: 10).fill(Color.white))
                    }

                    VStack(alignment: .leading, spacing: 4) {
                        Text("Preț")
                            .font(.subheadline)
                            .foregroundColor(.gray)
                        Text("\(bookingInfo.price, specifier: "%.2f") MDL")
                            .font(.headline)
                            .fontWeight(.semibold)
                            .frame(maxWidth: .infinity, alignment: .leading)
                            .padding()
                            .background(RoundedRectangle(cornerRadius: 10).fill(Color.white))
                    }

                    if let notes = bookingInfo.notes {
                        VStack(alignment: .leading, spacing: 4) {
                            Text("Note")
                                .font(.subheadline)
                                .foregroundColor(.gray)
                            Text(notes)
                                .font(.headline)
                                .fontWeight(.semibold)
                                .frame(maxWidth: .infinity, alignment: .leading)
                                .padding()
                                .background(RoundedRectangle(cornerRadius: 10).fill(Color.white))
                        }
                    }
                    Spacer()

                }

            }
            .frame(maxWidth: .infinity, alignment: .leading)
            .padding()
            .background(Color(hex: "#FAFAFA").ignoresSafeArea())
        }
    }
}

