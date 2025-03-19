def call(Map config){   
     withSonarQubeEnv('SonarQube') {
        sh "${config.SONAR_SCANNER_HOME}/bin/sonar-scanner -Dsonar.projectKey=${config.SONAR_PROJECT_KEY} -Dsonar.sources='.' \
        -Dsonar.host.url='http://sonarqube:9000' -Dsonar.login=${config.SONAR_TOKEN}"
     }

    timeout(time: 1, unit: 'HOURS') {
                waitForQualityGate abortPipeline: "${config.abortPipeline}"
    }
            				
}