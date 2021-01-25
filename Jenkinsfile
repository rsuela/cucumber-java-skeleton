pipeline {
    agent master
  stages {
    stage('Checkout') {
      steps {
        container('maven') {
          checkout scm
        }
      }
    }
    stage('build') {
      steps {
          container('maven') {
            sh "./gradlew test --rerun-tasks --info"
            sh "ls -al"
            sh "ls build"
          }
      }
    }
  }
  post {
    always{
      junit '**/build/test-results/test/TEST-*.xml'
      cucumber fileIncludePattern: '**/Cucumber.json', sortingMethod: 'ALPHABETICAL'
    }
  }
}
