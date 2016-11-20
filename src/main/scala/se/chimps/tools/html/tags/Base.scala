package se.chimps.tools.html.tags

import se.chimps.tools.html.Tags.{Custom, Tag}

trait Base {

	def html(attributes:Map[String, String] = Map())(children:List[Tag]):Tag = {
		Custom("html", attributes, children)
	}

	def body(attributes:Map[String, String] = Map())(func:()=>List[Tag]):Tag = {
		Custom("body", attributes, func())
	}

	def head(attributes:Map[String, String] = Map())(children:List[Tag]):Tag = {
		Custom("head", attributes, children)
	}

	def title(attributes:Map[String, String] = Map())(children:List[Tag]):Tag = {
		Custom("title", attributes, children)
	}

}
