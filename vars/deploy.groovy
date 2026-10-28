def call(String app_name, Number port_number, String tag_name) {

    if (!port_number || port_number < 1 || port_number > 65535) {
        error("Invalid port_number: ${port_number}")
    }

    echo "Deploying ${app_name}:${tag_name} on port ${port_number}"

    sh """
        if docker container inspect '${app_name}' >/dev/null 2>&1; then
            docker stop '${app_name}'
            docker rm '${app_name}'
        fi
    """

    sh """
        docker run -d \
            -p ${port_number}:${port_number} \
            --name '${app_name}' \
            '${app_name}:${tag_name}'
    """
}