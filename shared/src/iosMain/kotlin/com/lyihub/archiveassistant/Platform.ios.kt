package com.lyihub.archiveassistant

import platform.Foundation.NSFileManager
import platform.Foundation.NSSearchPathForDirectoriesInDomains
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSUserDomainMask

actual fun currentPlatform(): PlatformType = PlatformType.IOS

actual fun appFilesDirPath(): String {
    val paths = NSSearchPathForDirectoriesInDomains(
        NSDocumentDirectory,
        NSUserDomainMask,
        true
    )
    return (paths.firstOrNull() as? String) ?: NSFileManager.defaultManager
        .temporaryDirectory
        .path ?: "/tmp"
}
