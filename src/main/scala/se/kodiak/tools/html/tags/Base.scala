package se.kodiak.tools.html.tags

import se.kodiak.tools.html.Tags.{Custom, Tag, text}

trait Base {

	def html(attributes:Map[String, String] = Map())(children:Tag*):Tag = {
		Custom("html", attributes, children.toList)
	}

	def body(attributes:Map[String, String] = Map())(children:Tag*):Tag = {
		Custom("body", attributes, children.toList)
	}

	def head(attributes:Map[String, String] = Map())(children:Tag*):Tag = {
		Custom("head", attributes, children.toList)
	}

	def title(title:String, attributes:Map[String, String] = Map()):Tag = {
		Custom("title", attributes, List(text(title)))
	}

}
