#!/usr/bin/env groovy

def call(body) {
    echo "Check status"

    echo env.JOB_NAME
    echo env.RUN_DISPLAY_URL

    currentBuild.result = 'SUCCESS' //FAILURE to fail
    return this
}
