class CheckBoxListTagLib {

    def checkBoxList = { attrs, body ->

        def from = attrs.from
        def value = attrs.value
        def cname = attrs.name
        def isChecked, ht, wd, style, html

        style = "style='"
        if(attrs.height) style += "height:${attrs.height};"
        if(attrs.width) style += "width:${attrs.width};"
        if (style.length() == "style='".length()) style = ""
        else style += "'" // closing single quote

        html = "<ul class='CheckBoxList' " + style + ">"

        out << html

        from.each { obj ->

            isChecked = (value?.contains(obj."${attrs.optionKey}"))? true: false

            out << "<li>" << g.checkBox(name:cname, value:obj."${attrs.optionKey}", checked: isChecked) << "${attrs.optionValue ? obj.properties[attrs.optionValue] : obj}" << "</li>"
        }

        out << "</ul>"

    }

}