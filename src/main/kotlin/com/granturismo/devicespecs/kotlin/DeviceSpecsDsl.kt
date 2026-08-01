package com.granturismo.devicespecs.kotlin

import com.granturismo.devicespecs.DeviceSpecsClient
import com.granturismo.devicespecs.filter.DeviceFilterBuilder
import com.granturismo.devicespecs.models.DeviceSpecsResponse
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutionException

inline fun buildFilter(block: DeviceFilterBuilder.() -> Unit): DeviceFilterBuilder {
    return DeviceFilterBuilder.builder().apply(block)
}

fun DeviceSpecsClient.getDevices(filterBlock: DeviceFilterBuilder.() -> Unit): List<DeviceSpecsResponse> {
    val filter = buildFilter(filterBlock)
    return this.getDevices(filter)
}

fun DeviceSpecsClient.getDevicesByManufacturer(
    manufacturer: String,
    filterBlock: DeviceFilterBuilder.() -> Unit
): List<DeviceSpecsResponse> {
    val filter = buildFilter(filterBlock)
    return this.getDevicesByManufacturer(manufacturer, filter)
}

fun DeviceSpecsClient.getDevicesByChipset(
    chipset: String,
    filterBlock: DeviceFilterBuilder.() -> Unit
): List<DeviceSpecsResponse> {
    val filter = buildFilter(filterBlock)
    return this.getDevicesByChipset(chipset, filter)
}

fun DeviceSpecsClient.getDevicesAsync(
    filterBlock: DeviceFilterBuilder.() -> Unit
): CompletableFuture<List<DeviceSpecsResponse>> {
    val filter = buildFilter(filterBlock)
    return this.getDevicesAsync(filter)
}
