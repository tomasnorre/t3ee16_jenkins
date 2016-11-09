Jenkins Job DSL scripts
=======================


Description
-----------
This repository contains the [Jenkins Job DSL][1] scripts for the T3EE16 Presentation "Jenkins JobDSL - Configuration as Code"

For easier maintenance, every DSL file should only contain one Jenkins Job/View Group.
Jobs that loops over arrays like `ci_install.groovy` containing jobs for install on {latest,stage}
should of course be in one file, as it would make the maintenance to difficult.

Usage
-----
The seed job required to process the DSLs can be created automatically
using the `bart_tools_job-dsl_seed.groovy` script.

Testing Jobs Locally
--------------------

**Test the job scripts:**

Use the JobScriptsSpec to test your job scripts. Simply call: `./gradlew test`.
This will find syntactic errors in your DSL script.

**Test a specific job:**

Call `./gradlew run -PjobFile=Jobs/<MY_JOB_DSL_FILE>.groovy`.
This will generate Jenkins configuration \*.xml files like if directly run in
Jenkins.

[1]: https://wiki.jenkins-ci.org/display/JENKINS/Job+DSL+Plugin
