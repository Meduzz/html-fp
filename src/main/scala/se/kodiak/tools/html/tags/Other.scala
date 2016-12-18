package se.kodiak.tools.html.tags

import se.kodiak.tools.html.Tags._

trait Other {

	def ul(attributes:Map[String, String] = Map()):TagBuilder = Custom.build("ul", attributes)

	def li(attributes:Map[String, String] = Map()):TagBuilder = Custom.build("li", attributes)

	def table(attributes:Map[String, String] = Map()):TagBuilder = Custom.build("table", attributes)

	def tr(attributes:Map[String, String] = Map()):TagBuilder = Custom.build("tr", attributes)

	def td(attributes:Map[String, String] = Map()):TagBuilder = Custom.build("td", attributes)

	def th(attributes:Map[String, String] = Map()):TagBuilder = Custom.build("tr", attributes)

	def thead(attributes:Map[String, String] = Map()):TagBuilder = Custom.build("thead", attributes)

	def tbody(attributes:Map[String, String] = Map()):TagBuilder = Custom.build("tbody", attributes)

	def tfoot(attributes:Map[String, String] = Map()):TagBuilder = Custom.build("tfoot", attributes)

	def h1(attributes:Map[String, String] = Map()):TagBuilder = Custom.build("h1", attributes)

	def h2(attributes:Map[String, String] = Map()):TagBuilder = Custom.build("h2", attributes)

	def h3(attributes:Map[String, String] = Map()):TagBuilder = Custom.build("h3", attributes)

	def h4(attributes:Map[String, String] = Map()):TagBuilder = Custom.build("h4", attributes)

	def h5(attributes:Map[String, String] = Map()):TagBuilder = Custom.build("h5", attributes)

	def h6(attributes:Map[String, String] = Map()):TagBuilder = Custom.build("h6", attributes)
}
