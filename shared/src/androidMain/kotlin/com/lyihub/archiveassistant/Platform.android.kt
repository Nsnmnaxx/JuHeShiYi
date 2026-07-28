package com.lyihub.archiveassistant

import android.content.Context

actual fun currentPlatform(): PlatformType = PlatformType.ANDROID

actual fun appFilesDirPath(): String {
    // 通过 App 级 Context 获取 filesDir
    // 若未初始化则返回默认路径
    return AppContextHolder.filesDirPath ?: "/data/data/com.lyihub.archiveassistant/files"
}

/**
 * 持有 Application Context 引用，供 KMP shared 模块使用。
 */
object AppContextHolder {
    private var appContext: Context? = null
    var filesDirPath: String? = null
        private set

    fun init(context: Context) {
        appContext = context.applicationContext
        filesDirPath = context.filesDir.absolutePath
    }

    fun get(): Context = appContext
        ?: throw IllegalStateException("AppContextHolder not initialized. Call init() from Application.onCreate()")
}
