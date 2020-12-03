#!/bin/bash

echo Deploy customers-service........

cd /projects/quarkus-workshop-labs/quarkus-petclinic-customers-service

# oc delete deployments,dc,bc,build,svc,route,pod,is --all

#
# Database
#
oc new-app -e POSTGRESQL_USER=customers \
  -e POSTGRESQL_PASSWORD=mysecretpassword \
  -e POSTGRESQL_DATABASE=customers openshift/postgresql:latest \
  --name=customers-database

#
# Quarkus App
#
#
# Quarkus App
#
mvn clean package -Dquarkus.kubernetes.deploy=true

clear
echo "Done! Verify by using steps below:"
echo
echo "Run the curl command to view a list of owners (json):"
echo "$ curl http://$(oc get route customers-service -o=go-template --template='{{ .spec.host }}')/owners"
echo
echo "Open a web browser and visit the URL to view a list of owners (json):"
echo "http://$(oc get route customers-service -o=go-template --template='{{ .spec.host }}')/owners"
echo
echo "Open a web browser and visit Swagger UI"
echo "http://$(oc get route customers-service -o=go-template --template='{{ .spec.host }}')/swagger-ui"
echo