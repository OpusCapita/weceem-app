class UrlMappings {

    static mappings = {

        "/login/$action?/$id?"(controller: 'login')

        "/logout/$action?/$id?"(controller: 'logout')

        "/captcha/$action?/$id?"(controller: 'captcha')

        "/admin/easySearch/$action"(controller: 'easySearch')

        "/admin/users/$action?/$id?"(controller: 'CMSUser')

        "/admin/profile/$action/$id?"(controller: 'userProfile')
    }
}
