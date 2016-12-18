package se.kodiak.tools.html.tags

import se.kodiak.tools.html.Tags.{Custom, Tag, TagBuilder, text}

trait Base {

	def html(attributes:Map[String, String] = Map()):TagBuilder = Custom.build("html", attributes)

	def body(attributes:Map[String, String] = Map()):TagBuilder = Custom.build("body", attributes)

	def head(attributes:Map[String, String] = Map()):TagBuilder = Custom.build("head", attributes)

	def title(title:String, attributes:Map[String, String] = Map()):Tag = {
		Custom("title", attributes, List(text(title)))
	}

}
