node {
    def mvnImage = 'maven:3.9.3-eclipse-temurin-17-alpine'
    
    docker.image(mvnImage).inside('-v /root/.m2:/root/.m2') {
        stage('Build') {
            checkout scm
            sh 'mvn -B -DskipTests clean package'
        }
        
        stage('Test') {
            sh 'mvn test'
            junit 'target/surefire-reports/*.xml'
        }
        
        stage('Deploy') {
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
                sh 'java -cp target/classes com.mycompany.app.App'
                sleep 60
                sh './jenkins/scripts/kill.sh'
            } else {
                error('Pipeline dihentikan oleh pengguna.')
            }
        }
    }
}
