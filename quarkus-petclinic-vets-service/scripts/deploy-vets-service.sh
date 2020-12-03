#!/bin/bash

echo Deploy vets-service........

# oc delete deployments,dc,bc,build,svc,route,pod,is vets-service

cd /projects/quarkus-workshop-labs/quarkus-petclinic-vets-service

#
# Database
#
oc new-app openshift/postgresql:latest \
            --name=vets-database \
            -e POSTGRESQL_USER=vets \
            -e POSTGRESQL_PASSWORD=mysecretpassword \
            -e POSTGRESQL_DATABASE=vets 

#
# Quarkus App
#
mvn clean package -Dquarkus.kubernetes.deploy=true

echo "Done! Verify by using steps below:"
echo
echo "Run the curl command to view a list of vets (json):"
echo "$ curl http://$(oc get route vets-service -o=go-template --template='{{ .spec.host }}')/vets"
echo
echo "Open a web browser and visit Swagger UI"
echo "http://$(oc get route vets-service -o=go-template --template='{{ .spec.host }}')/swagger-ui"
echo
