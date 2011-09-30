
// Run with -Dweceem.security.policy.path set to point to the location of this file

policy = {

    'ROLE_ADMIN' {
        space '*'

        admin true
        create true
        edit true
        view true
        delete true
    }

    'ROLE_USER' {
        space '*'

        admin false
        create true
        edit true
        view true
        delete false
    }

    'ROLE_GUEST' {
        space '*'

        admin false
        create false
        edit false
        view true
        delete false
        
        "Customers/extranet" {
            view false
        }
        "blog" {
            create true
        }
    }
}
