package se.kodiak.tools.html.tags

import se.kodiak.tools.html.Tags._

trait Form {

	def button(attributes:Map[String, String] = Map())(func:()=>List[Tag]):Tag = {
		Custom("button", attributes, func())
	}

	def label(attributes:Map[String, String] = Map())(func:()=>List[Tag]):Tag = {
		Custom("label", attributes, func())
	}

	def form(attributes:Map[String, String] = Map())(func:()=>List[Tag]):Tag = {
		Custom("form", attributes, func())
	}

	def input(attributes:Map[String, String] = Map()):Tag = {
		Custom("input", attributes, List())
	}

	def select(attributes:Map[String, String] = Map())(func:()=>List[Tag]):Tag = {
		Custom("select", attributes, func())
	}

	def option(attributes:Map[String, String] = Map())(func:()=>List[Tag]):Tag = {
		Custom("option", attributes, func())
	}

	def textarea(attributes:Map[String, String] = Map())(value:String):Tag = {
		Custom("textarea", attributes, List(text(value)))
	}

}
