package se.chimps.tools.html

import se.chimps.tools.html.tags.{Base, Form, Layout}

object Tags extends Base with Layout with Form {

	trait Tag {
		def render(indent:Int):String
	}

	case class HtmlTag(name:String, attributes:Map[String, String], children:Seq[Tag]) extends Tag {
		override def render(indent:Int):String = {
			val text = s"<$name${renderAttribes()}"
			if (children.isEmpty) {
				return s"$text />"
			}

			if (indent > 0) {
				val tabs = (0 to indent).map(_ => "  ").mkString
				s"""$text>
					 |$tabs${renderChildren(indent + 1)}
					 |</$name>
				 """.stripMargin
			} else {
				s"$text>${renderChildren(0)}</$name>"
			}
		}

		private def renderAttribes():String = {
			val attribs = attributes.map(kv => s"""${kv._1}="${kv._2}"""").mkString(" ")

			// pretty...
			if (attribs.nonEmpty) {
				" ".concat(attribs)
			} else {
				""
			}
		}

		private def renderChildren(indent:Int):String = {
			if (indent > 0) {
				children.map(c => c.render(indent)).mkString("\r\n")
			} else {
				children.map(c => c.render(0)).mkString
			}
		}
	}

	case class TextTag(text:String) extends Tag {
		override def render(indent:Int):String = {
			if (indent > 0) {
				val tabs = (0 to indent).map(_ => "  ").mkString
				s"$tabs$text"
			} else {
				text
			}
		}
	}

	object Custom {
		def apply(name:String):(Map[String, String]) => (() => List[Tag]) => Tag = (attributes) => (func) => {
			HtmlTag(name, attributes, func())
		}

		def apply(name:String, attributes:Map[String, String], func:()=>List[Tag]):Tag = {
			HtmlTag(name, attributes, func())
		}

		def apply(name:String, attributes:Map[String, String] = Map(), children:List[Tag]):Tag = {
			HtmlTag(name, attributes, children)
		}
	}

	def text(text:String):Tag = {
		TextTag(text)
	}

	def text(input:Int):Tag = {
		TextTag(input.toString)
	}

	def div(attributes:Map[String, String] = Map())(func:()=>List[Tag]):Tag = {
		Custom("div", attributes, func())
	}

	def img(attributes:Map[String, String] = Map())(func:()=>List[Tag]):Tag = {
		Custom("img", attributes, func())
	}

	def span(attributes:Map[String, String] = Map())(func:()=>List[Tag]):Tag = {
		Custom("span", attributes, func())
	}

	def p(attributes:Map[String, String] = Map())(func:()=>List[Tag]):Tag = {
		Custom("p", attributes, func())
	}

	def script(attributes:Map[String, String] = Map())(func:()=>List[Tag]):Tag = {
		Custom("script", attributes, func())
	}

	def a(attributes:Map[String, String] = Map())(func:()=>List[Tag]):Tag = {
		Custom("a", attributes, func())
	}
}
