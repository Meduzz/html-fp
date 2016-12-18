package se.kodiak.tools.html.dressers

import se.kodiak.tools.html.Tags._

class StringDresser(input:String) {

	/**
		* Custom tag alias.
		* @param attributes the tags attributes.
		* @return returns a Tag
		*/
	def ~(attributes:Map[String, String]):(List[Tag])=>Tag = Custom.curry(input)(attributes)

	/**
		* Path builder alias continued.
		* @param path the bit of text to add to the current path (text).
		* @return returns a new string.
		*/
	def /(path:String):String = s"$input/$path"

	/**
		* Alias to create a text tag out of this string.
		* @return returns a Tag.
		*/
	def t:Tag = text(input)

	/**
		* Alias to create a list with one text tag out of this string.
		* @return returns a List[Tag]
		*/
	def ts:List[Tag] = List(text(input))

	/**
		* Custom tag with empty attributes alias.
		* @return returns a Tag, eventually.
		*/
	def ~():(List[Tag]) => Tag = Custom.curry(input)(Map())

}
