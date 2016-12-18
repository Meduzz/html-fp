package se.kodiak.tools.html.tags

import se.kodiak.tools.html.Tags._

trait Form {

	def button(attributes:Map[String, String] = Map()):TagBuilder = Custom.build("button", attributes)

	def label(attributes:Map[String, String] = Map()):TagBuilder = Custom.build("label", attributes)

	def form(attributes:Map[String, String] = Map()):TagBuilder = Custom.build("form", attributes)

	def input(attributes:Map[String, String] = Map()):Tag = {
		Custom("input", attributes, List())
	}

	def select(attributes:Map[String, String] = Map()):TagBuilder = Custom.build("select", attributes)

	def option(attributes:Map[String, String] = Map()):TagBuilder = Custom.build("option", attributes)

	def textarea(attributes:Map[String, String] = Map())(value:String):Tag = {
		Custom("textarea", attributes, List(text(value)))
	}

}
