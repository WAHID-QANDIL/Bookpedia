package org.bookpedia.domain.model
data class Book(
    val id: String,
    val title: String,
    val imageUrl: String,
    val authors: List<String>,
    val description: String?,
    val languages: List<String>,
    val firstPublishedYear: String?,
    val averageRating: Double?,
    val ratingCount:Int?,
    val numPages:Int?,
    val numEditions:Int
)