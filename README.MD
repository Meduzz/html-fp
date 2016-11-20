## Render HTML through functions

A bit 1800, but I got inspired by Elm. UI can be composed as functions. And down the road, fancy libs, parsing popular template languages can be built upon this.

With a few exception, most elements are called in this fashion:
```
div(Map("id" -> "speciul", "class" -> "left")) {
  text("Some important text.")
}
```

Because it's pretty boring to type ```Map("this"->"that")``` every time you need a html attribute, there are ... more fun ways:

```
  "div" ~ :# "speciul" ++ cls("left")
```

Or so's the plan. You might have to add a few dots and parantheses for now. 