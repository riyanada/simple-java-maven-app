node {
    docker.image('maven:3.9.0-eclipse-temurin-11').inside('-v /root/.m2:/root/.m2') {
        stage('Deploy') {
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
                    sh './jenkins/scripts/deliver.sh'
                    sleep 60
                    sh './jenkins/scripts/kill.sh'
                } else {
                    error('Pipeline dihentikan oleh pengguna.')
                }
            }
        }
    }
}
