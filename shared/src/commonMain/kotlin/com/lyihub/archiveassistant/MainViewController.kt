package com.lyihub.archiveassistant

import androidx.compose.runtime.Composable
import platform.UIKit.UIViewController

/**
 * Compose Multiplatform iOS 入口。
 * 由 SwiftUI ContentView 通过 UIViewControllerRepresentable 调用。
 */

fun MainViewController(): UIViewController =
    com.lyihub.archiveassistant.app.createApplication()
