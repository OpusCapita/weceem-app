/**
 * EasySearchTagLib.
 *
 * @author Sergei Shushkevich
 */
class EasySearchTagLib {

    def easySearch = {attrs ->
        out << render(template: '/easySearch/searchLink', model: [name: attrs.name])
    }
}
