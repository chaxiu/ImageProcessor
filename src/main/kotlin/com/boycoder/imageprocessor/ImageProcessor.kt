package com.boycoder.imageprocessor

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

const val BASE_PATH = "./src/main/resources/images/"

/**
 * 加载本地图片
 */
fun loadImage(imageFile: File) =
    ImageIO.read(imageFile)
        .let {
            Array(it.height) { y ->
                Array(it.width) { x ->
                    Color(it.getRGB(x, y))
                }
            }
        }.let {
            Image(it)
        }

/**
 * 图片裁切
 * 待实现
 */
fun Image.crop(startY: Int, startX: Int, width: Int, height: Int): Image = TODO()

/**
 * 横向翻转图片
 * 待实现
 */
fun Image.flipHorizontal(): Image = TODO()

/**
 * 纵向翻转图片
 * 待实现
 */
fun Image.flipVertical(): Image = TODO()

/**
 * 挂起函数，以http的方式下载图片，保存到本地
 * 待实现
 */
suspend fun downloadImage(url: String, outputFile: File): Boolean = TODO()

fun main() = runBlocking {
    val image = loadImage(File("${BASE_PATH}android.png"))
    println("Width = ${image.width()};Height = ${image.height()}")
}