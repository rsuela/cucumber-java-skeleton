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
            bat "gradlew test --rerun-tasks --info"
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
