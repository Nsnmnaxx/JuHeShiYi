package com.lyihub.archiveassistant

/**
 * iOS 平台桥接：KMP expect/actual 模式。
 * commonMain 中通过 expect 声明平台差异接口，iosMain 提供 actual 实现。
 */

/**
 * 平台类型枚举。
 */
enum class PlatformType {
    ANDROID, IOS
}

/**
 * 获取当前平台。
 */
expect fun currentPlatform(): PlatformType

/**
 * 获取 App 私有文件目录路径（对应 Android Context.filesDir）。
 */
expect fun appFilesDirPath(): String
