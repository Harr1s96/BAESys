pipeline {
    agent any
    stages {
        stage('---clean---') {
            steps {
                sh "mvn clean"
            }
        }
        stage('--test--') {
            steps {
                sh "mvn test"
            }
        }
        stage('--package--') {
            steps {
                sh "mvn package"
            }
        }
                stage('--deploy--') {

            steps {

                script {

                    // Read POM xml file using 'readMavenPom' step , this step 'readMavenPom' is included in: https://plugins.jenkins.io/pipeline-utility-steps

                    pom = readMavenPom file: "pom.xml";

                    // Find built artifact under target folder

                    filesByGlob = findFiles(glob: "target/*.${pom.packaging}");

                    // Print some info from the artifact found

                    echo "${filesByGlob[0].name} ${filesByGlob[0].path} ${filesByGlob[0].directory} ${filesByGlob[0].length} ${filesByGlob[0].lastModified}"

                    // Extract the path from the File found

                    artifactPath = filesByGlob[0].path;

                    // Assign to a boolean response verifying If the artifact name exists

                    artifactExists = fileExists artifactPath;

                    if(artifactExists) {

                        echo "*** File: ${artifactPath}, group: ${pom.groupId}, packaging: ${pom.packaging}, version ${pom.version}";

                        nexusArtifactUploader(

                            nexusVersion: nexus3,

                            protocol: http,

                            nexusUrl: "3.11.84.155:8081/repository/chrisandharris-hosted",

                            groupId: pom.groupId,

                            version: pom.version,

                            repository: chrisandharris-hosted,

                            credentialsId: nexus-credentials,

                            artifacts: [

                                // Artifact generated such as .jar, .ear and .war files.

                                [artifactId: pom.artifactId,

                                classifier: '',

                                file: artifactPath,

                                type: pom.packaging],

                                // Lets upload the pom.xml file for additional information for Transitive dependencies

                                [artifactId: pom.artifactId,

                                classifier: '',

                                file: "pom.xml",

                                type: "pom"]

                            ]

                        );

                    } else {

                        error "*** File: ${artifactPath}, could not be found";

                    }

                }

            }

        }
    }
}
