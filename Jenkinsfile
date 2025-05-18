pipeline {
    agent any

    tools {
        maven 'Maven 3.8.6'
        jdk 'JDK 20'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/aditya0594/java_con.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                sh 'mvn deploy'
            }
        }
    }
}