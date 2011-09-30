/**
 * Defines highlighting macros for Wiki content.
 *
 * @author Sergei Shushkevich
 */
class HighlightTagLib {

    // namespace for macros, which have body
    static namespace = 'macro'

    def highlightText = {attrs, body ->
        out << "<span style=\"background-color: ${attrs.color};\">"
        out << body()
        out << "</span>"
    }
}