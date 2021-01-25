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
            bat "gradlew sonarqube -Dsonar.host.url=http://13.210.217.246:9000 -Dsonar.login=1078be5f2e3ce40bc39ca0dddc030a2d75843229"
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
