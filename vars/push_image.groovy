def call(String docker_user,String docker_pass,String app_name,String tag_name) {
      withCredentials([usernamePassword(
                    credentialsId: 'docker_credential',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
      )]){
          sh "docker login -u ${docker_user} -p ${docker_pass}"
          sh "docker image tag ${app_name}:${tag_name} ${docker_user}/${app_name}:${tag_name}"
          sh "docker push ${docker_user}/${app_name}:${tag_name}"
      }
}
         
