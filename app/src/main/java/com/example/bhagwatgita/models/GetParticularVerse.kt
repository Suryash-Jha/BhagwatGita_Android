package com.example.bhagwatgita.models

data class GetParticularVerse(
	val commentaries: List<CommentariesItem?>? = null,
	val translations: List<TranslationsItem?>? = null,
	val chapter_number: Int? = null,
	val id: Int? = null,
	val text: String? = null,
	val verse_number: Int? = null,
	val wordMeanings: String? = null,
	val slug: String? = null,
	val transliteration: String? = null
)

data class TranslationsItem(
	val authorName: String? = null,
	val description: String? = null,
	val language: String? = null,
	val id: Int? = null
)

data class CommentariesItem(
	val authorName: String? = null,
	val description: String? = null,
	val language: String? = null,
	val id: Int? = null
)

