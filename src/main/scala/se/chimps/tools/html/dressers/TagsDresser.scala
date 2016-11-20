package se.chimps.tools.html.dressers

import se.chimps.tools.html.Tags.Tag

class TagsDresser(tags:List[Tag]) {

	/**
		* Concat a tag with a previius Seq of tags.
		* @param tag the tag to add.
		* @return returns a new Seq with previous + the new tag.
		*/
	def &(tag:Tag):List[Tag] = tags :+ tag

}
