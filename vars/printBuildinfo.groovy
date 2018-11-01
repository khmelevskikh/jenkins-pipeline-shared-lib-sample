#!/usr/bin/env groovy
import hudson.model.*
import hudson.FilePath
    
def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    echo config.name
    echo "Param1 is: ${env.param1}"
    echo "Param2 is: ${env.param2}"
    if (env.param1 == 'One default') {
        echo "Param1 is default"
    }
    
    git branch: 'master',
        credentialsId: 'nc_git',
        url: 'git@git.netcracker.com:khmelevskikh/test.git'

    sh "chmod +x $WORKSPACE/test_instances.sh"  

    return this
}
