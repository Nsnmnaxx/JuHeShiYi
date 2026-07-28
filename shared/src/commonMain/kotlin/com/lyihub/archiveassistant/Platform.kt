package com.lyihub.archiveassistant

/**
 * KMP expect 声明：commonMain 层定义平台差异接口，
 * androidMain 和 iosMain 各自提供 actual 实现。
 */

enum class PlatformType { ANDROID, IOS }

expect fun currentPlatform(): PlatformType

expect fun appFilesDirPath(): String
