def call(String app_name,Number port_number,String tag_name) {
    echo "Code deploy"
    sh "docker stop ${app_name} && docker rm ${app_name}"
    sh "docker run -d -p ${port_number}:${port_number} --name ${app_name}:${tag_name}"
}