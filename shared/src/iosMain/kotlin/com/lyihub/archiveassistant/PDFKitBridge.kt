package com.lyihub.archiveassistant

/**
 * iOS PDF 文档提取桥接层。
 *
 * Android 端使用 PdfBox-Android (com.tom-roush:pdfbox-android) 解析 PDF，
 * iOS 端使用原生 PDFKit (via Objective-C interop) 实现相同能力。
 *
 * 当前为占位实现，后续通过 objc-interop 调用 PDFKit 的 PDFDocument / PDFPage / PDFSelection。
 *
 * 参考 API：
 * - PDFDocument(url:) → 加载 PDF
 * - document.string → 全文提取
 * - page.string → 逐页提取
 * - page.selection(for: rect) → 区域选择文本
 */
object PDFKitBridge {

    /**
     * 从指定路径提取 PDF 全文。
     * @param filePath PDF 文件绝对路径
     * @return 提取的文本内容；失败返回空字符串
     */
    fun extractText(filePath: String): String {
        // TODO: 实现 objc-interop 调用 PDFKit
        // val url = NSURL.fileURLWithPath(filePath)
        // val document = PDFDocument(url)
        // return document.string ?: ""
        return "PDFKit extraction placeholder - implement via objc-interop"
    }

    /**
     * 从指定路径提取 PDF 的指定页文本。
     * @param filePath PDF 文件绝对路径
     * @param pageIndex 页码（0-based）
     * @return 该页文本内容；失败返回空字符串
     */
    fun extractPageText(filePath: String, pageIndex: Int): String {
        // TODO: 实现逐页提取
        return ""
    }

    /**
     * 获取 PDF 总页数。
     * @param filePath PDF 文件绝对路径
     * @return 页数；失败返回 0
     */
    fun pageCount(filePath: String): Int {
        // TODO: 实现页数统计
        return 0
    }
}
