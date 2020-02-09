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
    stage('archive') {
      steps {
          container('maven') {
            archive 'build/generated/*.jar'
          }
     }
    }
  }
  post {
    always{
      container('maven') {
        junit '**/builds/TEST-*.xml'
      }
    }
  }
}
