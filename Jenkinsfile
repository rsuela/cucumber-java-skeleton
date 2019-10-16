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
            sh "mvn test"
          }
      }
    }
    stage('archive') {
      steps {
          container('maven') {
            archive 'target/*.jar'
          }
      }
    }
  }
  post {
      always{
            container('maven') {
                junit '**/target/surefire-reports/TEST-*.xml'
            }
          //logstashSend failBuild: true, maxLines: 1000
      }
  }
}
