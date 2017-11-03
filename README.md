# karaf-sample-rest-service
A short example illustrating how to build a rest service for karaf using cxf-dosgi

## Setting up the karaf environment

Download and unzip karaf 4.1.2
Start the server and the console using `bin\karaf.bat`

By default, you'll have a server running on port 8181.

Run the following command in order to review the list of OSGi bundles currently deployed in this environment. Pretty empty isn't it?

```
bundle:list
```

A useful feature you can install right away is the web console. It provides useful monitoring and administration tools.

```
feature:install webconsole
```

Now you can access it at [console link](http://localhost:8181/system/console)

## Adding the cxf-dosgi feature

CXF DOSGi is a features that allows to publish CXF endpoints as Declarative Services (DS).
Thanks to this feature, the developer does not have to activate the CXF bus and the service endpoints through additional configuration or code.

```
feature:repo-add aries-rsa 1.11.0
feature:repo-add cxf-dosgi 2.3.0
feature:install cxf-dosgi-provider-rs
```

You can now run the `bundle:list` command to review all the additional bundles that have been deployed.

> Note: With this set of features, we'll be working with CXF 3.2.0.

We're going to deploy web services inside of this environment. The command below lists the currently published endpoints:

```
rsa:endpoints
```

For the moment there is not any.

## Deploying this sample service

We're going to deploy this project that contains one very simple rest service.

First build the project using `mvn install`. A snapshot of this artifact is now available inside of your maven local repository.

And using the command below, you're going to deploy this artifact to the server (the `-s` option asks karaf to start the bundle as well).

```
bundle:install -s mvn:com.imolczek.school.karaf.sample/karaf-sample-rest-service/0.0.1-SNAPSHOT
```

The artifact will get its own bundle id. You can review it again using the `bundle:list` command or have a look at the [web console](http://localhost:8181/system/console/bundles).

Go to the bundle's details inside of the console and have a look at the _Last Modified_ attribute.

If you type `rsa:endpoints` you'll see you now have an endpoint.

Let's request this service: [http://localhost:8181/cxf/sample/foo/HelloWorld](http://localhost:8181/cxf/sample/foo/HelloWorld).

One interesting feature of karaf is that it allows you to watch for updates of your bundles. Let's ask karaf to install a new version of the snapshot whenever a new one is built. Replace `[bundle-id]` with the id of your bundle's artifact.

```
bundle:watch [bundle-id]
```

Rebuild a snapshot of your artifact using `mvn install`, go back to the web console and see for yourself that the _Last Modified_ argument was updated.

## Add some features to the rest service

Now it's your turn to add some useful methods to SampleService and deploy them. How about a feature that adds two numbers?