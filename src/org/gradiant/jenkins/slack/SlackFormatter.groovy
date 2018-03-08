package org.gradiant.jenkins.slack


String format(String title = '', String message = '', String testSummary = '') {
  def helper = new JenkinsHelper()

  def project = helper.getProjectName()
  def branch = helper.getBranchName()
  def buildNumber = helper.getBuildNumber()
  def url = helper.getAbsoluteUrl()

  def result = "${project} » ${branch} - #${buildNumber} ${title.trim()} (<${url}|Open>)"
  if(message) result = result + "\nChanges:\n\t ${message.trim()}"
  if(testSummary) result = result + "\n ${testSummary}"

  return result
}

String format2(String title = '', String message = '', String testSummary = '', String artifact = '') {
  def helper = new JenkinsHelper()

  def project = helper.getProjectName()
  def branch = helper.getBranchName()
  def buildNumber = helper.getBuildNumber()
  def url = helper.getAbsoluteUrl()

  def result = "${project} » ${branch} - #${buildNumber} ${title.trim()} (<${url}|Open>)"
  if(message) result = result + "\nChanges:\n\t ${message.trim()}"
  if(artifact) result = result + "\nArtifacts:\n\t (<${artifact}|Download>)"
  if(testSummary) result = result + "\n ${testSummary}"

  return result
}
