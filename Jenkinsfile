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
}
