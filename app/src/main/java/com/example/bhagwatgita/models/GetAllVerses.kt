package com.example.bhagwatgita.models

data class GetAllVerses(
	val getAllVerses: List<GetAllVersesItem?>? = null
)

data class TranslationsItemx(
	val authorName: String? = null,
	val description: String? = null,
	val language: String? = null,
	val id: Int? = null
)

data class GetAllVersesItem(
	val commentaries: List<CommentariesItemx?>? = null,
	val translations: List<TranslationsItemx?>? = null,
	val chapter_number: Int? = null,
	val id: Int? = null,
	val text: String? = null,
	val verse_number: Int? = null,
	val wordMeanings: String? = null,
	val slug: String? = null,
	val transliteration: String? = null
)

data class CommentariesItemx(
	val authorName: String? = null,
	val description: String? = null,
	val language: String? = null,
	val id: Int? = null
)

