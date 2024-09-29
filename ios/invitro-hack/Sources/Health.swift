import Foundation
import SpeziHealthKit
import Spezi

actor ExampleStandard: Standard, HealthKitConstraint {
   // Add the newly collected HKSample to your application.
   func add(sample: HKSample) async {
       print(sample)
   }
 
   // Remove the deleted HKSample from your application.
   func remove(sample: HKDeletedObject) {
       
   }
}

class ExampleAppDelegate: SpeziAppDelegate {
    override var configuration: Configuration {
        Configuration(standard: ExampleStandard()) {
            if HKHealthStore.isHealthDataAvailable() {
                healthKit
            }
            HealthDataFetcher()
        }
    }


    private var healthKit: HealthKit {
        HealthKit {
            CollectSamples(
                [
                    HKQuantityType(.stepCount),
                    HKQuantityType(.activeEnergyBurned),
                    HKQuantityType(.appleExerciseTime),
                    HKQuantityType(.bodyMass),
                    HKQuantityType(.heartRate),
                    HKCategoryType(.sleepAnalysis)
                ],
                deliverySetting: .manual()
            )
        }
    }
}


