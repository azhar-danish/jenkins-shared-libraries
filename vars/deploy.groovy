def call(String app_name,Number port_number,String tag_name) {
    echo "Code deploy"
    sh '''
        CONTAINER_ID=\$(docker ps -q --filter "publish=\$port_number")
        if [ ! -z "\$CONTAINER_ID" ]; then
            docker stop \$CONTAINER_ID
            docker rm \$CONTAINER_ID
        fi
    '''
    // sh "docker stop ${app_name} && docker rm ${app_name}"
    sh "docker run -d -p ${port_number}:${port_number} --name ${app_name}:${tag_name}"
}