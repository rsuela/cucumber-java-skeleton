pipeline {
    agent {
        label 'master'
    }
  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }
    stage('build') {
      steps {
            sh "./gradlew test --rerun-tasks --info"
            sh "ls -al"
            sh "ls build"
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
