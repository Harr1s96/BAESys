pipeline {
    agent any
    stages {
        stage('--- package and deploy to Nexus ---') {
            steps {
                sh "mvn clean package deploy"
            }
        }
        stage('-- build docker image --') {
            steps {
                sh "docker build -t back-end ."
            }
        }
        stage('-- deploy image to Docker Hub --') {
            steps {
                withDockerRegistry([credentialsId: "docker-credentials", url: ""]) {
                    sh 'docker tag back-end bigheck123/back-end'
                    sh 'docker push bigheck123/back-end'
                }
            }
        }
    }
}
