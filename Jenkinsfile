pipeline {
    agent any 
    stages {
        stage('Compile and Clean') { 
            steps {

                sh "cd order-management-service; mvn clean compile"
            }
        }
       
		stage('Junit5 Test') { 
            steps {

                sh "cd order-management-service; mvn test"
            }
        }
        

		stage('Jacoco Coverage Report') {
        	steps{
            		jacoco()
			}
		}
        
        stage('SonarQube'){
			steps {
				sh "cd order-management-service; mvn sonar:sonar -Dsonar.host.url=http://44.197.198.59:9000 -Dsonar.login=f5149ebc08b1d5b00b3449d7f0cf24e19bee340f"
		         
		     }
   		}
   		
        stage('Maven Build') { 
            steps {
                sh "cd order-management-service; mvn package"
            }
        }


        stage('Build Docker image'){
            steps {
              
                sh 'cd order-management-service; docker build -t  malkhan52/customer_management_service:1.0 .'
            }
        }
        

        stage('Docker Login'){
            
            steps {
                 withCredentials([string(credentialsId: 'DockerId', variable: 'Dockerpwd')]) {
                    sh "cd order-management-service; docker login -u malkhan52 -p ${Dockerpwd}"
                }
            }                
        }

        stage('Docker Push'){
            steps {
                sh 'cd order-management-service; docker push malkhan52/customer_management_service:1.0'
            }
        }
        
        stage('Archiving') { 
            steps {
                 archiveArtifacts '**/target/*.jar'
            }
        }
             stage('Generate Cucumber report') {
            steps{
        			cucumber buildStatus: 'UNSTABLE',
                		reportTitle: 'My Cucumber Report',
                		fileIncludePattern: '**/*.json',
               			trendsLimit: 10,
                		classifications: [
                    		[
                        		'key': 'Browser',
                        		'value': 'Chrome'
                    		]
                		]
                  }
			}
        
        

    }
        
    }
}

