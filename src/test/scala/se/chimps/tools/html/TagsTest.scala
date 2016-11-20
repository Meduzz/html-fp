package se.chimps.tools.html

import org.scalatest.FunSpec
import se.chimps.tools.html.Tags._
import se.chimps.tools.html.Attributes._
import se.chimps.tools.html.Implicits._

class TagsTest extends FunSpec {

	describe("""the api "iz nice"...""") {
		val textHtml = html() {
			head() {
				title() {
					text("Hello there!") $
				} $
			} &
			body() {
				Custom("h1")(Map()) {
					text("Hello there!") $
				} $
			}
		}

		it("I mean, really nice...ish") {
			val expected = """<html><head><title>Hello there!</title></head><body><h1>Hello there!</h1></body></html>"""
			assert(textHtml.render(0).equals(expected), s"The html did not match the expected html.")
		}

		it("it can almost do unreadable one-liners") {
			// TODO wont compile without dots and parantheses...

			val h1 = "h1".~(:#("header") ++ cls(List("left", "black"))) {
				"got root?".t.$
			}

			val expected = """<h1 id="header" class="left black">got root?</h1>"""
			assert(h1.render(0).equals(expected), s"The rendered result did not match.")
		}

		it("it sure can look better") {
			Custom("ffs")(Map())(() => List())
		}
	}
}
