def call(){
    sh 'mvn test --illegal-access=permit'
}