import MijickCalendarView
import SwiftUI

struct DateTimeLocation: View {
  let procedureName: String
  @State private var selectedLocation: String?
  @State private var selectedDate: Date?
  @State private var selectedMonth: Date = .now
  @State private var selectedTime: String?

  let locations = ["Centrul Medical 1", "Centrul Medical 2", "Centrul Medical 3"]
  let timeSlots = ["09:00", "10:00", "11:00", "12:00", "14:00", "15:00", "16:00", "17:00"]

  var onConfirm: (BookingInfo) -> Void = { _ in }

  var body: some View {

    ScrollView {
      VStack(alignment: .leading, spacing: 20) {
        Text(procedureName)
          .font(.title)
          .fontWeight(.bold)

        Text("Alege data, ora și locația")
          .font(.system(size: 16, weight: .medium))

        VStack(alignment: .leading, spacing: 10) {
          Text("Locația")
            .font(.system(size: 16))
            .foregroundStyle(Color.init(hex: "#6A788E"))

          ForEach(locations, id: \.self) { location in
            Button(action: {
              selectedLocation = location
            }) {
              HStack {
                Image(
                  systemName: selectedLocation == location ? "largecircle.fill.circle" : "circle"
                )
                .foregroundColor(selectedLocation == location ? .blue : .gray)
                .padding(.trailing, 30)
                Text(location)
                  .font(.system(size: 16))
                  .foregroundColor(Color.black)
              }
              .padding(.bottom, 10)
            }
            .buttonStyle(PlainButtonStyle())
          }
        }

        MCalendarView(
          selectedDate: $selectedDate, selectedRange: nil, configBuilder: configureCalendar)

        if selectedDate != nil {
          Text("Selectează ora")
            .font(.headline)

          LazyVGrid(
            columns: [
              GridItem(.flexible()),
              GridItem(.flexible()),
              GridItem(.flexible()),
            ], spacing: 20
          ) {
            ForEach(timeSlots, id: \.self) { time in
              Button(action: {
                selectedTime = time
              }) {
                Text(time)
                  .font(.system(size: 14))
                  .padding(.vertical, 5)
                  .frame(maxWidth: .infinity)
                  .foregroundColor(selectedTime == time ? .white : .black)
                  .background(Capsule().fill(selectedTime == time ? Color.blue : Color.white))
                  .shadow(
                    color: Color(red: 0.06, green: 0.15, blue: 0.29).opacity(0.1), radius: 8, x: 0,
                    y: 3)
              }
            }
          }
        }
      }
      .padding()
      Button(action: {
        onConfirm(
          BookingInfo(
            procedureName: procedureName, location: selectedLocation!, date: selectedDate!,
            time: selectedTime!, price: 500, notes: "Note"))
      }) {
        Text("Confirma programarea (500 MDL)")
          .font(.system(size: 16, weight: .semibold))
          .padding(.vertical, 16)
          .frame(maxWidth: .infinity)
          .foregroundColor(.blue500)
          .background(Color.blue200)
          .cornerRadius(10)
      }
      .opacity(isConfirmButtonEnabled ? 1 : 0.2)
      .disabled(!isConfirmButtonEnabled)
      .padding(.vertical, 22)
      .padding(.horizontal, 24)
    }
  }

  var isConfirmButtonEnabled: Bool {
    return selectedLocation != nil && selectedDate != nil && selectedTime != nil
  }

  func configureCalendar(_ config: CalendarConfig) -> CalendarConfig {
    config
      .monthsTopPadding(15)
      .monthsBottomPadding(8)
      .daysHorizontalSpacing(10)
      .daysVerticalSpacing(10)
      .startMonth(selectedMonth)
      .endMonth(selectedMonth)
      .monthLabel(
        {
          ML(month: $0) {
            selectedMonth = Calendar.current.date(byAdding: .month, value: 1, to: selectedMonth)!
          } onPreviousMonth: {
            selectedMonth = Calendar.current.date(byAdding: .month, value: -1, to: selectedMonth)!
          }
        }
      )
      .dayView(
        {
          DV(date: $0, isCurrentMonth: $1, selectedDate: $2, selectedRange: $3)
        }
      )
  }
}

struct ML: MonthLabel {
  var month: Date

  var onNextMonth: () -> Void = {}
  var onPreviousMonth: () -> Void = {}

  var body: some View {
    HStack {
      Button(action: onPreviousMonth) {
        Image(systemName: "chevron.left")
      }
      .padding(.trailing, 25)
      Text(month, format: .dateTime.month(.wide))
        .font(.system(size: 16, weight: .semibold))
        .foregroundColor(.black)
      Spacer()
      Button(action: onNextMonth) {
        Image(systemName: "chevron.right")
      }
      .padding(.horizontal, 25)
    }
    .foregroundColor(.blue500)
  }
}

struct DV: DayView {
  var date: Date
  var hasAvailableTimeSlots: Bool = true
  var isCurrentMonth: Bool
  var selectedDate: Binding<Date?>?
  var selectedRange: Binding<MDateRange?>?

  func createDayLabel() -> AnyView {
    Text(date, format: .dateTime.day(.twoDigits))
      .font(.system(size: 14))
      .foregroundColor(
        hasAvailableTimeSlots && !isPast() ? (isSelected() ? .white : .black) : .white
      )
      .frame(maxWidth: .infinity, maxHeight: .infinity)
      .background(
        RoundedRectangle(cornerRadius: 10)
          .fill(
            hasAvailableTimeSlots && !isPast()
              ? (isSelected() ? Color.blue500 : Color(hex: "#E0E3EA")) : Color(hex: "#C3C3C3")
          )
      )
      .erased()
  }

  func onSelection() {
    selectedDate?.wrappedValue = date
  }

  func createSelectionView() -> AnyView {
    RoundedRectangle(cornerRadius: 10)
      .fill(Color.blue500)
      .transition(
        .asymmetric(insertion: .scale(scale: 0.5).combined(with: .opacity), removal: .opacity)
      )
      .active(if: isSelected())
      .erased()
  }
}

extension View {
  @ViewBuilder func active(if condition: Bool) -> some View { if condition { self } }
}
