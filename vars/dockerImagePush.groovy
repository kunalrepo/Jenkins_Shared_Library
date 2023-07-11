// def call(String project, String ImageTag, String hubUser){
//     withCredentials([usernamePassword(
//             credentialsId: "docker",
//             usernameVariable: "USER",
//             passwordVariable: "PASS"
//     )]) {
//         sh "docker login -u '$USER' -p '$PASS'"
//     }
//     sh "docker image push ${hubUser}/${project}:${ImageTag}"
//     sh "docker image push ${hubUser}/${project}:latest"   
// }

def call(String aws_access_key, String aws_secret_key, String region, String ecr_repoName) {
    sh """
     echo '${aws_access_key}' | docker login --username AWS --password-stdin ${params.aws_account_id}.dkr.ecr.${region}.amazonaws.com
     docker push ${params.aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
    """
}