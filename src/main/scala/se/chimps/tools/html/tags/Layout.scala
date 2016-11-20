package se.chimps.tools.html.tags

import se.chimps.tools.html.Tags._

trait Layout {

	def ul(attributes:Map[String, String] = Map())(func:()=>List[Tag]):Tag = {
		Custom("ul", attributes, func())
	}

	def li(attributes:Map[String, String] = Map())(func:()=>List[Tag]):Tag = {
		Custom("li", attributes, func())
	}

	def table(attributes:Map[String, String] = Map())(func:()=>List[Tag]):Tag = {
		Custom("table", attributes, func())
	}

	def tr(attributes:Map[String, String] = Map())(func:()=>List[Tag]):Tag = {
		Custom("tr", attributes, func())
	}

	def td(attributes:Map[String, String] = Map())(func:()=>List[Tag]):Tag = {
		Custom("td", attributes, func())
	}

	def th(attributes:Map[String, String] = Map())(func:()=>List[Tag]):Tag = {
		Custom("tr", attributes, func())
	}

	def thead(attributes:Map[String, String] = Map())(func:()=>List[Tag]):Tag = {
		Custom("thead", attributes, func())
	}

	def tbody(attributes:Map[String, String] = Map())(func:()=>List[Tag]):Tag = {
		Custom("tbody", attributes, func())
	}

	def tfoot(attributes:Map[String, String] = Map())(func:()=>List[Tag]):Tag = {
		Custom("tfoot", attributes, func())
	}

}
