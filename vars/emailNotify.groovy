    def notifySuccessful() {
        emailext (
                subject: "SUCCESSFUL: Job '${JOB_NAME} [${BUILD_NUMBER}]' ",
                body: '''<p>SUCCESSFUL: Job '${JOB_NAME} [${BUILD_NUMBER}]':</p>
                         <p>Check console output at "<a href="${BUILD_URL}">${JOB_NAME} [${BUILD_NUMBER}]</a>"</p>''',
                mimeType: 'text/html',
                to: "$RECIPIENTS"
        )
    }
    
    def notifyFailed() {
      emailext (
          subject: "FAILED: Job '${JOB_NAME} [${BUILD_NUMBER}]'",
          body: '''<p>FAILED: Job '${JOB_NAME} [${BUILD_NUMBER}]':</p>
                <p>Check console output at "<a href="${BUILD_URL}">${JOB_NAME} [${BUILD_NUMBER}]</a>"</p>
                <p>${BUILD_LOG, maxLines=150, escapeHtml=false}</p>
                ''',
          mimeType: 'text/html',
          to: "$RECIPIENTS"
        )
    }
    
def call(String status = 'SUCCESS') {
    if (status == 'SUCCESS') {
        notifySuccessful()
    }
    if (status == 'FAIL') {
        notifyFailed()
    }
}
