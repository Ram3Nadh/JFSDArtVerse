pipeline {
    agent any  // This runs on any available agent, modify if needed for a specific agent

    environment {
        JAVA_HOME = 'C:\\Program Files\\Java\\jdk-21'  // Path to JDK on your Windows system
        DOCKER_IMAGE = 'trinath2310/jfsdproject:latest'  // Docker Hub image name
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/Ram3Nadh/JFSDArtVerse.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean install'  // Use bat (Windows) instead of sh (Linux)
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t %DOCKER_IMAGE% .'  // Windows style variable syntax
            }
        }

        stage('Push Docker Image') {
            steps {
                withDockerRegistry([credentialsId: 'docker-hub-credentials', url: 'https://index.docker.io/v1/']) {
                    bat 'docker push %DOCKER_IMAGE%'  // Windows style variable syntax
                }
            }
        }

        stage('Deploy to Server') {
            steps {
                sshagent(['your-server-ssh-credentials']) {
                    bat 'ssh user@your-server-ip "docker pull %DOCKER_IMAGE% && docker run -d -p 8081:8081 %DOCKER_IMAGE%"'
                }
            }
        }
    }
}
