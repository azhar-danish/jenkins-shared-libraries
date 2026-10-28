def call(String git_url,String branch_name) {
  echo "git clone in progress"
  git url: "${git_url}",branch: "${branch_name}"
  echo "git cloning is completed"
}        
