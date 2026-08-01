# 📱 Device Specs SDK for Java, Kotlin & Android

The official, high-performance **Java, Kotlin, and Android SDK** for the **Device Specs API**. 

Features complete data binding for normalized hardware specifications, synchronous and asynchronous execution, and a **type-safe Fluent Deep Filtering system** to build complex device queries easily.

---

## 📦 Installation

### Gradle (Kotlin DSL)
```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("com.granturismo:devicespecs-sdk:1.0.0")
}
```

### Gradle (Groovy)
```groovy
repositories {
    mavenCentral()
}

dependencies {
    implementation 'com.granturismo:devicespecs-sdk:1.0.0'
}
```

### Maven (`pom.xml`)
```xml
<dependency>
    <groupId>com.granturismo</groupId>
    <artifactId>devicespecs-sdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

---

## 🚀 Quickstart

### ☕ Java Example

```java
import com.granturismo.devicespecs.DeviceSpecsClient;
import com.granturismo.devicespecs.filter.DeviceFilterBuilder;
import com.granturismo.devicespecs.models.DeviceSpecsResponse;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialize client
        DeviceSpecsClient client = new DeviceSpecsClient("YOUR_API_MARKET_KEY");

        // Simple fetch
        List<DeviceSpecsResponse> samsungDevices = client.getDevicesByManufacturer("Samsung");
        System.out.println("Found " + samsungDevices.size() + " Samsung devices.");

        // Fluent Deep Filtering
        DeviceFilterBuilder filter = DeviceFilterBuilder.builder()
                .manufacturer("Samsung")
                .ramGte(8)
                .batteryCapacityGte(5000)
                .display(d -> d.refreshRateHzGte(120).sizeInchesGte(6.5))
                .connectivity(c -> c.hasNfc(true).bluetoothVersionGte(5.0));

        List<DeviceSpecsResponse> filteredDevices = client.getDevices(filter);
        for (DeviceSpecsResponse device : filteredDevices) {
            System.out.println(device.getManufacturer() + " " + device.getModel() +
                    " - RAM: " + device.getNormalizedSpecs().getMemoryOptions().getAvailableRamGb() + "GB" +
                    " - Screen: " + device.getNormalizedSpecs().getDisplay().getSizeInches() + "\"");
        }
    }
}
```

---

### 🎯 Kotlin & Android Example

```kotlin
import com.granturismo.devicespecs.DeviceSpecsClient
import com.granturismo.devicespecs.kotlin.getDevices
import com.granturismo.devicespecs.kotlin.getDevicesByManufacturer

fun main() {
    val client = DeviceSpecsClient("YOUR_API_MARKET_KEY")

    // Idiomatic Kotlin DSL filtering
    val premiumDevices = client.getDevices {
        manufacturer("Samsung")
        priceUsdLte(1200.0)
        
        display {
            refreshRateHzGte(120)
            sizeInchesGte(6.5)
        }
        
        processor {
            totalCoresGte(8)
            maxClockSpeedGhzGt(2.8)
        }
        
        power {
            batteryCapacityGte(5000)
            hasWirelessCharging(true)
        }
        
        connectivity {
            hasNfc(true)
        }
    }

    premiumDevices.forEach { device ->
        println("${device.manufacturer} ${device.model} ($${device.priceUsd})")
    }
}
```

---

## ⚡ Async Execution (CompletableFuture)

```java
client.getDevicesAsync(filter)
    .thenAccept(devices -> {
        System.out.println("Asynchronously fetched " + devices.size() + " devices.");
    })
    .exceptionally(ex -> {
        System.err.println("Request failed: " + ex.getMessage());
        return null;
    });
```

---

## 🔍 Fluent Deep Filtering System

The SDK provides type-safe method chaining across all normalized hardware specification categories:

| Category | Builder Method | Available Filters |
|---|---|---|
| **Root** | `builder()` | `manufacturer()`, `model()`, `chipset()`, `priceUsdLte()`, `priceUsdBetween()` |
| **Display** | `.display(...)` | `sizeInchesGte()`, `refreshRateHzGte()`, `panelType()`, `peakBrightnessNitsGte()` |
| **Processor** | `.processor(...)` | `totalCoresGte()`, `maxClockSpeedGhzGt()` |
| **Memory** | `.memory(...)` | `ramGte()`, `ramBetween()`, `storageGte()`, `hasCardSlot()` |
| **Power** | `.power(...)` | `capacityMahGte()`, `chargingWattsGte()`, `hasWirelessCharging()` |
| **Cameras** | `.cameras(...)` | `maxMainResolutionMpGte()`, `mainLensesCountGte()`, `selfieLensesCountGte()` |
| **Physical** | `.physical(...)` | `weightGramsLte()`, `ipRatingContains()`, `isWaterResistant()` |
| **Sound** | `.sound(...)` | `hasStereoSpeakers()`, `has35mmJack()` |
| **Connectivity** | `.connectivity(...)` | `hasNfc()`, `hasInfrared()`, `bluetoothVersionGte()`, `usbTypeContains()` |
| **Benchmarks** | `.benchmarks(...)` | `antutuContains()`, `geekbenchContains()` |

---

## 🛠️ Building & Publishing to Maven Central

### Run Tests
```bash
./gradlew test
```

### Publish to Local Maven (`~/.m2/repository`)
```bash
./gradlew publishToMavenLocal
```

### Deploy to Sonatype OSSRH / Maven Central
Set your OSSRH credentials in `~/.gradle/gradle.properties`:
```properties
ossrhUsername=YOUR_SONATYPE_USERNAME
ossrhPassword=YOUR_SONATYPE_PASSWORD
signingKey=YOUR_GPG_PRIVATE_KEY
signingPassword=YOUR_GPG_PASSPHRASE
```
Then run:
```bash
./gradlew publish
```

---

## 📄 License

Licensed under the Apache License, Version 2.0.
