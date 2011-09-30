/*
eventCompileStart = {kind ->
    def pluginsBase = "${basedir}/plugins".toString().replaceAll('\\\\', '/')
    new File(pluginsBase).eachDir {
        def installScript = new File("${pluginsBase}/${it.name}/scripts/_Install.groovy")
        if (installScript.exists()) {
            event("StatusUpdate", ["Executing ${it.name} plugin post-install script"])
            def instrumentedInstallScript = "def pluginBasedir = '${pluginsBase}/${it.name}'\n" + installScript.text
            includeTargets << instrumentedInstallScript
        }
    }
}
*/