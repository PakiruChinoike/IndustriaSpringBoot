pipeline {
    agent any
    
    tools {
        jdk 'jdk23'
        maven 'maven3'
    }
    
    environment {
        SONAR_HOME = tool 'sonar-scanner'
        registry = "projetoindustria/industria-server"
        registryCredential = 'docker-hub'
        dockerImage = ''
        BUILD_NUMBER = '1.0'
    }

    stages {
        stage('Load env file') {
            steps {
                withCredentials([file(credentialsId: 'env-file', variable: 'mySecretEnvFile')]){
                    sh 'cp -rf $mySecretEnvFile $WORKSPACE'
                }
            }
        }
        stage('Git Checkout') {
            steps {
                git branch: 'main', changelog: false, credentialsId: 'git-cred', poll: false, url: 'https://github.com/PakiruChinoike/IndustriaSpringBoot'
            }
        }

        stage('Trivy Scan') {
            steps {
                sh "trivy fs --format table -o trivy-fs-report.html ."
            }
        }
        
        stage('Sonarqube Analysis') {
            steps {
                
                withSonarQubeEnv('sonar') {
                    sh ''' $SONAR_HOME/bin/sonar-scanner -Dsonar.projectKey=Projeto -Dsonar.projectName=projetoindustria -Dsonar.java.binaries=. '''
                }
            }
        }
        
        stage('Build') {
            steps {
                sh "mvn clean package -DskipTests"
            }
        }
        
        stage('Build Docker Image') {
            steps {
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER" 
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry( '', registryCredential ) { 
                        dockerImage.push() 
                    }
                }
            }
        }
        stage('Cleaning up') { 
            steps { 
                sh "docker rmi $registry:$BUILD_NUMBER" 
            }
        }
        stage('Deploy on server') { 
            steps { 
                 sshagent (credentials: ['ssh-cred']) {
                    sh 'ssh $SSH_USER@$SSH_IP -p $SSH_PORT uname -a'
                  }
            }
        }

    }
}
