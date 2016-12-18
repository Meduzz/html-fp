package se.kodiak.tools.html

import org.scalatest.FunSpec
import Tags._
import Attributes._
import Implicits._

class TagsTest extends FunSpec {

	describe("""the api "iz nice"...""") {
		val textHtml = html()(
			head()(title("Hello there!")),
			body() {
				Custom.curry("h1")(Map()) {
					text("Hello there!")
				}
			}
		)

		// TODO wont compile without dots and parantheses...
		val h1 = "h1".~(:#("header") ++ cls(List("left", "black"))) {
			"got root?".ts
		}

		val include = script(Map("src" -> "some_url.js")) {
			emptyWithCloseTag()
		}

		it("I mean, really nice...ish") {
			val expected = """<html><head><title>Hello there!</title></head><body><h1>Hello there!</h1></body></html>"""
			assert(textHtml.render(0).equals(expected), s"The html did not match the expected html. Was (${textHtml.render(0)}).")
		}

		it("it can almost do unreadable one-liners") {
			val expected = """<h1 id="header" class="left black">got root?</h1>"""
			assert(h1.render(0).equals(expected), s"The rendered result did not match. Was (${h1.render(0)}).")
		}

		it("can do empty tags") {
			val expected = """<script src="some_url.js"></script>"""
			assert(include.render(0).equals(expected), s"script was not rendered as intended. Was (${include.render(0)})")
		}
	}
}
