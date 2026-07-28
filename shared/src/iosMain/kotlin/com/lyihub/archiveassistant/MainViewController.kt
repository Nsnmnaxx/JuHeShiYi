package com.lyihub.archiveassistant

import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController

/**
 * Compose Multiplatform iOS 入口。
 * 由 SwiftUI ContentView 通过 UIViewControllerRepresentable 调用。
 */
fun MainViewController(): UIViewController =
    ComposeUIViewController {
        // TODO: Replace with iOS-specific app entry point
    }
