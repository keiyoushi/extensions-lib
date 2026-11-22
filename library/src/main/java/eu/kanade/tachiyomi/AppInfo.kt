package eu.kanade.tachiyomi

import eu.kanade.tachiyomi.source.model.SChapter
import eu.kanade.tachiyomi.source.model.SManga

@Suppress("Unused")
object AppInfo {
    /**
     * Version code of the host application. May be useful for sharing as User-Agent information.
     * Note that this value differs between forks so logic should not rely on it.
     *
     * @since extension-lib 1.3
     */
    fun getVersionCode(): Int = throw Exception("Stub!")

    /**
     * Version name of the host application. May be useful for sharing as User-Agent information.
     * Note that this value differs between forks so logic should not rely on it.
     *
     * @since extension-lib 1.3
     */
    fun getVersionName(): String = throw Exception("Stub!")

    /**
     * Keys of the `memo["meta"]` object of [SManga] and [SChapter] whose values the app shows itself.
     * A source may leave the facts under these keys out of [SManga.description] and [SChapter.name].
     * Empty when the app shows none. The keys and their values are specified by `schema/memo-meta.schema.json`.
     *
     * @since extensions-lib 1.6
     */
    fun getShownMetaKeys(): Set<String> = throw Exception("Stub!")
}
