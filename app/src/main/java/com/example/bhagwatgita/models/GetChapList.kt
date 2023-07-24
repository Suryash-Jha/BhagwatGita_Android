package com.example.bhagwatgita.models

data class GetChapList(
	val getChapList: List<GetChapListItem?>? = null
)

data class GetChapListItem(
	val nameMeaning: String? = null,
	val nameTranslated: String? = null,
	val name: String? = null,
	val versesCount: Int? = null,
	val chapterNumber: Int? = null,
	val chapterSummary: String? = null,
	val chapterSummaryHindi: String? = null,
	val id: Int? = null,
	val nameTransliterated: String? = null,
	val slug: String? = null
)

