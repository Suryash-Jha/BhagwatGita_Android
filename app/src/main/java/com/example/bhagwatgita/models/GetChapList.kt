package com.example.bhagwatgita.models

data class GetChapList(
	val getChapList: List<GetChapListItem?>? = null
)

data class GetChapListItem(
	val name_meaning: String? = null,
	val name_translated: String? = null,
	val name: String? = null,
	val verses_count: Int? = null,
	val chapter_number: Int? = null,
	val chapter_summary: String? = null,
	val chapter_summary_hindi: String? = null,
	val id: Int? = null,
	val name_transliterated: String? = null,
	val slug: String? = null
)

