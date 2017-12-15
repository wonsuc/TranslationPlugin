/*
 * YoudaoResults
 * 
 * Created by Yii.Guxing on 2017/10/30
 */
@file:Suppress("ArrayInDataClass")

package cn.yiiguxing.plugin.translate.trans

import com.google.gson.annotations.SerializedName


data class YoudaoResult(
        @SerializedName("query")
        var query: String? = null,
        @SerializedName("errorCode")
        var errorCode: Int = -1,
        var message: String? = null,
        @SerializedName("translation")
        var translation: Array<String>? = null,
        @SerializedName("basic")
        var basicExplain: BasicExplain? = null,
        @SerializedName("l")
        var languages: String? = null,
        @SerializedName("web")
        var webExplains: Array<WebExplain>? = null
) : TranslationAdapter {
    fun checkError() {
        if (errorCode == 0 && translation?.isEmpty() != false && basicExplain?.explains?.isEmpty() != false) {
            errorCode = 302
        }
    }

    override fun toTranslation(): Translation {
        return Translation("", "", Lang.AUTO, Lang.AUTO)
    }
}

data class BasicExplain(
        @SerializedName(value = "phonetic")
        var phonetic: String? = null,
        @SerializedName(value = "uk-phonetic")
        var phoneticUK: String? = null,
        @SerializedName(value = "us-phonetic")
        var phoneticUS: String? = null,
        @SerializedName(value = "explains")
        var explains: Array<String>? = null
)

data class WebExplain(
        @SerializedName(value = "key")
        var key: String? = null,
        @SerializedName(value = "value")
        var values: Array<String>? = null
)