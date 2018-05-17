# AWS cloudformation

## More information

* This stack depends on an ASG cluster created by the `bnc-cfn-stack`.
* A new target group gets assigned to an existing ALB which forwards request to this service.
* This will create a new service to be deployed in the cluster and a new deployment pipeline for it.
