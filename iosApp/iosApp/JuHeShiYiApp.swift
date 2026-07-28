import SwiftUI
import Shared

@main
struct JuHeShiYiApp: App {
    init() {
        // 初始化 KMP shared 模块
        SharedModuleInitializerKt.doInitKoin()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
