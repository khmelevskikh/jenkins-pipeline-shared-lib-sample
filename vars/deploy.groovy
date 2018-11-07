#!/usr/bin/env groovy
import java.io.File;

def call(body) {
    echo "Start Deploy"

    new Deployer(script:this).run()
    
    File theFile = new File("$WORKSPACE/Jenkinsfile");
    log.info "Location is: " + theFile.getParent()
    log.info "File name is: " + theFile.getName()
    echo "Deployed"
    currentBuild.result = 'SUCCESS' //FAILURE to fail

    return this
}
