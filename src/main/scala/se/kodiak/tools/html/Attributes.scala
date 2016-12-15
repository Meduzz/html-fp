package se.kodiak.tools.html

object Attributes {

	def id(id:String):Map[String, String] = Map("id" -> id)
	def cls(classes:List[String]):Map[String, String] = Map("class" -> classes.mkString(" "))
	def href(path:String):Map[String, String] = Map("href" -> path)
	def src(path:String):Map[String, String] = Map("src" -> path)
	def /(path:String):String = s"/$path"

	/**
		* Id attribute alias.
		* @return returns a map.
		*/
	def :#(ident:String):Map[String, String] = id(ident)

}
