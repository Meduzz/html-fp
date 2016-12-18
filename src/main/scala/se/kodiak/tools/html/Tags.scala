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

	trait TagBuilder {
		def child(tag:Tag):Tag
		def children(tags:List[Tag]):Tag
	}

	object Custom {
		def curry(name:String)(attributes: Map[String, String])(children:List[Tag]):Tag = {
			HtmlTag(name, attributes, children)
		}

		def apply(name:String, attributes:Map[String, String] = Map(), children:List[Tag] = List()):Tag = {
			HtmlTag(name, attributes, children)
		}

		def build(name:String, attributes:Map[String, String] = Map()):TagBuilder = new TagBuilder {
			override def children(tags:List[Tag]) = HtmlTag(name, attributes, tags)

			override def child(tag:Tag) = HtmlTag(name, attributes, List(tag))
		}
	}

	def text(text:String):Tag = {
		TextTag(text)
	}

	def div(attributes:Map[String, String] = Map()):TagBuilder = Custom.build("div", attributes)

	def img(attributes:Map[String, String] = Map(), children:List[Tag] = List()):Tag = {
		Custom("img", attributes, children)
	}

	def span(attributes:Map[String, String] = Map()):TagBuilder = Custom.build("span", attributes)

	def p(attributes:Map[String, String] = Map()):TagBuilder = Custom.build("p", attributes)

	def script(attributes:Map[String, String] = Map()):TagBuilder = Custom.build("script", attributes)

	def atag(attributes:Map[String, String] = Map()):TagBuilder = Custom.build("a", attributes)

	def a(label:String, attributes:Map[String, String] = Map()):Tag = {
		Custom("a", attributes, List(text(label)))
	}

	def emptyWithCloseTag():Tag = text("")
}
