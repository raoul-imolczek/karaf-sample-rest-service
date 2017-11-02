# karaf-sample-rest-service
A short example illustrating how to build a rest service for karaf

## Setting up the karaf environment

feature:install webconsole

feature:repo-add aries-rsa 1.11.0
feature:repo-add cxf-dosgi 2.3.0
feature:install cxf-dosgi-provider-rs

bundle:install -s mvn:sample/karaf-sample-rest-service/0.0.1-SNAPSHOT