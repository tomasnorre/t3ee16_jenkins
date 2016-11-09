// Include Default Settings
def slurper = new ConfigSlurper()
slurper.classLoader = this.class.classLoader
def conf = slurper.parse(readFileFromWorkspace(new File('Config', 'settings.groovy').path))

listView('T3EE16-JENKINS') {
    jobs {
        regex("t3ee_.*")
    }
    bart_default_columns(delegate)
}

/**
 * Default Columns for the Views.
 */
private void bart_default_columns(context) {
    context.columns {
        buildButton()
        status()
        weather()
        name()
        lastSuccess()
        lastFailure()
        lastDuration()
    }
}
