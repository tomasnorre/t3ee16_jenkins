import hudson.model.FreeStyleProject
import hudson.plugins.git.BranchSpec
import hudson.plugins.git.GitSCM
import hudson.triggers.SCMTrigger
import javaposse.jobdsl.plugin.*
import jenkins.model.Jenkins

def dslBuilder = new ExecuteDslScripts(
    new ExecuteDslScripts.ScriptLocation(
        value = 'false',
        targets = 'Jobs/*',
        scriptText = ''
    ),
    ignoreExisting = false,
    removedJobAction = RemovedJobAction.DELETE,
    removedViewAction = RemovedViewAction.DELETE,
    lookupStrategy = LookupStrategy.JENKINS_ROOT
)

def gitSCM = new GitSCM(###REPOSITORY_URL###)
gitSCM.branches = [new BranchSpec('*/master')]

def scmTrigger = new SCMTrigger('H/10 * * * *')

def seedJob = new FreeStyleProject(Jenkins.instance, 'bart_tools_job-dsl_seed')
seedJob.scm = gitSCM
seedJob.getBuildersList().add(dslBuilder)
seedJob.addTrigger(scmTrigger)
seedJob.save()

Jenkins.instance.reload()
