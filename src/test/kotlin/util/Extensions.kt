package util

import com.google.common.io.Resources
import java.nio.charset.Charset

// From https://github.com/dlew/aoc-2017/blob/master/src/test/kotlin/utils/Extensions.kt
fun getResourceAsString(resourceName: String, charset: Charset = Charsets.UTF_8) =
        Resources.toString(Resources.getResource(resourceName), charset)