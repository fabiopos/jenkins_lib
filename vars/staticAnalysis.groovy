def call(){   
    ${SONAR_SCANNER_HOME}/bin/sonar-scanner -Dsonar.projectKey=${SONAR_PROJECT_KEY} -Dsonar.sources='.' \
    -Dsonar.host.url='http://sonarqube:9000' -Dsonar.login=${SONAR_TOKEN}

    timeout(time: 1, unit: 'HOURS') {
                    waitForQualityGate abortPipeline: true
    }
            				
}