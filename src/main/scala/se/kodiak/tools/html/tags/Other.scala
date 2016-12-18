package se.kodiak.tools.html.tags

import se.kodiak.tools.html.Tags._

trait Other {

	def ul(attributes:Map[String, String] = Map())(children:Tag*):Tag = {
		Custom("ul", attributes, children.toList)
	}

	def li(attributes:Map[String, String] = Map())(children:Tag*):Tag = {
		Custom("li", attributes, children.toList)
	}

	def table(attributes:Map[String, String] = Map())(children:Tag*):Tag = {
		Custom("table", attributes, children.toList)
	}

	def tr(attributes:Map[String, String] = Map())(children:Tag*):Tag = {
		Custom("tr", attributes, children.toList)
	}

	def td(attributes:Map[String, String] = Map())(children:Tag*):Tag = {
		Custom("td", attributes, children.toList)
	}

	def th(attributes:Map[String, String] = Map())(children:Tag*):Tag = {
		Custom("tr", attributes, children.toList)
	}

	def thead(attributes:Map[String, String] = Map())(children:Tag*):Tag = {
		Custom("thead", attributes, children.toList)
	}

	def tbody(attributes:Map[String, String] = Map())(children:Tag*):Tag = {
		Custom("tbody", attributes, children.toList)
	}

	def tfoot(attributes:Map[String, String] = Map())(children:Tag*):Tag = {
		Custom("tfoot", attributes, children.toList)
	}

}
