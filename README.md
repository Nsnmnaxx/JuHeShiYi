# 聚合拾遗 —— 三省六部知识归档

## 项目结构

```
G:\A\最新版本\
├── 聚合拾遗-Android\   ← 原始 Android 项目（可直接构建 APK）
└── 聚合拾遗-Apple\     ← KMP 跨平台项目（Android + iOS 双端）
    ├── shared/          ← 共享业务逻辑（commonMain / androidMain / iosMain）
    │   ├── src/commonMain/   30 文件（纯 Compose Multiplatform）
    │   ├── src/androidMain/  32 文件（Android 专属：LiteRT / Canvas / DataStore）
    │   └── src/iosMain/       4 文件（iOS 专属：CoreML / PDFKit 桥接）
    ├── androidApp/      ← Android 壳工程（181 文件含 res）
    └── iosApp/          ← iOS 壳工程（SwiftUI + Xcode）
```

## 文件统计

| 版本 | 模块 | 文件数 | 说明 |
|------|------|--------|------|
| Android 版 | app/ | 293 | 完整原始项目，开箱即用 |
| Apple 版 | shared/commonMain | 30 | Compose Multiplatform 跨平台 UI |
| Apple 版 | shared/androidMain | 32 | Android 专属实现 |
| Apple 版 | shared/iosMain | 4 | iOS 专属桥接 |
| Apple 版 | androidApp | 181 | Android 壳 + 资源 |
| Apple 版 | iosApp | 4 | SwiftUI 壳 |

---

## 如何在手机上使用

### 方式一：Android 手机

**直接安装 APK（推荐）**

1. 在电脑上用 Android Studio 打开 `G:\A\最新版本\聚合拾遗-Android\`
2. 菜单：Build → Build Bundle(s) / APK(s) → Build APK(s)
3. 构建完成后，将 `app/build/outputs/apk/debug/app-debug.apk` 传到手机安装
4. 手机需 Android 12+（项目 minSdk = 31）

**或通过 Android 模拟器（本机）**

1. Android Studio → AVD Manager → 启动模拟器
2. Run 'app' 即可在模拟器运行

---

### 方式二：iPhone / iPad（Apple 版）

前提：需要一台 **Mac 电脑**，安装 Xcode 16+。

**第1步：在 Mac 上 clone 项目**

将 `G:\A\最新版本\聚合拾遗-Apple\` 整个文件夹拷贝到 Mac。

**第2步：用 Android Studio 构建 shared framework**

```bash
cd 聚合拾遗-Apple
./gradlew :shared:linkDebugFrameworkIosArm64
```

这会生成 `shared/build/bin/iosArm64/debugFramework/Shared.framework`

**第3步：用 Xcode 打开并运行**

```bash
open iosApp/iosApp.xcodeproj
```

在 Xcode 中：
- 选择你的 iPhone 作为目标设备
- 配置 Signing Team（免费 Apple ID 即可）
- Product → Run (Cmd+R)

---

### 关键依赖说明

| 原 Android 依赖 | Apple KMP 替换 |
|-----------------|---------------|
| OkHttp | Ktor Client（androidMain: OkHttp 引擎，iosMain: Darwin 引擎） |
| DataStore Preferences | multiplatform-settings |
| PdfBox-Android | PDFKit（iOS 原生） |
| LiteRT-LM（本地 AI） | CoreML（iOS 原生） |
| Jsoup | Ktor + kotlinx.serialization（网络解析） |

### 奏折阅读器说明

MemorialFoldView（3662 行）是 Android Canvas 自绘的奏折翻页效果，
在 iOS 上需要基于 UIKit / CoreAnimation 重写。
当前 androidMain 保留完整 Canvas 实现，iosMain 为占位，
后续可用 SwiftUI Canvas 或 UIKit drawRect 实现等效效果。

---

## 构建版本

- **项目名**：JuHeShiYi（聚合拾遗）
- **包名**：com.lyihub.archiveassistant
- **Kotlin**：2.2.21
- **AGP**：8.13.2
- **Compose**：Multiplatform 1.8.1
- **iOS 最低版本**：17.0
- **Android 最低版本**：API 31（Android 12）
