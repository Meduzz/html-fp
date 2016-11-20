package se.chimps.tools.html

import se.chimps.tools.html.Tags.Tag
import se.chimps.tools.html.dressers.{StringDresser, TagDresser, TagsDresser}

object Implicits {

	implicit def dressUpTag(tag:Tag):TagDresser = new TagDresser(tag)
	implicit def dressUpTags(tags:List[Tag]):TagsDresser = new TagsDresser(tags)
	implicit def dressUpString(input:String):StringDresser = new StringDresser(input)

}
