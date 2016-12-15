package se.kodiak.tools.html

import se.kodiak.tools.html.Tags.Tag
import se.kodiak.tools.html.dressers.{StringDresser, TagDresser, TagsDresser}

object Implicits {

	implicit def dressUpTag(tag:Tag):TagDresser = new TagDresser(tag)
	implicit def dressUpTags(tags:List[Tag]):TagsDresser = new TagsDresser(tags)
	implicit def dressUpString(input:String):StringDresser = new StringDresser(input)

}
