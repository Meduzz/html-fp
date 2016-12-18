package se.kodiak.tools.html.tags

import se.kodiak.tools.html.Tags._

trait Form {

	def button(attributes:Map[String, String] = Map())(children:Tag*):Tag = {
		Custom("button", attributes, children.toList)
	}

	def label(attributes:Map[String, String] = Map())(children:Tag*):Tag = {
		Custom("label", attributes, children.toList)
	}

	def form(attributes:Map[String, String] = Map())(children:Tag*):Tag = {
		Custom("form", attributes, children.toList)
	}

	def input(attributes:Map[String, String] = Map()):Tag = {
		Custom("input", attributes, List())
	}

	def select(attributes:Map[String, String] = Map())(children:Tag*):Tag = {
		Custom("select", attributes, children.toList)
	}

	def option(attributes:Map[String, String] = Map())(children:Tag*):Tag = {
		Custom("option", attributes, children.toList)
	}

	def textarea(attributes:Map[String, String] = Map())(value:String):Tag = {
		Custom("textarea", attributes, List(text(value)))
	}

}
