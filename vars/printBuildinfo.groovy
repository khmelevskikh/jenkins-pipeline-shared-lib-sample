#!/usr/bin/env groovy
   
def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    log.info config.name
    log.info "Param1 is: ${env.param1}"
    log.info "Param2 is: ${env.param2}"
    if (env.param1 == 'One default') {
        log.info "Param1 is default"
    }
    if (env.param1 == 'FAIL') {
      log.error "Build was marked as failed"
      currentBuild.result = 'SUCCESS'
    }
    sh "ls -la $WORKSPACE"  

    return this
}
