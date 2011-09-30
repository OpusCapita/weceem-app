/**
 * Defines 'empty' macros for Date object interactions in Wiki content.
 *
 * @author Sergei Shushkevich
 */
class DateTagLib {

    // namespace for empty macros, which haven't body
    static namespace = 'emacro'

    def currentDate = {attrs, body ->
        out << new Date()
    }
}