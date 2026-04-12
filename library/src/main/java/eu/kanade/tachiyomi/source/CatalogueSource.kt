package eu.kanade.tachiyomi.source

import eu.kanade.tachiyomi.source.model.FilterList
import eu.kanade.tachiyomi.source.model.MangasPage
import eu.kanade.tachiyomi.source.model.SManga
import rx.Observable

@Suppress("unused")
interface CatalogueSource : Source {

    /**
     * An ISO 639-1 compliant language code (two letters in lower case).
     */
    val lang: String

    /**
     * Whether the source has support for latest updates.
     */
    val supportsLatest: Boolean

    /**
     * Returns an observable containing a page with a list of manga.
     *
     * @param page the page number to retrieve.
     */
    fun fetchPopularManga(page: Int): Observable<MangasPage>

    /**
     * Returns an observable containing a page with a list of manga.
     *
     * @param page the page number to retrieve.
     * @param query the search query.
     * @param filters the list of filters to apply.
     */
    fun fetchSearchManga(page: Int, query: String, filters: FilterList): Observable<MangasPage>

    /**
     * Returns an observable containing a page with a list of latest manga updates.
     *
     * @param page the page number to retrieve.
     */
    fun fetchLatestUpdates(page: Int): Observable<MangasPage>

    /**
     * Returns the list of filters for the source.
     */
    fun getFilterList(): FilterList

    /**
     * Whether parsing related mangas in manga page or extension provide custom related mangas request.
     * Only Supported on Komikku
     * @default false
     */
    val supportsRelatedMangas: Boolean get() = false

    /**
     * Extensions doesn't want to use App's [getRelatedMangaListBySearch].
     * Only Supported on Komikku
     * @default false
     */
    val disableRelatedMangasBySearch: Boolean get() = false

    /**
     * Disable showing any related titles.
     * Only Supported on Komikku
     * @default false
     */
    val disableRelatedMangas: Boolean get() = false

    /**
     * Fetch related mangas for a manga from source/site.
     * Only Supported on Komikku
     *
     * @param manga the current manga to get related mangas.
     * @return the related mangas for the current manga.
     * @throws UnsupportedOperationException if a source doesn't support related mangas.
     */
    suspend fun fetchRelatedMangaList(manga: SManga): List<SManga> = throw UnsupportedOperationException("Unsupported!")
}