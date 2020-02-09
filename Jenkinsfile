pipeline {
    agent {
        kubernetes {
          label 'maven-node'
          yamlFile 'KubernetesPod.yaml'
        }
    }
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
      container('maven') {
        junit '**/build/test-results/test/TEST-*.xml'
      }
    }
  }
}
