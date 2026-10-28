def call(String app_name,String tag_name) {
  echo "building images ..."
  sh "docker build -f ${app_name}:${tag_name} ."
  echo "building image successful"
}
