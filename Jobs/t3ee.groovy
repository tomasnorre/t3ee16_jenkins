// Include Default Settings
def slurper = new ConfigSlurper()
slurper.classLoader = this.class.classLoader
def conf = slurper.parse(readFileFromWorkspace(new File('Config', 'settings.groovy').path))

[ 'latest', 'stage', 'production' ].eachWithIndex { environment, index ->
    job('t3ee_groovy_' + environment + '_job') {

        logRotator(
                conf.logRotator.daysToKeepInt,
                conf.logRotator.numToKeepInt,
                conf.logRotator.artifactDaysToKeepInt,
                conf.logRotator.artifactNumToKeepInt
        )

        steps {
            shell('''
#!/bin/sh

echo "Welcome to T3EE16 - Jenkins JobDSL"
    ''')
        }
    }
}

