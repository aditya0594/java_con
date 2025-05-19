pipeline {
    agent any

    tools {
        maven 'apache-maven-3.9.6-bin'
        jdk 'jdk-20'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/aditya0594/java_con.git'
            }
        }
        stage('Build') {
            steps {
                echo 'Code pushed! Running pipeline...'
                bat 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                bat 'mvn deploy'
            }
        }
    }
      post {
            always {
                // Archive Surefire Reports
                archiveArtifacts artifacts: 'target/surefire-reports/*.*', allowEmptyArchive: true

                // Archive Extent Report
                archiveArtifacts artifacts: 'test-output/ExtentReport.html', allowEmptyArchive: true

                // (Optional) Publish HTML Report in Jenkins
                publishHTML (target: [
                    allowMissing: true,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'test-output',
                    reportFiles: 'ExtentReport.html',
                    reportName: 'Extent Report'
                ])
            }
      }
}
