package se.kodiak.tools.html.dressers

import se.kodiak.tools.html.Tags.Tag

class TagDresser(first:Tag) {

	/**
		* Concat this tag with the next one.
		* @param tag te other tag.
		* @return returns a Seq[Tag]
		*/
	def &(tag:Tag):List[Tag] = List(first, tag)

	/**
		* Turn a single tag into a Seq[Tag].
		* @return
		*/
	def $():List[Tag] = List(first)

}
