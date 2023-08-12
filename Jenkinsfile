node {
    docker.image('maven:3.9.0-eclipse-temurin-11').inside('-v /root/.m2:/root/.m2') {
        stage('Build') {
            sh 'mvn -B -DskipTests clean package'
        }
        stage('Test') {
            sh 'mvn test'
            junit 'target/surefire-reports/*.xml'
        }
        stage('Manual Approval') {
            steps {
                script {
                    def userInput = input(
                        id: 'userInput',
                        message: 'Lanjutkan ke tahap Deploy?',
                        parameters: [
                            [$class: 'ChoiceParameterDefinition', 
                            choices: 'Proceed\nAbort', 
                            description: 'Pilih salah satu opsi', 
                            name: 'ACTION']
                        ]
                    )
                    if (userInput == 'Proceed') {
                        echo 'Melanjutkan ke tahap Deploy...'
                    } else {
                        error('Pipeline dihentikan oleh pengguna.')
                    }
                }
            }
        }
        stage('Deploy') {
            steps {
                sh './jenkins/scripts/deliver.sh'
                script {
                    sleep 60
                }
                sh './jenkins/scripts/kill.sh'
            }
        }
    }
}
