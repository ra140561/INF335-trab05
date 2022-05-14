pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
        stage('Build and test') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'main', url: 'https://github.com/RBonacin/INF335-Jenkins'

                // Run Maven on a Unix agent. --> Tests grabbed from POM.XML within project
                sh "cd trab-04; mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/trab-04/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'trab-04/target/*.jar'
                }
            }
        }
    }
}
