def call(String git_url,String branch_name) {
  echo "git clone"
  git url: git_url,branch: branch_name
}        
