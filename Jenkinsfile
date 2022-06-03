pipeline {
    agent any
    tools {
    maven 'maven'
  }
    stages {
        stage('Git') {
            steps {
                // Obtener el codigo de repositorio
                git branch: 'master', credentialsId: '77bbbf13-0cdf-4f68-8ba7-faf62bf15608', url: 'https://github.com/JParsu/backendTutoriales.git'
            }
        }
        stage('MvnPack') {
            steps {
                // Run Maven package para buildear el jar y ejecutar los tests.
                sh "mvn clean package"
            }
            }
        stage('Build docker image'){
            steps {
                script {
                   dockerImage = docker.build("jparsu/jenkins-tutoriales:1.0", "-f ./Dockerfile .")
                }
            }
        }
        stage('Push docker image'){
            steps{
                script{
                    docker.withRegistry('','dockerhub'){
                        dockerImage.push()
                    }
                }
            }
        }
        stage('Docker run'){
            steps{
                sh 'docker run -p 8081:8081 -d jparsu/jenkins-tutoriales:1.0'
            }
        }
    }
}
