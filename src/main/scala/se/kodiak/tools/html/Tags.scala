package se.kodiak.tools.html

import se.kodiak.tools.html.tags.{Base, Form, Other}

object Tags extends Base with Other with Form {

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
		def curry(name:String)(attributes: Map[String, String])(children:Tag*):Tag = {
			HtmlTag(name, attributes, children.toList)
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

	def div(attributes:Map[String, String] = Map())(children:Tag*):Tag = {
		Custom("div", attributes, children.toList)
	}

	def img(attributes:Map[String, String] = Map())(children:Tag*):Tag = {
		Custom("img", attributes, children.toList)
	}

	def span(attributes:Map[String, String] = Map())(children:Tag*):Tag = {
		Custom("span", attributes, children.toList)
	}

	def p(attributes:Map[String, String] = Map())(children:Tag*):Tag = {
		Custom("p", attributes, children.toList)
	}

	def script(attributes:Map[String, String] = Map())(children:Tag*):Tag = {
		Custom("script", attributes, children.toList)
	}

	def atag(attributes:Map[String, String] = Map())(children:Tag*):Tag = {
		Custom("a", attributes, children.toList)
	}

	def a(label:String, attributes:Map[String, String] = Map()):Tag = {
		Custom("a", attributes, List(text(label)))
	}

	def emptyWithCloseTag():Tag = text("")
}
