package se.kodiak.tools.html

import se.kodiak.tools.html.dressers.StringDresser

object Implicits {

	implicit def dressUpString(input:String):StringDresser = new StringDresser(input)

}
