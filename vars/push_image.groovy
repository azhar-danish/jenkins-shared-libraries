def call(String app_name,String tag_name) {
      withCredentials([usernamePassword(
                    credentialsId: 'docker_credential',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
      )]){
          sh "docker login -u ${env.DOCKER_USER} -p ${env.DOCKER_PASS}"
          sh "docker image tag ${app_name}:${tag_name} ${env.DOCKER_USER}/${app_name}:${tag_name}"
          sh "docker push ${env.DOCKER_USER}/${app_name}:${tag_name}"
      }
}
         
