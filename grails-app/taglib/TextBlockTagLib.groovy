/**
 * Defines macros of text blocks for Wiki content.
 *
 * @author Sergei Shushkevich
 */
class TextBlockTagLib {

    // namespace for macros, which have body
    static namespace = 'macro'

    def code = {attrs, body ->
        out << "<pre><code>" << body() << "</code></pre>"
    }

    def info = {attrs, body ->
        out << "<div class=\"info\" style=\"border: 1px solid #3c78b5;background-color: #D8E4F1;margin: 20px;padding: 0px 6px 0px 6px;\">"
        out << body()
        out << "</div>"
    }

    def note = {attrs, body ->
        out << "<div class=\"note\" style=\"border: 1px solid #F0C000;background-color: #FFFFCE;margin: 20px;padding: 0px 6px 0px 6px;\">"
        out << body()
        out << "</div>"
    }

    def panel = {attrs, body ->
        out << "<div class=\"panel\" style=\"border: 1px solid #ccc;background-color: #FFFFCE;margin: 10px;padding: 0px 6px 0px 6px;\">"
        out << body()
        out << "</div>"
    }

    def tip = {attrs, body ->
        out << "<div class=\"tip\" style=\"border: 1px solid #090;background-color: #dfd;margin: 20px;padding: 0px 6px 0px 6px;\">"
        out << body()
        out << "</div>"
    }

    def warning = {attrs, body ->
        out << "<div class=\"warning\" style=\"border: 1px solid #c00;background-color: #fcc;margin: 20px;padding: 0px 6px 0px 6px;\">"
        out << body()
        out << "</div>"
    }
}