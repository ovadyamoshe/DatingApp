pipeline {
  agent any
  parameters {
      choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
      booleanParam(name: 'executeTest', defaultValue: true, description: '')
  }
  stages {
  stage('builed') {
      steps {
        echo "building the application..."
      }
    }
  stage('test') {
      when {
          expression {
              params.executeTest
          }
      }
      steps {
          echo 'testing the applocatin...'
      }
    }
    stage('deploy'){
        steps{
            echo "deploying the application..."
            echo "deploying versio ${params.VERSION}"
        }
    }
  }
}
